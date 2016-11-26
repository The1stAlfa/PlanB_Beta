/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author AI-Saac
 */
public class Meeting {
    //aps Class Variables 
    private ArrayList<Collaborator> adtParticipants; //aditional partcipants
    private WorkTeam team; 
    private ActionPlan actionPlan;
 //************************************************************************
    private int meetingId;
    private String name;
    private String acronym;
    private String purpose;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    
    public Meeting(){
        
    }
    
    /** 
    * Class Empty constructor.
     * @param name
    */
    public Meeting(String name){
        setAcronym(name);
    }
    
    /**
     *
     * @param name
     * @param purpose
     * @param id
     * @param date_created
     */
    public Meeting(String name, String purpose, LocalDateTime dateCreated){
        this.name = name;
        this.purpose = purpose;
        this.dateCreated = dateCreated;
        
    }

    /**
     *
     * @return
     */
    public ArrayList<Collaborator> getAditionalParticipants() {
        return adtParticipants;
    }

    /**
     *
     * @return
     */
    public WorkTeam getTeam() {
        return team;
    }

    /**
     *
     * @return
     */
    public ActionPlan getActionPlan() {
        return actionPlan;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public int getMeetingId() {
        return meetingId;
    }

    /**
     *
     * @return
     */
    public String getAcronym() {
        return acronym;
    }

    /**
     *
     * @return
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getDateModified() {
        return dateModified;
    }

    /**
     *
     * @param adtParticipants
     */
    public void setAditionalParticipants(ArrayList<Collaborator> adtParticipants) {
        this.adtParticipants = adtParticipants;
    }

    /**
     *
     * @param team
     */
    public void setTeam(WorkTeam team) {
        this.team = team;
    }

    /**
     *
     * @param actionPlan
     */
    public void setActionPlan(ActionPlan actionPlan) {
        this.actionPlan = actionPlan;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param acronym
     */
    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    /**
     *
     * @param purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     *
     * @param date_created
     */
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     *
     * @param date_modified
     */
    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }
    
    public Collaborator searchParticipant(String hint, byte type){
        ArrayList<Collaborator> list = (ArrayList<Collaborator>)adtParticipants.clone();
        list.addAll(team.getMembers());
        if(type == 1){ //FULL NAME
            for(Collaborator collaborator: list){
                String collaboratorNames = collaborator.getFirstName()
                        +" "+ collaborator.getLastName();
                if(collaboratorNames.equalsIgnoreCase(hint))
                    return collaborator;
            }
        }
        else if(type == 2){ // ACRONYM
            for(Collaborator collaborator : list) {
                if(collaborator.getAcronymName().equalsIgnoreCase(hint))
                    return collaborator;
            }
        }
        return null;
    }
    
    public Collaborator searchParticipant(int collaboratorId){
        ArrayList<Collaborator> list = (ArrayList<Collaborator>)adtParticipants.clone();
        list.addAll(team.getMembers());
        for(Collaborator collaborator : list) {
            if(collaborator.getCollaboratorId() == collaboratorId)
                return collaborator;
        }
        return null;
    }
}
