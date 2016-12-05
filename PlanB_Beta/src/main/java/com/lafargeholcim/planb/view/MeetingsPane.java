/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.Box.Filler;

/**
 *
 * @author AI-Saac
 */
public class MeetingsPane extends JPanel{
    private JLabel acronymLabel, actionPlanIdLabel, actionsTitleLabel, 
            addMeetingIcon, addMemberIcon, addParticipantIcon, apOwnerLabel, 
            appTeamLabel, completedTeamLabel, editMeetingIcon, facilityLabel, 
            identifierLabel, meetingNameLabel, meetingsListLabel, optionTitle, 
            overdueTeamLabel, participantListLabel, performanceTeamLabel, 
            purposeLabel, removeMeetingIcon, removeMemberIcon, removeParticipantIcon, 
            systemTitle, teamListLabel, totalTeamLabel, workTeamIdLabel;
    private JTextField acronymTextField, actionPlanTextField, apOwnerTextField, 
            appTeamTextField, completedTeamTextField, facilityTextField, 
            idTextField, nameTextField, overdueTeamTextField, 
            performanceTeamTextField, totalTeamTextField, workTeamIdTextField;
    private JSeparator actionsSeparator;
    private JScrollPane adtParticipantsScrollPane, meetingListScrollPane, 
            purposeScrollPane, teamListScrollPane;
    private JTable adtParticipantsTable, meetingListTable, teamListTable;
    private Filler filler1;
    private JPanel leftPanel, meetingContentPanel, meetingInfoPanel,
            optionTitlePanel, rightPanel, workTeamInformationPanel;
    private JTextArea purposeTextArea;
    
    public MeetingsPane(){
        initComponents();
    }
    
    public void initComponents(){

        optionTitlePanel = new JPanel();
        optionTitle = new JLabel();
        filler1 = new Filler(new Dimension(0, 0), new Dimension(0, 0), 
                new Dimension(32767, 0));
        systemTitle = new JLabel();
        meetingContentPanel = new JPanel();
        leftPanel = new JPanel();
        addMeetingIcon = new JLabel();
        meetingsListLabel = new JLabel();
        editMeetingIcon = new JLabel();
        meetingListScrollPane = new JScrollPane();
        meetingListTable = new JTable();
        removeMeetingIcon = new JLabel();
        meetingInfoPanel = new JPanel();
        identifierLabel = new JLabel();
        idTextField = new JTextField();
        meetingNameLabel = new JLabel();
        actionPlanIdLabel = new JLabel();
        actionPlanTextField = new JTextField();
        nameTextField = new JTextField();
        acronymLabel = new JLabel();
        acronymTextField = new JTextField();
        facilityLabel = new JLabel();
        facilityTextField = new JTextField();
        purposeLabel = new JLabel();
        purposeScrollPane = new JScrollPane();
        purposeTextArea = new JTextArea();
        apOwnerLabel = new JLabel();
        apOwnerTextField = new JTextField();
        rightPanel = new JPanel();
        workTeamInformationPanel = new JPanel();
        workTeamIdLabel = new JLabel();
        workTeamIdTextField = new JTextField();
        performanceTeamLabel = new JLabel();
        performanceTeamTextField = new JTextField();
        totalTeamLabel = new JLabel();
        actionsTitleLabel = new JLabel();
        actionsSeparator = new JSeparator();
        appTeamLabel = new JLabel();
        totalTeamTextField = new JTextField();
        appTeamTextField = new JTextField();
        completedTeamLabel = new JLabel();
        completedTeamTextField = new JTextField();
        overdueTeamLabel = new JLabel();
        overdueTeamTextField = new JTextField();
        teamListLabel = new JLabel();
        removeMemberIcon = new JLabel();
        addMemberIcon = new JLabel();
        teamListScrollPane = new JScrollPane();
        teamListTable = new JTable();
        participantListLabel = new JLabel();
        removeParticipantIcon = new JLabel();
        addParticipantIcon = new JLabel();
        adtParticipantsScrollPane = new JScrollPane();
        adtParticipantsTable = new JTable();
        
        this.setBackground(Color.decode("#3C3F41"));
        this.setLayout(new java.awt.BorderLayout());

        optionTitlePanel.setBackground(new java.awt.Color(69, 73, 74));
        optionTitlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 8, 4, 8, new java.awt.Color(60, 63, 65)));
        optionTitlePanel.setMaximumSize(new java.awt.Dimension(32857, 65));
        optionTitlePanel.setMinimumSize(new java.awt.Dimension(90, 45));
        optionTitlePanel.setPreferredSize(new java.awt.Dimension(824, 45));
        optionTitlePanel.setLayout(new javax.swing.BoxLayout(optionTitlePanel, javax.swing.BoxLayout.LINE_AXIS));

        optionTitle.setForeground(new java.awt.Color(252, 254, 252));
        optionTitle.setText(" Meetings");
        optionTitlePanel.add(optionTitle);
        optionTitlePanel.add(filler1);

        systemTitle.setForeground(new java.awt.Color(252, 254, 252));
        systemTitle.setText("User: joel  ");
        optionTitlePanel.add(systemTitle);

        this.add(optionTitlePanel, java.awt.BorderLayout.NORTH);

        meetingContentPanel.setBackground(new java.awt.Color(187, 187, 187));
        meetingContentPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 8, 4, 8, new java.awt.Color(60, 63, 65)));
        meetingContentPanel.setPreferredSize(new java.awt.Dimension(816, 600));
        meetingContentPanel.setLayout(new javax.swing.BoxLayout(meetingContentPanel, javax.swing.BoxLayout.LINE_AXIS));

        leftPanel.setBackground(new java.awt.Color(187, 187, 187));
        leftPanel.setMaximumSize(new java.awt.Dimension(400, 32767));
        leftPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        addMeetingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plusWhite24.png"))); // NOI18N
        addMeetingIcon.setIconTextGap(0);

        meetingsListLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        meetingsListLabel.setForeground(new java.awt.Color(252, 254, 252));
        meetingsListLabel.setText("Meetings List");
        meetingsListLabel.setIconTextGap(0);

        editMeetingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editWhite24.png"))); // NOI18N
        editMeetingIcon.setIconTextGap(0);

        meetingListScrollPane.setPreferredSize(new java.awt.Dimension(352, 148));

        meetingListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        meetingListTable.setColumnSelectionAllowed(true);
        meetingListTable.setRowHeight(25);
        meetingListTable.setShowVerticalLines(false);
        meetingListScrollPane.setViewportView(meetingListTable);
        meetingListTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (meetingListTable.getColumnModel().getColumnCount() > 0) {
            meetingListTable.getColumnModel().getColumn(0).setMinWidth(65);
            meetingListTable.getColumnModel().getColumn(0).setPreferredWidth(65);
            meetingListTable.getColumnModel().getColumn(0).setMaxWidth(65);
        }

        removeMeetingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteWhite24.png"))); // NOI18N
        removeMeetingIcon.setIconTextGap(0);

        meetingInfoPanel.setBackground(new java.awt.Color(187, 187, 187));
        meetingInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Meeting Inforrmation", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        meetingInfoPanel.setPreferredSize(new java.awt.Dimension(360, 291));

        identifierLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        identifierLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        identifierLabel.setText("Identifier");
        identifierLabel.setIconTextGap(0);
        identifierLabel.setPreferredSize(new java.awt.Dimension(68, 33));

        idTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idTextField.setText(" 1");
        idTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        idTextField.setPreferredSize(new java.awt.Dimension(52, 33));

        meetingNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        meetingNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        meetingNameLabel.setText("Name");
        meetingNameLabel.setIconTextGap(0);
        meetingNameLabel.setPreferredSize(new java.awt.Dimension(63, 33));

        actionPlanIdLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        actionPlanIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actionPlanIdLabel.setText("Action Plan ID");
        actionPlanIdLabel.setIconTextGap(0);

        actionPlanTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        actionPlanTextField.setText(" 1");
        actionPlanTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        actionPlanTextField.setMaximumSize(new java.awt.Dimension(52, 33));
        actionPlanTextField.setPreferredSize(new java.awt.Dimension(52, 33));

        nameTextField.setText("Cómite Técnico Semanal");
        nameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        nameTextField.setMaximumSize(new java.awt.Dimension(257, 33));
        nameTextField.setPreferredSize(new java.awt.Dimension(257, 33));

        acronymLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        acronymLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acronymLabel.setText("Acronym");
        acronymLabel.setPreferredSize(new java.awt.Dimension(68, 33));

        acronymTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        acronymTextField.setText("CTE");
        acronymTextField.setPreferredSize(new java.awt.Dimension(52, 33));

        facilityLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        facilityLabel.setText("Facility");

        facilityTextField.setText("Planta Guayaquil");
        facilityTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        facilityTextField.setMaximumSize(new java.awt.Dimension(128, 33));
        facilityTextField.setPreferredSize(new java.awt.Dimension(128, 33));

        purposeLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        purposeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purposeLabel.setText("Purpose");
        purposeLabel.setIconTextGap(0);
        purposeLabel.setPreferredSize(new java.awt.Dimension(68, 33));

        purposeScrollPane.setMaximumSize(new java.awt.Dimension(257, 71));
        purposeScrollPane.setPreferredSize(new java.awt.Dimension(257, 71));

        purposeTextArea.setEditable(false);
        purposeTextArea.setColumns(20);
        purposeTextArea.setLineWrap(true);
        purposeTextArea.setRows(5);
        purposeTextArea.setText("El propósito será siempre el mismo\nustedes ya saben como son este tipo\nde cosas\n");
        purposeTextArea.setWrapStyleWord(true);
        purposeTextArea.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        purposeScrollPane.setViewportView(purposeTextArea);

        apOwnerLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        apOwnerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        apOwnerLabel.setText("Action Plan Owner");
        apOwnerLabel.setToolTipText("");
        apOwnerLabel.setPreferredSize(new java.awt.Dimension(143, 33));

        apOwnerTextField.setText("SERGIO ORJUELA");
        apOwnerTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        apOwnerTextField.setMaximumSize(new java.awt.Dimension(166, 33));
        apOwnerTextField.setPreferredSize(new java.awt.Dimension(166, 33));

        javax.swing.GroupLayout meetingInfoPanelLayout = new javax.swing.GroupLayout(meetingInfoPanel);
        meetingInfoPanel.setLayout(meetingInfoPanelLayout);
        meetingInfoPanelLayout.setHorizontalGroup(
            meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meetingInfoPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(meetingInfoPanelLayout.createSequentialGroup()
                        .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(acronymLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identifierLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(meetingNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(meetingInfoPanelLayout.createSequentialGroup()
                                .addComponent(acronymTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(facilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(meetingInfoPanelLayout.createSequentialGroup()
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(actionPlanIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(actionPlanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(meetingInfoPanelLayout.createSequentialGroup()
                        .addComponent(apOwnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apOwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(facilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, meetingInfoPanelLayout.createSequentialGroup()
                            .addComponent(purposeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(purposeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        meetingInfoPanelLayout.setVerticalGroup(
            meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meetingInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionPlanIdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(meetingInfoPanelLayout.createSequentialGroup()
                        .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identifierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(actionPlanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(meetingNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(acronymLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(acronymTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(facilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(facilityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(purposeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(purposeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(meetingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apOwnerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apOwnerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meetingInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(meetingListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(meetingsListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)
                        .addComponent(addMeetingIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editMeetingIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeMeetingIcon)))
                .addGap(16, 16, 16))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(meetingsListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMeetingIcon)
                    .addComponent(editMeetingIcon)
                    .addComponent(removeMeetingIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meetingListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(meetingInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        meetingContentPanel.add(leftPanel);

        rightPanel.setBackground(new java.awt.Color(187, 187, 187));
        rightPanel.setMinimumSize(new java.awt.Dimension(370, 500));
        rightPanel.setPreferredSize(new java.awt.Dimension(400, 500));

        workTeamInformationPanel.setBackground(new java.awt.Color(187, 187, 187));
        workTeamInformationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("WorkTeam Information"));
        workTeamInformationPanel.setPreferredSize(new java.awt.Dimension(340, 195));

        workTeamIdLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        workTeamIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workTeamIdLabel.setText("Identifier");
        workTeamIdLabel.setIconTextGap(0);
        workTeamIdLabel.setPreferredSize(new java.awt.Dimension(80, 33));

        workTeamIdTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        workTeamIdTextField.setText(" 1");
        workTeamIdTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        workTeamIdTextField.setEnabled(false);
        workTeamIdTextField.setPreferredSize(new java.awt.Dimension(45, 33));

        performanceTeamLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        performanceTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        performanceTeamLabel.setText("Performance");
        performanceTeamLabel.setPreferredSize(new java.awt.Dimension(107, 33));

        performanceTeamTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        performanceTeamTextField.setText(" 1");
        performanceTeamTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        performanceTeamTextField.setEnabled(false);
        performanceTeamTextField.setPreferredSize(new java.awt.Dimension(45, 33));

        totalTeamLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        totalTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalTeamLabel.setText("Total");
        totalTeamLabel.setIconTextGap(0);
        totalTeamLabel.setPreferredSize(new java.awt.Dimension(80, 33));
        totalTeamLabel.setRequestFocusEnabled(false);

        actionsTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        actionsTitleLabel.setText("Actions");

        actionsSeparator.setBackground(new java.awt.Color(187, 187, 187));

        appTeamLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        appTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appTeamLabel.setText("Completed APP");
        appTeamLabel.setIconTextGap(0);
        appTeamLabel.setPreferredSize(new java.awt.Dimension(107, 33));

        totalTeamTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalTeamTextField.setText(" 1");
        totalTeamTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        totalTeamTextField.setEnabled(false);
        totalTeamTextField.setPreferredSize(new java.awt.Dimension(45, 33));

        appTeamTextField.setBackground(new java.awt.Color(30, 31, 32));
        appTeamTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        appTeamTextField.setText(" 1");
        appTeamTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        appTeamTextField.setEnabled(false);
        appTeamTextField.setPreferredSize(new java.awt.Dimension(45, 33));

        completedTeamLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        completedTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completedTeamLabel.setText("Completed");
        completedTeamLabel.setIconTextGap(0);
        completedTeamLabel.setPreferredSize(new java.awt.Dimension(80, 33));

        completedTeamTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        completedTeamTextField.setText(" 1");
        completedTeamTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        completedTeamTextField.setEnabled(false);
        completedTeamTextField.setPreferredSize(new java.awt.Dimension(45, 33));

        overdueTeamLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        overdueTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        overdueTeamLabel.setText("Overdue");
        overdueTeamLabel.setIconTextGap(0);
        overdueTeamLabel.setPreferredSize(new java.awt.Dimension(107, 33));

        overdueTeamTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        overdueTeamTextField.setText(" 1");
        overdueTeamTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(187, 187, 187)));
        overdueTeamTextField.setPreferredSize(new java.awt.Dimension(45, 33));

        javax.swing.GroupLayout workTeamInformationPanelLayout = new javax.swing.GroupLayout(workTeamInformationPanel);
        workTeamInformationPanel.setLayout(workTeamInformationPanelLayout);
        workTeamInformationPanelLayout.setHorizontalGroup(
            workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                            .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(workTeamIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(totalTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(workTeamIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(performanceTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(performanceTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(totalTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(appTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(appTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                            .addComponent(actionsTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(actionsSeparator)))
                    .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                        .addComponent(completedTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(completedTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(overdueTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(overdueTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        workTeamInformationPanelLayout.setVerticalGroup(
            workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(workTeamInformationPanelLayout.createSequentialGroup()
                        .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(workTeamIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(workTeamIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(performanceTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(performanceTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actionsTitleLabel))
                    .addComponent(actionsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(appTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(workTeamInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(completedTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(completedTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overdueTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(overdueTeamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        teamListLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        teamListLabel.setText("Team Members List");
        teamListLabel.setIconTextGap(0);

        removeMemberIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteWhite24.png"))); // NOI18N
        removeMemberIcon.setIconTextGap(0);
        removeMemberIcon.setPreferredSize(new java.awt.Dimension(24, 30));

        addMemberIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plusWhite24.png"))); // NOI18N
        addMemberIcon.setIconTextGap(0);
        addMemberIcon.setPreferredSize(new java.awt.Dimension(24, 30));

        teamListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Names"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teamListTable.setColumnSelectionAllowed(true);
        teamListTable.setRowHeight(25);
        teamListTable.setShowVerticalLines(false);
        teamListScrollPane.setViewportView(teamListTable);
        teamListTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (teamListTable.getColumnModel().getColumnCount() > 0) {
            teamListTable.getColumnModel().getColumn(0).setMinWidth(65);
            teamListTable.getColumnModel().getColumn(0).setPreferredWidth(65);
            teamListTable.getColumnModel().getColumn(0).setMaxWidth(65);
        }

        participantListLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        participantListLabel.setText("Aditional Participants List");
        participantListLabel.setIconTextGap(0);

        removeParticipantIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteWhite24.png"))); // NOI18N
        removeParticipantIcon.setIconTextGap(0);
        removeParticipantIcon.setPreferredSize(new java.awt.Dimension(24, 30));

        addParticipantIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plusWhite24.png"))); // NOI18N
        addParticipantIcon.setIconTextGap(0);
        addParticipantIcon.setPreferredSize(new java.awt.Dimension(24, 30));

        adtParticipantsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Names"
            }
        ));
        adtParticipantsTable.setRowHeight(25);
        adtParticipantsTable.setShowVerticalLines(false);
        adtParticipantsScrollPane.setViewportView(adtParticipantsTable);
        if (adtParticipantsTable.getColumnModel().getColumnCount() > 0) {
            adtParticipantsTable.getColumnModel().getColumn(0).setMinWidth(65);
            adtParticipantsTable.getColumnModel().getColumn(0).setPreferredWidth(65);
            adtParticipantsTable.getColumnModel().getColumn(0).setMaxWidth(65);
        }

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(rightPanelLayout.createSequentialGroup()
                            .addComponent(teamListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(addMemberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(removeMemberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                            .addComponent(participantListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(100, 100, 100)
                            .addComponent(addParticipantIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(removeParticipantIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(teamListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(adtParticipantsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(workTeamInformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(workTeamInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(teamListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addMemberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeMemberIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teamListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(participantListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addParticipantIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeParticipantIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adtParticipantsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        meetingContentPanel.add(rightPanel);
        this.add(meetingContentPanel, java.awt.BorderLayout.CENTER);
    }
}
