/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view.colors;

/**
 *
 * @author AI-Saac
 */
public enum ColorsLight {
    BLACK_ABSOLUTE ("#000000"),
    BLUE ("#1160AE"),
    WHITE_ABSOLUTE ("#FFFFFF"),
    YELLOW_DRIVE ("#64D610");
    
    public String code;
    
    private ColorsLight(String code){
        this.code = code;
    }
}
