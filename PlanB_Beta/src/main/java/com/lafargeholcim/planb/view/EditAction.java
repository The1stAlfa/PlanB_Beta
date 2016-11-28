/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.model.ActionItemFilter;
import com.lafargeholcim.planb.sys.Terminal;
import com.lafargeholcim.planb.util.Time;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author AI-Saac
 */
public class EditAction extends MaintenanceForm{
    private final JFrame parent;
    private final Terminal terminal;
    private final String meetingName;
    private final Object[] rowData;
    private Object[] rowDataModified;
    private ActionItemFilter filter;
    private ArrayList<Object> filterValues;
    
    public EditAction(JFrame parent, Terminal terminal, 
            String meetingName, Object[] rowData, ActionItemFilter filter, 
            ArrayList<Object> filterValues){
        super("Edit Action");
        this.parent = parent;
        this.terminal = terminal;
        this.meetingName = meetingName;
        this.rowData = rowData;
        this.filter = filter;
        this.filterValues = filterValues;
        initComponents();
    }
    
    private void addWindowListener(){
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e){}

            @Override
            public void windowClosing(WindowEvent e){
                parent.setEnabled(true);
            }

            @Override
            public void windowClosed(WindowEvent e){}

            @Override
            public void windowIconified(WindowEvent e){}

            @Override
            public void windowDeiconified(WindowEvent e){}

            @Override
            public void windowActivated(WindowEvent e){}

            @Override
            public void windowDeactivated(WindowEvent e){}
        });
    }
    
    public void initComponents(){
        super.initComponents();
        parent.setEnabled(false);
        addWindowListener();
        actionButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String startDate = Time.getDate(startDateChooser.getCalendar());
                    String dueDate = Time.getDate(dueDateChooser.getCalendar());
                    int duration = Time.getDaysBetweenDates(startDate, dueDate);
                    if(duration <= 0)
                        JOptionPane.showMessageDialog(getJDialog(),
                                "Inconsistent Dates.","Error",JOptionPane.ERROR_MESSAGE);
                    else{
                        try {
                            if(detectActionDataModification()){
                                terminal.modifyAction(rowDataModified,meetingName);
                                parent.setEnabled(true);
                                ((UITerminal)parent).updateJTable(filter, filterValues);
                                getJDialog().dispose();
                            }
                        } catch (Exception ex) {

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
        /*
        if(){
            
        }
        else
            row_data_modified[4] = null;
        
        if(){
            
        }
        else
            row_data_modified[5] = null;
        */
        /*
        if(rowData[6] == null){
            if(cbYearReal.getSelectedIndex()!= -1 
                    && cbMonthReal.getSelectedIndex() != -1 
                    && cbDayReal.getSelectedIndex() != -1){
                String date = cbYearReal.getSelectedItem().toString()+"-"
                        +getMonthValue(cbMonthReal.getSelectedItem().toString())+"-"
                        +cbDayReal.getSelectedItem().toString();
                rowDataModified[6] = date;
                detection += 1;
            }
        }
        else{
            String date = cbYearReal.getSelectedItem().toString()+"-"
                        +getMonthValue(cbMonthReal.getSelectedItem().toString())+"-"
                        +cbDayReal.getSelectedItem().toString();
            if(!String.valueOf(rowData[6]).equalsIgnoreCase(date)){
                rowDataModified[6] = date;
                detection += 1;
            }
            else
                rowDataModified[6] = null;
        }*/
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
        rowDataModified[4] = null;
        rowDataModified[5] = null;
        rowDataModified[9] = null;
        if(detection != 0)
            return true;
        return false;
    }
    
    private String getAcronymName(String responsible_names){
        String[] names = responsible_names.split(" ");
        String acronym_name = "";
        for(String name:names)
            acronym_name = acronym_name+name.substring(0,1).toUpperCase();
        return acronym_name;
    }
    
    private int getResponsibleIndex(Object row_data){
        String responsible_acronym = row_data.toString();
        int length = ownerComboBox.getItemCount();
        for(int index=0;index<length;index++){
            String acronym = getAcronymName(ownerComboBox.getItemAt(index).toString());
            if(acronym.equalsIgnoreCase(responsible_acronym))
                return index;
        }
        return -1;
    }
}
