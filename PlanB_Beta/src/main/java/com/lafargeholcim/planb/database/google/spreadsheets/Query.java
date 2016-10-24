/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.database.google.spreadsheets;

/**
 *
 * @author AI-Saac
 */
public class Query {
    /**Google Structured Query*/
    private String gQuery;
    
    /**Google SpreadSheet ID*/
    private String spreadSheetId;
    
    /**General URL use to query a Google Spreadsheet*/
    private final String URL = 
            "https://spreadsheets.google.com/tq?&tq=";
    
    /**URL to make a specific query*/
    private String queryURL;

    public Query(String spreadSheetId, String query, String table) {
        this.spreadSheetId = spreadSheetId;
        this.gQuery = query;
        structuredUrlQuery(table);
    }

    public String getQueryURL() {
        return queryURL;
    }
    
    public void setGQuery(String query){
        this.gQuery = query;
    }

    public void setSpreadSheetId(String spreadSheetId) {
        this.spreadSheetId = spreadSheetId;
    }
    
    private void structuredUrlQuery(String table){
        queryURL = URL+gQuery+"&key="+spreadSheetId+"&sheet="+table; 
    }
}
