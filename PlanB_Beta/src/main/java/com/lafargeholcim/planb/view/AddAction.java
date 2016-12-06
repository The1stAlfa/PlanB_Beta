/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.util.CursorToolkit;
import com.lafargeholcim.planb.model.ActionItemFilter;
import com.lafargeholcim.planb.model.Status;
import com.lafargeholcim.planb.sys.Terminal;
import com.lafargeholcim.planb.util.Time;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


/**
 *
 * @author AI-Saac
 */
public class AddAction extends MaintenanceForm{
    private ActionPlansPane apPanel;
    
    public AddAction(UITerminal parent, Terminal terminal, ActionPlansPane apPanel,
            String meetingName){
        super(parent, "Add Action", false);
        super.meetingName = meetingName;
        super.parent = parent;
        super.terminal = terminal;
        this.apPanel = apPanel;
        CursorToolkit.startWaitCursor(parent.getRootPane());
        initComponents();
    }
    
    public void initComponents(){
        super.initComponents();
        super.setParticipantsNames(terminal.getParticipantsNames(meetingName));
        super.addWindowListener();
        setDates();
        statusTextField.setText("IN_PROCESS");
        endDateChooser.setVisible(false);
        endDateLabel.setVisible(false);
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    startDate = Time.getDate(startDateChooser.getCalendar());
                    dueDate = Time.getDate(dueDateChooser.getCalendar());
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
                                CursorToolkit.startWaitCursor(getJDialog().getRootPane());
                                terminal.addAction(ownerComboBox.getSelectedItem().toString(),
                                        detailTextArea.getText(),
                                        commentsTextArea.getText(),startDate,dueDate,
                                        statusTextField.getText(),
                                        (byte)progressSlider.getValue(),duration,meetingName);
                                ArrayList <Object> filterValues = new ArrayList();
                                if(duration > 3)
                                    filterValues.add(Status.IN_PROCESS);
                                else
                                    filterValues.add(Status.NEAR_DUE_DATE);
                                apPanel.updateJTable(ActionItemFilter.STATUS, 
                                                filterValues, meetingName);
                                JLabel label = (JLabel) apPanel.getComponent("addIcon");
                                label.setIcon(new ImageIcon(getClass().getResource("/images/plusWhite24.png")));
                                parent.getActionPlansPane().setFlag(false);
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
                JLabel label = (JLabel) parent.getActionPlansPane()
                        .getComponent("addIcon");
                label.setIcon(new ImageIcon(getClass().getResource("/images/plusWhite24.png")));
                parent.getActionPlansPane().setFlag(false);
                getJDialog().dispose();
            }
        });
   
    }
    
    public void setDates(){
        startDateChooser.setDate(Date.valueOf(Time.nowDate()));
        dueDateChooser.setDate(Date.valueOf(Time.nowDate().plusDays(1)));
    }
}
