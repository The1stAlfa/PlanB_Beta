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
import javax.swing.JPanel;


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
        gPlanB.insert();
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
                    List<Cell> cells = result.getRows().get(0).getC();
                    facility.setName(getCellValue(cells.get(0),false));
                    facility.setAcronym(getCellValue(cells.get(1),false));
                    facility.setCity(getCellValue(cells.get(2),false));
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
        
        String query = "SELECT+B,C,F+WHERE+A+CONTAINS+%27"+username
                +"%27AND+D+CONTAINS+%27"+hashedPassword+"%27";
        Table result = gPlanB.selectQuery(query,"user");
        if(result != null){
            List<Cell> cells = result.getRows().get(0).getC();
            user.setUsername(username);
            user.setEmail(getCellValue(cells.get(1),false));
            user.setRole(getRole(Integer.parseInt(getCellValue(cells.get(2),true))));
            user.setEmployeeId(Integer.parseInt(getCellValue(cells.get(0),true)));
            isAuthenticated = true;
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
        String actionID, responsible, detail, comments,
                date, progress, status, query;
        ActionPlan plan;
        Table result;
        List<Cell> cells;
        Facility facility = org.getFacility(meetingName,"meetingName");
        Meeting meeting = facility.searchMeeting(meetingName);
        
        if(meeting!= null)
            plan = meeting.getActionPlan();
        else
            plan = new ActionPlan();
        ArrayList<Action> list = new ArrayList();
        DefaultTableModel dm = new DefaultTableModel(null, new String [] {
                "ID","Resp.", "Detail", "Comments", 
                "StartDate", "DueDate", "EndDate",
                "Prog. %", "Status", "Dur."
            }){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
        
        if(filter.equals(ActionItemFilter.ALL)){
            query = "SELECT+A,C,D,E,F,G,H,K,L,DATEDIFF(G,F)+WHERE+B+CONTAINS+"+plan.getId()+
                    "+AND+N+CONTAINS+0+LABEL+DATEDIFF(G,F)+%27duration%27";
            result = gPlanB.selectQuery(query, "action");
            if(result != null){
                for(Row row:result.getRows()){
                    if(row != null){
                        cells = row.getC();
                        Action action = new Action();
                        Vector jTableRow = new Vector();
                        actionID = getCellValue(cells.get(0),false);
                        jTableRow.add(actionID);
                        action.setID(actionID);
                        responsible = facility.searchCollaborator(Integer.parseInt(getCellValue(cells.get(1),true))).getAcronymName();
                        //getOwnerAcronym(getCellValue(cells.get(1),true), facility);
                        jTableRow.add(responsible);
                        action.setResponsible(getCollaborator(facility.getId(),responsible));
                        detail = getCellValue(cells.get(2),false);
                        jTableRow.add(detail);
                        action.setDetail(detail);
                        comments = getCellValue(cells.get(3),false);
                        jTableRow.add(comments);
                        action.setComments(comments);
                        date = getCellValue(cells.get(4),true);
                        jTableRow.add(date);
                        action.setStartDate(parseDate(date));
                        date = getCellValue(cells.get(5),true);
                        jTableRow.add(date);
                        action.setDueDate(parseDate(date));
                        date = getCellValue(cells.get(6),true);
                        jTableRow.add(date);
                        action.setEndDate(parseDate(date));
                        progress = getCellValue(cells.get(8),true);
                        jTableRow.add(progress);
                        action.setProgress(Byte.parseByte(progress));
                        status = getStatusName(Integer.parseInt(getCellValue(cells.get(7),true))); 
                        jTableRow.add(status);
                        action.setStatus(Status.valueOf(status));
                        if(getCellValue(cells.get(9),false) != null){
                            double duration = Double.parseDouble(getCellValue(cells.get(9),false));
                            jTableRow.add(String.valueOf((int)duration));
                            action.setDuration((int) duration);
                        }
                        else
                            action.setDuration((byte)0);    
                        dm.addRow(jTableRow);
                        list.add(action);
                    }
                }  
                plan.setActionList(list);
            }
        }
        return new Object[]{meeting,dm};
    }
    
    public String getOwnerAcronym(String actionID, Facility facility) throws Exception{
        String query = "SELECT+A+WHERE+B+CONTAINS+%27"+actionID+"%27";
        Table result = gPlanB.selectQuery(query,"collaborator_action");
        if(result != null){
            int collaboratorID = Integer.parseInt(result.getUniqueCellValueOfUniqueRow(true));
            return facility.searchCollaborator(collaboratorID).getAcronymName();
        }
        return null;
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
        Facility facility = org.getFacility(facilityID,"id");
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
        String query;
        List<Cell> cells;
        HashMap<Integer, Collaborator> list = new HashMap();
        Table result;
        
        query = "SELECT+A,C,D,E,F,G+WHERE+B+CONTAINS+"+facilityID;
        result = gPlanB.selectQuery(query, "collaborator");
        if(result != null){
            for(Row row:result.getRows()){
                cells = row.getC();
                if(cells != null){
                    Collaborator collaborator = new Collaborator();
                    int collaboratorID = Integer.parseInt(getCellValue(cells.get(0),true));
                    collaborator.setCollaboratorId(collaboratorID);
                    collaborator.setFirstName(getCellValue(cells.get(1),false));
                    collaborator.setMiddleName(getCellValue(cells.get(2),false));
                    collaborator.setLastName(getCellValue(cells.get(3),false));
                    collaborator.setAcronymName(getCellValue(cells.get(4),false));
                    collaborator.setCharge(getCellValue(cells.get(5),false));
                    list.put(collaboratorID, collaborator);
                }
            }
        }
        return list;
    }
    
    private ArrayList getMeetings(Facility facility) throws SQLException, IOException{
        String query;
        Table result;
        List<Cell> cells;
        ArrayList<Meeting> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
        query = "SELECT+A,C,D,E,F+WHERE+B+CONTAINS+"+facility.getIntegerId();
        result = gPlanB.selectQuery(query, "meeting");
        if(result != null){
            for(Row row:result.getRows()){
                if(row != null){
                    cells = row.getC();
                    Meeting meeting = new Meeting();
                    int meetingID = Integer.parseInt(getCellValue(cells.get(0),true));
                    meeting.setName(getCellValue(cells.get(1),false));
                    meeting.setPurpose(getCellValue(cells.get(2),false));
                    meeting.setAcronym(getCellValue(cells.get(3),false));
                    meeting.setDateCreated(LocalDateTime.parse(getCellValue(cells.get(4),true),formatter));
                    meeting.setActionPlan(getActionPlan(meetingID,facility));
                    meeting.setTeam(getTeam(meetingID,facility));
                    meeting.setAditionalParticipants(getAdtParticipants(meetingID,facility));
                    list.add(meeting);
                }
            }
        }
        return list;
    }
    
    private ActionPlan getActionPlan(int meetingID, Facility facility) throws SQLException, IOException{
        String query;
        Table result;
        List<Cell> cells;
        ActionPlan actionPlan = new ActionPlan();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        query = "SELECT+A,C,D,E,F+WHERE+B+CONTAINS+"+meetingID;
        result = gPlanB.selectQuery(query, "actionplan");
        if(result != null){
            cells = result.getRows().get(0).getC();
            actionPlan.setId(Short.parseShort(getCellValue(cells.get(0),true)));
            actionPlan.setOwner(facility.searchCollaborator(Integer.parseInt(getCellValue(cells.get(1),true))));
            actionPlan.setDateCreated(LocalDateTime.parse(getCellValue(cells.get(2),true), formatter));
            actionPlan.setDateModified(LocalDateTime.parse(getCellValue(cells.get(3),true), formatter));
            actionPlan.setExecution(Byte.parseByte(getCellValue(cells.get(4),true)));
            actionPlan.setCurrentDate(LocalDateTime.now());
            query = "SELECT+A,C,D,E,F,G,H,I,J+WHERE+B+CONTAINS+"+actionPlan.getId();
            result = gPlanB.selectQuery(query,"apsummary");
            if(result != null){
                cells = result.getRows().get(0).getC();
                APSummary apsummary = new APSummary();
                apsummary.setId(Integer.parseInt(getCellValue(cells.get(0),true)));
                apsummary.setDateModified(LocalDateTime.parse(getCellValue(cells.get(1),true), formatter));
                apsummary.setActions(Integer.parseInt(getCellValue(cells.get(2),true)));
                apsummary.setActionsCancelled(Integer.parseInt(getCellValue(cells.get(3),true)));
                apsummary.setActionsCompleted(Integer.parseInt(getCellValue(cells.get(4),true)));
                apsummary.setActionsCompletedApp(Integer.parseInt(getCellValue(cells.get(5),true)));
                apsummary.setActionsInProgress(Integer.parseInt(getCellValue(cells.get(6),true)));
                apsummary.setActionsNearToDueDay(Integer.parseInt(getCellValue(cells.get(7),true)));
                apsummary.setActionsOverdue(Integer.parseInt(getCellValue(cells.get(8),true)));
                actionPlan.setZeros(Integer.parseInt(getCellValue(cells.get(2),true)));
                actionPlan.setSummary(apsummary);
            }
        }
        return actionPlan;
    }
    
    private ArrayList getMeetingIds(int facilityID) throws SQLException, IOException{
        String query;
        Table result;
        ArrayList list = new ArrayList();
        
        query = "SELECT+B+WHERE+A+CONTAINS+"+facilityID;
        result = gPlanB.selectQuery(query, "facility_meeting");
        if(result != null){
            for(Row row:result.getRows()){
                if(row != null)
                    list.add(Integer.parseInt(getCellValue(row.getC().get(0),true)));
            }
            return list;
        }
        return null;
    }
    
    public Object[] getMeetingsNames(){
        return org.getFacility("01","id").getMeetingsNames().toArray();
    }
    
    public ArrayList getCollaboratorIds(int facilityID) throws SQLException, IOException{
        String query;
        ArrayList list = new ArrayList(); 
        
        query = "SELECT+B+WHERE+A+CONTAINS+%27"+facilityID+"%27";
        Table result = gPlanB.selectQuery(query, "facility_collaborator");
        if(result != null){
            for (Row row : result.getRows()) {
                if(row != null)
                    list.add(Integer.parseInt(row.getCellValue(0, true)));
            }
            return list/**/;
        }
        return null;
    }
    
    public String getNewActionId(String meetingName) throws Exception{
        short number;
        String query;
        Facility facility = org.getFacility(meetingName,"meetingName"); 
        String id = facility.getId();
        Table result;
        Meeting meeting = facility.searchMeeting(meetingName); 
        String acronym = meeting.getAcronym();
        ActionPlan ap = meeting.getActionPlan();
        
        query = "SELECT+COUNT(A)+WHERE+B+CONTAINS+"+ap.getId();
        result = gPlanB.selectQuery(query, "action");
        if(result != null){
            float value = Float.parseFloat(result.getUniqueCellValueOfUniqueRow(false));
            number = (short)value;
            return com.lafargeholcim.planb.model.
                    Action.generateId(id, acronym, number, ap.getZeros());
        }
        return null;
    }
    
    private WorkTeam getTeam(int meetingID, Facility facility) throws SQLException, IOException{
        short workteamID;
        byte performance;
        String query;
        Table result;
        ArrayList<Collaborator> list = new ArrayList();
        
        query = "SELECT+A,C+WHERE+B+CONTAINS+"+meetingID;
        result = gPlanB.selectQuery(query, "workteam");
        if(result != null){
            workteamID = Short.parseShort(result.getRows().get(0).getCellValue(0,true));
            performance = Byte.parseByte(result.getRows().get(0).getCellValue(1,true));
            query = "SELECT+B+WHERE+A+CONTAINS+"+workteamID;
            result = gPlanB.selectQuery(query,"workteam_collaborator");
            if(result != null){
                WorkTeam workTeam= new WorkTeam();
                workTeam.setId(workteamID);
                workTeam.setPerformance(performance);
                for(Row row: result.getRows()){
                    if(row != null){
                        list.add(facility.searchCollaborator(
                                Integer.parseInt(row.getC().get(0).getF())));
                    }
                }
                workTeam.setMembers(list);
                return workTeam;
            }
        }
        return null;
    }
    
    public void addAction(String responsible, String detail, String comments, 
            String plannedStartDate, String plannedEndDate, 
            String status, byte progress, int duration, String meetingName) throws Exception{

        Facility facility = org.getFacility(meetingName,"meetingName"); 
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
            action.setStartDate(parseDate(plannedStartDate));
            action.setDueDate(parseDate(plannedEndDate));
            action.setEndDate(null);
            action.setStatus(Status.valueOf(status));
            action.setProgress((byte)progress);
            action.setDuration(duration);
            meeting.getActionPlan().getActionList().add(action);
            saveActionToDatabase(action, meeting);
            Aps.getUI().addRowToTableContent(new Object[]{
                action.getID(),action.getResponsible().getAcronymName(),
                action.getDetail(),action.getComments(),action.getStartDate().toString(),
                action.getDueDate().toString(),null,
                action.getProgress(),action.getStatus().toString(),action.getDuration()
            });
        }
        
    }
    
    public void modifyAction(Object[] rowDataModified, String meetingName) throws SQLException, Exception{
        Facility facility = org.getFacility(meetingName,"meetingName");
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
                action.setStartDate(parseDate(startDate));
                columns.add("plannedStartDate");
                list.add(rowDataModified[4]);
            }
            if(endDate != null){
                action.setDueDate(parseDate(endDate));
                columns.add("plannedEndDate");
                list.add(rowDataModified[5]);
            }
            if(realDate != null){
                action.setEndDate(parseDate(realDate));
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
                +"','"+action.getStartDate().toString()+"','"
                +action.getDueDate().toString()+"','"
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
        employeeID = action.getResponsible().getCollaboratorId();
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
            Facility facility = org.getFacility(meetingName,"meetingName"); 
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
        Facility facility = org.getFacility(meetingName,"meetingName");
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
    
    private ArrayList getAdtParticipants(int meetingID, Facility facility) throws SQLException, IOException{
        String query = "SELECT+A+WHERE+B+CONTAINS+"+meetingID;
        Table result = gPlanB.selectQuery(query, "adtparticipants_meeting");
        ArrayList<Collaborator> list = new ArrayList();
                
        if(result != null){
            for(Row row:result.getRows()){
                if(row != null)
                    list.add(facility.searchCollaborator(
                            Integer.parseInt(row.getC().get(0).getF())));
            }
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
