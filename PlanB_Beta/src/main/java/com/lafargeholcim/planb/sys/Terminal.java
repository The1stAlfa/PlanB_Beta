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
import com.lafargeholcim.planb.init.Aps;
import com.lafargeholcim.planb.database.google.spreadsheets.GDataBase;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Cell;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Row;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Table;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.CellFormat;
import com.google.api.services.sheets.v4.model.ExtendedValue;
import com.google.api.services.sheets.v4.model.Request;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.HashMap;
import com.lafargeholcim.planb.util.Time;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Terminal{
    private byte id;
    private User user;
    private static final String SALT = "MtO27:37";
    private final Organization org;
    private GDataBase gPlanB;
    
    public Terminal() throws Exception {
        user = new User();
        org = Aps.getOrganization();
        gPlanB = new GDataBase();
        
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
        
        query = "SELECT+C+WHERE+B+CONTAINS+"+user.getCollaboratorId();
        Table result = gPlanB.selectQuery(query, "collaborator");
        if(result != null){
            if(result.getRows().size() == 1){
                facility.setId("0"+result.getUniqueCellValueOfUniqueRow(true));
                query = "SELECT+C,D,E+WHERE+B+CONTAINS+"+facility.getIntegerId();
                result = gPlanB.selectQuery(query, "facility");
                if(result != null){
                    List<Cell> cells = result.getRows().get(0).getC();
                    facility.setName(getCellValue(cells.get(0),false));
                    facility.setAcronym(getCellValue(cells.get(1),false));
                    facility.setCity(getCellValue(cells.get(2),false));
                    facility.setCollaboratorList(
                            getCollaborators(facility.getIntegerId()));
                    facility.setMeetings(getMeetings(facility));
                    org.getFacilities().add(facility);
                }
                else
                    throw new Exception("Error in query response."
                            + " Null pointer for TableQuery");
            }
        }
        else
            throw new Exception("Error in query response. "
                    + "Null pointer for TableQuery"); 
    }
    
    public boolean login(String username, String password) 
            throws NoSuchAlgorithmException, SQLException, Exception{
        boolean isAuthenticated = false;
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        
        String query = "SELECT+C,D,G+WHERE+B+CONTAINS+%27"+username
                +"%27AND+E+CONTAINS+%27"+hashedPassword+"%27";
        Table result = gPlanB.selectQuery(query,"user");
        if(result != null){
            if(result.getRows().size() == 1){
                List<Cell> cells = result.getRows().get(0).getC();
                user.setUsername(username);
                user.setEmail(getCellValue(cells.get(1),false));
                user.setRole(getRole(Integer.parseInt(
                        getCellValue(cells.get(2),true))));
                user.setCollaboratorId(Integer.parseInt(
                        getCellValue(cells.get(0),true)));
                isAuthenticated = true;
            }
        }
        else
            throw new Exception("Error in query response. Null pointer for TableQuery");
        return isAuthenticated;
    }
    
    private static String generateHash(String input) 
            throws NoSuchAlgorithmException{
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++)
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        
        return sb.toString();
    }
    
    private ActionPlan getActionPlan(int meetingID, Facility facility)
            throws SQLException, IOException{
        
        String query;
        Table result;
        List<Cell> cells;
        ActionPlan actionPlan = new ActionPlan();
        
        query = "SELECT+B,D,E,F,G+WHERE+C+CONTAINS+"+meetingID;
        result = gPlanB.selectQuery(query, "actionplan");
        if(result != null){
            cells = result.getRows().get(0).getC();
            actionPlan.setId(Short.parseShort(getCellValue(cells.get(0),true)));
            actionPlan.setOwner(facility.searchCollaborator(
                    Integer.parseInt(getCellValue(cells.get(1),true))));
            actionPlan.setDateCreated(Time.parseDateTime(
                    getCellValue(cells.get(2),true)));
            actionPlan.setDateModified(Time.parseDateTime(
                    getCellValue(cells.get(3),true)));
            String execution = getCellValue(cells.get(4),true);
            actionPlan.setExecution(
                    Byte.parseByte(execution.substring(0, execution.length()-1)));
            actionPlan.setCurrentDate(Time.nowDateTime());
            query = "SELECT+B,D,E,F,G,H,I,J,K+WHERE+C+CONTAINS+"+actionPlan.getId();
            result = gPlanB.selectQuery(query,"apsummary");
            if(result != null){
                cells = result.getRows().get(0).getC();
                APSummary apsummary = new APSummary();
                apsummary.setId(Integer.parseInt(getCellValue(cells.get(0),true)));
                apsummary.setDateModified(Time.parseDateTime(
                        getCellValue(cells.get(1),true)));
                apsummary.setActions(Integer.parseInt(
                        getCellValue(cells.get(2),true)));
                apsummary.setActionsCancelled(Integer.parseInt(
                        getCellValue(cells.get(3),true)));
                int actionCompleted = Integer.parseInt(
                        getCellValue(cells.get(4),true)) + Integer.parseInt(
                        getCellValue(cells.get(5),true));
                apsummary.setActionsCompleted(actionCompleted);
                apsummary.setActionsCompletedApp(Integer.parseInt(
                        getCellValue(cells.get(5),true)));
                apsummary.setActionsInProgress(Integer.parseInt(
                        getCellValue(cells.get(6),true)));
                apsummary.setActionsNearToDueDay(Integer.parseInt(
                        getCellValue(cells.get(7),true)));
                apsummary.setActionsOverdue(Integer.parseInt(
                        getCellValue(cells.get(8),true)));
                actionPlan.setZeros(Integer.parseInt(
                        getCellValue(cells.get(2),true)));
                actionPlan.setSummary(apsummary);
            }
        }
        return actionPlan;
    }
    
    private ArrayList getAdtParticipants(int meetingID, Facility facility) 
            throws SQLException, IOException{
        
        String query = "SELECT+B+WHERE+C+CONTAINS+"+meetingID;
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
    
    private CellData getCellData(Double value){
        return new CellData()
                .setUserEnteredValue(new ExtendedValue()
                .setNumberValue(value));
    }
    
    private CellData getCellData(String value, boolean formula){
        if(formula){
            return new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                            .setFormulaValue(value));
        }
        return new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                            .setStringValue(value));
    }
    
    private String getCellValue(Cell cell, boolean formatted){
        if(cell != null){
            if(formatted)
                return cell.getF();
            return cell.getV();
        }
        return null;
    }
    
    public Collaborator getCollaborator(String facilityID, String collaboratorAcronym){
        Facility facility = org.getFacility(facilityID,"id");
        return facility.searchCollaborator(collaboratorAcronym,(byte) 2);
    }
    
    private HashMap<Integer, Collaborator> getCollaborators(int facilityID) 
            throws SQLException, IOException{
        String query;
        List<Cell> cells;
        HashMap<Integer, Collaborator> list = new HashMap();
        Table result;
        
        query = "SELECT+B,D,E,F,G,H+WHERE+C+CONTAINS+"+facilityID;
        result = gPlanB.selectQuery(query, "collaborator");
        if(result != null){
            for(Row row:result.getRows()){
                cells = row.getC();
                if(cells != null){
                    Collaborator collaborator = new Collaborator();
                    int collaboratorID = Integer.parseInt(
                            getCellValue(cells.get(0),true));
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
    
    public byte getId() {
        return id;
    }
    
    private ArrayList getMeetings(Facility facility) 
            throws SQLException, IOException{
        String query;
        Table result;
        List<Cell> cells;
        ArrayList<Meeting> list = new ArrayList<>();
            
        query = "SELECT+B,D,E,F,G+WHERE+C+CONTAINS+"+facility.getIntegerId();
        result = gPlanB.selectQuery(query, "meeting");
        if(result != null){
            for(Row row:result.getRows()){
                if(row != null){
                    cells = row.getC();
                    Meeting meeting = new Meeting();
                    int meetingID = Integer.parseInt(
                            getCellValue(cells.get(0),true));
                    meeting.setMeetingId(meetingID);
                    meeting.setName(getCellValue(cells.get(1),false));
                    meeting.setPurpose(getCellValue(cells.get(2),false));
                    meeting.setAcronym(getCellValue(cells.get(3),false));
                    meeting.setDateCreated(Time.parseDateTime(
                            getCellValue(cells.get(4),true)));
                    meeting.setActionPlan(getActionPlan(meetingID,facility));
                    meeting.setTeam(getTeam(meetingID,facility));
                    meeting.setAditionalParticipants(
                            getAdtParticipants(meetingID,facility));
                    list.add(meeting);
                }
            }
        }
        return list;
    }
    
    public Object[] getMeetingsNames(){
        return org.getFacility("01","id").getMeetingsNames().toArray();
    }
    
    public String getNewActionId(String meetingName) 
            throws Exception{
        short number;
        String query;
        Facility facility = org.getFacility(meetingName,"meetingName"); 
        String id = facility.getId();
        Table result;
        Meeting meeting = facility.searchMeeting(meetingName); 
        String acronym = meeting.getAcronym();
        ActionPlan ap = meeting.getActionPlan();
        
        query = "SELECT+COUNT(B)+WHERE+C+CONTAINS+"+ap.getId();
        result = gPlanB.selectQuery(query, "action");
        if(result != null){
            float value = Float.parseFloat(
                    result.getUniqueCellValueOfUniqueRow(false));
            number = (short)value;
            return com.lafargeholcim.planb.model.
                    Action.generateId(id, acronym, number, ap.getZeros());
        }
        return null;
    }
    
    public String getOwnerAcronym(String actionID, Facility facility) 
            throws Exception{
        String query = "SELECT+B+WHERE+C+CONTAINS+%27"+actionID+"%27";
        Table result = gPlanB.selectQuery(query,"collaborator_action");
        if(result != null){
            int collaboratorID = Integer.parseInt(result.getUniqueCellValueOfUniqueRow(true));
            return facility.searchCollaborator(collaboratorID).getAcronymName();
        }
        return null;
    }
    
    public String[] getParticipantsNames(String meetingName){
        Facility facility = org.getFacility(meetingName,"meetingName");
        Meeting meeting = facility.searchMeeting(meetingName);
        ArrayList<Collaborator> members = 
                (ArrayList<Collaborator>)meeting.getTeam().getMembers().clone();
        if(!meeting.getAditionalParticipants().isEmpty())
            members.addAll((ArrayList<Collaborator>)meeting
                    .getAditionalParticipants()
                    .clone());
        
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
    
    private Role getRole(int roleValue){
        Role roles[] = Role.values();
        for(Role role:roles){
            if(role.getValue() == roleValue)
                return role;
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
    
    public Object[] getTableContent(ActionItemFilter filter, String meetingName) throws Exception{
        String actionID, responsible, detail, comments,
                date, progress, status, query;
        ActionPlan plan;
        Table result;
        List<Cell> cells;
        Facility facility = org.getFacility(meetingName,"meetingName");
        Meeting meeting = facility.searchMeeting(meetingName);
        
        if(meeting!= null){
            plan = getActionPlan(meeting.getMeetingId(), facility);
            meeting.setActionPlan(plan);
        }
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
            query = "SELECT+B,D,E,F,G,H,I,L,M,DATEDIFF(H,G)+WHERE+C+CONTAINS+"+plan.getId()+
                    "+AND+N+CONTAINS+0+LABEL+DATEDIFF(H,G)+%27duration%27";
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
                        responsible = facility.searchCollaborator(
                                Integer.parseInt(getCellValue(cells.get(1),true)))
                                .getAcronymName();
                        jTableRow.add(responsible);
                        action.setResponsible(
                                getCollaborator(facility.getId(),responsible));
                        detail = getCellValue(cells.get(2),false);
                        jTableRow.add(detail);
                        action.setDetail(detail);
                        comments = getCellValue(cells.get(3),false);
                        jTableRow.add(comments);
                        action.setComments(comments);
                        date = getCellValue(cells.get(4),true);
                        jTableRow.add(date);
                        action.setStartDate(Time.parseDate(date));
                        date = getCellValue(cells.get(5),true);
                        jTableRow.add(date);
                        action.setDueDate(Time.parseDate(date));
                        date = getCellValue(cells.get(6),true);
                        jTableRow.add(date);
                        action.setEndDate(Time.parseDate(date));
                        progress = getCellValue(cells.get(8),true);
                        jTableRow.add(progress);
                        action.setProgress(Byte.parseByte(progress));
                        status = getStatusName(
                                Integer.parseInt(getCellValue(cells.get(7),true))); 
                        jTableRow.add(status);
                        action.setStatus(Status.valueOf(status));
                        if(getCellValue(cells.get(9),false) != null){
                            double duration = 
                                    Double.parseDouble(
                                            getCellValue(cells.get(9),false));
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
    
    private WorkTeam getTeam(int meetingID, Facility facility) throws SQLException, IOException{
        short workteamID;
        byte performance;
        String query;
        Table result;
        ArrayList<Collaborator> list = new ArrayList();
        
        query = "SELECT+B,D+WHERE+C+CONTAINS+"+meetingID;
        result = gPlanB.selectQuery(query, "workteam");
        if(result != null){
            workteamID = Short.parseShort(result.getRows().get(0).getCellValue(0,true));
            performance = Byte.parseByte(result.getRows().get(0).getCellValue(1,true));
            query = "SELECT+C+WHERE+B+CONTAINS+"+workteamID;
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
    
    public User getUser() {
        return user;
    }
    
    public void addAction(String responsible, String detail, String comments, 
            String startDate, String dueDate, String statusName, byte progress,
            int duration, String meetingName) throws Exception{
        
        short actionplanId;
        Collaborator collaborator;
        String actionId;
        Status status;
        Facility facility = org.getFacility(meetingName,"meetingName"); 
        Meeting meeting = facility.searchMeeting(meetingName);
        
        actionId = getNewActionId(meetingName);
        actionplanId = meeting.getActionPlan().getId();
        collaborator = facility.searchCollaborator(responsible,(byte)1);
        status = Status.valueOf(statusName);
        saveActionToDatabase(
                actionId, actionplanId, collaborator.getCollaboratorId(),
                detail, comments, startDate, dueDate, status.getValue(), 
                progress, meeting);
    }
    
    public void modifyAction(Object[] rowDataModified, String meetingName) throws SQLException, Exception{
        Facility facility = org.getFacility(meetingName,"meetingName");
        Meeting meeting = facility.searchMeeting(meetingName);
        ActionPlan plan = meeting.getActionPlan();
        Action action;
        byte progress = -1;
        String itemId, actionDetail=null,actionComments=null,startDate=null,
                dueDate=null,endDate=null;
        Status status = null;
        ArrayList<Integer> columnsIndex = new ArrayList();
        ArrayList<Object> list = new ArrayList();
        
        itemId = String.valueOf(rowDataModified[0]);
        if(rowDataModified[2] != null)
            actionDetail = String.valueOf(rowDataModified[2]);
        if(rowDataModified[3] != null)
            actionComments = String.valueOf(rowDataModified[3]);
        if(rowDataModified[4] != null)
            startDate = String.valueOf(rowDataModified[4]);
        if(rowDataModified[5] != null)
            dueDate = String.valueOf(rowDataModified[5]);
        if(rowDataModified[6] != null)
            endDate = String.valueOf(rowDataModified[6]);
        if(rowDataModified[7] != null)
            progress = (byte) Integer.parseInt(rowDataModified[7].toString());
        if(rowDataModified[8] != null)
            status = Status.valueOf(String.valueOf(rowDataModified[8]));
        
        action = plan.searchAction(itemId);
        if(action != null){
            if(actionDetail != null){
                action.setDetail(actionDetail);
                columnsIndex.add(4);
                list.add(rowDataModified[2]);
            }
            if(actionComments != null){
                action.setComments(actionComments);
                columnsIndex.add(5);  
                list.add(rowDataModified[3]);
            }
            if(startDate != null){
                action.setStartDate(Time.parseDate(startDate));
                columnsIndex.add(6);
                list.add(Time.getSerialNumberDate(startDate, false));
            }
            if(dueDate != null){
                action.setDueDate(Time.parseDate(dueDate));
                columnsIndex.add(7);
                list.add(Time.getSerialNumberDate(dueDate, false));
            }
            if(endDate != null){
                action.setEndDate(Time.parseDate(endDate));
                columnsIndex.add(8);
                list.add(Time.getSerialNumberDate(endDate, false));
            }
            if(progress != -1){
                action.setProgress(progress);
                columnsIndex.add(12);
                list.add(Double.parseDouble(rowDataModified[7].toString()));
            }
            if(status != null){
                action.setStatus(status);
                columnsIndex.add(11);
                list.add((double)status.getValue());
            }
           updateActionToDatabase(itemId,columnsIndex,list);
           //Aps.getUI().modifiedTableContent(rowDataModified);
        }
    }
    
    private String saveActionToDatabase(String actionId, short actionplanId, int collaboratorId, 
            String detail, String comments, String startDate, String dueDate, 
            int statusValue, byte progress, Meeting meeting) throws SQLException, Exception{
        
        String temporalActionId = actionId;
        List<CellData> values = new ArrayList<>();

        values.add(getCellData("=row()", true)); // Value for the index
        values.add(getCellData(actionId, false));  // Value for actionId
        values.add(getCellData((double)actionplanId));  // Value for actionplanId
        values.add(getCellData((double)collaboratorId));  // Value for collaboratorId
        values.add(getCellData(detail, false));  // Value for detail
        values.add(getCellData(comments, false));  // Value for comments
        values.add(getCellData(Time.getSerialNumberDate(startDate, false))
                .setFormattedValue(startDate));  // Value for startDate
        values.add(getCellData(Time.getSerialNumberDate(dueDate, false))
                .setFormattedValue(dueDate));  // Value for dueDate
        values.add(getCellData("", false));  // Value for finishDate
        values.add(getCellData(
                Time.getSerialNumberDate(
                Time.getNow(), true)));  // Value for DateCreated
        values.add(getCellData("", false));  // Value for DateModified
        values.add(getCellData((double)statusValue));  // Value for status
        values.add(getCellData((double)progress));  // Value for progress
        values.add(getCellData((double)0));  // Value for isDeleted
        /*
        String q = "=IF(ISERROR(QUERY(action!$B$2:$N;\"SELECT COUNT(B) WHERE l = 6 AND C = \"&$C2&\" AND N=0 LABEL COUNT(B) ''\"));0;QUERY(action!$B$2:$N;\"SELECT COUNT(B) WHERE L = 6 AND C = \"&$C2&\" AND N=0 LABEL COUNT(B) ''\"))";
        values.add();
        */
        while(isDuplicatedActionId(temporalActionId)){
            temporalActionId = getNewActionId(meeting.getName());
            if(!temporalActionId.equals(actionId)){
                values.set(0, getCellData(temporalActionId, false));
                gPlanB.insert("action", values);
                return temporalActionId;
            }
        }
        gPlanB.insert("action", values);
        return temporalActionId;
    }
    
    public void setId(byte id) {
        this.id = id;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public boolean signup(String username, String password) throws NoSuchAlgorithmException{
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        System.out.println(hashedPassword);
        return false;
    }
    
    private boolean updateActionToDatabase(String actionID, 
            ArrayList<Integer> columnsIndex, ArrayList<Object> list)
            throws SQLException, Exception{
        
        int rowIndex, columnIndex;
        List<Request> requests = new ArrayList();
        String query = "SELECT+A+WHERE+B+CONTAINS+%27"+actionID+"%27";
        Table result = gPlanB.selectQuery(query, "action");
        
        if(result != null){
            if(result.getRows().size() == 1){
                rowIndex = Integer.parseInt(
                        result.getUniqueCellValueOfUniqueRow(true))-1;
                for(int c=0; c<columnsIndex.size(); c++){
                    List<CellData> values = new ArrayList<>();
                    columnIndex = columnsIndex.get(c);
                    if(columnIndex == 11 || columnIndex == 12 
                            || (columnIndex>= 6 && columnIndex<=8))
                        values.add(getCellData((Double)list.get(c)));
                    else
                        values.add(getCellData(list.get(c).toString(), false));
                    requests.add(gPlanB.getRequest("action", values, rowIndex, 
                            columnIndex));
                }
                gPlanB.update(requests);
            }
        }
        

        
        return true;
    }
    
    public boolean deleteAction(String actionID, String meetingName) throws Exception{
        int rowIndex = 0, columnIndex = 13;
        List<Request> requests = new ArrayList();
        String query = "SELECT+A+WHERE+B+CONTAINS+%27"+actionID+"%27";
        Table result = gPlanB.selectQuery(query, "action");
        
        if(result != null){
            if(result.getRows().size() == 1){
                rowIndex = Integer.parseInt(
                        result.getUniqueCellValueOfUniqueRow(true))-1;
                List<CellData> values = new ArrayList<>();
                values.add(new CellData()
                            .setUserEnteredValue(new ExtendedValue()
                            .setNumberValue((double)1)));
                requests.add(gPlanB.getRequest("action", values, rowIndex, 
                            columnIndex));
                gPlanB.update(requests);
                return true;
            }
        }
        return false;
    }
    
    private boolean isDuplicatedActionId(String actionId) throws IOException{
        String query = 
                "SELECT+COUNT(B)+WHERE+B+CONTAINS+%27"+actionId+"%27";
        Table result = gPlanB.selectQuery(query, "action");
        
        if(result != null){
            if(result.getRows().size() == 1 &&
                    result.getUniqueCellValueOfUniqueRow(false).equals("1.0"))
                return true;
        }
        return false;
    }
}
