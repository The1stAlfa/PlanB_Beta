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
public enum ColorsDarcula {
    BLACK ("#3C3F41"),
    DARK_BLACK ("#303132"),
    LIGHT_BLACK ("#45494A"),
    HIGHTLIGHT ("");
    
    public String code;
    
    private ColorsDarcula(String code){
        this.code = code;
    }
}
