/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.util.CursorToolkit;
import com.lafargeholcim.planb.model.ActionItemFilter;
import com.lafargeholcim.planb.sys.Terminal;
import com.lafargeholcim.planb.util.Time;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author AI-Saac
 */
public class EditAction extends MaintenanceForm{
    private String endDate;
    private ActionPlansPane apPanel;
    private final Object[] rowData;
    private Object[] rowDataModified;
    private ActionItemFilter filter;
    private ArrayList<Object> filterValues;
    
    public EditAction(UITerminal parent, Terminal terminal, ActionPlansPane apPanel,
            String meetingName, Object[] rowData, ActionItemFilter filter, 
            ArrayList<Object> filterValues){
        super(parent, "Edit Action", false);
        super.parent = parent;
        super.terminal = terminal;
        super.meetingName = meetingName;
        this.apPanel = apPanel;
        this.rowData = rowData;
        this.filter = filter;
        this.filterValues = filterValues;
        CursorToolkit.startWaitCursor(parent.getRootPane());
        initComponents();
    }
    
    public void initComponents(){
        super.initComponents();
        super.addWindowListener();
        setParticipantsNames(terminal.getParticipantsNames(meetingName));
        setRowData();
        ((JTextFieldDateEditor)startDateChooser.getDateEditor())
        .setEditable(false);
        startDateChooser.getCalendarButton().setEnabled(false);
        ((JTextFieldDateEditor)dueDateChooser.getDateEditor())
        .setEditable(false);
        dueDateChooser.getCalendarButton().setEnabled(false);
        actionButton.setText("SAVE");
        actionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    startDate = Time.getDate(startDateChooser.getCalendar());
                    dueDate = Time.getDate(dueDateChooser.getCalendar());
                    int duration = Time.getDaysBetweenDates(startDate, dueDate);
                    if(duration <= 0)
                        JOptionPane.showMessageDialog(getJDialog(),
                                "Inconsistent Dates","Error",JOptionPane.ERROR_MESSAGE);
                    else{
                        try {
                            endDate = Time.getDate(endDateChooser.getCalendar());
                            if(!commentsTextArea.getText().equals("")){
                                if(detectActionDataModification()){
                                    CursorToolkit.startWaitCursor(getJDialog().getRootPane());
                                    terminal.modifyAction(rowDataModified,meetingName);
                                    apPanel.updateJTable(filter, filterValues, meetingName);
                                    getJDialog().dispose();
                                }
                                else{
                                    JOptionPane.showMessageDialog(getJDialog(),
                                        "There's NO change to apply","No Change",
                                        JOptionPane.INFORMATION_MESSAGE);
                                    getJDialog().dispose();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(getJDialog(),
                                        "Set Comments to close the Action","Validation",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (Exception ex) {
                            if(detectActionDataModification()){
                                CursorToolkit.startWaitCursor(getJDialog().getRootPane());
                                terminal.modifyAction(rowDataModified,meetingName);
                                apPanel.updateJTable(filter, filterValues, meetingName);
                                getJDialog().dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(getJDialog(),
                                    "There's NO change to apply","No Change",
                                    JOptionPane.INFORMATION_MESSAGE);
                                getJDialog().dispose();
                            }
                        }
                    }
                }catch(Exception ex){
                    
                }
            }
        });
        
        cancellButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                parent.setEnabled(true);
                getJDialog().dispose();
            }
        });
    }
    
    private boolean detectActionDataModification(){
        byte detection = 0;
        rowDataModified = new Object[10];
        rowDataModified[0] = idValueTextField.getText();
        if(ownerComboBox.getSelectedIndex() != getResponsibleIndex(rowData[1])){
            rowDataModified[1] = ownerComboBox.getSelectedItem().toString();
            detection += 1;
        }
        else
            rowDataModified[1] = null;
        
        if(!String.valueOf(rowData[2]).equalsIgnoreCase(detailTextArea.getText())){
            rowDataModified[2] = detailTextArea.getText();
            detection += 1;
        }
        else
            rowDataModified[2] = null;
        
        if(!String.valueOf(rowData[3]).equalsIgnoreCase(commentsTextArea.getText())){
            rowDataModified[3] = commentsTextArea.getText();
            detection += 1;
        }
        else
            rowDataModified[3] = null;
        if(rowData[4] == null){
            try{
                String startDate = Time.getDate(startDateChooser.getCalendar());
                rowDataModified[4] = startDate;
                detection += 1;
            }catch(Exception ex){
                Object[] options = { "Yes", "No" };
                if(JOptionPane.showOptionDialog(this,
                    "<html><center>Null end Date or wrong date format<br>Do you want to continue saving?",
                    "Delete Action",JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1)
                    return false;
            }
        }
        else{
            try{
                String startDate = Time.getDate(startDateChooser.getCalendar());
                if(!String.valueOf(rowData[4]).equalsIgnoreCase(startDate)){
                    rowDataModified[4] = startDate;
                    detection += 1;
                }
                else
                    rowDataModified[4] = null;
            }catch(Exception ex){
                Object[] options = { "Yes", "No" };
                if(JOptionPane.showOptionDialog(this,
                    "<html><center>Null end Date or wrong date format<br>Do you want to continue saving?",
                    "Delete Action",JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1)
                    return false;
            }
        }
        if(rowData[5] == null){
            try{
                String dueDate = Time.getDate(dueDateChooser.getCalendar());
                rowDataModified[5] = dueDate;
                detection += 1;
            }catch(Exception ex){
                Object[] options = { "Yes", "No" };
                if(JOptionPane.showOptionDialog(this,
                    "<html><center>Null end Date or wrong date format<br>Do you want to continue saving?",
                    "Delete Action",JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1)
                    return false;
            }
        }
        else{
            try{
                String dueDate = Time.getDate(dueDateChooser.getCalendar());
                if(!String.valueOf(rowData[5]).equalsIgnoreCase(dueDate)){
                    rowDataModified[5] = dueDate;
                    detection += 1;
                }
                else
                    rowDataModified[5] = null;
            }catch(Exception ex){
                Object[] options = { "Yes", "No" };
                if(JOptionPane.showOptionDialog(this,
                    "<html><center>Null end Date or wrong date format<br>Do you want to continue saving?",
                    "Delete Action",JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1)
                    return false;
            }
        }
        if(rowData[6] == null){
            try{
                String endDate = Time.getDate(endDateChooser.getCalendar());
                rowDataModified[6] = endDate;
                detection += 1;
            }catch(Exception ex){
                Object[] options = { "Yes", "No" };
                if(JOptionPane.showOptionDialog(this,
                    "<html><center>Null End Date or wrong date format<br>Do you want to continue saving?",
                    "Delete Action",JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 1)
                    return false;
            }
        }
        else{
            try{
                String endDate = Time.getDate(endDateChooser.getCalendar());
                if(!String.valueOf(rowData[6]).equalsIgnoreCase(endDate)){
                    rowDataModified[6] = endDate;
                    detection += 1;
                }
                else
                    rowDataModified[6] = null;
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Null date or wrong date format",
                        "Date Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if(Integer.parseInt(String.valueOf(rowData[7])) != progressSlider.getValue()){
            rowDataModified[7] = progressSlider.getValue();
            detection += 1;
        }
        else
            rowDataModified[7] = null;
        
        if(!String.valueOf(rowData[8]).equalsIgnoreCase(
                statusTextField.getText())){
            rowDataModified[8] = statusTextField.getText();
            detection += 1;
        }
        else
            rowDataModified[8] = null;
        rowDataModified[9] = null;
        if(detection != 0)
            return true;
        return false;
    }
    
    private String getAcronymName(String responsibleNames){
        String[] names = responsibleNames.split(" ");
        String acronymName = "";
        for(String name:names)
            acronymName = acronymName+name.substring(0,1).toUpperCase();
        return acronymName;
    }
    
    private int getResponsibleIndex(Object data){
        String responsibleAcronym = data.toString();
        int length = ownerComboBox.getItemCount();
        for(int index=0;index<length;index++){
            String acronym = getAcronymName(ownerComboBox.getItemAt(index).toString());
            if(acronym.equalsIgnoreCase(responsibleAcronym))
                return index;
        }
        return -1;
    }
    
    private void setRowData(){
        idValueTextField.setText(String.valueOf(rowData[0]));
        ownerComboBox.setSelectedIndex(getResponsibleIndex(rowData[1]));
        detailTextArea.setText(String.valueOf(rowData[2]));
        commentsTextArea.setText(String.valueOf(rowData[3]));
        startDateChooser.setDate(Date.valueOf(Time.parseDate(rowData[4].toString())));
        dueDateChooser.setDate(Date.valueOf(Time.parseDate(rowData[5].toString())));
        if(rowData[6] != null)
            endDateChooser.setDate(Date.valueOf(Time.parseDate(rowData[6].toString())));
        progressSlider.setValue(Integer.parseInt(String.valueOf(rowData[7])));
        statusTextField.setText(rowData[8].toString());
        durationValueLabel.setText(String.valueOf(rowData[9]));
    }
}
