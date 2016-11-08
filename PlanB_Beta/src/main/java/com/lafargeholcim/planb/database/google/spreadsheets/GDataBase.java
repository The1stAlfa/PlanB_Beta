/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.database.google.spreadsheets;

import com.lafargeholcim.planb.database.google.spreadsheets.json.model.Table;
import com.lafargeholcim.planb.database.google.spreadsheets.json.model.TableQueryModel;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.google.gson.Gson;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets.BatchUpdate;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets.Values.Update;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author AI-Saac
 */
public class GDataBase {
    /** Application name. */
    private static final String APPLICATION_NAME =
        "Google Sheets API Java Quickstart";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
        System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
        JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    private static Credential CREDENTIAL;
       
    /**Google SpreadSheet ID*/
    private String spreadsheetId;
    
    /**General URL use to query a Google Spreadsheet*/
    private final String URL = 
            "https://spreadsheets.google.com/tq?&tq=";
      
    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES =
        Arrays.asList(SheetsScopes.SPREADSHEETS); 
    
    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static HashMap<String, Worksheet> worksheets =
            new HashMap();
    
    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            //System.exit(1);
        }
    }
    
    public GDataBase() throws IOException{
        authorize();
        this.spreadsheetId = "1Xkd22LiN9unvv7GYOqsv3XwvjVMbFsi-EZASg4hxF9E";
        fetchSheetsIds();
    }
    
    public void setSpreadsheetId(String  spreadshseetId){
        this.spreadsheetId = spreadshseetId;
    }
    
    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public void authorize() throws IOException {
        // Load client secrets.
        InputStream in =
            GDataBase.class.getResourceAsStream("/secret/client_secret.json");
        GoogleClientSecrets clientSecrets =
            GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
            flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        CREDENTIAL = credential;
        /*
            public static void main(String[] args) {
              try {
                httpTransport = GoogleNetHttpTransport.newTrustedTransport();
                dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
                // authorization
                Credential credential = authorize();
                // set up global Plus instance
                plus = new Plus.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(
                    APPLICATION_NAME).build();
               // ...
            }

            private static Credential authorize() throws Exception {
              // load client secrets
              GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                  new InputStreamReader(PlusSample.class.getResourceAsStream("/client_secrets.json")));
              // set up authorization code flow
              GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                  httpTransport, JSON_FACTORY, clientSecrets,
                  Collections.singleton(PlusScopes.PLUS_ME)).setDataStoreFactory(
                  dataStoreFactory).build();
              // authorize
              return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
            }
        */
    }
        
    /**
     * Build and return an authorized Sheets API client service.
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public Sheets getSheetsService() throws IOException {
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, CREDENTIAL)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
    public Table selectQuery(String query, String table) throws IOException{
        String urlQuery = URL+query+"&key="+spreadsheetId+"&sheet="+table;
        DBRequest request = new DBRequest("");
        try {
            request.get(urlQuery);
        } catch (IOException ex) {
            Logger.getLogger(GDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(request.getResponseCode() == 200)
            return readResponse(request.getDbResponse());
        
        return null;
    }
    
    public void update(){
        
    }
    
    public void insert(String sheetTitle, List<CellData> values){
        try {
            /*
            Sheets service = getSheetsService();
            String range = "access";
            ValueRange values = new ValueRange();
            List<List<Object>> ob = new ArrayList<>();
            List<Object> o = new ArrayList<>();
            o.add("01CTE0026");
            o.add("3");
            ob.add(o);
            values.setValues(ob);
            values.setMajorDimension("ROWS");
            Update v = service.spreadsheets().values().update(spreadsheetId, range, values);
            
            v.setValueInputOption("USER_ENTERED");
            UpdateValuesResponse y = v.execute();
            System.out.println("");
            //.update(range, range, vr)
            //service.spreadsheets().values().
            */
            Sheets service = getSheetsService();
            List<Request> requests = new ArrayList<>();
            int sheetId = getSheetId(sheetTitle);
                   
            requests.add(new Request()
                    .setAppendCells(new AppendCellsRequest()
                    .setSheetId(sheetId)
                    .setRows(Arrays.asList(
                        new RowData().setValues(values)))
                        .setFields("userEnteredValue,userEnteredFormat.backgroundColor")));

            BatchUpdateSpreadsheetRequest batchUpdateRequest = 
                    new BatchUpdateSpreadsheetRequest()
                    .setRequests(requests);
            
            service.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
                    .execute();
        } catch (IOException ex) {
            Logger.getLogger(GDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        
    }
    
    private void fetchSheetsIds() throws IOException{
        String sheetsIdURL = 
                "https://sheets.googleapis.com/v4/spreadsheets/"+spreadsheetId
                +"?&fields=sheets.properties";
        Sheets service = getSheetsService();
        Spreadsheet spreadsheet = service.spreadsheets().get(sheetsIdURL)
                                    .setSpreadsheetId(spreadsheetId)
                                    .execute();
        List<Sheet> sheets = spreadsheet.getSheets();
        for(Sheet sheet:sheets){
            String title = sheet.getProperties().getTitle();
            Worksheet worksheet;
            switch(title){
                case "action":
                    worksheet = Worksheet.ACTION;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());
                    worksheets.put("action",worksheet);
                case "actionplan":
                    worksheet = Worksheet.ACTIONPLAN;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());
                    worksheets.put("actionplan", worksheet);
                case "adtparticipants_meeting":
                    worksheet = Worksheet.ADTPARTICIPANTS_MEETING;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());
                    worksheets.put("actionplan", worksheet);
                case "apsummary":
                    worksheet = Worksheet.APSUMMARY;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("apsummary", worksheet);
                case "collaborator":
                    worksheet = Worksheet.COLLABORATOR;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("collaborator", worksheet);
                case "facility":
                    worksheet = Worksheet.FACILITY;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("facility", worksheet);
                case "facility_collaborator":
                    worksheet = Worksheet.FACILITY_COLLABORATOR;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("facility_collaborator", worksheet);
                case "followup_action":
                    worksheet = Worksheet.FOLLOWUP_ACTION;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("followup_action", worksheet);
                case "meeting":
                    worksheet = Worksheet.MEETING;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("meeting", worksheet);
                case "user":
                    worksheet = Worksheet.USER;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("user", worksheet);
                case "workteam":
                    worksheet = Worksheet.WORKTEAM;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("workteam", worksheet);
                case "workteam_collaborator":
                    worksheet = Worksheet.WORKTEAM_COLLABORATOR;
                    worksheet.setSheetId(sheet.getProperties().getSheetId());    
                    worksheets.put("workteam_collaborator", worksheet);
            }
        }
    }
    
    private Table readResponse(InputStream response) throws IOException{
        Pattern pattern = Pattern.compile(".\\((.*?)\\);");
        Matcher matcher = pattern.matcher(convertStreamToString(response));
        matcher.find();
        String jsonElement = matcher.group(1);
        if(!jsonElement.contains("\"status\":\"error\"")){
            Gson gsonFactory = new Gson(); 
            TableQueryModel tableModel = gsonFactory.fromJson(jsonElement, TableQueryModel.class);
            return tableModel.getTable();
        }
        return null;
    }
    
    private static String convertStreamToString(InputStream input) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder result = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null)
                result.append(line); 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }
    
    private int getSheetId(String sheetTitle){
        return worksheets.get(sheetTitle).getSheetId();
    }
}
