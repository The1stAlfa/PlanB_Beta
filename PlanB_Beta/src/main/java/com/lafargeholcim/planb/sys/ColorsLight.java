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
public enum ColorsLight {
    BLUE ("1160AE"),
    HOLCIM_WHITE ("FCFEFC");
    
    public String code;
    
    private ColorsLight(String code){
        this.code = code;
    }
}
