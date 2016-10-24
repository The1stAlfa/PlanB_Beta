/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.database.google.spreadsheets;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AI-Saac
 */
public class TableQuery {
    private String status;
    private ArrayList<String> headers;
    private ArrayList<List<Object>> table;

    public TableQuery() {
        this.headers = new ArrayList();
        this.table = new ArrayList();
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getHeaders() {
        return headers;
    }

    public ArrayList<List<Object>> getTable() {
        return table;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHeaders(ArrayList<String> headers) {
        this.headers = headers;
    }

    public void setTable(ArrayList<List<Object>> table) {
        this.table = table;
    }
    
    public void addHeader(String label){
        headers.add(label);
    }
    
    public void addRow(List<Object> row){
        table.add(row);
    }
}