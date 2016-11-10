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
public enum Worksheet {
    /**
     *
     */
    ACCESS (0),
    /**
     *
     */
    ACTION (0),
    /**
     *
     */
    ACTIONPLAN (0),
    /**
     *
     */
    APSUMMARY (0),
    /**
     *
     */
    ADTPARTICIPANTS_MEETING (0),
    /**
     *
     */
    COLLABORATOR (0),
    /**
     *
     */
    FACILITY (0),
    /**
     *
     */
    FACILITY_COLLABORATOR (0),
    /**
     *
     */
    FOLLOWUP_ACTION (0),
    /**
     *
     */
    MEETING (0),
    /**
     *
     */
    USER (0),
    /**
     *
     */
    WORKTEAM (0),
    /**
     *
     */
    WORKTEAM_COLLABORATOR (0);
    
    private int sheetId;
    
    private Worksheet(int sheetId){
        this.sheetId = sheetId;
    }
    
    public int getSheetId(){
        return this.sheetId;
    }
    
    public void setSheetId(int sheetId){
        this.sheetId= sheetId;
    }
}
