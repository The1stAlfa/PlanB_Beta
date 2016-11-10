/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.init;

import com.lafargeholcim.planb.sys.Terminal;
import com.lafargeholcim.planb.view.LoginForm;
import com.lafargeholcim.planb.view.SplashWindow;
import com.lafargeholcim.planb.view.UITerminal;
import com.lafargeholcim.planb.model.Organization;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author AI-Saac
 */
public class Aps {

    /**
     *
     */
    private static  Organization org = new Organization();
    private static Terminal terminalAPS;
    private static UITerminal terminalUI;
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public static void main(String[] args)  {
        
        try {
            terminalAPS = new Terminal();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(terminalUI, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            LoginForm login = new LoginForm();
            try {
                //UIManager.setLookAndFeel(
                  //        UIManager.getCrossPlatformLookAndFeelClassName());
                //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                login.setVisible(true);
               /*
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }*/
            } catch (Exception ex) {
                System.out.println("MALito");
            }
        });
    }
    
    public static Organization getOrganization(){
        return org;
    }
    
    /**
     *
     * @return
     */
    public static Terminal getTerminal(){
        return terminalAPS;
    }
    
    /**
     *
     * @return
     */
    public static UITerminal getUI(){
        return terminalUI;
    }
    
    /**
     *
     * @throws java.io.IOException
     * @throws java.awt.FontFormatException
     */
    public static void initSystem() throws IOException, FontFormatException{
        try{
            SplashWindow window = new SplashWindow("planB-182x263.png", 
                new Frame(), 2500);
            terminalAPS.loadBusinessInformation();
            terminalUI = new UITerminal();
        }
        catch(Exception e){
        }
    }
}
