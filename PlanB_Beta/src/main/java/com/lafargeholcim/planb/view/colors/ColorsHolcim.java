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
    WHITE ("#FCFEFC"),
    RED ("#FE4344"),
    GRAY ("#9B9B9B");
    
    public String code;
    
    private ColorsHolcim(String code){
        this.code = code;
    }
}
