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
public enum ColorsDarcula {
    BLACK ("#3C3F41"),
    BLACK_DARK ("#303132"),
    BLACK_LIGHT ("#45494A"),
    FOREGROUND ("#BBBBBB"),
    HIGHTLIGHT ("#4B6EAF"),
    HIPERLINK ("#589DF6"),
    ORANGE ("#F07746"),
    PURPLE ("#9876AA");
    
    public String code;
    
    private ColorsDarcula(String code){
        this.code = code;
    }
}
