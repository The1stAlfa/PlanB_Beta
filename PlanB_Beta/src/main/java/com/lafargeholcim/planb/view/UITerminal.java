/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.<a href="
 * https://icons8.com/web-app/98/Plus-Math">Plus math icon credits</a>
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
import com.lafargeholcim.planb.util.Time;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * @palette
 * PALETTE
 * +----------------------------------+------------------------------ -+----------------------------------+------------------------------------+----------------------------------------+
 * |         COLORS         | HEX.CODE|          ANALOG COLORS         |         COMPLEMENTARY COLORS     |         MONOCROMATIC COLORS        |             COMPOUND COLORS            |
 * +----------------------------------+--------------------------------+----------------------------------+------------------------------------+----------------------------------------+
 * |------------------------|---------|--------------------------------|----------------------------------|------------------------------------|----------------------------------------|
 * | BACKGROUND BLACK       | #303132 |
 * | ABSOLUTE WHITE         | #FFFFFF |                                |                                  |                                    |                                        |
 * | ABSOLUTE BLACK         | #000000 |                                |                                  |                                    |                                        |
 * | HOLCIM WHITE           | #FCFEFC |R#FF0000 ORA#E8AE0C             |GR#00FF00-19FF19 MAG#FF007F-B20059|GRA#CACCCA W#FDFFFD GR#587F58-B0FFB0|GR#5A995A GRE#B9B5CC W#FEFFFC PUI#DABCFF|
 * | HOLCIM RED             | #FC4344 |R#FF0D0D-#E80C0C R#FF4949       |GR#00FF47-00B232 R#FF0001         |BR#7F4848 PI#FF9091 R#FF4445-CC3637 |BR#995A5A W#FFFCFF YEL#EBFFBC OC#CCCCB5 | 
 * | HOLCIM BLACK           | #232323 |R#FF0000                        |                                  |W#CCCCCC-FFFFFF BR#7F5959 PI#FFB2B2 |                                        |
 * | HOLCIM GRAY            | #9B9B9B |R#FF0D0D                        |                                  |                                    |                                        |
 * | HOLCIM SECOND RED      | #E83434 |                                |                                  |                                    |                                        |
 * | HOLCIM BROWN           | #692628 |R#FF0F0D-#E80C0F                |                                  |                                    |                                        |
 * | HOLCIM GRAY REFLECTIVE | #D1D3D1 |YEL#E8AE0C BLU#160CE8 GR#0DFF96 |GR#00FF00 MAG#FF007F-B20059       |PI#FFA9AB R#FF5C61-CC4A4E BR#7F5456 |GR#5A995A PU#DABCFF-B9B5CC              |
 * | HOLCIM DARK GRAY       | #4C4B4C |ORA#FF530D ORA#E82C0C MAG#E80C7A|MAG#FF00FF GR#3EB200-59FF00       |PU#7F587F-FFAFFF W#FFFCFF-CCC9CC    |PU#995A99 0C#CCC7B5                     |
 * | HOLCIM SECOND BROWN    | #453D3F |R#FF1E0D                        |R#FF0040-FF1953 GR#00FF24-00B219  |                                    |R#995A6A OC#FEFFBC-CCCB5 W#FFFCFF       |
 * +----------------------------------+--------------------------------+----------------------------------+------------------------------------+----------------------------------------+
 */

/**
 *
 * @author LoboAlfa2.0
 */

public class UITerminal extends JFrame{
    private Dimension nativeScreenSize;
    private int xPosition=0, yPosition=0, selectedRow=-1;
    private JMenuBar mainMenu;
    private JMenuItem dashboardMenu, meetingMenu, actionPlanMenu, teamMenu,
            profileMenu,settingsMenu,menuItem,itemFlag;
    private JPanel contentPanel, highlightPanel, titleBarPanel, optionsContentPanel,
            frameButtonsPanel, mainPanel;
    private JPanel dashboardPanel, actionPlanPanel, meetingPanel;
    private JLabel apsLogoLabel, resizeLabel, minimizeLabel, closeLabel;
    private JLabel initImageLabel;
    private String meetingName; 
    private JPanel gapPanel1,gapPanel2,pagePanel;
    private JTable actionListTable; 
    private JPanel h1,h2,h3,h4,h5,h6,h7;
    private boolean menuFlag = false, resizeFlag = false, clickFlag = false;
    private JLabel actionLabel, actionValueLabel, actionsLabel, addIcon, 
            appLabel, appValueLabel, completedLabel, completedValueLabel, 
            content2Label, date2Label, dateLabel, dateValueLabel, deleteIcon, 
            dotMenuLabel, editIcon, executionLabel, executionValueLabel, 
            filterLabel, firstNameLabel, meetingLabel, overdueLabel, 
            overdueValueLabel, owner2Label, ownerLabel, participantsLabel, 
            performanceLabel, performanceValueLabel, planLabel, surnameLabel, status2Label, 
            title1Label, title2Label;
    private JPanel actionListPanel,apInformationPanel, apPanel, appActionPanel,
            buttonsPanel, completedActionPanel, datePanel, filterLabelPanel, meetingNamePanel, 
            overdueActionPanel, ownerNamePanel, participantsPanel, 
            planExecutionPanel, statusPanel, teamPerformancePanel, totalActionsPanel;
    private JRadioButton contentRadioButton, dateRadioButton, ownerRadioButton, statusRadioButton;
    private JComboBox<String> dateComboBox, statusComboBox;
    private JTextField endLabel, hintTextField, owner2TextField, startLabel;
    private JPopupMenu meetingPopupMenu;
    private JTextArea participantsTextArea;
    private JScrollPane alTableScrollPane, participantsScrollPane;
    private ActionItemFilter globalFilter;
    private ArrayList<Object> filterValues;

       
    public UITerminal() throws IOException, FontFormatException, Exception{
        initComponents(); 
    }
    
    public void addFonts() throws FontFormatException{
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src\\fonts\\diane_de_france\\Diane de France.ttf")));
        }
        catch (IOException e) {
            //Handle exception
            System.out.println("NO CARGAN LAS FUENTES");
        }
    }
    
    public void addRowToTableContent(Object[] row){
        DefaultTableModel dm = (DefaultTableModel) actionListTable.getModel();
        dm.addRow(row);
        actionListTable.setModel(dm);
        actionListTable.repaint();
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
                    if(column == 8){
                        if(value.toString().equalsIgnoreCase("OVERDUE")){
                            c.setBackground(Color.decode("#E80C0C"));
                            c.setForeground(Color.decode("#FCFEFC"));
                        }
                        else if(value.toString().equalsIgnoreCase("COMPLETED_APP")){
                            c.setBackground(Color.decode("#64D610"));
                            c.setForeground(Color.decode("#FCFEFC"));                            
                        }
                        else if(value.toString().equalsIgnoreCase("COMPLETED")){
                            c.setBackground(Color.decode("#64D610"));
                            c.setForeground(Color.decode("#FCFEFC"));
                        }
                        else{
                            c.setBackground(row%2==0 ? Color.WHITE : Color.decode("#EDEDED"));
                            c.setForeground(Color.decode("#000000"));
                        }
                    }
                    else
                        c.setBackground(row%2==0 ? Color.WHITE : Color.decode("#EDEDED"));
                    return c;
                }
            });
        }
    }
    
    private void createActionPlanInformationPanel(){
        GridBagConstraints gridBagConstraints;
        
        meetingPopupMenu = new  JPopupMenu();       
        apInformationPanel = new JPanel();
        apPanel = new JPanel();
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
        startLabel = new JTextField();
        endLabel = new JTextField();
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
        
        meetingPopupMenu.setAutoscrolls(true);
        for(String name:Aps.getTerminal().getMeetingsNames())
            createMenuItem(name);

        apInformationPanel.setBackground(new Color(252, 254, 252));
        apInformationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        apInformationPanel.setMinimumSize(new java.awt.Dimension(950, 250));
        apInformationPanel.setPreferredSize(new java.awt.Dimension(700, 250));
        apInformationPanel.setLayout(new java.awt.GridBagLayout());
        
        apPanel.setBackground(new java.awt.Color(0, 66, 118));
        apPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 2, new java.awt.Color(252, 254, 252)));
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

        meetingNamePanel.setBackground(new java.awt.Color(48, 49, 50));
        meetingNamePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 2, new java.awt.Color(252, 254, 252)));
        meetingNamePanel.setMinimumSize(new java.awt.Dimension(242, 100));
        meetingNamePanel.setPreferredSize(new java.awt.Dimension(252, 100));

        meetingLabel.setBackground(new java.awt.Color(187, 187, 188));
        meetingLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        meetingLabel.setForeground(new java.awt.Color(252, 254, 252));
        meetingLabel.setText("meeting");

        title1Label.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        title1Label.setForeground(new java.awt.Color(252, 254, 252));
        title1Label.setText("Hola ");
        title1Label.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        title1Label.setIconTextGap(0);
        title1Label.setMaximumSize(new java.awt.Dimension(175, 34));
        title1Label.setMinimumSize(new java.awt.Dimension(0, 0));
        title1Label.setPreferredSize(new java.awt.Dimension(175, 34));

        title2Label.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        title2Label.setForeground(new java.awt.Color(252, 254, 252));
        title2Label.setText("tecnico tencdafoo");
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

        title2Label.getAccessibleContext().setAccessibleName("");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(meetingNamePanel, gridBagConstraints);

        ownerNamePanel.setBackground(new java.awt.Color(48, 49, 50));
        ownerNamePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 2, new java.awt.Color(252, 254, 252)));
        ownerNamePanel.setMinimumSize(new java.awt.Dimension(121, 100));
        ownerNamePanel.setPreferredSize(new java.awt.Dimension(126, 100));

        firstNameLabel.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(252, 254, 252));
        firstNameLabel.setText("SERGIO");
        firstNameLabel.setIconTextGap(0);
        firstNameLabel.setMaximumSize(new java.awt.Dimension(90, 23));
        firstNameLabel.setMinimumSize(new java.awt.Dimension(90, 23));
        firstNameLabel.setPreferredSize(new java.awt.Dimension(90, 23));

        surnameLabel.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(252, 254, 252));
        surnameLabel.setText("ORJUELA");
        surnameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        surnameLabel.setIconTextGap(0);
        surnameLabel.setMaximumSize(new java.awt.Dimension(90, 23));
        surnameLabel.setMinimumSize(new java.awt.Dimension(90, 23));
        surnameLabel.setPreferredSize(new java.awt.Dimension(90, 23));

        ownerLabel.setBackground(new java.awt.Color(187, 187, 188));
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

        firstNameLabel.getAccessibleContext().setAccessibleName("SERGIO");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(ownerNamePanel, gridBagConstraints);

        participantsPanel.setBackground(new java.awt.Color(48, 49, 50));
        participantsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 2, new java.awt.Color(252, 254, 252)));
        participantsPanel.setMinimumSize(new java.awt.Dimension(126, 100));
        participantsPanel.setPreferredSize(new java.awt.Dimension(126, 100));

        participantsLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        participantsLabel.setForeground(new java.awt.Color(252, 254, 252));
        participantsLabel.setText("participants");

        participantsScrollPane.setBackground(new java.awt.Color(48, 49, 50));
        participantsScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 0));
        participantsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        participantsScrollPane.setPreferredSize(new java.awt.Dimension(120, 48));

        participantsTextArea.setEditable(false);
        participantsTextArea.setBackground(new java.awt.Color(48, 49, 50));
        participantsTextArea.setColumns(16);
        participantsTextArea.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        participantsTextArea.setForeground(new java.awt.Color(252, 254, 252));
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

        totalActionsPanel.setBackground(new java.awt.Color(230, 231, 234));
        totalActionsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 2, new java.awt.Color(252, 254, 252)));
        totalActionsPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        totalActionsPanel.setPreferredSize(new java.awt.Dimension(100, 100));

        actionsLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        actionsLabel.setForeground(new java.awt.Color(48, 49, 50));
        actionsLabel.setText("actions");

        actionValueLabel.setFont(new java.awt.Font("Dialog", 1, 42)); // NOI18N
        actionValueLabel.setForeground(new java.awt.Color(122, 120, 123));
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
        completedActionPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 2, new java.awt.Color(252, 254, 252)));
        completedActionPanel.setForeground(new java.awt.Color(230, 231, 234));
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
        appActionPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 2, new java.awt.Color(252, 254, 252)));
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
        overdueActionPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 2, new java.awt.Color(252, 254, 252)));
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

        teamPerformancePanel.setBackground(new java.awt.Color(254, 67, 68));
        teamPerformancePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 2, new java.awt.Color(252, 254, 252)));
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

        planExecutionPanel.setBackground(new java.awt.Color(48, 49, 50));
        planExecutionPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 2, 4, new java.awt.Color(252, 254, 252)));
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

        datePanel.setBackground(new java.awt.Color(252, 254, 252));
        datePanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 4, 4, new java.awt.Color(252, 254, 252)));
        datePanel.setMinimumSize(new java.awt.Dimension(220, 100));
        datePanel.setPreferredSize(new java.awt.Dimension(220, 100));

        dateLabel.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(122, 120, 123));
        dateLabel.setText("date");

        dateValueLabel.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        dateValueLabel.setForeground(new java.awt.Color(120, 120, 123));
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
        filterLabelPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 2, new Color(252, 254, 252)));
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
                filterValues = new ArrayList();
                if(statusRadioButton.isSelected() && dateRadioButton.isSelected()
                        && ownerRadioButton.isSelected()){
                    String statusValue = statusComboBox.getSelectedItem().toString();;
                    if(statusValue.equalsIgnoreCase("ALL")){
                        filterValues.add(owner2TextField.getText());
                        filterValues.add(endLabel.getText());
                        filterValues.add(startLabel.getText());
                        if(dateComboBox.getSelectedIndex() == 1)
                            globalFilter = ActionItemFilter.S_DATE_OWNER;
                        else if(dateComboBox.getSelectedIndex() == 2)
                            globalFilter = ActionItemFilter.D_DATE_OWNER;
                        else if (dateComboBox.getSelectedIndex() == 3)
                            globalFilter = ActionItemFilter.E_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                    else if(statusComboBox.getSelectedIndex() != 0){
                        filterValues.add(Status.valueOf(statusValue));
                        filterValues.add(owner2TextField.getText());
                        filterValues.add(endLabel.getText());
                        filterValues.add(startLabel.getText());
                        if(dateComboBox.getSelectedIndex() == 1)
                            globalFilter = ActionItemFilter.STATUS_S_DATE_OWNER;
                        else if(dateComboBox.getSelectedIndex() == 2)
                            globalFilter = ActionItemFilter.STATUS_D_DATE_OWNER;
                        else if (dateComboBox.getSelectedIndex() == 3)
                            globalFilter = ActionItemFilter.STATUS_E_DATE_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                }
                else if(statusRadioButton.isSelected() && dateRadioButton.isSelected()){                    
                    String statusValue = statusComboBox.getSelectedItem().toString();
                    if(statusValue.equalsIgnoreCase("ALL")){
                        filterValues.add(endLabel.getText());
                        filterValues.add(startLabel.getText());
                        if(dateComboBox.getSelectedIndex() == 1)
                            globalFilter = ActionItemFilter.S_DATE;
                        else if(dateComboBox.getSelectedIndex() == 2)
                            globalFilter = ActionItemFilter.D_DATE;
                        else if (dateComboBox.getSelectedIndex() == 3)
                            globalFilter = ActionItemFilter.E_DATE;
                        updateJTable(globalFilter, filterValues);
                        
                    }
                    else if(statusComboBox.getSelectedIndex() != 0){
                        filterValues.add(Status.valueOf(statusValue));
                        filterValues.add(endLabel.getText());
                        filterValues.add(startLabel.getText());
                        if(dateComboBox.getSelectedIndex() == 1)
                            globalFilter = ActionItemFilter.STATUS_S_DATE;
                        else if(dateComboBox.getSelectedIndex() == 2)
                            globalFilter = ActionItemFilter.STATUS_D_DATE;
                        else if (dateComboBox.getSelectedIndex() == 3)
                            globalFilter = ActionItemFilter.STATUS_E_DATE;
                        updateJTable(globalFilter, filterValues);
                    }
                }
                else if(dateRadioButton.isSelected() && ownerRadioButton.isSelected()){
                    filterValues.add(owner2TextField.getText());
                    filterValues.add(endLabel.getText());
                    filterValues.add(startLabel.getText());
                    if(dateComboBox.getSelectedIndex() == 1)
                        globalFilter = ActionItemFilter.S_DATE_OWNER;
                    else if(dateComboBox.getSelectedIndex() == 2)
                        globalFilter = ActionItemFilter.D_DATE_OWNER;
                    else if (dateComboBox.getSelectedIndex() == 3)
                        globalFilter = ActionItemFilter.E_DATE_OWNER;
                    updateJTable(globalFilter, filterValues);
                }
                else if(statusRadioButton.isSelected() && ownerRadioButton.isSelected()){
                    String statusValue = statusComboBox.getSelectedItem().toString();
                    if(statusValue.equalsIgnoreCase("ALL")){
                        filterValues.add(owner2TextField.getText());
                        globalFilter = ActionItemFilter.OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                    else{
                        filterValues.add(Status.valueOf(statusValue));
                        filterValues.add(owner2TextField.getText());
                        globalFilter = ActionItemFilter.STATUS_OWNER;
                        updateJTable(globalFilter, filterValues);
                    }
                }
                else if(statusRadioButton.isSelected()){
                    String statusValue = statusComboBox.getSelectedItem().toString();
                    if(statusValue.equalsIgnoreCase("ALL")){
                        globalFilter = ActionItemFilter.ALL;
                        updateJTable(globalFilter, null);
                    }
                    else if(statusComboBox.getSelectedIndex() != 0){
                        globalFilter = ActionItemFilter.STATUS;
                        filterValues.add(Status.valueOf(statusValue));
                        Status.valueOf(statusComboBox.getSelectedItem().toString());
                        updateJTable(globalFilter, filterValues);
                    }
                }
                else if(dateRadioButton.isSelected()){
                    filterValues.add(endLabel.getText());
                    filterValues.add(startLabel.getText());
                    if(dateComboBox.getSelectedIndex() == 1)
                        globalFilter = ActionItemFilter.S_DATE;
                    else if(dateComboBox.getSelectedIndex() == 2)
                        globalFilter = ActionItemFilter.D_DATE;
                    else if (dateComboBox.getSelectedIndex() == 3)
                        globalFilter = ActionItemFilter.E_DATE;

                    updateJTable(globalFilter, filterValues);
                }
                else if(ownerRadioButton.isSelected()){
                    globalFilter = ActionItemFilter.OWNER;
                    filterValues.add(owner2TextField.getText());
                    updateJTable(globalFilter, filterValues);
                }
                else{
                    globalFilter = ActionItemFilter.CONTENT; 
                    filterValues.add(hintTextField.getText());
                    updateJTable(globalFilter, filterValues);
                }
                if(actionListTable.getRowCount() == 0){
                    JOptionPane.showMessageDialog(new JOptionPane(),
                        "There's not action with the specified criteria",
                        "Information",JOptionPane.INFORMATION_MESSAGE);
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

        statusPanel.setBackground(new Color(0, 66, 118));
        statusPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 4, 0, new Color(252, 254, 252)));
        statusPanel.setMaximumSize(new Dimension(32767, 50));
        statusPanel.setMinimumSize(new Dimension(710, 50));
        statusPanel.setPreferredSize(new Dimension(710, 50));

        statusRadioButton.setBackground(new Color(0, 66, 118));
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
            "IN_PROCESS", "COMPLETED_APP", "NEAR_TO_DUE_DATE", "WAITING_TO_START" }));
        statusComboBox.setBorder(null);
        statusComboBox.setMaximumSize(new java.awt.Dimension(149, 29));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });

        status2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        status2Label.setForeground(new java.awt.Color(252, 254, 252));
        status2Label.setText("status");

        dateRadioButton.setBackground(new Color(0, 66, 118));
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

        startLabel.setBackground(new java.awt.Color(252, 254, 252));
        startLabel.setText("start");
        startLabel.setForeground(new Color(230, 231, 234));
        startLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        startLabel.setMinimumSize(new java.awt.Dimension(34, 27));
        startLabel.setPreferredSize(new java.awt.Dimension(27, 27));

        endLabel.setBackground(new java.awt.Color(252, 254, 252));
        endLabel.setText("end");
        endLabel.setForeground(new Color(230, 231, 234));
        endLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        endLabel.setMinimumSize(new java.awt.Dimension(34, 27));
        endLabel.setPreferredSize(new java.awt.Dimension(25, 27));

        ownerRadioButton.setBackground(new java.awt.Color(6, 66, 118));
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
        owner2TextField.setForeground(new Color(230, 231, 234));
        owner2TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        owner2TextField.setMinimumSize(new java.awt.Dimension(4, 27));
        owner2TextField.setPreferredSize(new java.awt.Dimension(54, 27));

        contentRadioButton.setBackground(new java.awt.Color(0, 66, 118));
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

        hintTextField.setBackground(new java.awt.Color(252, 254, 252));
        hintTextField.setText("hint");
        hintTextField.setForeground(new Color(230, 231, 234));
        hintTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        hintTextField.setMinimumSize(new java.awt.Dimension(0, 27));
        hintTextField.setPreferredSize(new java.awt.Dimension(35, 27));

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
                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date2Label)
                    .addComponent(dateRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(5, 5, 5)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hintTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(owner2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        buttonsPanel.setBackground(new java.awt.Color(0, 66, 118));
        buttonsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 0, 4, 2, new java.awt.Color(252, 254, 252)));
        buttonsPanel.setMaximumSize(new java.awt.Dimension(122, 50));
        buttonsPanel.setMinimumSize(new java.awt.Dimension(120, 50));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(120, 50));
        buttonsPanel.setLayout(new javax.swing.BoxLayout(buttonsPanel, javax.swing.BoxLayout.LINE_AXIS));

        addIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plusWhite24.png"))); // NOI18N
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
                    AddActionForm addAction;
                    try {
                        clickFlag = true;
                        addIcon.setIcon(new ImageIcon(getClass().getResource("/images/plusGreen-24.png")));
                        addAction = new AddActionForm(getJFrame(),Aps.getTerminal(),meetingName);
                        addAction.setLocationRelativeTo(getJFrame());
                    } catch (Exception ex) {
                        Logger.getLogger(UITerminal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                else{
                    JOptionPane.showMessageDialog(getJFrame(),
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
                    JOptionPane.showMessageDialog(getJFrame(),
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else if(actionListTable.getSelectedRowCount() == 0){
                    JOptionPane.showMessageDialog(getJFrame(),
                            "<html><center>No Action has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    EditActionForm editAction = new EditActionForm(getJFrame(),
                            Aps.getTerminal(),meetingName, getSelectedRowData(), globalFilter, filterValues);
                    editAction.setLocationRelativeTo(getJFrame());
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
                    JOptionPane.showMessageDialog(getJFrame(),
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else if(actionListTable.getSelectedRowCount() == 0){
                    JOptionPane.showMessageDialog(getJFrame(),
                            "<html><center>No Action has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    Object[] options = { "Yes", "No" };
                    if(JOptionPane.showOptionDialog(getJFrame(),
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
    
    private void createActionPlanPanel() throws Exception{
        actionListTable = new JTable();
        
        actionPlanPanel = new JPanel();
        actionPlanPanel.setLayout(new BorderLayout());
        actionPlanPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        actionPlanPanel.setBackground(Color.decode("#FCFEFC"));
        createActionPlanInformationPanel();
        actionListPanel = new JPanel();
        actionListPanel.setLayout(new BorderLayout());
        actionListPanel.setPreferredSize(new Dimension(300,300));
        actionListPanel.setBackground(Color.decode("#FCFEFC"));
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
        //actionListTable.setBackground(Color.decode("#FCFEFC"));
        actionListTable.setAutoCreateRowSorter(true);
        actionListTable.setRowHeight(30);
        actionListTable.setGridColor(Color.decode("#FCFEFC"));
        actionListTable.setFillsViewportHeight(true);
        actionListTable.setFocusable(false);
        actionListTable.setSelectionBackground(Color.decode("#1160AE"));
        actionListTable.setSelectionForeground(Color.decode("#1160AE"));
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
                        EditActionForm editAction = new EditActionForm(getJFrame(),
                            Aps.getTerminal(),meetingName, getSelectedRowData(), 
                                globalFilter, filterValues);
                        editAction.setLocationRelativeTo(getJFrame());
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
        alTableScrollPane.getViewport().setBackground(Color.decode("#FCFEFC"));
        alTableScrollPane.setBorder(BorderFactory.createEmptyBorder());
        actionListPanel.add(alTableScrollPane, BorderLayout.CENTER);
        gapPanel1 = new JPanel();
        gapPanel1.setPreferredSize(new Dimension(4,300));
        gapPanel1.setMinimumSize(new Dimension(4,300));
        gapPanel1.setOpaque(false);
        gapPanel2 = new JPanel();
        gapPanel2.setPreferredSize(new Dimension(4,300));
        gapPanel2.setMinimumSize(new Dimension(4,300));
        gapPanel2.setOpaque(false);
        pagePanel = new JPanel();
        pagePanel.setPreferredSize(new Dimension(Short.MAX_VALUE,15));
        JOptionPane.showMessageDialog(this, "aki toy3", "umm", JOptionPane.ERROR_MESSAGE);
        actionPlanPanel.add(apInformationPanel, BorderLayout.NORTH);
        JOptionPane.showMessageDialog(this, "aki toy4", "umm", JOptionPane.ERROR_MESSAGE);
        actionPlanPanel.add(actionListPanel, BorderLayout.CENTER);
        actionPlanPanel.add(gapPanel1, BorderLayout.WEST);
        actionPlanPanel.add(gapPanel2, BorderLayout.EAST);
        actionPlanPanel.add(pagePanel, BorderLayout.SOUTH);
    }
    
    private void createDashboardPanel(){
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());
        dashboardPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        dashboardPanel.setBackground(Color.decode("#FCFEFC"));
        
        initImageLabel = new JLabel(new ImageIcon(getClass().getResource("/images/planta.jpg")), JLabel.CENTER);
        initImageLabel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        initImageLabel.setPreferredSize(new Dimension(500,328));
        initImageLabel.setBackground(Color.decode("#FCFEFC"));
        
        dashboardPanel.add(initImageLabel,BorderLayout.CENTER);
        
    }
    
    private void createMainMenu(){ 
        mainMenu = new JMenuBar();
        dashboardMenu = new JMenuItem("  DashBoard"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        meetingMenu = new JMenuItem("  Meeting"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        actionPlanMenu = new JMenuItem("  Action Plan"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        teamMenu = new JMenuItem("  Team"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        profileMenu = new JMenuItem("  Profile"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        settingsMenu = new JMenuItem("  Settings"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        menuItem = new JMenuItem(""){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.PAGE_AXIS));
        mainMenu.setMaximumSize(new Dimension(140,Integer.MAX_VALUE));
        mainMenu.setPreferredSize(new Dimension(40,600));
        mainMenu.setMinimumSize(new Dimension(40,50));
        mainMenu.setBackground(Color.decode("#EDEBEB"));
        
        mainMenu.add(createMainMenuItem(menuItem, "menuBlack.png"));
        mainMenu.add(createMainMenuItem(dashboardMenu, "dashboardL.png"));
        mainMenu.add(createMainMenuItem(meetingMenu, "meetingL.png"));
        mainMenu.add(createMainMenuItem(actionPlanMenu, "actionplanL.png"));
        mainMenu.add(createMainMenuItem(teamMenu, "teamL.png"));
        mainMenu.add(createMainMenuItem(profileMenu, "userL.png"));
        mainMenu.add(Box.createVerticalGlue());
        mainMenu.add(createMainMenuItem(settingsMenu, "settingsL.png"));
        
        mainMenuEvents(menuItem, "menuBlue.png", "menuBlack.png");
        mainMenuEvents(dashboardMenu, "dashboardLB.png", "dashboardL.png");
        mainMenuEvents(meetingMenu, "meetingLB.png", "meetingL.png");
        mainMenuEvents(actionPlanMenu, "actionplanLB.png", "actionplanL.png");
        mainMenuEvents(teamMenu, "teamLB.png", "teamL.png");
        mainMenuEvents(profileMenu, "userLB.png", "userL.png");
        mainMenuEvents(settingsMenu, "settingsLB.png", "settingsL.png");        
        
    }
    
    private JMenuItem createMainMenuItem(JMenuItem item, String iconName){
        item.setBackground(Color.decode("#EDEBEB"));
        item.setFont(new Font("Roboto-Regular", Font.PLAIN, 14));
        item.setForeground(Color.decode("#000000"));
        item.setIconTextGap(5);
        item.setMaximumSize(new Dimension(Integer.MAX_VALUE,65));
        item.setPreferredSize(new Dimension(140,45));
        item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
        if(item.equals(this.menuItem))
            item.setToolTipText("Maximize Navigation Bar");
        else
            item.setToolTipText(item.getText());
        return item;
    }
    
    private void createMenuItem(String option){
        JMenuItem item = new JMenuItem(option);
        item.setBackground(Color.decode("#303132"));
        item.setForeground(Color.decode("#FCFEFC"));
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
                startLabel.setText("yyyy-mm-dd");
                endLabel.setText("yyyy-mm-dd");
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
    
    private void createOptionsContentPanel() throws Exception{
        optionsContentPanel = new JPanel();
        optionsContentPanel.setBackground(Color.decode("#FCFEFC"));
        optionsContentPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        optionsContentPanel.setPreferredSize(new Dimension(1002,600));
        optionsContentPanel.setSize(optionsContentPanel.getPreferredSize());
        optionsContentPanel.setLayout(new BorderLayout());
        
        createDashboardPanel();
        createActionPlanPanel();
        
        initImageLabel = new JLabel(new ImageIcon(getClass().getResource("/images/holcim-logo.png")));
        initImageLabel.setPreferredSize(new Dimension(500,328));
        initImageLabel.setSize(initImageLabel.getPreferredSize());
        optionsContentPanel.add(initImageLabel,BorderLayout.CENTER);
        optionsContentPanel.add(titleBarPanel, BorderLayout.NORTH);
        pack();
                
    }
    
    private void createTitleBarPanel(){
        titleBarPanel = new JPanel();
        titleBarPanel.setLayout(new BorderLayout());    
        titleBarPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        titleBarPanel.setPreferredSize(new Dimension(867,30));
        titleBarPanel.setBackground(Color.decode("#FFFFFF"));
        titleBarPanel.addMouseListener(new MouseAdapter(){});
        MoveMouseListener ml = new MoveMouseListener(titleBarPanel);
        titleBarPanel.addMouseListener(ml);
        titleBarPanel.addMouseMotionListener(ml);
        
        frameButtonsPanel = new JPanel();
        apsLogoLabel = new JLabel("PlanB System 1.0");
        apsLogoLabel.setIcon(new ImageIcon(getClass().getResource("/images/planB-18x21.png")));
        apsLogoLabel.setIconTextGap(3);
        Border border = BorderFactory.createEmptyBorder(0,4,0,0);
        apsLogoLabel.setBorder(border);
        resizeLabel = new JLabel(new ImageIcon(getClass().getResource("/images/tabB.png")), JLabel.CENTER);
        minimizeLabel = new JLabel(new ImageIcon(getClass().getResource("/images/minusB.png")), JLabel.CENTER);
        closeLabel = new JLabel(new ImageIcon(getClass().getResource("/images/closeB.png")), JLabel.CENTER);
        
        apsLogoLabel.setForeground(Color.decode("#707070"));
        apsLogoLabel.setHorizontalAlignment(JLabel.CENTER);
        apsLogoLabel.setFont(new Font("Roboto-Thin",Font.BOLD,12));
        apsLogoLabel.setHorizontalTextPosition(JLabel.RIGHT);
        
        resizeLabel.setOpaque(true);
        resizeLabel.setBackground(Color.decode("#FCFEFC"));
        resizeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resizeLabel.setMaximumSize(new Dimension(47,30));
        resizeLabel.setPreferredSize(new Dimension(47,30));
        resizeLabel.setToolTipText("Minimize:size");
        resizeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                resizeLabel.setBackground(Color.decode("#E2E5E2"));
                resizeLabel.repaint();
                
            }
            @Override
            public void mouseExited(MouseEvent e){
                resizeLabel.setBackground(Color.decode("#FCFEFC"));
                resizeLabel.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                resizeWindow();
            }  
        });
        
        minimizeLabel.setOpaque(true);
        minimizeLabel.setBackground(Color.decode("#FCFEFC"));
        minimizeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeLabel.setMaximumSize(new Dimension(47,30));
        minimizeLabel.setPreferredSize(new Dimension(47,30));
        minimizeLabel.setToolTipText("Minimize");
        minimizeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                minimizeLabel.setBackground(Color.decode("#E2E5E2"));
                //minimizeLabel.setIcon(new ImageIcon(getClass().getResource("/images/minusW.png"));
                minimizeLabel.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                minimizeLabel.setBackground(Color.decode("#FCFEFC"));
                minimizeLabel.setIcon(new ImageIcon(getClass().getResource("/images/minusB.png")));
                minimizeLabel.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                minimizeWindow();
            }  
        });
        
        closeLabel.setOpaque(true);
        closeLabel.setBackground(Color.decode("#FCFEFC"));
        closeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeLabel.setMaximumSize(new Dimension(47,30));
        closeLabel.setPreferredSize(new Dimension(47,30));
        closeLabel.setToolTipText("Close");
        closeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                closeLabel.setBackground(Color.decode("#FC4344"));
                closeLabel.setIcon(new ImageIcon(getClass().getResource("/images/closeW.png")));
                closeLabel.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                closeLabel.setBackground(Color.decode("#FCFEFC"));
                closeLabel.setIcon(new ImageIcon(getClass().getResource("/images/closeB.png")));
                closeLabel.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }  
        });
        
        frameButtonsPanel.setLayout(new BoxLayout(frameButtonsPanel, BoxLayout.X_AXIS));
        frameButtonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        frameButtonsPanel.setPreferredSize(new Dimension(nativeScreenSize.width, 30));
        frameButtonsPanel.setBackground(Color.decode("#FCFEFC"));
        frameButtonsPanel.add(apsLogoLabel);
        frameButtonsPanel.add(Box.createHorizontalGlue());
        frameButtonsPanel.add(minimizeLabel);
        frameButtonsPanel.add(resizeLabel);
        frameButtonsPanel.add(closeLabel);
        
        titleBarPanel.add(frameButtonsPanel, BorderLayout.LINE_START);
    }
    
    public void disableFrame(){
        this.setEnabled(false);
    }
    
    public Component getJComponent(String name){
        if(name.equals("addIcon"))
            return addIcon;
        return null;
    }
    
    public JFrame getJFrame(){
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
    
    private void initComponents() throws FontFormatException, Exception{
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWindowListener();
        nativeScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        setMinimumSize(new Dimension(1000,700));
        this.setResizable(true);
        UIManager.put("ToolTip.background", Color.decode("#303132"));
        UIManager.put("ToolTip.foreground", Color.decode("#C9CDD1"));
        UIManager.put("ProgressBar.selectionForeground", Color.decode("#FCFEFC"));
        UIManager.put("ProgressBar.selectionBackground", Color.decode("#FCFEFC"));
        UIManager.put("JSlider.altTrackColor", Color.decode("#1160AE"));
        //UIManager.put("Slider.focus", Color.decode("#1160AE"));
        //UIManager.put("Slider.shadow", Color.decode("#1160AE"));
        Border border = BorderFactory.createMatteBorder(1,1,1,1,Color.decode("#3B3C3D"));
        UIManager.put("ToolTip.border", border);
        setIconImage(new ImageIcon(getClass().getResource("/images/planB-27x32.png")).getImage());
        createTitleBarPanel();      
        createMainMenu();
        createOptionsContentPanel();
        itemFlag = new JMenuItem();
        
        mainPanel = new JPanel();
        highlightPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        highlightPanel.setLayout(new BoxLayout(highlightPanel, BoxLayout.PAGE_AXIS));
        highlightPanel.setMaximumSize(new Dimension(4,Integer.MAX_VALUE));
        highlightPanel.setPreferredSize(new Dimension(4,600));
        highlightPanel.setMinimumSize(new Dimension(4,50));
        highlightPanel.setBackground(Color.decode("#EDEBEB"));
        setHighlightPanels();
        mainPanel.setLayout(new BorderLayout());
        contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.decode("#F8FAF8")));
        contentPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(titleBarPanel, BorderLayout.NORTH);
        contentPanel.add(highlightPanel, BorderLayout.WEST);
        contentPanel.add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(optionsContentPanel,BorderLayout.CENTER);
        mainPanel.add(mainMenu,BorderLayout.WEST);
        getContentPane().setBackground(Color.decode("#000000"));
        addFonts();
        setContentPane(contentPanel);
        pack();
        maximize(6);
        setVisible(true);
    }

    private void mainMenuEvents(JMenuItem item, String iconName, String iconName2){
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(Color.decode("#CDCFCD"));
                item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                if(item.equals(menuItem))
                    h1.setBackground(Color.decode("#CDCFCD"));
                if(!item.equals(itemFlag)){    
                    if(item.equals(dashboardMenu))
                        h2.setBackground(Color.decode("#CDCFCD"));
                    else if(item.equals(meetingMenu))
                        h3.setBackground(Color.decode("#CDCFCD"));
                    else if(item.equals(actionPlanMenu))
                        h4.setBackground(Color.decode("#CDCFCD"));
                    else if(item.equals(teamMenu))
                        h5.setBackground(Color.decode("#CDCFCD"));
                    else if(item.equals(profileMenu))
                        h6.setBackground(Color.decode("#CDCFCD"));
                    else if(item.equals(settingsMenu))
                        h7.setBackground(Color.decode("#CDCFCD"));
                }
                item.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                item.setBackground(Color.decode("#EDEBEB"));
                if(item.equals(menuItem))
                    h1.setBackground(Color.decode("#EDEBEB"));
                if(!item.equals(itemFlag)){    
                    if(item.equals(dashboardMenu))
                        h2.setBackground(Color.decode("#EDEBEB"));
                    else if(item.equals(meetingMenu))
                        h3.setBackground(Color.decode("#EDEBEB"));
                    else if(item.equals(actionPlanMenu))
                        h4.setBackground(Color.decode("#EDEBEB"));
                    else if(item.equals(teamMenu))
                        h5.setBackground(Color.decode("#EDEBEB"));
                    else if(item.equals(profileMenu))
                        h6.setBackground(Color.decode("#EDEBEB"));
                    else if(item.equals(settingsMenu))
                        h7.setBackground(Color.decode("#EDEBEB"));
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName2)));
                }
                else{
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                }
                item.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                if(item.equals(menuItem)){
                    if(!menuFlag){
                        mainMenu.setPreferredSize(new Dimension(140,600));
                        //menuItem.setToolTipText("<html><body style=\"background-color:#303132;color:#C9CDD1;border=0\">"
                        //        + " Minimize Navigation Bar </body></ht‌​ml>");
                        mainPanel.revalidate();
                        //contentPanel.revalidate();
                        menuItem.setToolTipText("Minimize Navigation Bar");
                        menuFlag = true;
                    }
                    else{
                        mainMenu.setPreferredSize(new Dimension(40,600));
                        //contentPanel.revalidate();
                        mainPanel.revalidate();
                        menuItem.setToolTipText("Maximize Navigation Bar");
                        menuFlag = false;
                    }
                }
                else if(item.equals(dashboardMenu)){
                    optionsContentPanel.removeAll();
                    optionsContentPanel.add(dashboardPanel, BorderLayout.CENTER);
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                    h2.setBackground(Color.decode("#1160AE"));
                    h3.setBackground(Color.decode("#EDEBEB"));
                    h4.setBackground(Color.decode("#EDEBEB"));
                    h5.setBackground(Color.decode("#EDEBEB"));
                    h6.setBackground(Color.decode("#EDEBEB"));
                    h7.setBackground(Color.decode("#EDEBEB"));
                    itemFlag = dashboardMenu;
                    pack();
                    optionsContentPanel.repaint();
                }
                else if(item.equals(meetingMenu)){
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                    h2.setBackground(Color.decode("#EDEBEB"));
                    h3.setBackground(Color.decode("#1160AE"));
                    h4.setBackground(Color.decode("#EDEBEB"));
                    h5.setBackground(Color.decode("#EDEBEB"));
                    h6.setBackground(Color.decode("#EDEBEB"));
                    h7.setBackground(Color.decode("#EDEBEB"));
                    itemFlag = meetingMenu;
                }
                else if(item.equals(actionPlanMenu)){
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                    optionsContentPanel.removeAll();
                    optionsContentPanel.add(actionPlanPanel, BorderLayout.CENTER);
                    h2.setBackground(Color.decode("#EDEBEB"));
                    h3.setBackground(Color.decode("#EDEBEB"));
                    h4.setBackground(Color.decode("#1160AE"));
                    h5.setBackground(Color.decode("#EDEBEB"));
                    h6.setBackground(Color.decode("#EDEBEB"));
                    h7.setBackground(Color.decode("#EDEBEB"));
                    itemFlag = actionPlanMenu;
                    pack();
                    optionsContentPanel.repaint();
                }
                else if(item.equals(teamMenu)){
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                    h2.setBackground(Color.decode("#EDEBEB"));
                    h3.setBackground(Color.decode("#EDEBEB"));
                    h4.setBackground(Color.decode("#EDEBEB"));
                    h5.setBackground(Color.decode("#1160AE"));
                    h6.setBackground(Color.decode("#EDEBEB"));
                    h7.setBackground(Color.decode("#EDEBEB"));
                    itemFlag = teamMenu;
                }
                else if(item.equals(profileMenu)){
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                    h2.setBackground(Color.decode("#EDEBEB"));
                    h3.setBackground(Color.decode("#EDEBEB"));
                    h4.setBackground(Color.decode("#EDEBEB"));
                    h5.setBackground(Color.decode("#EDEBEB"));
                    h6.setBackground(Color.decode("#1160AE"));
                    h7.setBackground(Color.decode("#EDEBEB"));
                    itemFlag = profileMenu;
                }
                else if(item.equals(settingsMenu)){
                    item.setIcon(new ImageIcon(getClass().getResource("/images/"+iconName)));
                    h2.setBackground(Color.decode("#EDEBEB"));
                    h3.setBackground(Color.decode("#EDEBEB"));
                    h4.setBackground(Color.decode("#EDEBEB"));
                    h5.setBackground(Color.decode("#EDEBEB"));
                    h6.setBackground(Color.decode("#EDEBEB"));
                    h7.setBackground(Color.decode("#1160AE"));
                    itemFlag = settingsMenu;
                }
                if(!item.equals(menuItem)){
                    if(!meetingMenu.equals(item))
                        meetingMenu.setIcon(new ImageIcon(getClass().getResource("/images/meetingL.png")));
                    if(!dashboardMenu.equals(item))
                        dashboardMenu.setIcon(new ImageIcon(getClass().getResource("/images/dashboardL.png")));
                    if(!teamMenu.equals(item))
                        teamMenu.setIcon(new ImageIcon(getClass().getResource("/images/teamL.png")));
                    if(!profileMenu.equals(item))
                        profileMenu.setIcon(new ImageIcon(getClass().getResource("/images/userL.png")));
                    if(!settingsMenu.equals(item))
                        settingsMenu.setIcon(new ImageIcon(getClass().getResource("/images/settingsL.png")));
                    if(!actionPlanMenu.equals(item))
                        actionPlanMenu.setIcon(new ImageIcon(getClass().getResource("/images/actionplanL.png")));
                }
            }
        }); 
    }
    
    public synchronized void maximize(int state){
        if ((state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) { 
            Insets screenInsets = getToolkit().getScreenInsets(getGraphicsConfiguration());
            Rectangle screenSize = getGraphicsConfiguration().getBounds();
            Rectangle maxBounds = new Rectangle(screenInsets.left + screenSize.x, 
                    screenInsets.top + screenSize.y, 
                    screenSize.x + screenSize.width - screenInsets.right - screenInsets.left,
                    screenSize.y + screenSize.height - screenInsets.bottom - screenInsets.top); 
            this.setMaximizedBounds(maxBounds); 
        } 
        this.setExtendedState(state);
    }
    
    public void modifiedTableContent(Object[] rowDataModified){
        DefaultTableModel dm = (DefaultTableModel) actionListTable.getModel();
        int rowIndex = actionListTable.getSelectedRow();
        for(int columnIndex=1;columnIndex<rowDataModified.length;columnIndex++){
            Object data = rowDataModified[columnIndex];
            if(data != null)
                if(actionListTable.getRowSorter() != null)
                    System.out.println("IS SORTER");
                dm.setValueAt(data, rowIndex, columnIndex);
        }
        actionListTable.repaint();
    }
    
    private void minimizeWindow(){
        this.setState(ICONIFIED);
    }
    
    private void resizeWindow(){
        if(!resizeFlag){
            Dimension d = this.getMinimumSize();
            this.setPreferredSize(this.getMinimumSize());
            xPosition = (nativeScreenSize.width/2)-(d.width/2);
            yPosition = (nativeScreenSize.height/2)-(d.height/2);
            this.setLocation(xPosition,yPosition);
            frameButtonsPanel.setPreferredSize(new Dimension(d.width,30));
            resizeLabel.setIcon(new ImageIcon(getClass().getResource("/images/resize.png")));
            resizeLabel.setToolTipText("Maximize");
            pack();
            resizeFlag = true;
        }
        else{ // Restoring statements
            this.setLocation(0,0);
            this.setPreferredSize(nativeScreenSize);
            frameButtonsPanel.setPreferredSize(new Dimension(nativeScreenSize.width,30));
            resizeLabel.setIcon(new ImageIcon(getClass().getResource("/images/tabB.png")));
            resizeLabel.setToolTipText("Minimize:Size");
            maximize(6);
            revalidate();
            resizeFlag = false;
        }
    }
    
    private void setColumnWidth(){       
        actionListTable.getColumnModel().getColumn(0).setMaxWidth(77);  //ID
        actionListTable.getColumnModel().getColumn(0).setMinWidth(77);  //ID
        actionListTable.getColumnModel().getColumn(1).setMaxWidth(40);  //RESPONSIBLE
        actionListTable.getColumnModel().getColumn(4).setMaxWidth(73);  //START DATE
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
    
    private void setHighlightPanels(){
        h1 = new JPanel();
        h2 = new JPanel();
        h3 = new JPanel();
        h4 = new JPanel();
        h5 = new JPanel();
        h6 = new JPanel();
        h7 = new JPanel();
        
        h1.setBackground(Color.decode("#EDEBEB"));
        h2.setBackground(Color.decode("#EDEBEB"));
        h3.setBackground(Color.decode("#EDEBEB"));
        h4.setBackground(Color.decode("#EDEBEB"));
        h5.setBackground(Color.decode("#EDEBEB"));
        h6.setBackground(Color.decode("#EDEBEB"));
        h7.setBackground(Color.decode("#EDEBEB"));
        
        h1.setMaximumSize(new Dimension(4,65));
        h1.setPreferredSize(new Dimension(4,45));
        h2.setMaximumSize(new Dimension(4,65));
        h2.setPreferredSize(new Dimension(4,45));
        h3.setMaximumSize(new Dimension(4,65));
        h3.setPreferredSize(new Dimension(4,45));
        h4.setMaximumSize(new Dimension(4,65));
        h4.setPreferredSize(new Dimension(4,45));
        h5.setMaximumSize(new Dimension(4,65));
        h5.setPreferredSize(new Dimension(4,45));
        h6.setMaximumSize(new Dimension(4,65));
        h6.setPreferredSize(new Dimension(4,45));
        h7.setMaximumSize(new Dimension(4,65));
        h7.setPreferredSize(new Dimension(4,45));
        
        highlightPanel.add(h1);
        highlightPanel.add(h2);
        highlightPanel.add(h3);
        highlightPanel.add(h4);
        highlightPanel.add(h5);
        highlightPanel.add(h6);
        highlightPanel.add(Box.createVerticalGlue());
        highlightPanel.add(h7);
    }
    
    private void setWindowListener(){
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e){}

            @Override
            public void windowClosing(WindowEvent e){
                //parent.setEnabled(true);
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
    
    protected void updateJTable(ActionItemFilter filter, ArrayList<Object> values){
        try {
            Object[] object = Aps.getTerminal().getTableContent(filter,values, meetingName);
            Meeting meeting = (Meeting)object[0];
            actionListTable.setModel((TableModel)object[1]);                
            setColumnWidth();
            centerColumnContent();

            if(meeting != null){
                ActionPlan plan = meeting.getActionPlan();
                APSummary summary = plan.getSummary();
                String[] nameSplitted = meetingName.split(" ");
                if(nameSplitted.length > 1){
                    String namePortion = "";
                    for(int i=0; i < nameSplitted.length; i++){
                        if(i == 0)
                            title1Label.setText(nameSplitted[i]);
                        else
                            namePortion += nameSplitted[i]+" ";
                    }
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
                int team_performance = 100;
                if(summary.getActionsOverdue() == 0 && summary.getActionsCompletedApp() > 0)
                    performanceValueLabel.setText(String.valueOf(team_performance)+"%");
                else{
                    team_performance = (int)Math.round(((float)summary.getActionsCompletedApp()/
                            ((float)summary.getActions()))*100);
                    performanceValueLabel.setText(String.valueOf(team_performance)+"%");
                }
                executionValueLabel.setText(String.valueOf(plan.getExecution())+"%");
                if(team_performance <= 70){
                    teamPerformancePanel.setBackground(Color.decode("#E80C0C"));
                    performanceValueLabel.setForeground(Color.decode("#FCFEFC"));
                }
                else if(team_performance > 70 && team_performance < 90){
                    teamPerformancePanel.setBackground(Color.decode("#F2D345")); // Yellow Color
                    performanceValueLabel.setForeground(Color.decode("#303132"));
                }
                else{
                    // Darcula black color 3C3E41
                    teamPerformancePanel.setBackground(Color.decode("#64D610"));
                    performanceValueLabel.setForeground(Color.decode("#FCFEFC"));
                }
            }
            actionListTable.repaint();
        }
        catch (Exception ex) {
            Logger.getLogger(UITerminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
