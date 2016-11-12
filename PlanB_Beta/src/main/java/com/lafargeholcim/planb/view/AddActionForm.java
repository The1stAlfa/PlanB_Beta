/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.sys.Month;
import com.lafargeholcim.planb.sys.Terminal;
import com.lafargeholcim.planb.util.Time;
import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 *
 * @author debryan10
 * @author Joel Ordoñez
 */
public class AddActionForm extends JDialog{
    private final String meetingName;
    private final Terminal terminal;
    private final JFrame parent;
     // Variables declaration - do not modify                     
    private JButton addButton;
    private JComboBox<String> cbDayEnd;
    private JComboBox<String> cbDayReal;
    private JComboBox<String> cbDayStart;
    private JComboBox<String> cbMonthEnd;
    private JComboBox<String> cbMonthReal;
    private JComboBox<String> cbMonthStart;
    private JComboBox<String> cbYearEnd;
    private JComboBox<String> cbYearReal;
    private JComboBox<String> cbYearStart;
    private JComboBox<String> status_comboBox;
    private JButton cancellButton;
    private JLabel days_label;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JTextField tfDuration;
    private JTextField tfId;
    private JComboBox responsibleComboBox;
    private JSlider progressSlider;
    // End of variables declaration
    /**
     * Creates new form Ingreso
     * @param parent
     * @param terminal
     * @param meetingName
     */
    public AddActionForm(JFrame parent, Terminal terminal, String meetingName) throws Exception {
        this.meetingName = meetingName;
        this.parent = parent;
        this.terminal = terminal;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() throws Exception {
        parent.setEnabled(false);
        addWindowListener();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        tfId = new JTextField();
        responsibleComboBox = new JComboBox();
        tfDuration = new JTextField();
        addButton = new JButton();
        cancellButton = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jScrollPane2 = new JScrollPane();
        jTextArea2 = new JTextArea();
        cbDayStart = new JComboBox<>();
        cbMonthStart = new javax.swing.JComboBox<>();
        cbYearStart = new javax.swing.JComboBox<>();
        cbDayReal = new javax.swing.JComboBox<>();
        cbDayEnd = new javax.swing.JComboBox<>();
        cbMonthEnd = new javax.swing.JComboBox<>();
        cbMonthReal = new javax.swing.JComboBox<>();
        cbYearReal = new javax.swing.JComboBox<>();
        cbYearEnd = new javax.swing.JComboBox<>();
        status_comboBox = new javax.swing.JComboBox<>();
        progressSlider = new JSlider();
        days_label = new JLabel();
       
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Action");
        getContentPane().setBackground(new java.awt.Color(48, 49, 50));
        
        days_label.setText("days");
        days_label.setForeground(Color.decode("#C9CDD1"));
        jLabel2.setText("ID");
        jLabel2.setForeground(Color.decode("#C9CDD1"));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Detail");
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setForeground(Color.decode("#C9CDD1"));
        jLabel6.setText("Responsible");
        jLabel6.setForeground(Color.decode("#C9CDD1"));
        jLabel7.setText("Comments");
        jLabel7.setForeground(Color.decode("#C9CDD1"));
        jLabel8.setText("<html>Planned<br>Start Date</html>");
        jLabel8.setForeground(Color.decode("#C9CDD1"));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("<html>Planned<br> End Date</html>");
        jLabel9.setForeground(Color.decode("#C9CDD1"));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("<html>Real  <br>End Date</html>");
        jLabel10.setForeground(Color.decode("#C9CDD1"));
        jLabel10.setVisible(false);
        jLabel11.setText("Progress");
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setForeground(Color.decode("#C9CDD1"));
        jLabel12.setText("Status");
        jLabel12.setForeground(Color.decode("#C9CDD1"));
        jLabel13.setText("Duration");
        jLabel13.setForeground(Color.decode("#C9CDD1"));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addButton.setText("ADD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startDate = getDate(cbYearStart,cbMonthStart,cbDayStart);
                String dueDate = getDate(cbYearEnd,cbMonthEnd,cbDayEnd);
                int duration = Time.getDaysBetweenDates(startDate, dueDate);
                if(duration <= 0)
                    JOptionPane.showMessageDialog(getJDialog(),"Inconsistent Dates.","Error",JOptionPane.ERROR_MESSAGE);
                else if("".equals(jTextArea1.getText()))
                    JOptionPane.showMessageDialog(getJDialog(),"The Action Detail can't be Empty.","Error",JOptionPane.ERROR_MESSAGE);
                else{
                    try {
                        Object[] options = { "Yes", "No" };                    
                        if(JOptionPane.showOptionDialog(getJDialog(),
                            "<html><center>Are you sure you want to add the Action?",
                            "Delete Action",JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0){
                            terminal.addAction(responsibleComboBox.getSelectedItem().toString(),jTextArea1.getText(),
                                    jTextArea2.getText(),startDate,dueDate,
                                    status_comboBox.getSelectedItem().toString(),
                                    (byte)progressSlider.getValue(),duration,meetingName);
                            ((UITerminal)parent).updateJTable();
                            parent.setEnabled(true);
                            JLabel label = (JLabel) ((UITerminal)parent).getJComponent("addActionLabel");
                            label.setIcon(new ImageIcon(getClass().getResource("/images/plus-24.png")));
                            ((UITerminal)parent).setFlag(false);
                            getJDialog().dispose();
                       }
                    } 
                    catch (Exception ex) {
                        Logger.getLogger(AddActionForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        cancellButton.setText("CANCELL");
        cancellButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.setEnabled(true);
                JLabel label = (JLabel) ((UITerminal)parent).getJComponent("addActionLabel");
                label.setIcon(new ImageIcon(getClass().getResource("/images/plus-24.png")));
                ((UITerminal)parent).setFlag(false);
                getJDialog().dispose();
            }
        });
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setLineWrap(true);
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);
        /*
        UIManager.put("Slider.altTrackColor", Color.decode("#1160AE"));
        UIManager.put("Slider.tickColor", Color.decode("#1160AE"));
        UIManager.put("Slider.focus", Color.decode("#1160AE"));
        UIManager.put("Slider.darkShadow", Color.decode("#1160AE"));
        UIManager.put("Slider.highlight", Color.decode("#1160AE"));
        UIManager.put("Slider.thumb", Color.decode("#303132"));
        UIManager.put("Slider.background", Color.decode("#1160AE"));
        */
        cbDayStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
            "23", "24", "25", "26", "27", "28", "29", "30", "31" 
        }));
        cbMonthStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" 
        }));
        cbYearStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008",
            "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
            "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024",
            "2025", "2026", "2027", "2028", "2029", "2030" 
        }));
        cbDayEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", 
            "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
            "23", "24", "25", "26", "27", "28", "29", "30", "31" 
        }));
        cbMonthEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" 
        }));
        cbYearEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", 
            "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", 
            "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", 
            "2025", "2026", "2027", "2028", "2029", "2030" 
        }));
        cbDayReal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
            "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
            "23", "24", "25", "26", "27", "28", "29", "30", "31" 
        }));
        cbMonthReal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" 
        }));
        cbYearReal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", 
            "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", 
            "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", 
            "2025", "2026", "2027", "2028", "2029", "2030" 
        }));
        cbDayStart.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                String startDate = getDate(cbYearStart,cbMonthStart,cbDayStart);
                String dueDate = getDate(cbYearEnd,cbMonthEnd,cbDayEnd);
                tfDuration.setText(String.valueOf(Time.getDaysBetweenDates(startDate, dueDate)));
            }
        });
        cbMonthStart.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                String startDate = getDate(cbYearStart,cbMonthStart,cbDayStart);
                String dueDate = getDate(cbYearEnd,cbMonthEnd,cbDayEnd);
                tfDuration.setText(String.valueOf(Time.getDaysBetweenDates(startDate, dueDate)));
            }
        });
        cbYearStart.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                String startDate = getDate(cbYearStart,cbMonthStart,cbDayStart);
                String dueDate = getDate(cbYearEnd,cbMonthEnd,cbDayEnd);
                tfDuration.setText(String.valueOf(Time.getDaysBetweenDates(startDate, dueDate)));
            }
        });
        cbDayEnd.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                String startDate = getDate(cbYearStart,cbMonthStart,cbDayStart);
                String dueDate = getDate(cbYearEnd,cbMonthEnd,cbDayEnd);
                tfDuration.setText(String.valueOf(Time.getDaysBetweenDates(startDate, dueDate)));
            }
        });
        cbMonthEnd.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                String startDate = getDate(cbYearStart,cbMonthStart,cbDayStart);
                String dueDate = getDate(cbYearEnd,cbMonthEnd,cbDayEnd);
                tfDuration.setText(String.valueOf(Time.getDaysBetweenDates(startDate, dueDate)));
            }
        });
        cbYearEnd.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                String startDate = getDate(cbYearStart,cbMonthStart,cbDayStart);
                String dueDate = getDate(cbYearEnd,cbMonthEnd,cbDayEnd);
                tfDuration.setText(String.valueOf(Time.getDaysBetweenDates(startDate, dueDate)));
            }
        });
        cbDayReal.setVisible(false);
        cbMonthReal.setVisible(false);
        cbYearReal.setVisible(false);
        status_comboBox.setModel(new DefaultComboBoxModel<>(new String[] { 
            "IN_PROCESS", "COMPLETED_APP", "COMPLETED", "OVERDUE",
            "CANCELLED", "NEAR_TO_DUE_DATE", "WAITING_TO_START"
        }));
        status_comboBox.setSelectedIndex(0);
        setParticipantsNames();
        responsibleComboBox.setSelectedIndex(-1);
        responsibleComboBox.setBackground(Color.decode("#45494A"));
        responsibleComboBox.setForeground(Color.decode("#FCFEFC"));
        progressSlider.setValue(0);       
        //progressSlider.setOpaque(false);
        //ui.put("Slider.altTrackColor", Color.decode("#1160AE"));
        //progressSlider.setUI();

        tfId.setText(terminal.getNewActionId(meetingName));
        tfId.setEditable(false);
        setDates();

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addGap(15, 15, 15)
                                        .addComponent(responsibleComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbDayReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbMonthReal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbYearReal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbDayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbMonthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbYearEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbDayStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbMonthStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbYearStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(progressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(status_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(days_label))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(cancellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(responsibleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbDayStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbMonthStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbYearStart, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(status_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progressSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(cancellButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDayEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMonthEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbYearEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbDayReal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMonthReal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbYearReal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(tfDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(days_label)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        setVisible(true);
        pack();
    }   
    
    private void setDates(){
        LocalDate today = LocalDate.now();
        cbYearStart.setSelectedIndex(searchYearIndex(today,cbYearStart));
        cbMonthStart.setSelectedIndex(searchMonthIndex(today,cbMonthStart));
        cbDayStart.setSelectedIndex(searchDayIndex(today,cbDayStart));
        cbYearEnd.setSelectedIndex(searchYearIndex(today,cbYearEnd));
        cbMonthEnd.setSelectedIndex(searchMonthIndex(today,cbMonthEnd));
        cbDayEnd.setSelectedIndex(searchDayIndex(today,cbDayEnd));
    }
    
    private int searchYearIndex(LocalDate date, JComboBox comboBox){
        String year = String.valueOf(date.getYear());
        int length = comboBox.getItemCount();
        for(int index=0;index<length;index++){
            if(comboBox.getItemAt(index).toString().equalsIgnoreCase(year))
                return index;
        }
        return 0;
    }
    
    private int searchMonthIndex(LocalDate date, JComboBox comboBox){
        String month = date.getMonth().toString();
        int length = comboBox.getItemCount();
        for(int index=0;index<length;index++){
            if(comboBox.getItemAt(index).toString().equalsIgnoreCase(getMonthAbbreviation(month)))
                return index;
        }
        return 0;
    }
    
    private int searchDayIndex(LocalDate date, JComboBox comboBox){
        String day = String.valueOf(date.getDayOfMonth());
        if(day.length() == 1)
            day = "0" + day;
        int length = comboBox.getItemCount();
        for(int index=0;index<length;index++){
            if(comboBox.getItemAt(index).toString().equalsIgnoreCase(day))
                return index;
        }
        return 0;
    }
    
    private String getMonthName(String abbreviation){
        Month mon[] = Month.values();
        for(Month m:mon){
            if(m.getAbbreviation().equalsIgnoreCase(abbreviation))
                return m.toString();
        }
        return null;
    }

    private String getMonthAbbreviation(String monthName){
        Month mon[] = Month.values();
        for(Month m:mon){
            if(m.toString().equalsIgnoreCase(monthName))
                return m.getAbbreviation();
        }
        return null;
    }

    private JDialog getJDialog(){
        return this;
    }
     
    private String getDate(JComboBox year, JComboBox month, JComboBox day){
        return year.getSelectedItem().toString()+"-"
                +Month.valueOf(getMonthName(month.getSelectedItem().toString())).getValue()
                +"-"+day.getSelectedItem().toString();
    }
    
    private void setParticipantsNames(){
        responsibleComboBox.setModel(new DefaultComboBoxModel(terminal.getParticipantsNames(meetingName)));        
    }
    
    private void addWindowListener(){
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e){}

            @Override
            public void windowClosing(WindowEvent e){
                parent.setEnabled(true);
                JLabel label = (JLabel) ((UITerminal)parent).getJComponent("addActionLabel");
                label.setIcon(new ImageIcon(getClass().getResource("/images/plus-24.png")));
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
}
