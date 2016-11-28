/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.model.ActionItemFilter;
import com.lafargeholcim.planb.model.Status;
import com.lafargeholcim.planb.sys.Terminal;
import com.lafargeholcim.planb.util.Time;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author AI-Saac
 */
public class AddAction extends MaintenanceForm{
    private final String meetingName;
    private final Terminal terminal;
    private final JFrame parent;
    
    public AddAction(JFrame parent, Terminal terminal, String meetingName){
        super("Add Action");
        this.meetingName = meetingName;
        this.parent = parent;
        this.terminal = terminal;
        initComponents();
    }
    
    private void addWindowListener(){
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e){}

            @Override
            public void windowClosing(WindowEvent e){
                parent.setEnabled(true);
                JLabel label = (JLabel) ((UITerminal)parent).getJComponent("addIcon");
                label.setIcon(new ImageIcon(getClass().getResource("/images/plusWhite24.png")));
                ((UITerminal)parent).setFlag(false);
            }

            @Override
            public void windowClosed(WindowEvent e){}

            @Override
            public void windowIconified(WindowEvent e){
                ((UITerminal)parent).setState(ICONIFIED);
            }

            @Override
            public void windowDeiconified(WindowEvent e){
                //((UITerminal)parent).setState();
            }

            @Override
            public void windowActivated(WindowEvent e){}

            @Override
            public void windowDeactivated(WindowEvent e){}
        });
    }
    
    public void initComponents(){
        super.initComponents();
        super.setParticipantsNames(terminal.getParticipantsNames(meetingName));
        parent.setEnabled(false);
        addWindowListener();
        setDates();
        endDateChooser.setVisible(false);
        endDateLabel.setVisible(false);
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String startDate = Time.getDate(startDateChooser.getCalendar());
                    String dueDate = Time.getDate(dueDateChooser.getCalendar());
                    int duration = Time.getDaysBetweenDates(startDate, dueDate);
                    if(duration <= 0){
                        JOptionPane.showMessageDialog(getJDialog(),
                                "The Due Date can't be the same of the Start Date",
                                "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else if("".equals(detailTextArea.getText())){
                        JOptionPane.showMessageDialog(getJDialog(),
                                "The Action Detail can't be empty.","Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    else if(ownerComboBox.getSelectedItem() == null){
                        JOptionPane.showMessageDialog(getJDialog(),
                                "The Responsible for the action hasn't been selected.",
                                "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try {
                            Object[] options = { "Yes", "No" };                    
                            if(JOptionPane.showOptionDialog(getJDialog(),
                                "<html><center>Are you sure you want to add the Action?",
                                "Confirmation",JOptionPane.DEFAULT_OPTION, 
                                JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0){
                                terminal.addAction(ownerComboBox.getSelectedItem().toString(),
                                        detailTextArea.getText(),
                                        commentsTextArea.getText(),startDate,dueDate,
                                        statusTextField.getText(),
                                        (byte)progressSlider.getValue(),duration,meetingName);
                                ArrayList <Object> filterValues = new ArrayList();
                                filterValues.add(Status.IN_PROCESS);
                                ((UITerminal)parent).updateJTable(ActionItemFilter.STATUS, filterValues);
                                parent.setEnabled(true);
                                JLabel label = (JLabel) ((UITerminal)parent).getJComponent("addIcon");
                                label.setIcon(new ImageIcon(getClass().getResource("/images/plusWhite24.png")));
                                ((UITerminal)parent).setFlag(false);
                                getJDialog().dispose();
                           }
                        } 
                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(new JOptionPane(),"An Error has ocurred."
                                    + " Data was not save", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(new JOptionPane(), 
                        "Null date or wrong date format", "Date Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        cancellButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setEnabled(true);
                JLabel label = (JLabel) ((UITerminal)parent).getJComponent("addIcon");
                label.setIcon(new ImageIcon(getClass().getResource("/images/plusWhite24.png")));
                ((UITerminal)parent).setFlag(false);
                getJDialog().dispose();
            }
        });
   
    }
    
    public void setDates(){
        startDateChooser.setDate(Date.valueOf(Time.nowDate()));
        dueDateChooser.setDate(Date.valueOf(Time.nowDate().plusDays(1)));
    }
}
