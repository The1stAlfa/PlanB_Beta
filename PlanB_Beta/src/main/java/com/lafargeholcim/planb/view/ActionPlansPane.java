/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.init.Aps;
import com.lafargeholcim.planb.model.APSummary;
import com.lafargeholcim.planb.model.ActionItemFilter;
import com.lafargeholcim.planb.model.ActionPlan;
import com.lafargeholcim.planb.model.Collaborator;
import com.lafargeholcim.planb.model.Meeting;
import com.lafargeholcim.planb.model.Status;
import com.lafargeholcim.planb.model.WorkTeam;
import com.lafargeholcim.planb.sys.ColorsDarcula;
import com.lafargeholcim.planb.util.CursorToolkit;
import com.lafargeholcim.planb.util.Time;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author AI-Saac
 */
public class ActionPlansPane extends JPanel{
    private ActionItemFilter globalFilter;
    private ArrayList<Object> filterValues;
    private boolean clickFlag = false;
    private String meetingName;
    private JDateChooser startDateChooser, endDateChooser;
    private JFrame mainInterface;
    private JLabel actionLabel, actionValueLabel, actionsLabel, addIcon, 
            appLabel, appValueLabel, completedLabel, completedValueLabel, 
            content2Label, date2Label, dateLabel, dateValueLabel, deleteIcon, 
            dotMenuLabel, editIcon, executionLabel, executionValueLabel, 
            filterLabel, firstNameLabel, meetingLabel, overdueLabel, 
            overdueValueLabel, owner2Label, ownerLabel, participantsLabel, 
            performanceLabel, performanceValueLabel, planLabel, surnameLabel, status2Label, 
            title1Label, title2Label;
    private JPanel pagePanel, actionListPanel,apInformationPanel, apPanel, appActionPanel,
            buttonsPanel, completedActionPanel, datePanel, filterLabelPanel, meetingNamePanel, 
            overdueActionPanel, ownerNamePanel, participantsPanel, 
            planExecutionPanel, statusPanel, teamPerformancePanel, totalActionsPanel;
    private JScrollPane alTableScrollPane, participantsScrollPane; // al = Action List
    private JRadioButton contentRadioButton, dateRadioButton, ownerRadioButton, statusRadioButton;
    private JPopupMenu meetingPopupMenu;
    private JTable actionListTable;
    private JTextArea participantsTextArea;
    private JTextField hintTextField, owner2TextField;
    private JComboBox<String> dateComboBox, statusComboBox;
    
    public ActionPlansPane(JFrame mainInterface){
        this.mainInterface = mainInterface;
        initComponents();
    }
    
    private void centerColumnContent(){
        for(int i=0; i<10;i++){
            actionListTable.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(){
                private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
                @Override
                public Component getTableCellRendererComponent(JTable table, 
                        Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if(!(column == 2 || column ==3) )
                        DEFAULT_RENDERER.setHorizontalAlignment(SwingConstants.CENTER);
                    if(isSelected)
                        c.setBackground(Color.decode("#4B6EAF"));
                    else if(column == 0){
                       c.setForeground(Color.decode("#9876AA"));
                       c.setBackground(row%2==0 ? Color.decode("#303132") : Color.decode("#3C3F41"));
                    }
                    else if(column == 8){
                        if(value.toString().equalsIgnoreCase("OVERDUE")){
                            c.setBackground(Color.decode("#FE4344")); // E80C0C
                            c.setForeground(Color.decode("#FCFEFC"));
                        }
                        else if(value.toString().equalsIgnoreCase("COMPLETED_APP")){
                            c.setBackground(Color.decode("#64D610"));
                            c.setForeground(Color.decode("#FCFEFC"));                            
                        }
                        else if(value.toString().equalsIgnoreCase("COMPLETED")){
                            c.setBackground(Color.decode("#F2D345"));
                            c.setForeground(Color.decode("#FCFEFC"));
                        }
                        else{
                            c.setBackground(row%2==0 ? Color.decode("#303132") : Color.decode("#3C3F41")); //EDEDED
                            c.setForeground(Color.decode("#000000"));
                        }
                    }
                    else if(column == 5){
                        c.setBackground(new Color(120, 120, 123));
                        c.setForeground(Color.decode("#FCFEFC"));
                    }
                    else{
                        c.setBackground(row%2==0 ? Color.decode("#303132") : Color.decode("#3C3F41"));
                    }
                    return c;
                }
            });
        }
    }
    
    private void createMenuItem(String option){
        JMenuItem item = new JMenuItem(option);
        item.setBackground(Color.decode("#3C3F41"));
        item.setForeground(Color.decode("#E3E3E3"));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meetingName = ((JMenuItem)e.getSource()).getText();
                filterValues = new ArrayList<>();
                filterValues.add(Status.OVERDUE);
                globalFilter = ActionItemFilter.STATUS;
                updateJTable(globalFilter, filterValues);
                statusRadioButton.setSelected(true);
                dateRadioButton.setSelected(false);
                dateComboBox.setSelectedIndex(0);
                contentRadioButton.setSelected(false);
                hintTextField.setText("hint");
                statusComboBox.setSelectedIndex(3);
                if(actionListTable.getRowCount() == 0){
                    JOptionPane.showMessageDialog(new JOptionPane(),
                        "There's not action with the specified criteria",
                        "Information",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        meetingPopupMenu.add(item);
    }
    
    private void createInformationPanel(){
        GridBagConstraints gridBagConstraints;
        
        meetingPopupMenu = new  JPopupMenu();       
        apInformationPanel = new JPanel();
        apPanel = new JPanel(); // Panel that contains the LABEL FOR ACTION PLAN TITLE
        actionLabel = new JLabel();
        planLabel = new JLabel();
        meetingNamePanel = new JPanel();
        meetingLabel = new JLabel();
        title1Label = new JLabel();
        title2Label = new JLabel();
        dotMenuLabel = new JLabel();
        ownerNamePanel = new JPanel();
        firstNameLabel = new JLabel();
        surnameLabel = new JLabel();
        ownerLabel = new JLabel();
        participantsPanel = new JPanel();
        participantsLabel = new JLabel();
        participantsScrollPane = new JScrollPane();
        participantsTextArea = new JTextArea();
        totalActionsPanel = new JPanel();
        actionsLabel = new JLabel();
        actionValueLabel = new JLabel();
        completedActionPanel = new JPanel();
        completedLabel = new JLabel();
        completedValueLabel = new JLabel();
        appActionPanel = new JPanel();
        appLabel = new JLabel();
        appValueLabel = new JLabel();
        overdueActionPanel = new JPanel();
        overdueLabel = new JLabel();
        overdueValueLabel = new JLabel();
        teamPerformancePanel = new JPanel();
        performanceLabel = new JLabel();
        performanceValueLabel = new JLabel();
        planExecutionPanel = new JPanel();
        executionLabel = new JLabel();
        executionValueLabel = new JLabel();
        datePanel = new JPanel();
        dateLabel = new JLabel();
        dateValueLabel = new JLabel();
        filterLabelPanel = new JPanel();
        filterLabel = new JLabel();
        statusPanel = new JPanel();
        statusRadioButton = new JRadioButton();
        statusComboBox = new JComboBox<>();
        status2Label = new JLabel();
        dateRadioButton = new javax.swing.JRadioButton();
        dateComboBox = new JComboBox<>();
        date2Label = new JLabel();
        ownerRadioButton = new JRadioButton();
        owner2Label = new JLabel();
        owner2TextField = new JTextField();
        contentRadioButton = new JRadioButton();
        content2Label = new JLabel();
        hintTextField = new JTextField();
        buttonsPanel = new JPanel();
        addIcon = new JLabel();
        editIcon = new JLabel();
        deleteIcon = new JLabel();
        startDateChooser = new JDateChooser();
        endDateChooser = new JDateChooser();
        
        meetingPopupMenu.setAutoscrolls(true);
        for(String name:Aps.getTerminal().getMeetingsNames())
            createMenuItem(name);

        apInformationPanel.setBackground(Color.decode("#3C3F41"));
        apInformationPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        apInformationPanel.setPreferredSize(new java.awt.Dimension(Short.MAX_VALUE, 250));
        apInformationPanel.setLayout(new java.awt.GridBagLayout());
                
        apPanel.setBackground(Color.decode("#303132"));
                //new java.awt.Color(0, 66, 118));
        apPanel.setBorder(javax.swing.BorderFactory.
                createMatteBorder(4, 4, 4, 2, Color.decode("#3C3F41")));
        apPanel.setMaximumSize(new java.awt.Dimension(164, 200));
        apPanel.setMinimumSize(new java.awt.Dimension(110, 200));
        apPanel.setPreferredSize(new java.awt.Dimension(120, 200));

        actionLabel.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        actionLabel.setForeground(new java.awt.Color(252, 254, 252));
        actionLabel.setText("Action");

        planLabel.setFont(new java.awt.Font("Dialog", 1, 35)); // NOI18N
        planLabel.setForeground(new java.awt.Color(252, 254, 252));
        planLabel.setText("Plan");

        javax.swing.GroupLayout apPanelLayout = new javax.swing.GroupLayout(apPanel);
        apPanel.setLayout(apPanelLayout);
        apPanelLayout.setHorizontalGroup(
            apPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(apPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionLabel)
                    .addComponent(planLabel))
                .addContainerGap(2, Short.MAX_VALUE))
        );
        apPanelLayout.setVerticalGroup(
            apPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planLabel)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(apPanel, gridBagConstraints);

        meetingNamePanel.setBackground(Color.decode("#4B6EAF")); //CC7832
        meetingNamePanel.setBorder(BorderFactory
                .createMatteBorder(4, 2, 2, 2, Color.decode("#3C3F41")));
        meetingNamePanel.setMinimumSize(new java.awt.Dimension(242, 100));
        meetingNamePanel.setPreferredSize(new java.awt.Dimension(252, 100));

        meetingLabel.setBackground(new java.awt.Color(230, 231, 234));
        meetingLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        meetingLabel.setForeground(Color.decode("#FFFFFF"));
        meetingLabel.setText("meeting");

        title1Label.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        title1Label.setForeground(Color.decode("#FCFEFC"));
        title1Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        title1Label.setIconTextGap(0);
        title1Label.setMaximumSize(new java.awt.Dimension(175, 34));
        title1Label.setMinimumSize(new java.awt.Dimension(0, 0));
        title1Label.setPreferredSize(new java.awt.Dimension(175, 34));

        title2Label.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        title2Label.setForeground(Color.decode("#FCFEFC"));
        title2Label.setText("-Select Meeting-");
        title2Label.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        title2Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        title2Label.setIconTextGap(0);
        title2Label.setMaximumSize(new java.awt.Dimension(195, 37));
        title2Label.setMinimumSize(new java.awt.Dimension(157, 37));
        title2Label.setPreferredSize(new java.awt.Dimension(148, 37));

        dotMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dotMenuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dotsMenu-24.png"))); // NOI18N
        dotMenuLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dotMenuLabel.setIconTextGap(0);        
        dotMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int xPos = meetingPopupMenu.getPreferredSize().width - 3;
                meetingPopupMenu.show(dotMenuLabel, -xPos, -5);
            }
        });

        javax.swing.GroupLayout meetingNamePanelLayout = new javax.swing.GroupLayout(meetingNamePanel);
        meetingNamePanel.setLayout(meetingNamePanelLayout);
        meetingNamePanelLayout.setHorizontalGroup(
            meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meetingNamePanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(meetingNamePanelLayout.createSequentialGroup()
                        .addComponent(title1Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(meetingLabel))
                    .addGroup(meetingNamePanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(title2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(dotMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        meetingNamePanelLayout.setVerticalGroup(
            meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meetingNamePanelLayout.createSequentialGroup()
                .addGroup(meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meetingLabel)
                    .addGroup(meetingNamePanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(title1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(dotMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(meetingNamePanel, gridBagConstraints);

        ownerNamePanel.setBackground(Color.decode("#4B6EAF"));
        ownerNamePanel.setBorder(BorderFactory
                .createMatteBorder(2, 2, 4, 2, Color.decode("#3C3F41")));
        ownerNamePanel.setMinimumSize(new java.awt.Dimension(121, 100));
        ownerNamePanel.setPreferredSize(new java.awt.Dimension(126, 100));

        firstNameLabel.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        firstNameLabel.setForeground(Color.decode("#FCFEFC"));
        firstNameLabel.setIconTextGap(0);
        firstNameLabel.setMaximumSize(new java.awt.Dimension(90, 23));
        firstNameLabel.setMinimumSize(new java.awt.Dimension(90, 23));
        firstNameLabel.setPreferredSize(new java.awt.Dimension(90, 23));

        surnameLabel.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        surnameLabel.setForeground(Color.decode("#FCFEFC"));
        surnameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        surnameLabel.setIconTextGap(0);
        surnameLabel.setMaximumSize(new java.awt.Dimension(90, 23));
        surnameLabel.setMinimumSize(new java.awt.Dimension(90, 23));
        surnameLabel.setPreferredSize(new java.awt.Dimension(90, 23));

        ownerLabel.setBackground(Color.decode("#FFFFFF"));
        ownerLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        ownerLabel.setForeground(new java.awt.Color(252, 254, 252));
        ownerLabel.setText("owner");

        javax.swing.GroupLayout ownerNamePanelLayout = new javax.swing.GroupLayout(ownerNamePanel);
        ownerNamePanel.setLayout(ownerNamePanelLayout);
        ownerNamePanelLayout.setHorizontalGroup(
            ownerNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ownerNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ownerNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ownerNamePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ownerLabel))
                    .addGroup(ownerNamePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(surnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ownerNamePanelLayout.setVerticalGroup(
            ownerNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ownerNamePanelLayout.createSequentialGroup()
                .addComponent(ownerLabel)
                .addGap(4, 4, 4)
                .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(surnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(ownerNamePanel, gridBagConstraints);

        participantsPanel.setBackground(Color.decode("#4B6EAF"));
        participantsPanel.setBorder(BorderFactory
                .createMatteBorder(2, 2, 4, 2, Color.decode("#3C3F41")));
        participantsPanel.setMinimumSize(new java.awt.Dimension(126, 100));
        participantsPanel.setPreferredSize(new java.awt.Dimension(126, 100));

        participantsLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        participantsLabel.setForeground(Color.decode("#FFFFFF"));
        participantsLabel.setText("participants");

        participantsScrollPane.setBackground(Color.decode("#4B6EAF"));
        participantsScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 0));
        participantsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        participantsScrollPane.setPreferredSize(new java.awt.Dimension(120, 48));

        participantsTextArea.setEditable(false);
        participantsTextArea.setBackground(Color.decode("#4B6EAF"));
        participantsTextArea.setColumns(16);
        participantsTextArea.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        participantsTextArea.setForeground(Color.decode("#FCFEFC"));
        participantsTextArea.setLineWrap(true);
        participantsTextArea.setRows(3);
        participantsTextArea.setTabSize(0);
        participantsTextArea.setWrapStyleWord(true);
        participantsTextArea.setAutoscrolls(false);
        participantsTextArea.setBorder(null);
        participantsTextArea.setMinimumSize(new java.awt.Dimension(0, 150));
        participantsTextArea.setPreferredSize(new java.awt.Dimension(120, 52));
        participantsScrollPane.setViewportView(participantsTextArea);

        javax.swing.GroupLayout participantsPanelLayout = new javax.swing.GroupLayout(participantsPanel);
        participantsPanel.setLayout(participantsPanelLayout);
        participantsPanelLayout.setHorizontalGroup(
            participantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantsPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(participantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(participantsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, participantsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(participantsLabel)))
                .addContainerGap())
        );
        participantsPanelLayout.setVerticalGroup(
            participantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantsPanelLayout.createSequentialGroup()
                .addComponent(participantsLabel)
                .addGap(4, 4, 4)
                .addComponent(participantsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(participantsPanel, gridBagConstraints);

        totalActionsPanel.setBackground(new java.awt.Color(230, 231, 234)); //91835C
        totalActionsPanel.setBorder(BorderFactory
                .createMatteBorder(4, 2, 2, 2, Color.decode("#3C3F41")));
        totalActionsPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        totalActionsPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        actionsLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        actionsLabel.setForeground(new java.awt.Color(48, 49, 50));
        actionsLabel.setText("actions");

        actionValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        actionValueLabel.setForeground(new java.awt.Color(120, 120, 123));
        actionValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actionValueLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        actionValueLabel.setIconTextGap(0);

        javax.swing.GroupLayout totalActionsPanelLayout = new javax.swing.GroupLayout(totalActionsPanel);
        totalActionsPanel.setLayout(totalActionsPanelLayout);
        totalActionsPanelLayout.setHorizontalGroup(
            totalActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalActionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalActionsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(actionsLabel))
                    .addComponent(actionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addContainerGap())
        );
        totalActionsPanelLayout.setVerticalGroup(
            totalActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalActionsPanelLayout.createSequentialGroup()
                .addComponent(actionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(totalActionsPanel, gridBagConstraints);

        completedActionPanel.setBackground(new java.awt.Color(230, 231, 234));
        completedActionPanel.setBorder(BorderFactory
                .createMatteBorder(2, 2, 4, 2, Color.decode("#3C3F41")));
        completedActionPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        completedActionPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        completedLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        completedLabel.setForeground(new java.awt.Color(48, 49, 50));
        completedLabel.setText("completed");

        completedValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        completedValueLabel.setForeground(new java.awt.Color(120, 120, 123));
        completedValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completedValueLabel.setMaximumSize(new java.awt.Dimension(69, 54));
        completedValueLabel.setMinimumSize(new java.awt.Dimension(69, 54));
        completedValueLabel.setPreferredSize(new java.awt.Dimension(69, 54));

        javax.swing.GroupLayout completedActionPanelLayout = new javax.swing.GroupLayout(completedActionPanel);
        completedActionPanel.setLayout(completedActionPanelLayout);
        completedActionPanelLayout.setHorizontalGroup(
            completedActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completedActionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(completedActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, completedActionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(completedLabel))
                    .addComponent(completedValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addContainerGap())
        );
        completedActionPanelLayout.setVerticalGroup(
            completedActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completedActionPanelLayout.createSequentialGroup()
                .addComponent(completedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(completedValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(completedActionPanel, gridBagConstraints);

        appActionPanel.setBackground(new java.awt.Color(230, 231, 234));
        appActionPanel.setBorder(BorderFactory
                .createMatteBorder(4, 2, 2, 2, Color.decode("#3C3F41")));
        appActionPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        appActionPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        appLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        appLabel.setForeground(new java.awt.Color(48, 49, 50));
        appLabel.setText("app");

        appValueLabel.setBackground(new java.awt.Color(48, 49, 50));
        appValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        appValueLabel.setForeground(new java.awt.Color(120, 120, 123));
        appValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appValueLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        appValueLabel.setIconTextGap(0);

        javax.swing.GroupLayout appActionPanelLayout = new javax.swing.GroupLayout(appActionPanel);
        appActionPanel.setLayout(appActionPanelLayout);
        appActionPanelLayout.setHorizontalGroup(
            appActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appActionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(appActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appActionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(appLabel))
                    .addComponent(appValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addContainerGap())
        );
        appActionPanelLayout.setVerticalGroup(
            appActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appActionPanelLayout.createSequentialGroup()
                .addComponent(appLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(appActionPanel, gridBagConstraints);

        overdueActionPanel.setBackground(new java.awt.Color(230, 231, 234));
        overdueActionPanel.setBorder(BorderFactory
                .createMatteBorder(2, 2, 4, 2, Color.decode("#3C3F41")));
        overdueActionPanel.setMinimumSize(new java.awt.Dimension(100, 100));

        overdueLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        overdueLabel.setForeground(new java.awt.Color(48, 49, 50));
        overdueLabel.setText("overdue");

        overdueValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        overdueValueLabel.setForeground(new java.awt.Color(120, 120, 123));
        overdueValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        overdueValueLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout overdueActionPanelLayout = new javax.swing.GroupLayout(overdueActionPanel);
        overdueActionPanel.setLayout(overdueActionPanelLayout);
        overdueActionPanelLayout.setHorizontalGroup(
            overdueActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueActionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(overdueActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, overdueActionPanelLayout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(overdueLabel))
                    .addComponent(overdueValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        overdueActionPanelLayout.setVerticalGroup(
            overdueActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueActionPanelLayout.createSequentialGroup()
                .addComponent(overdueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overdueValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(overdueActionPanel, gridBagConstraints);

        teamPerformancePanel.setBackground(Color.decode("#FE4344"));
        teamPerformancePanel.setBorder(BorderFactory
                .createMatteBorder(4, 2, 2, 2, Color.decode("#3C3F41")));
        teamPerformancePanel.setMinimumSize(new java.awt.Dimension(110, 100));
        teamPerformancePanel.setPreferredSize(new java.awt.Dimension(110, 100));

        performanceLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        performanceLabel.setForeground(new java.awt.Color(252, 254, 252));
        performanceLabel.setText("performance");

        performanceValueLabel.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        performanceValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        performanceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        performanceValueLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        performanceValueLabel.setIconTextGap(0);

        javax.swing.GroupLayout teamPerformancePanelLayout = new javax.swing.GroupLayout(teamPerformancePanel);
        teamPerformancePanel.setLayout(teamPerformancePanelLayout);
        teamPerformancePanelLayout.setHorizontalGroup(
            teamPerformancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamPerformancePanelLayout.createSequentialGroup()
                .addGroup(teamPerformancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(teamPerformancePanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(performanceLabel))
                    .addComponent(performanceValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addContainerGap())
        );
        teamPerformancePanelLayout.setVerticalGroup(
            teamPerformancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamPerformancePanelLayout.createSequentialGroup()
                .addComponent(performanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(performanceValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        apInformationPanel.add(teamPerformancePanel, gridBagConstraints);

        planExecutionPanel.setBackground(Color.decode("#45494A"));
        planExecutionPanel.setBorder(
                BorderFactory.createMatteBorder(4, 2, 2, 4, Color.decode("#3C3F41")));
        planExecutionPanel.setMinimumSize(new java.awt.Dimension(110, 100));
        planExecutionPanel.setPreferredSize(new java.awt.Dimension(110, 100));

        executionLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        executionLabel.setForeground(new java.awt.Color(252, 254, 252));
        executionLabel.setText("execution");

        executionValueLabel.setFont(new java.awt.Font("Dialog", 1, 40)); // NOI18N
        executionValueLabel.setForeground(new java.awt.Color(51, 255, 0));
        executionValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);


        javax.swing.GroupLayout planExecutionPanelLayout = new javax.swing.GroupLayout(planExecutionPanel);
        planExecutionPanel.setLayout(planExecutionPanelLayout);
        planExecutionPanelLayout.setHorizontalGroup(
            planExecutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planExecutionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(planExecutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, planExecutionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(executionLabel))
                    .addComponent(executionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        planExecutionPanelLayout.setVerticalGroup(
            planExecutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planExecutionPanelLayout.createSequentialGroup()
                .addComponent(executionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(executionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(planExecutionPanel, gridBagConstraints);

        datePanel.setBackground(Color.decode("#45494A"));
        datePanel.setBorder(BorderFactory
                .createMatteBorder(2, 2, 4, 4, Color.decode("#3C3F41")));
        datePanel.setMinimumSize(new java.awt.Dimension(220, 100));
        datePanel.setPreferredSize(new java.awt.Dimension(220, 100));

        dateLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        dateLabel.setForeground(Color.decode("#FCFEFC"));
        dateLabel.setText("date");

        dateValueLabel.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        dateValueLabel.setForeground(Color.decode("#FCFEFC"));
        dateValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateValueLabel.setText(Time.nowDate().toString());
        dateValueLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout datePanelLayout = new javax.swing.GroupLayout(datePanel);
        datePanel.setLayout(datePanelLayout);
        datePanelLayout.setHorizontalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dateLabel))
                    .addComponent(dateValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addContainerGap())
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(datePanel, gridBagConstraints);

        filterLabelPanel.setBackground(new Color(230, 231, 234));
        filterLabelPanel.setBorder(BorderFactory
                .createMatteBorder(4, 4, 4, 2, Color.decode("#3C3F41")));
        filterLabelPanel.setMaximumSize(new Dimension(164, 50));
        filterLabelPanel.setMinimumSize(new Dimension(100, 50));
        filterLabelPanel.setPreferredSize(new Dimension(164, 50));
        filterLabelPanel.setLayout(new BorderLayout());

        filterLabel.setBackground(new Color(230, 231, 234));
        filterLabel.setFont(new Font("Dialog", 1, 18)); // NOI18N
        filterLabel.setForeground(new Color(122, 120, 123));
        filterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filterLabel.setText("Filter by");
        filterLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        filterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        filterLabel.setIconTextGap(0);
        filterLabel.setMaximumSize(new Dimension(164, 24));
        filterLabel.setMinimumSize(new Dimension(80, 24));
        filterLabel.setOpaque(true);
        filterLabel.setPreferredSize(new Dimension(100, 24));
        filterLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                filterLabel.setBackground(Color.decode("#D9DADC"));
            }
            public void mouseExited(MouseEvent evt) {
                filterLabel.setBackground(Color.decode("#E6E7EA"));
            }
            public void mouseClicked(MouseEvent evt){
                if(meetingName != null){
                    filterLabelAction();
                }
                else{
                    JOptionPane.showMessageDialog(mainInterface,
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        filterLabelPanel.add(filterLabel, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(filterLabelPanel, gridBagConstraints);

        statusPanel.setBackground(Color.decode("#4B6EAF"));
                //new Color(0, 66, 118));
        statusPanel.setBorder(BorderFactory
                .createMatteBorder(4, 2, 4, 0, Color.decode("#3C3F41")));
        statusPanel.setMaximumSize(new Dimension(32767, 50));
        statusPanel.setMinimumSize(new Dimension(710, 50));
        statusPanel.setPreferredSize(new Dimension(710, 50));

        statusRadioButton.setOpaque(false);
        statusRadioButton.setFont(new Font("Dialog", 1, 20)); // NOI18N
        statusRadioButton.setForeground(new Color(252, 254, 252));
        statusRadioButton.setIconTextGap(0);
        statusRadioButton.setMargin(new Insets(0, 2, 0, 2));
        statusRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentRadioButton.setSelected(false);
            }
        });

        statusComboBox.setBackground(new java.awt.Color(252, 254, 252));
        statusComboBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        statusComboBox.setForeground(new java.awt.Color(48, 49, 50));
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] 
        { "  --- Select ---", "ALL", "COMPLETED", "OVERDUE",
            "IN_PROCESS", "COMPLETED_APP", "NEAR_DUE_DATE"}));
        statusComboBox.setBorder(null);
        statusComboBox.setMaximumSize(new java.awt.Dimension(149, 29));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        status2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        status2Label.setForeground(new java.awt.Color(252, 254, 252));
        status2Label.setText("status");

        dateRadioButton.setOpaque(false);//setBackground(new Color(0, 66, 118));
        dateRadioButton.setForeground(new Color(252, 254, 252));
        dateRadioButton.setIconTextGap(0);
        dateRadioButton.setMargin(new Insets(0, 2, 0, 2));
        dateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentRadioButton.setSelected(false);
            }
        });

        dateComboBox.setBackground(new java.awt.Color(252, 254, 252));
        dateComboBox.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        dateComboBox.setForeground(new java.awt.Color(48, 49, 50));
        dateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] 
        { "-- Select --", "start Date", "due Date", "end Date" }));
        dateComboBox.setBorder(null);
        dateComboBox.setMaximumSize(new java.awt.Dimension(106, 29));
        dateComboBox.setMinimumSize(new java.awt.Dimension(90, 29));

        date2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        date2Label.setForeground(new java.awt.Color(252, 254, 252));
        date2Label.setText("date");
        
        ownerRadioButton.setOpaque(false);
        ownerRadioButton.setIconTextGap(0);
        ownerRadioButton.setMargin(new java.awt.Insets(0, 2, 0, 0));
        ownerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentRadioButton.setSelected(false);
            }
        });

        owner2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        owner2Label.setForeground(new java.awt.Color(252, 254, 252));
        owner2Label.setText("owner");

        owner2TextField.setBackground(new java.awt.Color(252, 254, 252));
        owner2TextField.setText("acronym");
        owner2TextField.setForeground(new Color(120, 120, 123));
        owner2TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        owner2TextField.setMinimumSize(new java.awt.Dimension(4, 27));
        owner2TextField.setPreferredSize(new java.awt.Dimension(54, 27));
        owner2TextField.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent arg0) {

            }
            @Override
            public void focusGained(FocusEvent arg0) {
                owner2TextField.setText("");
                owner2TextField.setForeground(Color.decode("#303132"));
            }
        });

        contentRadioButton.setOpaque(false);
        contentRadioButton.setIconTextGap(0);
        contentRadioButton.setMargin(new java.awt.Insets(0, 2, 0, 2));
        contentRadioButton.setMinimumSize(new java.awt.Dimension(0, 26));
        contentRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusRadioButton.setSelected(false);
                dateRadioButton.setSelected(false);
                ownerRadioButton.setSelected(false);
            }
        });

        content2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        content2Label.setForeground(new java.awt.Color(252, 254, 252));
        content2Label.setText("content");
        content2Label.setMinimumSize(new java.awt.Dimension(0, 15));
        content2Label.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent arg0) {

            }
            @Override
            public void focusGained(FocusEvent arg0) {
                content2Label.setText("");
                content2Label.setForeground(Color.decode("#303132"));
            }
        });
        
        hintTextField.setBackground(new java.awt.Color(252, 254, 252));
        hintTextField.setText("hint");
        hintTextField.setForeground(new Color(120, 120, 123));
        hintTextField.setBorder(BorderFactory
                .createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        hintTextField.setMinimumSize(new java.awt.Dimension(0, 27));
        hintTextField.setPreferredSize(new java.awt.Dimension(35, 27));
        hintTextField.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent arg0) {

            }
            @Override
            public void focusGained(FocusEvent arg0) {
                hintTextField.setText("");
                hintTextField.setForeground(Color.decode("#303132"));
            }
        });
        
        
        startDateChooser.setDateFormatString("yyyy-MM-dd");
        startDateChooser.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        startDateChooser.setDate(Date.valueOf(Time.nowDate()));
        startDateChooser.getCalendarButton().setBackground(Color.decode("#4B6EAF"));
        startDateChooser.getCalendarButton().setIcon(new ImageIcon(getClass()
                .getResource("/images/JDateChooserIcon2.gif")));
        ((JTextFieldDateEditor)startDateChooser.getDateEditor())
        .setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#FCFEFC")));
        startDateChooser.getCalendarButton().setBorder(null);
        
        endDateChooser.setDateFormatString("yyyy-MM-dd");
        endDateChooser.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        endDateChooser.setDate(Date.valueOf(Time.nowDate().plusDays(1)));
        endDateChooser.getCalendarButton().setBackground(Color.decode("#4B6EAF"));
        endDateChooser.getCalendarButton().setIcon(new ImageIcon(getClass()
                .getResource("/images/JDateChooserIcon2.gif")));
        ((JTextFieldDateEditor)endDateChooser.getDateEditor())
        .setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#FCFEFC")));
        endDateChooser.getCalendarButton().setBorder(null);
        
        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status2Label)
                    .addComponent(statusRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date2Label)
                    .addComponent(dateRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(owner2Label)
                    .addComponent(ownerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(owner2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contentRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(hintTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(owner2Label)
                        .addGap(1, 1, 1)
                        .addComponent(ownerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(content2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(contentRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status2Label)
                            .addComponent(date2Label))
                        .addGap(1, 1, 1)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(statusRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hintTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(owner2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(statusPanel, gridBagConstraints);

        buttonsPanel.setBackground(Color.decode("#4B6EAF"));
        buttonsPanel.setBorder(BorderFactory
                .createMatteBorder(4, 0, 4, 4, Color.decode("#3C3F41")));
        buttonsPanel.setMaximumSize(new java.awt.Dimension(122, 50));
        buttonsPanel.setMinimumSize(new java.awt.Dimension(120, 50));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(120, 50));
        buttonsPanel.setLayout(new javax.swing.BoxLayout(buttonsPanel, javax.swing.BoxLayout.LINE_AXIS));

        addIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addIcon.setIcon(new ImageIcon(getClass().getResource("/images/plusWhite24.png"))); // NOI18N
        addIcon.setToolTipText("Add Action");
        addIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addIcon.setIconTextGap(0);
        addIcon.setMaximumSize(new java.awt.Dimension(32767, 32767));
        addIcon.setMinimumSize(new java.awt.Dimension(35, 40));
        addIcon.setPreferredSize(new java.awt.Dimension(35, 40));
        addIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                addIcon.setIcon(new ImageIcon(getClass().getResource("/images/plusGreen-24.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(!clickFlag)
                    addIcon.setIcon(new ImageIcon(getClass().getResource("/images/plusWhite24.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                if(meetingName != null){
                    AddAction addAction;
                    try {
                        clickFlag = true;
                        addIcon.setIcon(new ImageIcon(getClass().getResource("/images/plusGreen-24.png")));
                        addAction = new AddAction(mainInterface,Aps.getTerminal(),meetingName);
                        addAction.setLocationRelativeTo(mainInterface);
                        addAction.setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(UITerminal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                else{
                    JOptionPane.showMessageDialog(mainInterface,
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
            }
        }); 
        buttonsPanel.add(addIcon);

        editIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editWhite24.png"))); // NOI18N
        editIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editIcon.setIconTextGap(0);
        editIcon.setMaximumSize(new java.awt.Dimension(32767, 32767));
        editIcon.setMinimumSize(new java.awt.Dimension(34, 40));
        editIcon.setPreferredSize(new java.awt.Dimension(34, 40));
        editIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mouseClicked(MouseEvent e){
                if(meetingName == null){
                    JOptionPane.showMessageDialog(mainInterface,
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else if(actionListTable.getSelectedRowCount() == 0){
                    JOptionPane.showMessageDialog(mainInterface,
                            "<html><center>No Action has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    EditAction editAction = new EditAction(mainInterface,
                            Aps.getTerminal(),meetingName, getSelectedRowData(), globalFilter, filterValues);
                    editAction.setLocationRelativeTo(mainInterface);
                    editAction.setVisible(true);
                    actionListTable.getSelectionModel().clearSelection();
                }
            }
        }); 
        buttonsPanel.add(editIcon);

        deleteIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteWhite24.png"))); // NOI18N
        deleteIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteIcon.setIconTextGap(0);
        deleteIcon.setMaximumSize(new java.awt.Dimension(32767, 32767));
        deleteIcon.setMinimumSize(new java.awt.Dimension(34, 40));
        deleteIcon.setPreferredSize(new java.awt.Dimension(34, 40));
        deleteIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mouseClicked(MouseEvent e){
                if(meetingName == null){
                    JOptionPane.showMessageDialog(mainInterface,
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else if(actionListTable.getSelectedRowCount() == 0){
                    JOptionPane.showMessageDialog(mainInterface,
                            "<html><center>No Action has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Object[] options = { "Yes", "No" };
                    if(JOptionPane.showOptionDialog(mainInterface,
                        "<html><center>Are you sure to delete the selected Action?",
                        "Delete Action",JOptionPane.DEFAULT_OPTION, 
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0){
                        int row_index = actionListTable.getSelectedRow();
                        TableModel model = actionListTable.getModel();
                        try {
                            boolean is_deleted = Aps.getTerminal().deleteAction(
                                    String.valueOf(model.getValueAt(row_index, 0)),meetingName);
                            if(is_deleted)
                                updateJTable(globalFilter, filterValues);
                        } catch (Exception ex) {
                            Logger.getLogger(UITerminal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    else{
                    }
                }
            }
        });
        buttonsPanel.add(deleteIcon);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(buttonsPanel, gridBagConstraints);
    }
    
    private void filterLabelAction(){
        CursorToolkit.startWaitCursor(mainInterface.getRootPane());
        filterValues = new ArrayList();
        if(statusRadioButton.isSelected() && dateRadioButton.isSelected()
                && ownerRadioButton.isSelected()){
            String statusValue = statusComboBox.getSelectedItem().toString();;
            if(statusValue.equalsIgnoreCase("ALL")){
                try{
                    Collaborator collaborator = Aps.getTerminal()
                        .getParticipant(meetingName, owner2TextField.getText());
                    filterValues.add(collaborator.getCollaboratorId());
                    filterValues.add(Time.getDate(endDateChooser.getCalendar()));
                    filterValues.add(Time.getDate(startDateChooser.getCalendar()));
                    if(dateComboBox.getSelectedIndex() == 1){
                        globalFilter = ActionItemFilter.S_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                    else if(dateComboBox.getSelectedIndex() == 2){
                        globalFilter = ActionItemFilter.D_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                    else if (dateComboBox.getSelectedIndex() == 3){
                        globalFilter = ActionItemFilter.E_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);                
                    }
                    else{
                        JOptionPane.showMessageDialog(this, 
                        "Select a Date criteria for filtering", "Date Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, 
                        "Values of Dates or Owner Invalid", "Data Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(statusComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, 
                        "Select an Action status", "Status Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                try{
                    Collaborator collaborator = Aps.getTerminal()
                        .getParticipant(meetingName, owner2TextField.getText());
                    filterValues.add(Status.valueOf(statusValue));
                    filterValues.add(collaborator.getCollaboratorId());
                    filterValues.add(Time.getDate(endDateChooser.getCalendar()));
                    filterValues.add(Time.getDate(startDateChooser.getCalendar()));
                    if(dateComboBox.getSelectedIndex() == 1){
                        globalFilter = ActionItemFilter.STATUS_S_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                    else if(dateComboBox.getSelectedIndex() == 2){
                        globalFilter = ActionItemFilter.STATUS_D_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                    else if (dateComboBox.getSelectedIndex() == 3){
                        globalFilter = ActionItemFilter.STATUS_E_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, 
                        "Select a Date criteria for filtering", "Date Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, 
                        "Values of Dates or Owner Invalid", "Data Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(statusRadioButton.isSelected() && dateRadioButton.isSelected()){                    
            String statusValue = statusComboBox.getSelectedItem().toString();
            if(statusValue.equalsIgnoreCase("ALL")){
                try{
                    filterValues.add(Time.getDate(endDateChooser.getCalendar()));
                    filterValues.add(Time.getDate(startDateChooser.getCalendar()));
                    if(dateComboBox.getSelectedIndex() == 1){
                        globalFilter = ActionItemFilter.S_DATE;
                        updateJTable(globalFilter, filterValues);
                    }
                    else if(dateComboBox.getSelectedIndex() == 2){
                        globalFilter = ActionItemFilter.D_DATE;
                        updateJTable(globalFilter, filterValues);
                    }
                    else if (dateComboBox.getSelectedIndex() == 3){
                        globalFilter = ActionItemFilter.E_DATE;
                        updateJTable(globalFilter, filterValues);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, 
                        "Select a Date criteria for filtering", "Date Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, 
                        "Null date or wrong date format", "Date Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(statusComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, 
                        "Select an Action status", "Status Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                try{
                    filterValues.add(Status.valueOf(statusValue));
                    filterValues.add(Time.getDate(endDateChooser.getCalendar()));
                    filterValues.add(Time.getDate(startDateChooser.getCalendar()));
                    if(dateComboBox.getSelectedIndex() == 1){
                        globalFilter = ActionItemFilter.STATUS_S_DATE;
                        updateJTable(globalFilter, filterValues);                
                    }
                    else if(dateComboBox.getSelectedIndex() == 2){
                        globalFilter = ActionItemFilter.STATUS_D_DATE;
                        updateJTable(globalFilter, filterValues);                
                    }
                    else if (dateComboBox.getSelectedIndex() == 3){
                        globalFilter = ActionItemFilter.STATUS_E_DATE;
                        updateJTable(globalFilter, filterValues);                
                    }
                    else{
                       JOptionPane.showMessageDialog(this, 
                        "Select a Date criteria for filtering", "Date Selection", 
                        JOptionPane.INFORMATION_MESSAGE);                        
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(this, 
                        "Null date or wrong date format", "Date Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(dateRadioButton.isSelected() && ownerRadioButton.isSelected()){
            try{
                Collaborator collaborator = Aps.getTerminal()
                    .getParticipant(meetingName, owner2TextField.getText());
                filterValues.add(collaborator.getCollaboratorId());
                filterValues.add(Time.getDate(endDateChooser.getCalendar()));
                filterValues.add(Time.getDate(startDateChooser.getCalendar()));
                if(dateComboBox.getSelectedIndex() == 1){
                    globalFilter = ActionItemFilter.S_DATE_OWNER;
                    updateJTable(globalFilter, filterValues);
                }
                else if(dateComboBox.getSelectedIndex() == 2){
                    globalFilter = ActionItemFilter.D_DATE_OWNER;
                    updateJTable(globalFilter, filterValues);
                }
                else if (dateComboBox.getSelectedIndex() == 3){
                    globalFilter = ActionItemFilter.E_DATE_OWNER;
                    updateJTable(globalFilter, filterValues);
                }
                else{
                    JOptionPane.showMessageDialog(this, 
                        "Select a Date criteria for filtering", "Date Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, 
                        "Null date or wrong date format", "Date Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(statusRadioButton.isSelected() && ownerRadioButton.isSelected()){
            String statusValue = statusComboBox.getSelectedItem().toString();
            if(statusValue.equalsIgnoreCase("ALL")){                
                Collaborator collaborator = Aps.getTerminal()
                    .getParticipant(meetingName, owner2TextField.getText());
                if(collaborator != null){
                    filterValues.add(collaborator.getCollaboratorId());
                    globalFilter = ActionItemFilter.OWNER;
                    updateJTable(globalFilter, filterValues);
                }
                else{
                    JOptionPane.showMessageDialog(this, 
                        "Data invalid\nOwner doesn't exist or not belong to this meeting ",
                        "Data Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(statusComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, 
                        "Select an Action status", "Status Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                Collaborator collaborator = Aps.getTerminal()
                    .getParticipant(meetingName, owner2TextField.getText());
                if(collaborator != null){
                    filterValues.add(Status.valueOf(statusValue));
                    filterValues.add(collaborator.getCollaboratorId());
                    globalFilter = ActionItemFilter.STATUS_OWNER;
                    updateJTable(globalFilter, filterValues);
                }
                else{
                    JOptionPane.showMessageDialog(this, 
                        "Data invalid\nOwner doesn't exist or not belong to this meeting ",
                        "Data Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else if(statusRadioButton.isSelected()){
            String statusValue = statusComboBox.getSelectedItem().toString();
            if(statusValue.equalsIgnoreCase("ALL")){
                globalFilter = ActionItemFilter.ALL;
                updateJTable(globalFilter, null);
            }
            else if(statusComboBox.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(this, 
                        "Select an Action status", "Status Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                globalFilter = ActionItemFilter.STATUS;
                filterValues.add(Status.valueOf(statusValue));
                Status.valueOf(statusComboBox.getSelectedItem().toString());
                updateJTable(globalFilter, filterValues);
            }
        }
        else if(dateRadioButton.isSelected()){
            try{
                filterValues.add(Time.getDate(endDateChooser.getCalendar()));
                filterValues.add(Time.getDate(startDateChooser.getCalendar()));
                if(dateComboBox.getSelectedIndex() == 1){
                    globalFilter = ActionItemFilter.S_DATE;
                    updateJTable(globalFilter, filterValues);
                }
                else if(dateComboBox.getSelectedIndex() == 2){
                    globalFilter = ActionItemFilter.D_DATE;
                    updateJTable(globalFilter, filterValues);
                }
                else if (dateComboBox.getSelectedIndex() == 3){
                    globalFilter = ActionItemFilter.E_DATE;
                    updateJTable(globalFilter, filterValues);
                }
                else{
                    JOptionPane.showMessageDialog(this, 
                        "Select a Date criteria for filtering", "Date Selection", 
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, 
                        "Null date or wrong date format", "Date Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if(ownerRadioButton.isSelected()){
            if(owner2TextField.getText() != ""){
                Collaborator collaborator = Aps.getTerminal()
                        .getParticipant(meetingName, owner2TextField.getText());
                if(collaborator != null){
                    globalFilter = ActionItemFilter.OWNER;
                    filterValues.add(collaborator.getCollaboratorId());
                    updateJTable(globalFilter, filterValues);
                }
                else{
                    JOptionPane.showMessageDialog(this, 
                        "Data invalid\nOwner doesn't exist or not belong to this meeting ",
                        "Data Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, 
                    "Enter an Owner acronym or ID for filtering ",
                    "Data Input", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(contentRadioButton.isSelected()){
            globalFilter = ActionItemFilter.CONTENT;
            if(hintTextField.getText() != ""){
                filterValues.add(hintTextField.getText());
                updateJTable(globalFilter, filterValues);
            }
            else{
                JOptionPane.showMessageDialog(this, 
                    "Enter a content hint for filtering ",
                    "Data Input", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, 
                    "Select a criteria for filtering ",
                    "Selection", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
        CursorToolkit.stopWaitCursor(mainInterface.getRootPane());
    }
    
    private void initComponents(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        this.setBorder(BorderFactory.createMatteBorder(0, 4, 1, 4, 
                Color.decode(ColorsDarcula.BLACK.code)));
        actionListTable = new JTable();
        createInformationPanel();
        actionListPanel = new JPanel();
        actionListPanel.setLayout(new BorderLayout());
        actionListPanel.setPreferredSize(new Dimension(300,300));
        actionListPanel.setBackground(Color.decode("#3C3F41"));
        //**********************************************************************
        //  Action List Table Components
        //**********************************************************************
        //  Action List Table
        actionListTable.setModel(new DefaultTableModel(null, new String [] {
                "ID", "Resp.", "Detail", "Comments", 
                "P.Start Date", "P.End Date", "R.End Date",
                "Prog. %", "Status", "Dur."
            }));
        actionListTable.setMinimumSize(new Dimension(300, 200));
        actionListTable.setAutoCreateRowSorter(true);
        actionListTable.setRowHeight(30);
        actionListTable.setFillsViewportHeight(true);
        actionListTable.setFocusable(false);
        actionListTable.setBackground(Color.decode("#3C3F41"));
        actionListTable.setForeground(Color.decode("#BBBBBB"));
        actionListTable.getTableHeader().setBackground(Color.decode("#3F4044"));
        actionListTable.getTableHeader().setForeground(Color.decode("#E3E3E3"));
        actionListTable.getTableHeader().setBorder(BorderFactory
                .createMatteBorder(1,1,1,1, Color.decode("#303132")));
        //actionListTable.setShowGrid(false);
        actionListTable.setShowVerticalLines(false);
        actionListTable.setShowHorizontalLines(false);
        actionListTable.setSelectionForeground(Color.decode("#BBBBBB"));
        actionListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setColumnWidth();
        actionListTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                JTable table =(JTable) e.getSource();
                Point p = e.getPoint();
                int row = table.rowAtPoint(p);
                if (e.getClickCount() == 2) {
                    if(row != -1){
                        EditAction editAction = new EditAction(mainInterface,
                            Aps.getTerminal(),meetingName, getSelectedRowData(), 
                                globalFilter, filterValues);
                        editAction.setLocationRelativeTo(mainInterface);
                        editAction.setVisible(true);
                    }
                }
            }
        });
        actionListTable.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                //actionListTable.getSelectionModel().clearSelection();
                //actionListTable.getSelectionModel().removeSelectionInterval(actionListTable.getSelectedRow(), actionListTable.getSelectedRow());
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });
        alTableScrollPane = new JScrollPane();
        alTableScrollPane.setViewportView(actionListTable);
        alTableScrollPane.getViewport().setBackground(Color.decode("#3C3F41"));
        alTableScrollPane.setBorder(BorderFactory.createMatteBorder(0,1,1,1, Color.decode("#303132")));
        actionListPanel.add(alTableScrollPane, BorderLayout.CENTER);
        pagePanel = new JPanel();
        pagePanel.setBackground(Color.decode("#3C3F41"));
        pagePanel.setPreferredSize(new Dimension(Short.MAX_VALUE,15));
        this.add(apInformationPanel, BorderLayout.NORTH);
        this.add(actionListPanel, BorderLayout.CENTER);
        this.add(pagePanel, BorderLayout.SOUTH);
        
    }
    
    public Component getComponent(String name){
        if(name.equals("addIcon"))
            return addIcon;
        return null;
    }
    
    public JPanel getJPanel(){
        return this;
    }
    
    private String getParticipantsAcronyms(WorkTeam workteam, 
            ArrayList<Collaborator> adtParticipants){
        String s = "";
        ArrayList<Collaborator> collaborators = (ArrayList<Collaborator>)workteam.getMembers().clone();
        if(!adtParticipants.isEmpty())
            collaborators.addAll((ArrayList<Collaborator>)adtParticipants.clone());
        
        for(int i=0;i<collaborators.size();i++){
            if(i == collaborators.size()-1)
                s = s+ collaborators.get(i).getAcronymName();
            else
                s = s+ collaborators.get(i).getAcronymName()+", ";
        }
        return s;
    }
    
    private Object[] getSelectedRowData(){
        Object[] rowData = new Object[10];
        int rowIndex = actionListTable.getSelectedRow();
        TableModel model = actionListTable.getModel();
        
        if(actionListTable.getRowSorter() != null)
            rowIndex = actionListTable.convertRowIndexToModel(rowIndex);
        
        for(int columnIndex = 0;columnIndex < 10;columnIndex++)
            rowData[columnIndex] = model.getValueAt(rowIndex, columnIndex);
        return rowData;
    }
    
    protected void updateJTable(ActionItemFilter filter, ArrayList<Object> values){
        try {
            Object[] object = Aps.getTerminal().getTableContent(filter,values, meetingName);
            Meeting meeting = (Meeting)object[0];            
            if(meeting != null){
                ActionPlan plan = meeting.getActionPlan();
                APSummary summary = plan.getSummary();
                String[] nameSplitted = meetingName.split(" ");
                if(nameSplitted.length > 1){
                    String namePortion = "";
                    title1Label.setForeground(new Color(252,254,252));
                    for(int i=0; i < nameSplitted.length; i++){
                        if(i == 0)
                            title1Label.setText(nameSplitted[i]);
                        else
                            namePortion += nameSplitted[i]+" ";
                    }
                    title2Label.setForeground(new Color(252, 254, 252));
                    title2Label.setText(namePortion);
                }
                else{
                    title1Label.setText(null);
                    title2Label.setText(meetingName);
                }
                firstNameLabel.setText(plan.getOwner().getFirstName());
                int index = plan.getOwner().getLastName().indexOf(" ");
                String surname = plan.getOwner().getLastName().substring(0,index);
                surnameLabel.setText(surname);
                actionValueLabel.setText(String.valueOf(summary.getActions()));
                completedValueLabel.setText(String.valueOf(summary.getActionsCompleted()));
                appValueLabel.setText(String.valueOf(summary.getActionsCompletedApp()));
                overdueValueLabel.setText(String.valueOf(summary.getActionsOverdue()));
                participantsTextArea.setText(getParticipantsAcronyms(meeting.getTeam(),meeting.getAditionalParticipants()));
                int teamPerformance = 100;
                if(summary.getActionsOverdue() == 0 && summary.getActionsCompletedApp() > 0)
                    performanceValueLabel.setText(String.valueOf(teamPerformance)+"%");
                else{
                    teamPerformance = (int)Math.round(((float)summary.getActionsCompletedApp()/
                            ((float)summary.getActions()))*100);
                    performanceValueLabel.setText(String.valueOf(teamPerformance)+"%");
                }
                executionValueLabel.setText(String.valueOf(plan.getExecution())+"%");
                if(teamPerformance <= 70){
                    teamPerformancePanel.setBackground(Color.decode("#FE4344"));
                    performanceValueLabel.setForeground(Color.decode("#FCFEFC"));
                }
                else if(teamPerformance > 70 && teamPerformance < 90){
                    teamPerformancePanel.setBackground(Color.decode("#F2D345")); // Yellow Color
                    performanceValueLabel.setForeground(Color.decode("#303132"));
                }
                else{
                    // Darcula black color 3C3E41
                    teamPerformancePanel.setBackground(Color.decode("#64D610"));
                    performanceValueLabel.setForeground(Color.decode("#FCFEFC"));
                }
            }
            if(((TableModel)object[1]).getRowCount() != 0){
                actionListTable.setModel((TableModel)object[1]);
                setColumnWidth();
                centerColumnContent();
            } 
            else if(meetingName != null){
                JOptionPane.showMessageDialog(new JOptionPane(),
                "There's not Action with the specified criteria",
                "Information",JOptionPane.INFORMATION_MESSAGE);
            }
            actionListTable.repaint();
        }
        catch (Exception ex) {
            Logger.getLogger(UITerminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setColumnWidth(){       
        actionListTable.getColumnModel().getColumn(0).setMaxWidth(77);  //ID
        actionListTable.getColumnModel().getColumn(0).setMinWidth(77);  //ID
        actionListTable.getColumnModel().getColumn(1).setMaxWidth(40);  //RESPONSIBLE
        actionListTable.getColumnModel().getColumn(4).setMinWidth(70);  //START DATE
        actionListTable.getColumnModel().getColumn(4).setMaxWidth(73);  //START DATE
        actionListTable.getColumnModel().getColumn(5).setMinWidth(70);  //DUE DATE
        actionListTable.getColumnModel().getColumn(5).setMaxWidth(73);  //DUE DATE
        actionListTable.getColumnModel().getColumn(6).setMaxWidth(73);  //END DATE
        actionListTable.getColumnModel().getColumn(7).setMaxWidth(50);  //PROGRESS
        actionListTable.getColumnModel().getColumn(8).setMaxWidth(120); //STATUS
        actionListTable.getColumnModel().getColumn(8).setMinWidth(110); //STATUS
        actionListTable.getColumnModel().getColumn(9).setMaxWidth(40);  //DURATION
    }
    
    public void setFlag(boolean bool){
        clickFlag = bool;
    }
}
