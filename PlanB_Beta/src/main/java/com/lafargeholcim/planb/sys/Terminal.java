/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AI-Saac
 */
package com.lafargeholcim.planb.sys;

import com.lafargeholcim.planb.model.APSummary;
import com.lafargeholcim.planb.model.ActionItemFilter;
import com.lafargeholcim.planb.model.ActionPlan;
import com.lafargeholcim.planb.model.Collaborator;
import com.lafargeholcim.planb.model.Facility;
import com.lafargeholcim.planb.model.Meeting;
import com.lafargeholcim.planb.model.Organization;
import com.lafargeholcim.planb.model.Status;
import com.lafargeholcim.planb.model.Action;
import com.lafargeholcim.planb.model.WorkTeam;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import com.lafargeholcim.planb.init.Aps;
import com.lafargeholcim.planb.database.mysql.DataBase;
import com.lafargeholcim.planb.database.google.spreadsheets.GDataBase;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Cell;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Row;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Table;
import com.lafargeholcim.planb.sys.Role;
import com.lafargeholcim.planb.sys.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;


public class Terminal{
    private byte id;
    private User user;
    private final DataBase planB = null;
    private static final String SALT = "MtO27:37";
    private final Organization org;
    private GDataBase gPlanB;
    
    public Terminal() throws Exception {
        user = new User();
        //planB = new DataBase();
        org = Aps.getOrganization();
        gPlanB = new GDataBase();
        //boolean con = planB.connection();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
    
    public ArrayList defineAccessList(String accesses){
        ArrayList<String> list = new ArrayList();
	char comparator = '-';
	int counter = -1;

        for(int i=0;i<accesses.length();i++){
            if(accesses.charAt(i) == comparator){
                list.add(accesses.substring(counter+1,i));
                counter = i;	
            }
        }
        return list;
    }
   
    public void loadBusinessInformation() throws Exception{
        String query;
        Facility facility = new Facility();
        
        query = "SELECT+A+WHERE+B+CONTAINS+"+user.getEmployeeId();
        Table result = gPlanB.selectQuery(query, "facility_collaborator");
        if(result != null){
            if(result.getRows().size() == 1){
                facility.setId("0"+result.getUniqueCellValueOfUniqueRow(true));
                query = "SELECT+B,C,D+WHERE+A+CONTAINS+"+facility.getIntegerId();
                result = gPlanB.selectQuery(query, "facility");
                if(result != null){
                    String[] headers = result.getHeaders();
                    HashMap<String, Cell> row = result.getMappedRowValues(headers,0);
                    facility.setName(getCellValue(row.get("name"),false));
                    facility.setAcronym(getCellValue(row.get("acronym"),false));
                    facility.setCity(getCellValue(row.get("city"),false));
                    facility.setCollaboratorList(getCollaborators(facility.getIntegerId()));
                    facility.setMeetings(getMeetings(facility));
                    org.getFacilities().add(facility);
                }
                else
                    throw new Exception("Error in query response. Null pointer for TableQuery");
            }
        }
        else
            throw new Exception("Error in query response. Null pointer for TableQuery"); 
    }
    
    public boolean login(String username, String password) throws NoSuchAlgorithmException, 
            SQLException, Exception{
        boolean isAuthenticated = false;
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        
        String query = "SELECT+COUNT(A)+WHERE+A+CONTAINS+%27"+username+"%27+"
                + "AND+C+CONTAINS+%27"+hashedPassword+"%27+LABEL+COUNT(A)+%27is_user%27";
        Table result = gPlanB.selectQuery(query, "user");
        if(result != null){
            if(result.getRows().size() == 1){
                if(result.getUniqueCellValueOfUniqueRow(false).equals("1.0")){
                    isAuthenticated = true;
                    query = "SELECT+B,E+WHERE+A+CONTAINS+%27"+username+"%27";
                    result = gPlanB.selectQuery(query,"user");
                    if(result != null){
                        String[] headers = result.getHeaders();
                        HashMap<String, Cell> row = result.getMappedRowValues(headers,0);
                        user.setUsername(username);
                        user.setEmail(row.get("email").getV());
                        user.setRole(getRole(Integer.parseInt(row.get("role").getF())));
                        query = "SELECT+B+WHERE+A+CONTAINS+%27"+username+"%27";
                        result = gPlanB.selectQuery(query,"user_collaborator");
                        if(result != null){
                            headers = result.getHeaders();
                            row = result.getMappedRowValues(headers, 0);
                            if(row != null){
                                if(row.get("collaborator_id") != null)
                                    user.setEmployeeId(Integer.parseInt(row.get("collaborator_id").getF()));
                            }
                        }
                        else
                            throw new Exception("Error in query response. Null pointer for TableQuery");
                    }
                    else
                        throw new Exception("Error in query response. Null pointer for TableQuery");
                }
            }
        }
        else
            throw new Exception("Error in query response. Null pointer for TableQuery");
        
        return isAuthenticated;
    }
    
    public boolean signup(String username, String password) throws NoSuchAlgorithmException{
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        return false;
    }
    
    public Object[] getTableContent(ActionItemFilter filter, String meetingName) throws Exception{
        String id, responsible, date, status, duration;
        ActionPlan plan;
        Facility facility = org.getFacility("01");
        Meeting meeting = facility.searchMeeting(meetingName);
        
        if(meeting!= null)
            plan = meeting.getActionPlan();
        else
            plan = new ActionPlan();
        ArrayList<Action> list = new ArrayList();
        DefaultTableModel dm = new DefaultTableModel(null, new String [] {
                "ID","Resp.", "Detail", "Comments", 
                "P.Start Date", "P.End Date", "R.End Date",
                "Prog. %", "Status", "Dur."
            }){
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
        
        if(filter.equals(ActionItemFilter.ALL)){
            String query = "SELECT actionId,itemId,detail,comments,plannedStartDate,"
                    + "plannedEndDate, realEndDate,progress,status,"
                    + "timestampdiff(day,plannedStartDate,plannedEndDate) AS duration "
                    + "FROM planb.action INNER JOIN planb.actionplan_action ON "
                    + "actionId=action_id and isDeleted=0 and actionPlan_id="+plan.getId()+";";
            planB.connection();
            ResultSet result = planB.selectQuery(query);
            if(result != null){
                while(result.next()){
                    Action action = new Action();
                    Vector row = new Vector();
                    id = result.getString("actionId");
                    row.add(result.getString("itemId"));
                    action.setID(result.getString("itemId"));
                    responsible = getOwnerAcronym(id);
                    row.add(responsible);
                    action.setResponsible(getCollaborator(facility.getId(),responsible));
                    row.add(result.getString("detail"));
                    action.setDetail(result.getString("detail"));
                    row.add(result.getString("comments"));
                    action.setComments(result.getString("comments"));
                    date = result.getString("plannedStartDate");
                    row.add(date);
                    action.setPlannedStartDate(parseDate(date));
                    date = result.getString("plannedEndDate");
                    row.add(date);
                    action.setPlannedEndDate(parseDate(date));
                    date = result.getString("realEndDate");
                    row.add(date);
                    action.setRealEndDate(parseDate(date));
                    row.add(result.getString("progress"));
                    action.setProgress((byte) Integer.parseInt(result.getString("progress")));
                    status = getStatusName(result.getInt("status")); 
                    row.add(status);
                    action.setStatus(Status.valueOf(status));
                    duration = result.getString("duration"); 
                    row.add(duration);
                    if(duration == null)
                        action.setDuration((byte)0);
                    else
                        action.setDuration((byte) Integer.parseInt(duration));
                    row.add(null);
                    row.add(null);
                    dm.addRow(row);
                    list.add(action);
                }
                plan.setActionList(list);
            }
            planB.disconnection();
        }
        return new Object[]{meeting,dm};
    }
    
    public String getOwnerAcronym(String actionID) throws Exception{
        String query = "SELECT acronymName FROM planb.collaborator INNER JOIN"
                + " planb.collaborator_action ON employeeId=collaborator_id"
                + " AND action_id ="+actionID+";";
        planB.connection();
        ResultSet result = planB.selectQuery(query);
        result.next();
        String acronym = result.getString("acronymName"); 
        planB.disconnection();
        return acronym;
    }
    
    public String getStatusName(int status){
        Status st[] = Status.values();
        for(Status s:st){
            if(s.getValue()==status)
                return s.toString();
        }
        return null;
    }
    
    public Collaborator getCollaborator(String facilityID, String collaboratorAcronym){
        Facility facility = org.getFacility(facilityID);
        return facility.searchCollaborator(collaboratorAcronym,(byte) 2);
    }
    
    public static LocalDate parseDate(String date){
        if(date != null)
            return LocalDate.parse(date);
        return null;
    }
    
    private static String generateHash(String input) throws NoSuchAlgorithmException{
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++)
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        
        return sb.toString();
    }
    
    private Role getRole(int roleValue){
        Role roles[] = Role.values();
        for(Role role:roles){
            if(role.getValue() == roleValue)
                return role;
        }
        return null;
    }
    
    private HashMap<Integer, Collaborator> getCollaborators(int facilityID) throws SQLException, IOException{
        int collaboratorID;
        String query;
        HashMap<Integer, Collaborator> list = new HashMap();
        HashMap<String, Cell> row;
        ArrayList identifiers = getCollaboratorIds(facilityID);
        Table result;
        
        if(identifiers != null){
            for(Iterator it = identifiers.iterator(); it.hasNext();) {
                collaboratorID = (int) it.next();
                query = "SELECT+B,C,D,E,F+WHERE+A+CONTAINS+"+collaboratorID;
                result = gPlanB.selectQuery(query, "collaborator");
                if(result != null){
                    String[] headers = result.getHeaders();
                    for(int i=0; i<result.getRows().size(); i++){
                        row = result.getMappedRowValues(headers, i);
                        if(row != null){
                            Collaborator collaborator = new Collaborator();
                            collaborator.setEmployeeId(collaboratorID);
                            collaborator.setFirstName(getCellValue(row.get("firstname"),false));
                            collaborator.setMiddleName(getCellValue(row.get("middlename"),false));
                            collaborator.setLastName(getCellValue(row.get("lastname"),false));
                            collaborator.setCharge(getCellValue(row.get("charge"),false));
                            collaborator.setAcronymName(getCellValue(row.get("acronymName"),false));
                            list.put(new Integer(collaboratorID), collaborator);
                        }
                    }
                }
            }
            return list;
        }
        return null;
    }
    
    private ArrayList getMeetings(Facility facility) throws SQLException, IOException{
        int meetingID;
        String query;
        Table result;
        HashMap<String, Cell> row;
        ArrayList identifiers;
        ArrayList<Meeting> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        identifiers = getMeetingIds(facility.getIntegerId());      
        if(identifiers != null){
            for(Iterator it = identifiers.iterator(); it.hasNext();){
                meetingID  = (int) it.next();
                query = "SELECT+B,C,D,E+WHERE+A+CONTAINS+"+meetingID;
                result = gPlanB.selectQuery(query, "meeting");
                if(result != null){
                    String[] headers = result.getHeaders();
                    for(int i=0; i<result.getRows().size(); i++){
                        row = result.getMappedRowValues(headers, i);
                        if(row != null){
                            Meeting meeting = new Meeting();
                            meeting.setName(getCellValue(row.get("name"),false));
                            meeting.setAcronym(getCellValue(row.get("acronym"),false));
                            meeting.setPurpose(getCellValue(row.get("purpose"),false));
                            meeting.setDateCreated(LocalDateTime.parse(getCellValue(row.get("dateCreated"),true),formatter));
                            meeting.setActionPlan(getActionPlan(meetingID,facility.getId()));
                            //meeting.setTeam(getTeam((int)results[count],facility));
                            //meeting.setAditionalParticipants(getAdtParticipants((int)results[count],facility));
                            list.add(meeting);
                        }
                    }
                }
            }
            return list;
        }
        return null;
    }
    
    private ActionPlan getActionPlan(int meetingID, String facilityID) throws SQLException, IOException{
        String query;
        Table result, result2;
        HashMap<String, Cell> row, row2;
        ActionPlan actionPlan = new ActionPlan();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        query = "SELECT+B+WHERE+A+CONTAINS+"+meetingID;
        result = gPlanB.selectQuery(query, "meeting_actionplan");
        if(result != null){
            int actionPlanID = Integer.parseInt(result.getUniqueCellValueOfUniqueRow(true));
            query = "SELECT+B,C,D+WHERE+A+CONTAINS+"+actionPlanID;
            result = gPlanB.selectQuery(query, "actionplan");
            if(result != null){
                String[] headers = result.getHeaders();
                for(int i=0; i<result.getRows().size(); i++){
                    row = result.getMappedRowValues(headers, i);
                    if(row != null){
                        actionPlan.setId((short)actionPlanID);
                        actionPlan.setDateCreated(LocalDateTime.parse(getCellValue(row.get("dateCreated"),true), formatter));
                        actionPlan.setDateModified(LocalDateTime.parse(getCellValue(row.get("dateModified"),true), formatter));
                        actionPlan.setExecution(Byte.parseByte(getCellValue(row.get("execution"),true)));
                        query = "SELECT+B+WHERE+A+CONTAINS+"+actionPlanID;
                        result2 = gPlanB.selectQuery(query,"actionplan_apsummary");
                        if(result2 != null){
                            int apSummaryID = Integer.parseInt(result2.getUniqueCellValueOfUniqueRow(true));
                            query = "SELECT+B,C,D,E,F,G,H,I+WHERE+A+CONTAINS+"+apSummaryID;
                            result2 = gPlanB.selectQuery(query,"apsummary");
                            if(result2 != null){
                                String[] headers2 = result2.getHeaders();
                                row2 = result2.getMappedRowValues(headers2, 0);
                                if(row2 != null){
                                    APSummary apsummary = new APSummary();
                                    apsummary.setDate_modified(LocalDateTime.parse(getCellValue(row.get("dateModified"),true), formatter));
                                    apsummary.setActions(Integer.parseInt(getCellValue(row2.get("actions"),true)));
                                    apsummary.setActionsCompleted(Integer.parseInt(getCellValue(row2.get("actionsCompleted"),true)));
                                    apsummary.setActionsCompletedApp(Integer.parseInt(getCellValue(row2.get("actionsCompletedApp"),true)));
                                    apsummary.setActionsInProgress(Integer.parseInt(getCellValue(row2.get("actionsInProgress"),true)));
                                    apsummary.setActionsNearToDueDay(Integer.parseInt(getCellValue(row2.get("actionsNearToDueDay"),true)));
                                    apsummary.setActionsCancelled(Integer.parseInt(getCellValue(row2.get("actionsCancelled"),true)));
                                    apsummary.setActionsOverdue(Integer.parseInt(getCellValue(row2.get("actionsOverdue"),true)));
                                    actionPlan.setZeros(Integer.parseInt(getCellValue(row2.get("actions"),true)));
                                    actionPlan.setSummary(apsummary);
                                }
                            }
                        }
                        
                    }
                }
                query = "SELECT+A+WHERE+B+CONTAINS+"+actionPlanID;
                result = gPlanB.selectQuery(query,"collaborator_actionplan");
                if(result != null){
                    int collaboratorID = Integer.parseInt(result.getUniqueCellValueOfUniqueRow(true));     
                    actionPlan.setOwner(org.getFacility(facilityID).searchCollaborator(collaboratorID));
                    actionPlan.setCurrentDate(LocalDateTime.now());
                }
            }
            return actionPlan;
        }
        return null;
    }
    
    private ArrayList getMeetingIds(int facilityID) throws SQLException, IOException{
        String query;
        Table result;
        HashMap<String, Cell> row;
        ArrayList list = new ArrayList();
        
        query = "SELECT+B+WHERE+A+CONTAINS+"+facilityID;
        result = gPlanB.selectQuery(query, "facility_meeting");
        if(result != null){
            String[] headers = result.getHeaders();
            for(int i=0; i<result.getRows().size(); i++){
                row = result.getMappedRowValues(headers, i);
                if(row != null){
                    list.add(Integer.parseInt(getCellValue(row.get("meeting_id"),true)));
                }
            }
            return list;
        }
        return null;
    }
    
    public Object[] getMeetingsNames(){
        return org.getFacility("01").getMeetingsNames().toArray();
    }
    
    public ArrayList getCollaboratorIds(int facilityID) throws SQLException, IOException{
        String query;
        ArrayList list = new ArrayList();
        HashMap<String, Cell> row; 
        
        query = "SELECT+B+WHERE+A+CONTAINS+%27"+facilityID+"%27";
        Table result = gPlanB.selectQuery(query, "facility_collaborator");
        if(result != null){
            String[] headers = result.getHeaders();
            for(int i=0; i<result.getRows().size(); i++){
                row = result.getMappedRowValues(headers, i);
                if(row != null)
                    list.add(Integer.parseInt(getCellValue(row.get("collaborator_id"),true)));
            }
            return list/**/;
        }
        return null;
    }
    
    public String getNewActionId(String meetingName) throws Exception{
        short number;
        String query;
        Facility facility = org.getFacility("01"); 
        String id = facility.getId();
        Meeting meeting = facility.searchMeeting(meetingName); 
        String acronym = meeting.getAcronym();
        ActionPlan ap = meeting.getActionPlan();
        
        query = "SELECT COUNT(*) as number from planb.action INNER JOIN "
        + "planb.actionplan_action ON actionId=action_id and "
        + "actionPlan_id="+ap.getId()+";";
        planB.connection();
        ResultSet rs = planB.selectQuery(query);
        if(rs != null){
            rs.next();
            number = (short)rs.getInt("number");
            return com.lafargeholcim.planb.model.
                    Action.generateId(id, acronym, number, ap.getZeros());
        }
        return null;
    }
    
    private WorkTeam getTeam(int meetingID, Facility facility) throws SQLException{
        String query = "SELECT employeeId FROM planb.collaborator "
                + "INNER JOIN planb.workteam_collaborator "
                + "ON employeeId = collaborator_id "
                + "INNER JOIN planb.workteam_meeting "
                + "ON workteam_collaborator.workTeam_id = workteam_meeting.workTeam_id "
                + "and meeting_id="+meetingID+";";
        ResultSet result = planB.selectQuery(query);
        if(result != null){
            WorkTeam workTeam= new WorkTeam();
            ArrayList<Collaborator> list = new ArrayList();
            while(result.next())
                list.add(facility.searchCollaborator(result.getInt("employeeId")));
            workTeam.setMembers(list);
            return workTeam;
        }
        return null;
    }
    
    public void addAction(String responsible, String detail, String comments, 
            String plannedStartDate, String plannedEndDate, 
            String status, byte progress, int duration, String meetingName) throws Exception{

        Facility facility = org.getFacility("01"); 
        Meeting meeting = facility.searchMeeting(meetingName);
        short number;
        Action action;
        String query = "SELECT COUNT(*) AS number FROM planb.action INNER JOIN "
                + "planb.actionplan_action ON actionId=action_id AND "
                + "actionPlan_id="+meeting.getActionPlan().getId()+";";
        planB.connection();
        ResultSet rs = planB.selectQuery(query);
        if(rs != null){
            rs.next();
            number = (short)rs.getInt("number");
            action = new Action("01", meeting.getAcronym(), number, meeting.getActionPlan().getZeros());
            action.setDetail(detail);
            action.setComments(comments);
            action.setResponsible(facility.searchCollaborator(responsible,(byte)1));
            action.setPlannedStartDate(parseDate(plannedStartDate));
            action.setPlannedEndDate(parseDate(plannedEndDate));
            action.setRealEndDate(null);
            action.setStatus(Status.valueOf(status));
            action.setProgress((byte)progress);
            action.setDuration(duration);
            meeting.getActionPlan().getActionList().add(action);
            saveActionToDatabase(action, meeting);
            Aps.getUI().addRowToTableContent(new Object[]{
                action.getID(),action.getResponsible().getAcronymName(),
                action.getDetail(),action.getComments(),action.getPlannedStartDate().toString(),
                action.getPlannedEndDate().toString(),null,
                action.getProgress(),action.getStatus().toString(),action.getDuration()
            });
        }
        
    }
    
    public void modifyAction(Object[] rowDataModified, String meetingName) throws SQLException, Exception{
        Facility facility = org.getFacility("01");
        Meeting meeting = facility.searchMeeting(meetingName);
        ActionPlan plan = meeting.getActionPlan();
        Action action;
        byte progress = -1;
        String itemId, actionDetail=null,actionComments=null,startDate=null,
                endDate=null,realDate=null;
        Status status = null;
        ArrayList<String> columns = new ArrayList();
        ArrayList<Object> list = new ArrayList();
        
        itemId = String.valueOf(rowDataModified[0]);
        if(rowDataModified[2] != null)
            actionDetail = String.valueOf(rowDataModified[2]);
        if(rowDataModified[3] != null)
            actionComments = String.valueOf(rowDataModified[3]);
        if(rowDataModified[4] != null)
            startDate = String.valueOf(rowDataModified[4]);
        if(rowDataModified[5] != null)
            endDate = String.valueOf(rowDataModified[5]);
        if(rowDataModified[6] != null)
            realDate = String.valueOf(rowDataModified[6]);
        if(rowDataModified[7] != null)
            progress = (byte) Integer.parseInt(rowDataModified[7].toString());
        if(rowDataModified[8] != null)
            status = Status.valueOf(String.valueOf(rowDataModified[8]));
        
        action = plan.searchAction(itemId);
        if(action != null){
            if(actionDetail != null){
                action.setDetail(actionDetail);
                columns.add("detail");
                list.add(rowDataModified[2]);
            }
            if(actionComments != null){
                action.setComments(actionComments);
                columns.add("comments");  
                list.add(rowDataModified[3]);
            }
            if(startDate != null){
                action.setPlannedStartDate(parseDate(startDate));
                columns.add("plannedStartDate");
                list.add(rowDataModified[4]);
            }
            if(endDate != null){
                action.setPlannedEndDate(parseDate(endDate));
                columns.add("plannedEndDate");
                list.add(rowDataModified[5]);
            }
            if(realDate != null){
                action.setRealEndDate(parseDate(realDate));
                columns.add("realEndDate");
                list.add(rowDataModified[6]);
            }
            if(progress != -1){
                action.setProgress(progress);
                columns.add("progress");
                list.add(rowDataModified[7]);
            }
            if(status != null){
                action.setStatus(status);
                columns.add("status");
                list.add(status.getValue());
            }
           updateActionToDatabase(itemId,columns,list);
           Aps.getUI().modifiedTableContent(rowDataModified);
        }
    }
    
    private void saveActionToDatabase(Action action, Meeting meeting) throws SQLException{
        String query, values;
        int isRowInserted,actionID,actionPlanID,employeeID;
        values = "('"+action.getID()+"','"+action.getDetail()+"','"+action.getComments()
                +"','"+action.getPlannedStartDate().toString()+"','"
                +action.getPlannedEndDate().toString()+"','"
                +action.getDateCreated().toLocalDate().toString()+" "
                +action.getDateCreated().toLocalTime().toString()+"',"
                +action.getStatus().getValue()+","+(int)action.getProgress()+")";
        query = "INSERT INTO planb.action (itemId,detail,comments,"
            + "plannedStartDate,plannedEndDate,dateCreated,status,progress) "
            + "VALUES "+values+";";
        isRowInserted = planB.insertQuery(query);
        
        query = "SELECT actionId FROM planb.action where itemId='"+action.getID()+"';";
        ResultSet rs = planB.selectQuery(query);
        rs.next();
        actionID = rs.getInt("actionId");
        actionPlanID = meeting.getActionPlan().getId();
        query = "INSERT INTO planb.actionplan_action (actionPlan_id,action_id) "
                + "VALUES ("+actionPlanID+","+actionID+");";
        isRowInserted = planB.insertQuery(query);
        employeeID = action.getResponsible().getEmployeeId();
        query = "INSERT INTO planb.collaborator_action (collaborator_id,action_id) "
                + "VALUES ("+employeeID+","+actionID+");";
        planB.insertQuery(query);
    }
    
    private boolean updateActionToDatabase(String actionID,ArrayList<String> columns, ArrayList<Object> list)
            throws SQLException, Exception{
        int isUpdated;
        String query, values="";
        if(columns != null){
            for(int i=0;i<columns.size();i++){
                if(columns.get(i).equalsIgnoreCase("status") ||
                        columns.get(i).equalsIgnoreCase("progress"))
                    if(values.equals(""))
                        values += columns.get(i)+"="+(int)list.get(i);
                    else
                        values += ","+columns.get(i)+"="+(int)list.get(i);
                else
                    if(values.equals(""))
                        values += columns.get(i)+"='"+String.valueOf(list.get(i))+"'";
                    else
                        values += ","+columns.get(i)+"="+String.valueOf(list.get(i));
            }
        }
        query = "UPDATE planb.action SET "+values+" WHERE itemId='"+actionID+"';";
        planB.connection();
        isUpdated = planB.updateQuery(query);
        if(isUpdated == 1)
            return true;
        return false;
    }
    
    public boolean deleteAction(String actionID, String meetingName) throws Exception{
        if(actionID != null){
            Facility facility = org.getFacility("01"); 
            Meeting meeting = facility.searchMeeting(meetingName);
            if(meeting.getActionPlan().deleteAction(actionID))
                deleteActionFromDatabase(actionID);
            return true;
        }
        return false;
    }
    
    private boolean deleteActionFromDatabase(String actionID) throws Exception{
        String query;
        planB.connection();
        
        if(actionID != null){
            query = "UPDATE planb.action SET isDeleted=1 WHERE itemId='"+actionID+"';";
            int is_updated = planB.updateQuery(query);
            if(is_updated == 1)
                return true;   
        }
        return false;
    }
    
    public String[] getParticipantsNames(String meetingName){
        Facility facility = org.getFacility("01");
        Meeting meeting = facility.searchMeeting(meetingName);
        ArrayList<Collaborator> members = (ArrayList<Collaborator>)meeting.getTeam().getMembers().clone();
        if(!meeting.getAditionalParticipants().isEmpty())
            members.addAll((ArrayList<Collaborator>)meeting.getAditionalParticipants().clone());
        
        if(members != null){   
            int number_of_members = members.size();
            String[] names = new String[number_of_members];
            for(int i=0;i<number_of_members;i++){
                String collaborator_names = members.get(i).getFirstName()
                            +" "+ members.get(i).getLastName();
                names[i] = collaborator_names;
            }
            return names;
        }
        return null;
    }
    
    private ArrayList getAdtParticipants(int meetingID, Facility facility) throws SQLException{
        String query = "SELECT collaborator_id FROM planb.adtparticipants_meeting "
                + "WHERE meeting_id="+meetingID+";";
        ResultSet result = planB.selectQuery(query);
        if(result != null){
            ArrayList<Collaborator> list = new ArrayList();
            while(result.next())
                list.add(facility.searchCollaborator(result.getInt("collaborator_id")));
            return list;
        }
        return null;
    }
    
    private String getCellValue(Cell cell, boolean formatted){
        if(cell != null){
            if(formatted)
                return cell.getF();
            return cell.getV();
        }
        return null;
    }
}
