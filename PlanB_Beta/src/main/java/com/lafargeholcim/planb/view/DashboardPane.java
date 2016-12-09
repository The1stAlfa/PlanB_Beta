/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.sys.User;
import com.lafargeholcim.planb.view.colors.ColorsDarcula;
import com.lafargeholcim.planb.view.colors.ColorsHolcim;
import com.lafargeholcim.planb.view.colors.ColorsLight;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box.Filler;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author AI-Saac
 */
public class DashboardPane extends JPanel{
    private JLabel actionsArrowIcon;
    private JLabel actionsComparisonLabel;
    private JLabel actionsLabel;
    private JPanel actionsPanel;
    private JLabel actionsValueLabel;
    private JLabel appArrowIcon;
    private JLabel appComparisonLabel;
    private JLabel appLabel;
    private JPanel appPanel;
    private JLabel appValueLabel;
    private JLabel completedArrowLabel;
    private JLabel completedComparisonLabel;
    private JLabel completedLabel;
    private JPanel completedPanel;
    private JLabel completedValueLabel;
    private JPanel dashboardPanel;
    private JLabel excutionComparisonLabel;
    private JLabel executionArrowIcon;
    private JLabel executionLabel;
    private JPanel executionPanel;
    private JLabel executionValueLabel;
    private Filler filler1;
    private JLabel inProcessArrowIcon;
    private JButton inProcessCloseButton;
    private JLabel inProcessComparisonLabel;
    private JLabel inProcessEditIcon;
    private JLabel inProcessLabel;
    private JLabel inProcessListLabel;
    private JPanel inProcessListPanel;
    private JScrollPane inProcessListScrollPane;
    private JTable inProcessListTable;
    private JPanel inProcessPanel;
    private JLabel inProcessValueLabel;
    private JLabel nearDueDateArrowIcon;
    private JButton nearDueDateCloseButton;
    private JLabel nearDueDateComparisonLabel;
    private JLabel nearDueDateEditIcon;
    private JLabel nearDueDateLabel;
    private JLabel nearDueDateListLabel;
    private JPanel nearDueDateListPanel;
    private JTable nearDueDateListTable;
    private JPanel nearDueDatePanel;
    private JScrollPane nearDueDateListScrollPane;
    private JLabel nearDueDateValueLabel;
    private JLabel overdueArrowIcon;
    private JButton overdueCloseButton;
    private JLabel overdueComparisonLabel;
    private JLabel overdueEditIcon;
    private JLabel overdueLabel;
    private JLabel overdueListLabel;
    private JPanel overdueListPanel;
    private JScrollPane overdueListScrollPane;
    private JTable overdueListTable;
    private JPanel overduePanel;
    private JLabel overdueValueLabel;
    private JLabel panelNameLabel;
    private JPanel perfomancePanel;
    private JLabel performanceArrowIcon;
    private JLabel performanceComparisonLabel;
    private JLabel performanceLabel;
    private JLabel performanceValueLabel;
    private JPanel summaryPanel;
    private JPanel titlePanel;
    private JLabel usernameLabel;
    private UITerminal mainInterface;
    private User user;
    
    public DashboardPane(UITerminal mainInterface, User user){
        this.mainInterface = mainInterface;
        this.user = user;
        initComponents();
    }
    
    private void initComponents() {                          
        java.awt.GridBagConstraints gridBagConstraints;

        titlePanel = new JPanel();
        panelNameLabel = new JLabel();
        filler1 = new Filler(new Dimension(0, 0), new Dimension(0, 0), 
                new Dimension(32767, 0));
        usernameLabel = new JLabel();
        dashboardPanel = new JPanel();
        summaryPanel = new JPanel();
        actionsPanel = new JPanel();
        actionsLabel = new JLabel();
        actionsValueLabel = new javax.swing.JLabel();
        actionsComparisonLabel = new javax.swing.JLabel();
        actionsArrowIcon = new javax.swing.JLabel();
        completedPanel = new javax.swing.JPanel();
        completedLabel = new javax.swing.JLabel();
        completedValueLabel = new javax.swing.JLabel();
        completedComparisonLabel = new javax.swing.JLabel();
        completedArrowLabel = new javax.swing.JLabel();
        appPanel = new javax.swing.JPanel();
        appLabel = new javax.swing.JLabel();
        appValueLabel = new javax.swing.JLabel();
        appComparisonLabel = new javax.swing.JLabel();
        appArrowIcon = new javax.swing.JLabel();
        overduePanel = new javax.swing.JPanel();
        overdueLabel = new javax.swing.JLabel();
        overdueValueLabel = new javax.swing.JLabel();
        overdueComparisonLabel = new javax.swing.JLabel();
        overdueArrowIcon = new javax.swing.JLabel();
        nearDueDatePanel = new javax.swing.JPanel();
        nearDueDateLabel = new javax.swing.JLabel();
        nearDueDateValueLabel = new javax.swing.JLabel();
        nearDueDateArrowIcon = new javax.swing.JLabel();
        nearDueDateComparisonLabel = new javax.swing.JLabel();
        inProcessPanel = new javax.swing.JPanel();
        inProcessLabel = new javax.swing.JLabel();
        inProcessValueLabel = new javax.swing.JLabel();
        inProcessComparisonLabel = new javax.swing.JLabel();
        inProcessArrowIcon = new javax.swing.JLabel();
        executionPanel = new javax.swing.JPanel();
        executionLabel = new javax.swing.JLabel();
        executionValueLabel = new javax.swing.JLabel();
        excutionComparisonLabel = new javax.swing.JLabel();
        executionArrowIcon = new javax.swing.JLabel();
        perfomancePanel = new javax.swing.JPanel();
        performanceLabel = new javax.swing.JLabel();
        performanceValueLabel = new javax.swing.JLabel();
        performanceArrowIcon = new javax.swing.JLabel();
        performanceComparisonLabel = new javax.swing.JLabel();
        overdueListPanel = new javax.swing.JPanel();
        overdueListScrollPane = new javax.swing.JScrollPane();
        overdueListTable = new javax.swing.JTable();
        overdueListLabel = new javax.swing.JLabel();
        overdueCloseButton = new javax.swing.JButton();
        overdueEditIcon = new javax.swing.JLabel();
        nearDueDateListPanel = new javax.swing.JPanel();
        nearDueDateListScrollPane = new javax.swing.JScrollPane();
        nearDueDateListTable = new javax.swing.JTable();
        nearDueDateListLabel = new javax.swing.JLabel();
        nearDueDateCloseButton = new javax.swing.JButton();
        nearDueDateEditIcon = new javax.swing.JLabel();
        inProcessListPanel = new javax.swing.JPanel();
        inProcessListLabel = new javax.swing.JLabel();
        inProcessListScrollPane = new javax.swing.JScrollPane();
        inProcessListTable = new javax.swing.JTable();
        inProcessCloseButton = new javax.swing.JButton();
        inProcessEditIcon = new javax.swing.JLabel();

            
        this.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        this.setLayout(new BorderLayout());
        
        summaryPanel.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        
        titlePanel.setBackground(new java.awt.Color(69, 73, 74));
        titlePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 8, 4, 8, new java.awt.Color(60, 63, 65)));
        titlePanel.setMaximumSize(new java.awt.Dimension(32767, 65));
        titlePanel.setMinimumSize(new java.awt.Dimension(0, 45));
        titlePanel.setPreferredSize(new java.awt.Dimension(400, 45));
        titlePanel.setLayout(new javax.swing.BoxLayout(titlePanel, javax.swing.BoxLayout.LINE_AXIS));

        panelNameLabel.setForeground(new java.awt.Color(252, 254, 252));
        panelNameLabel.setText("  Dashboard");
        titlePanel.add(panelNameLabel);
        titlePanel.add(filler1);

        usernameLabel.setForeground(new java.awt.Color(252, 254, 252));
        usernameLabel.setText("Username: joel  ");
        titlePanel.add(usernameLabel);

        this.add(titlePanel, java.awt.BorderLayout.PAGE_START);

        dashboardPanel.setLayout(new javax.swing.BoxLayout(dashboardPanel, javax.swing.BoxLayout.PAGE_AXIS));
        dashboardPanel.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        
        summaryPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 8, 4, 8, new java.awt.Color(60, 63, 65)));
        summaryPanel.setMaximumSize(new java.awt.Dimension(2147483647, 220));
        summaryPanel.setLayout(new java.awt.GridBagLayout());

        actionsPanel.setBackground(new java.awt.Color(69, 73, 74));
        actionsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 4, new java.awt.Color(60, 63, 65)));
        actionsPanel.setForeground(new java.awt.Color(252, 254, 252));
        actionsPanel.setMaximumSize(new java.awt.Dimension(120, 110));
        actionsPanel.setMinimumSize(new java.awt.Dimension(110, 100));
        actionsPanel.setPreferredSize(new java.awt.Dimension(110, 100));

        actionsLabel.setForeground(new java.awt.Color(252, 254, 252));
        actionsLabel.setText("actions");

        actionsValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        actionsValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        actionsValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actionsValueLabel.setText("200");
        actionsValueLabel.setMaximumSize(new java.awt.Dimension(95, 67));
        actionsValueLabel.setPreferredSize(new java.awt.Dimension(88, 67));

        actionsComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        actionsComparisonLabel.setForeground(new java.awt.Color(252, 254, 252));
        actionsComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actionsComparisonLabel.setText("0");
        actionsComparisonLabel.setIconTextGap(0);
        actionsComparisonLabel.setMaximumSize(new java.awt.Dimension(24, 24));
        actionsComparisonLabel.setMinimumSize(new java.awt.Dimension(24, 24));
        actionsComparisonLabel.setPreferredSize(new java.awt.Dimension(24, 24));

        actionsArrowIcon.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        actionsArrowIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lineWhite-24.png"))); // NOI18N
        actionsArrowIcon.setIconTextGap(0);
        actionsArrowIcon.setMaximumSize(new java.awt.Dimension(24, 20));
        actionsArrowIcon.setMinimumSize(new java.awt.Dimension(24, 20));
        actionsArrowIcon.setPreferredSize(new java.awt.Dimension(24, 20));

        javax.swing.GroupLayout actionsPanelLayout = new javax.swing.GroupLayout(actionsPanel);
        actionsPanel.setLayout(actionsPanelLayout);
        actionsPanelLayout.setHorizontalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actionsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(actionsLabel)
                .addContainerGap())
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionsValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionsComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actionsArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        actionsPanelLayout.setVerticalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addComponent(actionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionsValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(actionsPanelLayout.createSequentialGroup()
                        .addComponent(actionsComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(actionsArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(actionsPanel, gridBagConstraints);

        completedPanel.setBackground(new java.awt.Color(242, 211, 69));
        completedPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 4, new java.awt.Color(60, 63, 65)));
        completedPanel.setMaximumSize(new java.awt.Dimension(120, 110));
        completedPanel.setMinimumSize(new java.awt.Dimension(110, 100));
        completedPanel.setPreferredSize(new java.awt.Dimension(110, 100));

        completedLabel.setForeground(new java.awt.Color(252, 254, 252));
        completedLabel.setText("completed");

        completedValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        completedValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        completedValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completedValueLabel.setText("100");
        completedValueLabel.setIconTextGap(0);
        completedValueLabel.setMaximumSize(new java.awt.Dimension(95, 67));
        completedValueLabel.setPreferredSize(new java.awt.Dimension(88, 67));

        completedComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        completedComparisonLabel.setForeground(new java.awt.Color(48, 49, 50));
        completedComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        completedComparisonLabel.setText("0");
        completedComparisonLabel.setIconTextGap(0);
        completedComparisonLabel.setMaximumSize(new java.awt.Dimension(24, 24));
        completedComparisonLabel.setMinimumSize(new java.awt.Dimension(24, 24));
        completedComparisonLabel.setPreferredSize(new java.awt.Dimension(24, 24));

        completedArrowLabel.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        completedArrowLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/line-24.png"))); // NOI18N
        completedArrowLabel.setIconTextGap(0);
        completedArrowLabel.setMaximumSize(new java.awt.Dimension(24, 20));
        completedArrowLabel.setMinimumSize(new java.awt.Dimension(24, 20));
        completedArrowLabel.setPreferredSize(new java.awt.Dimension(24, 20));

        javax.swing.GroupLayout completedPanelLayout = new javax.swing.GroupLayout(completedPanel);
        completedPanel.setLayout(completedPanelLayout);
        completedPanelLayout.setHorizontalGroup(
            completedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completedPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(completedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, completedPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(completedLabel))
                    .addGroup(completedPanelLayout.createSequentialGroup()
                        .addComponent(completedValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(completedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(completedComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(completedArrowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        completedPanelLayout.setVerticalGroup(
            completedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completedPanelLayout.createSequentialGroup()
                .addComponent(completedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(completedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(completedValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(completedPanelLayout.createSequentialGroup()
                        .addComponent(completedComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(completedArrowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(completedPanel, gridBagConstraints);

        appPanel.setBackground(new java.awt.Color(100, 214, 16));
        appPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 4, 4, 4, new java.awt.Color(60, 63, 65)));
        appPanel.setMaximumSize(new java.awt.Dimension(120, 110));
        appPanel.setMinimumSize(new java.awt.Dimension(110, 100));
        appPanel.setPreferredSize(new java.awt.Dimension(110, 100));

        appLabel.setForeground(new java.awt.Color(252, 254, 252));
        appLabel.setText("asPerPlanned");

        appValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        appValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        appValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appValueLabel.setText("100");
        appValueLabel.setIconTextGap(0);
        appValueLabel.setMaximumSize(new java.awt.Dimension(95, 67));
        appValueLabel.setPreferredSize(new java.awt.Dimension(88, 67));

        appComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        appComparisonLabel.setForeground(new java.awt.Color(48, 49, 50));
        appComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appComparisonLabel.setText("1");
        appComparisonLabel.setIconTextGap(0);
        appComparisonLabel.setMaximumSize(new java.awt.Dimension(24, 24));
        appComparisonLabel.setMinimumSize(new java.awt.Dimension(24, 24));
        appComparisonLabel.setPreferredSize(new java.awt.Dimension(24, 24));

        appArrowIcon.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        appArrowIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowUp-24.png"))); // NOI18N
        appArrowIcon.setIconTextGap(0);

        javax.swing.GroupLayout appPanelLayout = new javax.swing.GroupLayout(appPanel);
        appPanel.setLayout(appPanelLayout);
        appPanelLayout.setHorizontalGroup(
            appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(appLabel))
                    .addGroup(appPanelLayout.createSequentialGroup()
                        .addComponent(appValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(appArrowIcon))))
                .addContainerGap())
        );
        appPanelLayout.setVerticalGroup(
            appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appPanelLayout.createSequentialGroup()
                .addComponent(appLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(appPanelLayout.createSequentialGroup()
                        .addComponent(appComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(appArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(appPanel, gridBagConstraints);

        overduePanel.setBackground(new java.awt.Color(254, 67, 68));
        overduePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 4, new java.awt.Color(60, 63, 65)));
        overduePanel.setMaximumSize(new java.awt.Dimension(120, 110));
        overduePanel.setMinimumSize(new java.awt.Dimension(110, 100));
        overduePanel.setPreferredSize(new java.awt.Dimension(110, 100));

        overdueLabel.setForeground(new java.awt.Color(252, 254, 252));
        overdueLabel.setText("overdue");

        overdueValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        overdueValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        overdueValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        overdueValueLabel.setText("100");
        overdueValueLabel.setIconTextGap(0);
        overdueValueLabel.setMaximumSize(new java.awt.Dimension(95, 67));
        overdueValueLabel.setPreferredSize(new java.awt.Dimension(88, 67));

        overdueComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        overdueComparisonLabel.setForeground(new java.awt.Color(48, 49, 50));
        overdueComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        overdueComparisonLabel.setText("5");
        overdueComparisonLabel.setIconTextGap(0);
        overdueComparisonLabel.setMaximumSize(new java.awt.Dimension(24, 24));
        overdueComparisonLabel.setMinimumSize(new java.awt.Dimension(24, 24));
        overdueComparisonLabel.setPreferredSize(new java.awt.Dimension(24, 24));

        overdueArrowIcon.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        overdueArrowIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowDown-24.png"))); // NOI18N
        overdueArrowIcon.setIconTextGap(0);

        javax.swing.GroupLayout overduePanelLayout = new javax.swing.GroupLayout(overduePanel);
        overduePanel.setLayout(overduePanelLayout);
        overduePanelLayout.setHorizontalGroup(
            overduePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overduePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(overduePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, overduePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(overdueLabel))
                    .addGroup(overduePanelLayout.createSequentialGroup()
                        .addComponent(overdueValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(overduePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(overdueComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(overdueArrowIcon))))
                .addContainerGap())
        );
        overduePanelLayout.setVerticalGroup(
            overduePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overduePanelLayout.createSequentialGroup()
                .addComponent(overdueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(overduePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(overdueValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(overduePanelLayout.createSequentialGroup()
                        .addComponent(overdueComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(overdueArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(overduePanel, gridBagConstraints);

        nearDueDatePanel.setBackground(new java.awt.Color(240, 119, 70));
        nearDueDatePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 4, 4, 2, new java.awt.Color(60, 63, 65)));
        nearDueDatePanel.setMaximumSize(new java.awt.Dimension(120, 110));
        nearDueDatePanel.setMinimumSize(new java.awt.Dimension(110, 100));
        nearDueDatePanel.setPreferredSize(new java.awt.Dimension(110, 100));

        nearDueDateLabel.setForeground(new java.awt.Color(252, 254, 252));
        nearDueDateLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nearDueDateLabel.setText("nearDueDate");

        nearDueDateValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        nearDueDateValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        nearDueDateValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nearDueDateValueLabel.setText("100");
        nearDueDateValueLabel.setMaximumSize(new java.awt.Dimension(95, 67));
        nearDueDateValueLabel.setPreferredSize(new java.awt.Dimension(88, 67));

        nearDueDateArrowIcon.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        nearDueDateArrowIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowDown-24.png"))); // NOI18N
        nearDueDateArrowIcon.setIconTextGap(0);

        nearDueDateComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nearDueDateComparisonLabel.setForeground(new java.awt.Color(48, 49, 50));
        nearDueDateComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nearDueDateComparisonLabel.setText("4");
        nearDueDateComparisonLabel.setIconTextGap(0);
        nearDueDateComparisonLabel.setMaximumSize(new java.awt.Dimension(24, 24));
        nearDueDateComparisonLabel.setMinimumSize(new java.awt.Dimension(24, 24));
        nearDueDateComparisonLabel.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout nearDueDatePanelLayout = new javax.swing.GroupLayout(nearDueDatePanel);
        nearDueDatePanel.setLayout(nearDueDatePanelLayout);
        nearDueDatePanelLayout.setHorizontalGroup(
            nearDueDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nearDueDatePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(nearDueDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nearDueDatePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nearDueDateLabel))
                    .addGroup(nearDueDatePanelLayout.createSequentialGroup()
                        .addComponent(nearDueDateValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nearDueDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nearDueDateArrowIcon, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nearDueDateComparisonLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        nearDueDatePanelLayout.setVerticalGroup(
            nearDueDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nearDueDatePanelLayout.createSequentialGroup()
                .addComponent(nearDueDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nearDueDatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nearDueDatePanelLayout.createSequentialGroup()
                        .addComponent(nearDueDateValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(nearDueDatePanelLayout.createSequentialGroup()
                        .addComponent(nearDueDateComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(nearDueDateArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(nearDueDatePanel, gridBagConstraints);

        inProcessPanel.setBackground(new java.awt.Color(152, 118, 170));
        inProcessPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 2, 2, new java.awt.Color(60, 63, 65)));
        inProcessPanel.setMaximumSize(new java.awt.Dimension(120, 110));
        inProcessPanel.setMinimumSize(new java.awt.Dimension(110, 100));
        inProcessPanel.setPreferredSize(new java.awt.Dimension(110, 100));

        inProcessLabel.setForeground(new java.awt.Color(252, 254, 252));
        inProcessLabel.setText("inProcess");

        inProcessValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        inProcessValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        inProcessValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inProcessValueLabel.setText("100");
        inProcessValueLabel.setIconTextGap(0);
        inProcessValueLabel.setMaximumSize(new java.awt.Dimension(95, 67));
        inProcessValueLabel.setPreferredSize(new java.awt.Dimension(88, 67));

        inProcessComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        inProcessComparisonLabel.setForeground(new java.awt.Color(48, 49, 50));
        inProcessComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inProcessComparisonLabel.setText("1");
        inProcessComparisonLabel.setIconTextGap(0);
        inProcessComparisonLabel.setMaximumSize(new java.awt.Dimension(24, 24));
        inProcessComparisonLabel.setMinimumSize(new java.awt.Dimension(24, 24));
        inProcessComparisonLabel.setPreferredSize(new java.awt.Dimension(24, 24));

        inProcessArrowIcon.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        inProcessArrowIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowDown-24.png"))); // NOI18N
        inProcessArrowIcon.setIconTextGap(0);

        javax.swing.GroupLayout inProcessPanelLayout = new javax.swing.GroupLayout(inProcessPanel);
        inProcessPanel.setLayout(inProcessPanelLayout);
        inProcessPanelLayout.setHorizontalGroup(
            inProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inProcessPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inProcessPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inProcessLabel))
                    .addGroup(inProcessPanelLayout.createSequentialGroup()
                        .addComponent(inProcessValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(inProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inProcessComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inProcessArrowIcon))))
                .addContainerGap())
        );
        inProcessPanelLayout.setVerticalGroup(
            inProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inProcessPanelLayout.createSequentialGroup()
                .addComponent(inProcessLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inProcessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inProcessValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inProcessPanelLayout.createSequentialGroup()
                        .addComponent(inProcessComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(inProcessArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(inProcessPanel, gridBagConstraints);

        executionPanel.setBackground(new java.awt.Color(69, 73, 74));
        executionPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 8, 2, 0, new java.awt.Color(60, 63, 65)));
        executionPanel.setMaximumSize(new java.awt.Dimension(32767, 220));
        executionPanel.setPreferredSize(new java.awt.Dimension(200, 200));

        executionLabel.setForeground(new java.awt.Color(252, 254, 252));
        executionLabel.setText("execution");

        executionValueLabel.setFont(new java.awt.Font("Dialog", 1, 55)); // NOI18N
        executionValueLabel.setForeground(new java.awt.Color(100, 214, 16));
        executionValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        executionValueLabel.setText("100%");
        executionValueLabel.setMaximumSize(new java.awt.Dimension(165, 162));
        executionValueLabel.setPreferredSize(new java.awt.Dimension(157, 162));

        excutionComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        excutionComparisonLabel.setForeground(new java.awt.Color(252, 254, 252));
        excutionComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        excutionComparisonLabel.setText("2");
        excutionComparisonLabel.setIconTextGap(0);
        excutionComparisonLabel.setMaximumSize(new java.awt.Dimension(32, 32));
        excutionComparisonLabel.setMinimumSize(new java.awt.Dimension(32, 32));
        excutionComparisonLabel.setPreferredSize(new java.awt.Dimension(32, 32));

        executionArrowIcon.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        executionArrowIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowUpWhite-32.png"))); // NOI18N
        executionArrowIcon.setIconTextGap(0);
        executionArrowIcon.setMaximumSize(new java.awt.Dimension(32, 32));
        executionArrowIcon.setMinimumSize(new java.awt.Dimension(32, 32));
        executionArrowIcon.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout executionPanelLayout = new javax.swing.GroupLayout(executionPanel);
        executionPanel.setLayout(executionPanelLayout);
        executionPanelLayout.setHorizontalGroup(
            executionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, executionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(executionLabel)
                .addContainerGap())
            .addGroup(executionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(executionValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(executionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(excutionComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(executionArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        executionPanelLayout.setVerticalGroup(
            executionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(executionPanelLayout.createSequentialGroup()
                .addComponent(executionLabel)
                .addGroup(executionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(executionPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(executionValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(executionPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(excutionComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(executionArrowIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(executionPanel, gridBagConstraints);

        perfomancePanel.setBackground(new java.awt.Color(254, 67, 68));
        perfomancePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 8, 2, 0, new java.awt.Color(60, 63, 65)));
        perfomancePanel.setMaximumSize(new java.awt.Dimension(32767, 220));
        perfomancePanel.setMinimumSize(new java.awt.Dimension(0, 200));
        perfomancePanel.setPreferredSize(new java.awt.Dimension(200, 200));

        performanceLabel.setForeground(new java.awt.Color(252, 254, 252));
        performanceLabel.setText("performance");

        performanceValueLabel.setFont(new java.awt.Font("Dialog", 1, 55)); // NOI18N
        performanceValueLabel.setForeground(new java.awt.Color(252, 254, 252));
        performanceValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        performanceValueLabel.setText("100%");
        performanceValueLabel.setMaximumSize(new java.awt.Dimension(165, 162));
        performanceValueLabel.setPreferredSize(new java.awt.Dimension(157, 162));

        performanceArrowIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrowDownWhite-32.png"))); // NOI18N
        performanceArrowIcon.setIconTextGap(0);

        performanceComparisonLabel.setFont(new java.awt.Font("Dialog", 1, 32)); // NOI18N
        performanceComparisonLabel.setForeground(new java.awt.Color(252, 254, 252));
        performanceComparisonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        performanceComparisonLabel.setText("2");
        performanceComparisonLabel.setMaximumSize(new java.awt.Dimension(32, 32));
        performanceComparisonLabel.setMinimumSize(new java.awt.Dimension(32, 32));
        performanceComparisonLabel.setPreferredSize(new java.awt.Dimension(32, 32));

        javax.swing.GroupLayout perfomancePanelLayout = new javax.swing.GroupLayout(perfomancePanel);
        perfomancePanel.setLayout(perfomancePanelLayout);
        perfomancePanelLayout.setHorizontalGroup(
            perfomancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(perfomancePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(perfomancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, perfomancePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(performanceLabel))
                    .addGroup(perfomancePanelLayout.createSequentialGroup()
                        .addComponent(performanceValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(perfomancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(performanceComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(performanceArrowIcon))
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        perfomancePanelLayout.setVerticalGroup(
            perfomancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(perfomancePanelLayout.createSequentialGroup()
                .addComponent(performanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(perfomancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(performanceValueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(perfomancePanelLayout.createSequentialGroup()
                        .addComponent(performanceComparisonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(performanceArrowIcon)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        summaryPanel.add(perfomancePanel, gridBagConstraints);

        dashboardPanel.add(summaryPanel);

        overdueListPanel.setMaximumSize(new java.awt.Dimension(32767, 135));
        overdueListPanel.setMinimumSize(new java.awt.Dimension(0, 100));
        overdueListPanel.setName(""); // NOI18N
        overdueListPanel.setPreferredSize(new java.awt.Dimension(864, 135));
        overdueListPanel.setBackground(Color.decode(ColorsDarcula.BLACK.code));

        overdueListScrollPane.getViewport().setBackground(
                Color.decode(ColorsDarcula.BLACK.code));
        overdueListScrollPane.setBorder(BorderFactory.createMatteBorder(0,1,1,1, 
                Color.decode(ColorsDarcula.BLACK_DARK.code)));
        overdueListTable.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        overdueListTable.getTableHeader().setBackground(Color.decode("#3F4044"));
        overdueListTable.getTableHeader().setForeground(Color.decode("#E3E3E3"));
        overdueListTable.getTableHeader().setBorder(BorderFactory
                .createMatteBorder(1,1,1,1, Color.decode("#303132")));
        overdueListTable.setModel(new javax.swing.table.DefaultTableModel(null,
            new String [] {
                "ID", "StartDate", "DueDate", "Detail", "Comments", "Prog. %", "DueDays"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        overdueListScrollPane.setViewportView(overdueListTable);
        if (overdueListTable.getColumnModel().getColumnCount() > 0) {
            overdueListTable.getColumnModel().getColumn(0).setMinWidth(76);
            overdueListTable.getColumnModel().getColumn(0).setPreferredWidth(76);
            overdueListTable.getColumnModel().getColumn(0).setMaxWidth(76);
            overdueListTable.getColumnModel().getColumn(1).setMinWidth(70);
            overdueListTable.getColumnModel().getColumn(1).setPreferredWidth(73);
            overdueListTable.getColumnModel().getColumn(1).setMaxWidth(73);
            overdueListTable.getColumnModel().getColumn(2).setMinWidth(70);
            overdueListTable.getColumnModel().getColumn(2).setPreferredWidth(73);
            overdueListTable.getColumnModel().getColumn(2).setMaxWidth(73);
            overdueListTable.getColumnModel().getColumn(5).setMinWidth(45);
            overdueListTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            overdueListTable.getColumnModel().getColumn(5).setMaxWidth(50);
            overdueListTable.getColumnModel().getColumn(6).setMinWidth(35);
            overdueListTable.getColumnModel().getColumn(6).setPreferredWidth(55);
            overdueListTable.getColumnModel().getColumn(6).setMaxWidth(55);
        }

        overdueListLabel.setText("Overdue Actions List");
        overdueListLabel.setForeground(Color.decode(ColorsHolcim.WHITE.code));
        overdueListLabel.setMaximumSize(new java.awt.Dimension(118, 30));
        overdueListLabel.setMinimumSize(new java.awt.Dimension(118, 30));
        overdueListLabel.setPreferredSize(new java.awt.Dimension(118, 30));

        overdueCloseButton.setText("Close Action");
        overdueCloseButton.setIconTextGap(0);
        overdueCloseButton.setMaximumSize(new java.awt.Dimension(105, 30));
        overdueCloseButton.setMinimumSize(new java.awt.Dimension(105, 30));
        overdueCloseButton.setPreferredSize(new java.awt.Dimension(105, 30));
        overdueCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        overdueEditIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editWhite24.png"))); // NOI18N
        overdueEditIcon.setIconTextGap(0);
        overdueEditIcon.setMaximumSize(new java.awt.Dimension(24, 30));
        overdueEditIcon.setMinimumSize(new java.awt.Dimension(24, 30));
        overdueEditIcon.setPreferredSize(new java.awt.Dimension(24, 30));

        javax.swing.GroupLayout overdueListPanelLayout = new javax.swing.GroupLayout(overdueListPanel);
        overdueListPanel.setLayout(overdueListPanelLayout);
        overdueListPanelLayout.setHorizontalGroup(
            overdueListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueListPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(overdueListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(overdueListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                    .addGroup(overdueListPanelLayout.createSequentialGroup()
                        .addComponent(overdueListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(overdueEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(overdueCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        overdueListPanelLayout.setVerticalGroup(
            overdueListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueListPanelLayout.createSequentialGroup()
                .addGroup(overdueListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(overdueListPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(overdueListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(overdueListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(overdueListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(overdueCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(overdueEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overdueListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        dashboardPanel.add(overdueListPanel);

        nearDueDateListPanel.setMinimumSize(new java.awt.Dimension(0, 120));
        nearDueDateListPanel.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        
        nearDueDateListScrollPane.getViewport().setBackground(
                Color.decode(ColorsDarcula.BLACK.code));
        nearDueDateListScrollPane.setBorder(BorderFactory.createMatteBorder(0,1,1,1, 
                Color.decode(ColorsDarcula.BLACK_DARK.code)));
        nearDueDateListTable.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        nearDueDateListTable.getTableHeader().setBackground(Color.decode("#3F4044"));
        nearDueDateListTable.getTableHeader().setForeground(Color.decode("#E3E3E3"));
        nearDueDateListTable.getTableHeader().setBorder(BorderFactory
                .createMatteBorder(1,1,1,1, Color.decode("#303132")));
        nearDueDateListTable.setModel(new javax.swing.table.DefaultTableModel(null,
            new String [] {
                "ID", "StartDate", "DueDate", "Detail", "Comments", "Prog. %", "Days"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nearDueDateListTable.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        nearDueDateListScrollPane.setViewportView(nearDueDateListTable);
        if (nearDueDateListTable.getColumnModel().getColumnCount() > 0) {
            nearDueDateListTable.getColumnModel().getColumn(0).setMinWidth(76);
            nearDueDateListTable.getColumnModel().getColumn(0).setPreferredWidth(76);
            nearDueDateListTable.getColumnModel().getColumn(0).setMaxWidth(76);
            nearDueDateListTable.getColumnModel().getColumn(1).setMinWidth(70);
            nearDueDateListTable.getColumnModel().getColumn(1).setPreferredWidth(73);
            nearDueDateListTable.getColumnModel().getColumn(1).setMaxWidth(73);
            nearDueDateListTable.getColumnModel().getColumn(2).setMinWidth(70);
            nearDueDateListTable.getColumnModel().getColumn(2).setPreferredWidth(73);
            nearDueDateListTable.getColumnModel().getColumn(2).setMaxWidth(73);
            nearDueDateListTable.getColumnModel().getColumn(5).setMinWidth(45);
            nearDueDateListTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            nearDueDateListTable.getColumnModel().getColumn(5).setMaxWidth(50);
            nearDueDateListTable.getColumnModel().getColumn(6).setMinWidth(35);
            nearDueDateListTable.getColumnModel().getColumn(6).setPreferredWidth(60);
            nearDueDateListTable.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        nearDueDateListLabel.setText("Near Due Date Actions List");
        nearDueDateListLabel.setForeground(Color.decode(ColorsHolcim.WHITE.code));
        nearDueDateListLabel.setMaximumSize(new java.awt.Dimension(118, 30));
        nearDueDateListLabel.setMinimumSize(new java.awt.Dimension(118, 30));
        nearDueDateListLabel.setPreferredSize(new java.awt.Dimension(118, 30));

        nearDueDateCloseButton.setText("Close Action");
        nearDueDateCloseButton.setIconTextGap(0);
        nearDueDateCloseButton.setMaximumSize(new java.awt.Dimension(105, 30));
        nearDueDateCloseButton.setMinimumSize(new java.awt.Dimension(105, 30));
        nearDueDateCloseButton.setPreferredSize(new java.awt.Dimension(105, 30));

        nearDueDateEditIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editWhite24.png"))); // NOI18N
        nearDueDateEditIcon.setIconTextGap(0);
        nearDueDateEditIcon.setMaximumSize(new java.awt.Dimension(24, 30));
        nearDueDateEditIcon.setMinimumSize(new java.awt.Dimension(24, 30));
        nearDueDateEditIcon.setPreferredSize(new java.awt.Dimension(24, 30));

        javax.swing.GroupLayout nearDueDateListPanelLayout = new javax.swing.GroupLayout(nearDueDateListPanel);
        nearDueDateListPanel.setLayout(nearDueDateListPanelLayout);
        nearDueDateListPanelLayout.setHorizontalGroup(
            nearDueDateListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nearDueDateListPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(nearDueDateListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nearDueDateListPanelLayout.createSequentialGroup()
                        .addComponent(nearDueDateListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nearDueDateEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nearDueDateCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nearDueDateListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        nearDueDateListPanelLayout.setVerticalGroup(
            nearDueDateListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nearDueDateListPanelLayout.createSequentialGroup()
                .addGroup(nearDueDateListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nearDueDateListPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(nearDueDateListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nearDueDateListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(nearDueDateListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nearDueDateCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nearDueDateEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nearDueDateListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        dashboardPanel.add(nearDueDateListPanel);

        inProcessListPanel.setMaximumSize(new java.awt.Dimension(32767, 140));
        inProcessListPanel.setMinimumSize(new java.awt.Dimension(0, 120));
        inProcessListPanel.setPreferredSize(new java.awt.Dimension(864, 135));
        inProcessListPanel.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        
        inProcessListLabel.setText("In Process Action List");
        inProcessListLabel.setForeground(Color.decode(ColorsHolcim.WHITE.code));
        inProcessListLabel.setMaximumSize(new java.awt.Dimension(124, 30));
        inProcessListLabel.setMinimumSize(new java.awt.Dimension(124, 30));
        inProcessListLabel.setPreferredSize(new java.awt.Dimension(124, 30));
        
        inProcessListScrollPane.getViewport().setBackground(
                Color.decode(ColorsDarcula.BLACK.code));
        inProcessListScrollPane.setBorder(BorderFactory.createMatteBorder(0,1,1,1, 
                Color.decode(ColorsDarcula.BLACK_DARK.code)));
        inProcessListTable.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        inProcessListTable.getTableHeader().setBackground(Color.decode("#3F4044"));
        inProcessListTable.getTableHeader().setForeground(Color.decode("#E3E3E3"));
        inProcessListTable.getTableHeader().setBorder(BorderFactory
                .createMatteBorder(1,1,1,1, Color.decode("#303132")));
        inProcessListTable.setModel(new javax.swing.table.DefaultTableModel(null,
            new String [] {
                "ID", "StartDate", "DueDate", "Detail", "Comments", "Prog. %", "Dur."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inProcessListTable.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        inProcessListScrollPane.setViewportView(inProcessListTable);
        if (inProcessListTable.getColumnModel().getColumnCount() > 0) {
            inProcessListTable.getColumnModel().getColumn(0).setMinWidth(76);
            inProcessListTable.getColumnModel().getColumn(0).setPreferredWidth(76);
            inProcessListTable.getColumnModel().getColumn(0).setMaxWidth(76);
            inProcessListTable.getColumnModel().getColumn(1).setMinWidth(70);
            inProcessListTable.getColumnModel().getColumn(1).setPreferredWidth(73);
            inProcessListTable.getColumnModel().getColumn(1).setMaxWidth(73);
            inProcessListTable.getColumnModel().getColumn(2).setMinWidth(70);
            inProcessListTable.getColumnModel().getColumn(2).setPreferredWidth(73);
            inProcessListTable.getColumnModel().getColumn(2).setMaxWidth(73);
            inProcessListTable.getColumnModel().getColumn(5).setMinWidth(45);
            inProcessListTable.getColumnModel().getColumn(5).setPreferredWidth(50);
            inProcessListTable.getColumnModel().getColumn(5).setMaxWidth(50);
            inProcessListTable.getColumnModel().getColumn(6).setMinWidth(35);
            inProcessListTable.getColumnModel().getColumn(6).setPreferredWidth(60);
            inProcessListTable.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        inProcessCloseButton.setIconTextGap(0);
        inProcessCloseButton.setText("Close Action");
        inProcessCloseButton.setMaximumSize(new java.awt.Dimension(105, 30));
        inProcessCloseButton.setMinimumSize(new java.awt.Dimension(105, 30));
        inProcessCloseButton.setPreferredSize(new java.awt.Dimension(105, 30));

        inProcessEditIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editWhite24.png"))); // NOI18N
        inProcessEditIcon.setIconTextGap(0);
        inProcessEditIcon.setMaximumSize(new java.awt.Dimension(24, 30));
        inProcessEditIcon.setMinimumSize(new java.awt.Dimension(24, 30));
        inProcessEditIcon.setPreferredSize(new java.awt.Dimension(24, 30));

        javax.swing.GroupLayout inProcessListPanelLayout = new javax.swing.GroupLayout(inProcessListPanel);
        inProcessListPanel.setLayout(inProcessListPanelLayout);
        inProcessListPanelLayout.setHorizontalGroup(
            inProcessListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inProcessListPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(inProcessListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inProcessListPanelLayout.createSequentialGroup()
                        .addComponent(inProcessListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inProcessEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inProcessCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inProcessListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        inProcessListPanelLayout.setVerticalGroup(
            inProcessListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inProcessListPanelLayout.createSequentialGroup()
                .addGroup(inProcessListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inProcessListPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(inProcessListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inProcessListPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(inProcessListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inProcessCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inProcessEditIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inProcessListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        dashboardPanel.add(inProcessListPanel);

        this.add(dashboardPanel, java.awt.BorderLayout.CENTER);
        this.setVisible(true);
        
    }
}
