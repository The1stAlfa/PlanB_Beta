/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author AI-Saac
 */
public class Facility {
    //aps Class Variables 
    private static ArrayList<Collaborator> collaboratorsList;
    private static ArrayList<FuntionalArea> funtionalAreas;
    private ArrayList<Meeting> meetings;
    //************************************************************************
    private String id;
    private String name;
    private String acronym;
    private String city;
    
    /** 
    * Class Empty constructor.
    */    
    public Facility(){
        
    }

    public ArrayList<Collaborator> getCollaboratorList() {
        return collaboratorsList;
    }

    public ArrayList<FuntionalArea> getFuntional_areas() {
        return funtionalAreas;
    }

    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public String getCity() {
        return city;
    }
    
    public ArrayList getMeetingsNames(){
        ArrayList s = new ArrayList();
        for(Meeting meeting:meetings)
            s.add(meeting.getName());
        return s;
    }

    public void setCollaboratorList(ArrayList<Collaborator> collaboratorList) {
        this.collaboratorsList = collaboratorList;
    }

    public void setFuntionalAreas(ArrayList<FuntionalArea> funtionalAreas) {
        this.funtionalAreas = funtionalAreas;
    }

    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public Meeting searchMeeting(String name){
        for(Meeting meeting:meetings){
            if(meeting.getName().equalsIgnoreCase(name))
                return meeting;
        }
        return null;
    }
    
    public Collaborator searchCollaborator(String hint, byte type){
        if(type == 1){ //FULL NAME
            for(Collaborator collaborator: this.collaboratorsList){
                String collaboratorNames = collaborator.getFirstName()
                        +" "+ collaborator.getLastName();
                if(collaboratorNames.equalsIgnoreCase(hint))
                    return collaborator;
            }
        }
        else if(type == 2){ // ACRONYM
            for(Collaborator collaborator : this.collaboratorsList) {
                if(collaborator.getAcronymName().equalsIgnoreCase(hint))
                    return collaborator;
            }
        }
        return null;
    }
    
    public Collaborator searchCollaborator(int collaboratorId){
        for(Collaborator collaborator : this.collaboratorsList) {
            if(collaborator.getCollaboratorId() == collaboratorId)
                return collaborator;
        }
        return null;
    }
    
    public int getIntegerId(){
        if(id.substring(0).equals("0"))
            return Integer.parseInt(id);
        return Integer.parseInt(id.substring(1));
    }
}
