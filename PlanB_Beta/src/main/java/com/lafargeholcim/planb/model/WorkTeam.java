/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.model;

import java.util.ArrayList;

/**
 *
 * @author AI-Saac
 */
public class WorkTeam {
    //aps Class Variables
    private ArrayList<Collaborator> membersList;
    private ArrayList<ActionPlan> plansIdList;
    //************************************************************************
    private short id;
    private byte performance; // Team APP Percentage of performance
    
    /**
     *
     */
    public WorkTeam(){
        
    }
    
    /**
     *
     * @param members
     * @param plansID_list
     */
    public WorkTeam(ArrayList<Collaborator> membersList, ArrayList<ActionPlan> plansIdList) {
        setId((short)2);
        this.membersList = membersList;
        this.plansIdList = plansIdList;
    }

    /**
     *
     * @return
     */
    public ArrayList<Collaborator> getMembers() {
        return membersList;
    }

    /**
     *
     * @return
     */
    public ArrayList<ActionPlan> getPlansIdList() {
        return plansIdList;
    }

    /**
     *
     * @return
     */
    public short getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public byte getPerformance() {
        return performance;
    }

    /**
     *
     * @param members
     */
    public void setMembers(ArrayList<Collaborator> membersList) {
        this.membersList = membersList;
    }

    /**
     *
     * @param plansID_list
     */
    public void setPlansIdList(ArrayList<ActionPlan> plansIdList) {
        this.plansIdList = plansIdList;
    }

    /**
     *
     * @param id
     */
    public void setId(short id) {
        this.id = id;
    }

    /**
     *
     * @param performance
     */
    public void setPerformance(byte performance) {
        this.performance = performance;
    }
    
    public Collaborator searchMember(String hint, byte type){
        if(type == 1){ //FULL NAME
            for(Collaborator collaborator: this.membersList){
                String collaboratorNames = collaborator.getFirstName()
                        +" "+ collaborator.getLastName();
                if(collaboratorNames.equalsIgnoreCase(hint))
                    return collaborator;
            }
        }
        else if(type == 2){ // ACRONYM
            for(Collaborator collaborator : this.membersList) {
                if(collaborator.getAcronymName().equalsIgnoreCase(hint))
                    return collaborator;
            }
        }
        return null;
    }
    
    public Collaborator searchMember(int collaboratorId){
        for(Collaborator collaborator : this.membersList) {
            if(collaborator.getCollaboratorId() == collaboratorId)
                return collaborator;
        }
        return null;
    }
}
