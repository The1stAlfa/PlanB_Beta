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
public enum ColorsHolcim {
    BLUE ("#355F91"),
    WHITE ("#FCFEFC"),
    RED ("#FE4344"),
    GRAY ("#9B9B9B"),
    BROWN_LIGHT ("#C2B4A7");
    
    public String code;
    
    private ColorsHolcim(String code){
        this.code = code;
    }
}
