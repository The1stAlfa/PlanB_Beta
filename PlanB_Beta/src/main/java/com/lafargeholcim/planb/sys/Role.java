/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.sys;

/**
 *
 * @author AI-Saac
 */
public enum Role {
    ADMIN (1),
    OWNER (2),
    PRIVILEGED (3),
    NORMAL (4);
    
    private int value;
    
    private Role(int value){
        this.value = value;
    }
    
    public int getValue(){
        return this.value;
    }
}
