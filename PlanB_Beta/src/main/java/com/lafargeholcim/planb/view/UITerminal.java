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
import com.lafargeholcim.planb.model.WorkTeam;
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
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
    private int value_at_changed, xPosition=0, yPosition=0, selectedRow=-1;
    private JMenuBar mainMenu;
    private JMenuItem dashboardMenu, meetingMenu, actionPlanMenu, teamMenu,
            profileMenu,settingsMenu,menuItem,itemFlag;
    private JPanel contentPanel, highlightPanel, titleBarPanel, optionsContentPanel,
            frameButtonsPanel, mainPanel;
    private JPanel dashboardPanel, actionPlanPanel, meetingPanel;
    private JLabel apsLogoLabel, resizeLabel, minimizeLabel, closeLabel;
    private JLabel initImageLabel;
    private String meetingName;
    private JLabel apLabel, owLabel, parLabel, meetLabel, actLabel, compLabel, 
                compAppLabel, overAppLabel, actContentLabel, owContentLabel,
                compContentLabel, compAppContentLabel, overAppContentLabel, 
                performanceLabel, exeLabel, performanceContentLabel;
    private JPanel filterPanel, apInformationPanel, actionListPanel, 
            gapPanel1,gapPanel2,pagePanel;
    private JLabel addActionLabel, modifyActionLabel, deleteActionLabel;
    private JComboBox filterContentComboBox,filterCombobox,meetComboBox;
    private JTable jTable1; 
    private JProgressBar exeContentLabel;
    private JScrollPane jScrollPane1, jScrollPane2;
    private JTextArea parTextArea;
    private JPanel h1,h2,h3,h4,h5,h6,h7;
    private boolean menuFlag = false, resizeFlag = false, clickFlag = false;
    
    private javax.swing.JLabel actionLabel;
    private javax.swing.JLabel actionValueLabel;
    private javax.swing.JLabel actionsLabel;
    private javax.swing.JLabel addIcon;
    private javax.swing.JPanel apPanel;
    private javax.swing.JPanel appActionPanel;
    private javax.swing.JLabel appLabel;
    private javax.swing.JLabel appValueLabel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel completedActionPanel;
    private javax.swing.JLabel completedLabel;
    private javax.swing.JLabel completedValueLabel;
    private javax.swing.JLabel content2Label;
    private javax.swing.JRadioButton contentRadioButton;
    private javax.swing.JLabel date2Label;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel datePanel;
    private javax.swing.JRadioButton dateRadioButton;
    private javax.swing.JLabel dateValueLabel;
    private javax.swing.JLabel deleteIcon;
    private javax.swing.JLabel dotMenuLabel;
    private javax.swing.JLabel editIcon;
    private javax.swing.JTextField endLabel;
    private javax.swing.JLabel executionLabel;
    private javax.swing.JLabel executionValueLabel;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JPanel filterLabelPanel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField hintTextField;
    private javax.swing.JLabel meetingLabel;
    private javax.swing.JPanel meetingNamePanel;
    private javax.swing.JPanel overdueActionPanel;
    private javax.swing.JLabel overdueLabel;
    private javax.swing.JLabel overdueValueLabel;
    private javax.swing.JLabel owner2Label;
    private javax.swing.JTextField owner2TextField;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JPanel ownerNamePanel;
    private javax.swing.JRadioButton ownerRadioButton;
    private javax.swing.JLabel participantsLabel;
    private javax.swing.JPanel participantsPanel;
    private javax.swing.JTextArea participantsTextArea;
    private javax.swing.JLabel performanceValueLabel;
    private javax.swing.JPanel planExecutionPanel;
    private javax.swing.JLabel planLabel;
    private javax.swing.JScrollPane scrollParticipants;
    private javax.swing.JTextField startLabel;
    private javax.swing.JLabel status2Label;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JRadioButton statusRadioButton;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JPanel teamPerformancePanel;
    private javax.swing.JLabel title1Label;
    private javax.swing.JLabel title2Label;
    private javax.swing.JPanel totalActionsPanel;

       
    public UITerminal() throws IOException, FontFormatException, Exception{
        initComponents(); 
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
    
    private JMenuItem createMenuItem(JMenuItem item, String iconName){
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
    
    private void menuEvents(JMenuItem item, String iconName, String iconName2){
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
        
        mainMenu.add(createMenuItem(menuItem, "menuBlack.png"));
        mainMenu.add(createMenuItem(dashboardMenu, "dashboardL.png"));
        mainMenu.add(createMenuItem(meetingMenu, "meetingL.png"));
        mainMenu.add(createMenuItem(actionPlanMenu, "actionplanL.png"));
        mainMenu.add(createMenuItem(teamMenu, "teamL.png"));
        mainMenu.add(createMenuItem(profileMenu, "userL.png"));
        mainMenu.add(Box.createVerticalGlue());
        mainMenu.add(createMenuItem(settingsMenu, "settingsL.png"));
        
        menuEvents(menuItem, "menuBlue.png", "menuBlack.png");
        menuEvents(dashboardMenu, "dashboardLB.png", "dashboardL.png");
        menuEvents(meetingMenu, "meetingLB.png", "meetingL.png");
        menuEvents(actionPlanMenu, "actionplanLB.png", "actionplanL.png");
        menuEvents(teamMenu, "teamLB.png", "teamL.png");
        menuEvents(profileMenu, "userLB.png", "userL.png");
        menuEvents(settingsMenu, "settingsLB.png", "settingsL.png");        
        
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
    
    private void createActionPlanPanel() throws Exception{
        GridBagConstraints gbc = new GridBagConstraints();
        meetComboBox = new JComboBox();
        jTable1 = new JTable();
        parTextArea = new JTextArea();
        
        
        actionPlanPanel = new JPanel();
        actionPlanPanel.setLayout(new BorderLayout());
        actionPlanPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        actionPlanPanel.setBackground(Color.decode("#FCFEFC"));
        createActionPlanInformationPanel();
        /*
        apInformationPanel = new JPanel();
        apInformationPanel.setLayout(new GridBagLayout());
        apInformationPanel.setBackground(Color.decode("#3C3E41"));
        actionListPanel = new JPanel();
        actionListPanel.setLayout(new BorderLayout());
        actionListPanel.setPreferredSize(new Dimension(300,300));
        actionListPanel.setBackground(Color.decode("#FCFEFC"));
        //**********************************************************************
        //  ActionPlan Information Panel Components
        //**********************************************************************
        apLabel = new JLabel("Action Plan");
        apLabel.setFont(new Font("Dialog", 1, 24)); // NOI18N
        apLabel.setForeground(Color.decode("#FCFEFC"));
        apLabel.setHorizontalAlignment(SwingConstants.CENTER);
        apLabel.setVerticalTextPosition(SwingConstants.TOP);
        
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.insets = new Insets(0, 5, 0, 5);
        apInformationPanel.add(apLabel, gbc);
        
        owLabel = new JLabel("Owner");
        owLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        owLabel.setForeground(Color.decode("#FCFEFC"));
        owLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        owLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        owLabel.setMaximumSize(new Dimension(45, 16));
        owLabel.setMinimumSize(new Dimension(45, 16));
        owLabel.setPreferredSize(new Dimension(45, 16));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 2, 2, 3);
        apInformationPanel.add(owLabel, gbc);

        parLabel = new JLabel("Participants");
        parLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        parLabel.setForeground(Color.decode("#FCFEFC"));
        parLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        parLabel.setVerticalAlignment(SwingConstants.TOP);
        parLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        parLabel.setPreferredSize(new Dimension(82, 16));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(0, 4, 2, 3);
        apInformationPanel.add(parLabel, gbc);
        
        meetLabel = new JLabel("Meeting");
        meetLabel.setForeground(Color.decode("#FCFEFC"));
        meetLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        meetLabel.setHorizontalAlignment(SwingConstants.LEFT);
        meetLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 2, 2, 3);
        apInformationPanel.add(meetLabel, gbc);
        
        meetComboBox.setModel(new DefaultComboBoxModel<>(Aps.getTerminal().getMeetingsNames()));
        meetComboBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(204, 204, 204), null, null));
        meetComboBox.setMaximumSize(new Dimension(170, 24));
        meetComboBox.setPreferredSize(new Dimension(170, 24));
        meetComboBox.setSelectedIndex(-1);
        meetComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                meetingSelected(event);
                updateJTable();
            }
        });

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.insets = new Insets(0, 2, 2, 2);
        apInformationPanel.add(meetComboBox, gbc);
        
        actLabel = new JLabel("Actions");
        actLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        actLabel.setForeground(Color.decode("#FCFEFC"));
        actLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc =  new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 2, 2, 2);
        apInformationPanel.add(actLabel, gbc);

        compLabel = new JLabel("Completed");
        compLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        compLabel.setForeground(Color.decode("#FCFEFC"));
        compLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 2, 2, 2);
        apInformationPanel.add(compLabel, gbc);
        
        compAppLabel = new JLabel("Completed APP");
        compAppLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        compAppLabel.setForeground(Color.decode("#FCFEFC"));
        compAppLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        compAppLabel.setVerticalAlignment(SwingConstants.TOP);
        compAppLabel.setPreferredSize(new Dimension(105, 24));
        compAppLabel.setVerticalTextPosition(SwingConstants.TOP);
        compAppLabel.setForeground(Color.decode("#FCFEFC"));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.insets = new Insets(0, 4, 2, 2);
        apInformationPanel.add(compAppLabel, gbc);
        
        overAppLabel = new JLabel("OverDue APP");
        overAppLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        overAppLabel.setForeground(Color.decode("#FCFEFC"));
        overAppLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 2, 2, 2);
        apInformationPanel.add(overAppLabel, gbc);

        actContentLabel = new JLabel();
        actContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        actContentLabel.setPreferredSize(new Dimension(40, 16));
        actContentLabel.setForeground(Color.decode("#FCFEFC"));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        apInformationPanel.add(actContentLabel, gbc);

        owContentLabel = new JLabel();
        owContentLabel.setHorizontalAlignment(SwingConstants.LEFT);
        owContentLabel.setLabelFor(owLabel);
        owContentLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        owContentLabel.setPreferredSize(new Dimension(150, 24));
        owContentLabel.setForeground(Color.decode("#FCFEFC"));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 4, 3, 2);
        apInformationPanel.add(owContentLabel, gbc);
        
        compContentLabel = new JLabel();
        compContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compContentLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        compContentLabel.setForeground(Color.decode("#FCFEFC"));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(0, 2, 2, 2);
        apInformationPanel.add(compContentLabel, gbc);

        compAppContentLabel = new JLabel();
        compAppContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compAppContentLabel.setVerticalAlignment(SwingConstants.TOP);
        compAppContentLabel.setHorizontalTextPosition(SwingConstants.LEADING);
        compAppContentLabel.setVerticalTextPosition(SwingConstants.TOP);
        compAppContentLabel.setForeground(Color.decode("#FCFEFC"));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        apInformationPanel.add(compAppContentLabel, gbc);

        overAppContentLabel = new JLabel();
        overAppContentLabel.setForeground(Color.decode("#FCFEFC"));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        apInformationPanel.add(overAppContentLabel, gbc);

        performanceLabel = new JLabel("Team Preformance APP");
        performanceLabel.setFont(new Font("Dialog", 1, 14)); // NOI18N
        performanceLabel.setForeground(Color.decode("#FCFEFC"));
        performanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        performanceLabel.setPreferredSize(new Dimension(164, 16));
        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
        gbc.insets = new Insets(0, 12, 2, 2);
        apInformationPanel.add(performanceLabel, gbc);
        
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setBackground(Color.decode("#3C3E41"));
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder(0, 2, 2, 2));
        jScrollPane1.setPreferredSize(new Dimension(170, 25));

        parTextArea.setText("");
        parTextArea.setBackground(Color.decode("#3C3E41"));
        parTextArea.setFont(new Font("Dialog", 1, 12));
        parTextArea.setForeground(Color.decode("#FCFEFC"));
        parTextArea.setEditable(false);
        parTextArea.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        parTextArea.setLineWrap(true);
        parTextArea.setWrapStyleWord(true);
        parTextArea.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(parTextArea);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        apInformationPanel.add(jScrollPane1, gbc);

        exeLabel = new JLabel("Overall Execution");
        exeLabel.setFont(new Font("Dialog", 1, 14));
        exeLabel.setForeground(Color.decode("#FCFEFC"));
        exeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        apInformationPanel.add(exeLabel, gbc);

        performanceContentLabel = new JLabel(); 
        performanceContentLabel.setBackground(new Color(55, 55, 55));
        performanceContentLabel.setFont(new Font("Dialog", 1, 18)); // NOI18N
        performanceContentLabel.setForeground(new Color(255, 255, 255));
        performanceContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        performanceContentLabel.setHorizontalTextPosition(SwingConstants.LEFT);
        performanceContentLabel.setMaximumSize(new Dimension(77, 24));
        performanceContentLabel.setOpaque(true);
        performanceContentLabel.setPreferredSize(new Dimension(77, 24));
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 12, 2, 2);
        apInformationPanel.add(performanceContentLabel, gbc);

        exeContentLabel = new JProgressBar();
        exeContentLabel.setValue(0);
        exeContentLabel.setBackground(Color.decode("#3C3E41"));
        exeContentLabel.setBorder(BorderFactory.createLineBorder(Color.decode("#FCFEFC"), 1));
        //exeContentLabel.set
        exeContentLabel.setFont(new Font("Dialog", 1, 18)); // NOI18N
        exeContentLabel.setForeground(Color.decode("#64D610"));
        //exeContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //exeContentLabel.setOpaque(true);
        exeContentLabel.setStringPainted(true);
        exeContentLabel.setPreferredSize(new Dimension(77, 16));
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 12, 2, 2);
        apInformationPanel.add(exeContentLabel, gbc);
        */
        //**********************************************************************
        //  Action List Table Components
        //**********************************************************************
        //  Filter Panel
        JOptionPane.showMessageDialog(this, "aki toy2", "umm", JOptionPane.ERROR_MESSAGE);
        //createFilterPanel();
        //  Action List Table
        jTable1.setModel(new DefaultTableModel(null, new String [] {
                "ID", "Resp.", "Detail", "Comments", 
                "P.Start Date", "P.End Date", "R.End Date",
                "Prog. %", "Status", "Dur."
            }));
        jTable1.setMinimumSize(new Dimension(300, 200));
        //jTable1.setBackground(Color.decode("#FCFEFC"));
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setRowHeight(30);
        jTable1.setGridColor(Color.decode("#FCFEFC"));
        jTable1.setFillsViewportHeight(true);
        jTable1.setFocusable(false);
        jTable1.setSelectionBackground(Color.decode("#1160AE"));
        jTable1.setSelectionForeground(Color.decode("#1160AE"));
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JOptionPane.showMessageDialog(this, "aki toy3.1", "umm", JOptionPane.ERROR_MESSAGE);
        setColumnWidth();
        /*jTable1.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                JTable table =(JTable) e.getSource();
                Point p = e.getPoint();
                int row = table.rowAtPoint(p);
                if (e.getClickCount() == 2) {
                    if(row != -1){
                        EditActionForm editAction = new EditActionForm(getJFrame(),
                            Aps.getTerminal(),meetingName, getSelectedRowData());
                        editAction.setLocationRelativeTo(getJFrame());
                    }
                }
            }
        });
        jTable1.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                //jTable1.getSelectionModel().clearSelection();
                //jTable1.getSelectionModel().removeSelectionInterval(jTable1.getSelectedRow(), jTable1.getSelectedRow());
            }

            @Override
            public void focusGained(FocusEvent e) {
            }
        });*/
        jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(jTable1);
        jScrollPane2.getViewport().setBackground(Color.decode("#FCFEFC"));
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        //actionListPanel.add(filterPanel, BorderLayout.NORTH);
        //actionListPanel.add(jScrollPane2, BorderLayout.CENTER);
        JOptionPane.showMessageDialog(this, "aki toy3.2", "umm", JOptionPane.ERROR_MESSAGE);
        gapPanel1 = new JPanel();
        gapPanel1.setPreferredSize(new Dimension(10,300));
        gapPanel1.setMinimumSize(new Dimension(10,300));
        gapPanel1.setOpaque(false);
        gapPanel2 = new JPanel();
        gapPanel2.setPreferredSize(new Dimension(10,300));
        gapPanel2.setMinimumSize(new Dimension(10,300));
        gapPanel2.setOpaque(false);
        pagePanel = new JPanel();
        pagePanel.setPreferredSize(new Dimension(Short.MAX_VALUE,15));
        JOptionPane.showMessageDialog(this, "aki toy3", "umm", JOptionPane.ERROR_MESSAGE);
        actionPlanPanel.add(apInformationPanel, BorderLayout.NORTH);
        JOptionPane.showMessageDialog(this, "aki toy4", "umm", JOptionPane.ERROR_MESSAGE);
        //actionPlanPanel.add(actionListPanel, BorderLayout.CENTER);
        actionPlanPanel.add(gapPanel1, BorderLayout.WEST);
        actionPlanPanel.add(gapPanel2, BorderLayout.EAST);
        actionPlanPanel.add(pagePanel, BorderLayout.SOUTH);
        
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
        
    public JFrame getJFrame(){
        return this;
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
    
    private void meetingSelected(ItemEvent event){
        meetingName = event.getItem().toString();
    }
    
    private void setAPSumary(ActionPlan plan){
        
    }
    
    private void createFilterPanel(){
        filterPanel = new JPanel();//1160AE
        filterPanel.setBackground(Color.decode("#004276"));
        filterPanel.setBorder(BorderFactory.createMatteBorder(7,0,0,0,Color.decode("#FCFEFC")));
        filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.LINE_AXIS));
        filterPanel.setPreferredSize(new Dimension(actionPlanPanel.getMaximumSize().height, 50));
        JLabel filterLabel = new JLabel("Filter by");
        filterLabel.setHorizontalAlignment(JLabel.CENTER);
        filterLabel.setPreferredSize(new Dimension(60,filterPanel.getPreferredSize().height));
        filterCombobox = new JComboBox();
        filterCombobox.setMaximumSize(new Dimension(140,26));
        filterCombobox.setModel(new DefaultComboBoxModel<>(new Object[]
            {"DATE", "RESPONSIBLE","STATUS"}
        ));

        filterPanel.add(filterLabel);
        filterPanel.add(filterCombobox);
        filterPanel.add(Box.createRigidArea(new Dimension(20,26)));
        filterContentComboBox = new JComboBox();
        filterContentComboBox.setMaximumSize(new Dimension(140,26));
        filterPanel.add(filterContentComboBox);
        filterPanel.add(Box.createHorizontalGlue());
        
        addActionLabel = new JLabel();
        addActionLabel.setIcon(new ImageIcon(getClass().getResource("/images/plus-24.png")));
        addActionLabel.setPreferredSize(new Dimension(35,filterPanel.getPreferredSize().height));
        addActionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                addActionLabel.setIcon(new ImageIcon(getClass().getResource("/images/plusGreen-24.png")));
            }
            @Override
            public void mouseExited(MouseEvent e){
                if(!clickFlag)
                    addActionLabel.setIcon(new ImageIcon(getClass().getResource("/images/plus-24.png")));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                if(meetComboBox.getSelectedIndex() != -1){
                    AddActionForm add_action;
                    try {
                        clickFlag = true;
                        addActionLabel.setIcon(new ImageIcon(getClass().getResource("/images/plusGreen-24.png")));
                        add_action = new AddActionForm(getJFrame(),Aps.getTerminal(),meetingName);
                        add_action.setLocationRelativeTo(getJFrame());
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

        modifyActionLabel = new JLabel();
        modifyActionLabel.setIcon(new ImageIcon(getClass().getResource("/images/edit-24.png")));
        modifyActionLabel.setPreferredSize(new Dimension(35,filterPanel.getPreferredSize().height));
        modifyActionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mouseClicked(MouseEvent e){
                if(meetComboBox.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(getJFrame(),
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else if(jTable1.getSelectedRowCount() == 0){
                    JOptionPane.showMessageDialog(getJFrame(),
                            "<html><center>No Action has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    EditActionForm editAction = new EditActionForm(getJFrame(),
                            Aps.getTerminal(),meetingName, getSelectedRowData());
                    editAction.setLocationRelativeTo(getJFrame());
                    jTable1.getSelectionModel().clearSelection();
                }
            }
        }); 
        
        deleteActionLabel = new JLabel();
        deleteActionLabel.setIcon(new ImageIcon(getClass().getResource("/images/delete-24.png")));
        deleteActionLabel.setPreferredSize(new Dimension(35, filterPanel.getPreferredSize().height));
        
        deleteActionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){}
            @Override
            public void mouseExited(MouseEvent e){}
            @Override
            public void mouseClicked(MouseEvent e){
                if(meetComboBox.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(getJFrame(),
                            "<html><center>No Meeting has been selected. Select one first.</html>",
                            "Validation",JOptionPane.ERROR_MESSAGE);
                }
                else if(jTable1.getSelectedRowCount() == 0){
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
                        int row_index = jTable1.getSelectedRow();
                        TableModel model = jTable1.getModel();
                        try {
                            boolean is_deleted = Aps.getTerminal().deleteAction(
                                    String.valueOf(model.getValueAt(row_index, 0)),meetingName);
                            if(is_deleted){
                                ((DefaultTableModel)model).removeRow(row_index);
                                jTable1.getSelectionModel().clearSelection();
                                jTable1.repaint();
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(UITerminal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    else{
                    }
                }
            }
        });
        filterPanel.add(addActionLabel);
        filterPanel.add(modifyActionLabel);
        filterPanel.add(deleteActionLabel);
        
    }
    
    private void centerColumnContent(){
        for(int i=0; i<10;i++){
            jTable1.getColumnModel().getColumn(i).setCellRenderer(new TableCellRenderer(){
                private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
                @Override
                public Component getTableCellRendererComponent(JTable table, 
                        Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if(!(column == 2 || column ==3) )
                        DEFAULT_RENDERER.setHorizontalAlignment(SwingConstants.CENTER);
                    c.setBackground(row%2==0 ? Color.WHITE : Color.decode("#EDEDED"));
                    return c;
                }
            });
        }
    }
    
    private void setColumnWidth(){       
        jTable1.getColumnModel().getColumn(0).setMaxWidth(77);  //ID
        jTable1.getColumnModel().getColumn(0).setMinWidth(77);  //ID
        jTable1.getColumnModel().getColumn(1).setMaxWidth(40);  //RESPONSIBLE
        jTable1.getColumnModel().getColumn(4).setMaxWidth(73);  //START DATE
        jTable1.getColumnModel().getColumn(5).setMaxWidth(73);  //DUE DATE
        jTable1.getColumnModel().getColumn(6).setMaxWidth(73);  //END DATE
        jTable1.getColumnModel().getColumn(7).setMaxWidth(50);  //PROGRESS
        jTable1.getColumnModel().getColumn(8).setMaxWidth(120); //STATUS
        jTable1.getColumnModel().getColumn(8).setMinWidth(110); //STATUS
        jTable1.getColumnModel().getColumn(9).setMaxWidth(40);  //DURATION
    }
    
    public void addRowToTableContent(Object[] row){
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.addRow(row);
        jTable1.setModel(dm);
        jTable1.repaint();
    }
    
    public void modifiedTableContent(Object[] rowDataModified){
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        int rowIndex = jTable1.getSelectedRow();
        for(int columnIndex=1;columnIndex<rowDataModified.length;columnIndex++){
            Object data = rowDataModified[columnIndex];
            if(data != null)
                if(jTable1.getRowSorter() != null)
                    System.out.println("IS SORTER");
                dm.setValueAt(data, rowIndex, columnIndex);
        }
        jTable1.repaint();
    }
    
    public void disableFrame(){
        this.setEnabled(false);
    }
    
    private Object[] getSelectedRowData(){
        Object[] rowData = new Object[10];
        int rowIndex = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        
        if(jTable1.getRowSorter() != null)
            rowIndex = jTable1.convertRowIndexToModel(rowIndex);
        
        for(int columnIndex = 0;columnIndex < 10;columnIndex++)
            rowData[columnIndex] = model.getValueAt(rowIndex, columnIndex);
        return rowData;
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
    
    public Component getJComponent(String name){
        if(name.equals("addActionLabel"))
            return addActionLabel;
        return null;
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
    
    protected void updateJTable(){
        try {
            Object[] object = Aps.getTerminal().getTableContent(ActionItemFilter.ALL, meetingName);
            Meeting meeting = (Meeting)object[0];
            jTable1.setModel((TableModel)object[1]);                
            setColumnWidth();
            centerColumnContent();

            if(meeting != null){
                ActionPlan plan = meeting.getActionPlan();
                APSummary summary = plan.getSummary();
                owContentLabel.setText(plan.getOwner().getFirstName()+" "
                        +plan.getOwner().getLastName());
                actContentLabel.setText(String.valueOf(summary.getActions()));
                compContentLabel.setText(String.valueOf(summary.getActionsCompleted()));
                compAppContentLabel.setText(String.valueOf(summary.getActionsCompletedApp()));
                overAppContentLabel.setText(String.valueOf(summary.getActionsOverdue()));
                parTextArea.setText(getParticipantsAcronyms(meeting.getTeam(),meeting.getAditionalParticipants()));
                int team_performance = 100;
                if(summary.getActionsOverdue() == 0 && summary.getActionsCompletedApp() > 0)
                    performanceContentLabel.setText(String.valueOf(team_performance)+"%");
                else{
                    team_performance = (int)Math.round(((float)summary.getActionsCompletedApp()/
                            ((float)summary.getActions()))*100);
                    performanceContentLabel.setText(String.valueOf(team_performance)+"%");
                }
                exeContentLabel.setValue((int)plan.getExecution());
                if(team_performance <= 70){
                    performanceContentLabel.setBackground(Color.decode("#E80C0C"));
                    performanceContentLabel.setForeground(Color.decode("#FCFEFC"));
                }
                else if(team_performance > 70 && team_performance < 90){
                    performanceContentLabel.setBackground(Color.YELLOW);
                    performanceContentLabel.setForeground(Color.decode("#303132"));
                }
                else{
                    // Darcula black color 3C3E41
                    performanceContentLabel.setBackground(Color.decode("#64D610"));
                    performanceContentLabel.setForeground(Color.decode("#FCFEFC"));
                }
            }
            //jTable1.repaint();
        }
        catch (Exception ex) {
            Logger.getLogger(UITerminal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createActionPlanInformationPanel(){
        java.awt.GridBagConstraints gridBagConstraints;

        apInformationPanel = new javax.swing.JPanel();
        apPanel = new javax.swing.JPanel();
        actionLabel = new javax.swing.JLabel();
        planLabel = new javax.swing.JLabel();
        meetingNamePanel = new javax.swing.JPanel();
        meetingLabel = new javax.swing.JLabel();
        title1Label = new javax.swing.JLabel();
        title2Label = new javax.swing.JLabel();
        dotMenuLabel = new javax.swing.JLabel();
        ownerNamePanel = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        participantsPanel = new javax.swing.JPanel();
        participantsLabel = new javax.swing.JLabel();
        scrollParticipants = new javax.swing.JScrollPane();
        participantsTextArea = new javax.swing.JTextArea();
        totalActionsPanel = new javax.swing.JPanel();
        actionsLabel = new javax.swing.JLabel();
        actionValueLabel = new javax.swing.JLabel();
        completedActionPanel = new javax.swing.JPanel();
        completedLabel = new javax.swing.JLabel();
        completedValueLabel = new javax.swing.JLabel();
        appActionPanel = new javax.swing.JPanel();
        appLabel = new javax.swing.JLabel();
        appValueLabel = new javax.swing.JLabel();
        overdueActionPanel = new javax.swing.JPanel();
        overdueLabel = new javax.swing.JLabel();
        overdueValueLabel = new javax.swing.JLabel();
        teamPerformancePanel = new javax.swing.JPanel();
        performanceLabel = new javax.swing.JLabel();
        performanceValueLabel = new javax.swing.JLabel();
        planExecutionPanel = new javax.swing.JPanel();
        executionLabel = new javax.swing.JLabel();
        executionValueLabel = new javax.swing.JLabel();
        datePanel = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        dateValueLabel = new javax.swing.JLabel();
        filterLabelPanel = new javax.swing.JPanel();
        filterLabel = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        statusRadioButton = new javax.swing.JRadioButton();
        statusComboBox = new javax.swing.JComboBox<>();
        status2Label = new javax.swing.JLabel();
        dateRadioButton = new javax.swing.JRadioButton();
        dateComboBox = new javax.swing.JComboBox<>();
        date2Label = new javax.swing.JLabel();
        startLabel = new javax.swing.JTextField();
        endLabel = new javax.swing.JTextField();
        ownerRadioButton = new javax.swing.JRadioButton();
        owner2Label = new javax.swing.JLabel();
        owner2TextField = new javax.swing.JTextField();
        contentRadioButton = new javax.swing.JRadioButton();
        content2Label = new javax.swing.JLabel();
        hintTextField = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        addIcon = new javax.swing.JLabel();
        editIcon = new javax.swing.JLabel();
        deleteIcon = new javax.swing.JLabel();

        apInformationPanel.setBackground(new java.awt.Color(252, 254, 252));
        apInformationPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        apInformationPanel.setMinimumSize(new java.awt.Dimension(950, 250));
        apInformationPanel.setPreferredSize(new java.awt.Dimension(700, 250));
        apInformationPanel.setLayout(new java.awt.GridBagLayout());

               apPanel.setBackground(new java.awt.Color(0, 66, 118));
        apPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 2, new java.awt.Color(252, 254, 252)));
        apPanel.setMaximumSize(new java.awt.Dimension(164, 200));
        apPanel.setMinimumSize(new java.awt.Dimension(110, 200));
        apPanel.setPreferredSize(new java.awt.Dimension(120, 200));

        actionLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        actionLabel.setForeground(new java.awt.Color(252, 254, 252));
        actionLabel.setText("Action");

        planLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        planLabel.setForeground(new java.awt.Color(252, 254, 252));
        planLabel.setText("Plan");

        javax.swing.GroupLayout apPanelLayout = new javax.swing.GroupLayout(apPanel);
        apPanel.setLayout(apPanelLayout);
        apPanelLayout.setHorizontalGroup(
            apPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(apPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionLabel)
                    .addComponent(planLabel))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        apPanelLayout.setVerticalGroup(
            apPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(planLabel)
                .addContainerGap(100, Short.MAX_VALUE))
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
        title1Label.setText("Comité");

        title2Label.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        title2Label.setForeground(new java.awt.Color(252, 254, 252));
        title2Label.setText("Técnico");

        dotMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dotMenuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dotsMenu-24.png"))); // NOI18N
        dotMenuLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dotMenuLabel.setIconTextGap(0);

        javax.swing.GroupLayout meetingNamePanelLayout = new javax.swing.GroupLayout(meetingNamePanel);
        meetingNamePanel.setLayout(meetingNamePanelLayout);
        meetingNamePanelLayout.setHorizontalGroup(
            meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meetingNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(meetingNamePanelLayout.createSequentialGroup()
                        .addComponent(title1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(meetingLabel))
                    .addGroup(meetingNamePanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(title2Label, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(dotMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        meetingNamePanelLayout.setVerticalGroup(
            meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meetingNamePanelLayout.createSequentialGroup()
                .addGroup(meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(meetingNamePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(title1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addComponent(meetingLabel))
                .addGap(2, 2, 2)
                .addGroup(meetingNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(title2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dotMenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        title2Label.getAccessibleContext().setAccessibleName("Indicadores");

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

        surnameLabel.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(252, 254, 252));
        surnameLabel.setText("ORJUELA");

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
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ownerNamePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ownerLabel))
                    .addGroup(ownerNamePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(surnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ownerNamePanelLayout.setVerticalGroup(
            ownerNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ownerNamePanelLayout.createSequentialGroup()
                .addComponent(ownerLabel)
                .addGap(4, 4, 4)
                .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(surnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

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

        scrollParticipants.setBackground(new java.awt.Color(48, 49, 50));
        scrollParticipants.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 3, 0, 0));
        scrollParticipants.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollParticipants.setPreferredSize(new java.awt.Dimension(120, 48));

        participantsTextArea.setEditable(false);
        participantsTextArea.setBackground(new java.awt.Color(60, 63, 65));
        participantsTextArea.setColumns(16);
        participantsTextArea.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        participantsTextArea.setForeground(new java.awt.Color(252, 254, 252));
        participantsTextArea.setLineWrap(true);
        participantsTextArea.setRows(3);
        participantsTextArea.setTabSize(0);
        participantsTextArea.setText("SOR, WCO, HRI, DCE, OMA, MCI, RCP, CRO, JOA, MDM");
        participantsTextArea.setWrapStyleWord(true);
        participantsTextArea.setAutoscrolls(false);
        participantsTextArea.setBorder(null);
        participantsTextArea.setMinimumSize(new java.awt.Dimension(0, 150));
        participantsTextArea.setPreferredSize(new java.awt.Dimension(120, 52));
        scrollParticipants.setViewportView(participantsTextArea);

        javax.swing.GroupLayout participantsPanelLayout = new javax.swing.GroupLayout(participantsPanel);
        participantsPanel.setLayout(participantsPanelLayout);
        participantsPanelLayout.setHorizontalGroup(
            participantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(participantsPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(participantsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollParticipants, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
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
                .addComponent(scrollParticipants, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
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
        actionValueLabel.setText("100");
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
                    .addComponent(actionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap())
        );
        totalActionsPanelLayout.setVerticalGroup(
            totalActionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalActionsPanelLayout.createSequentialGroup()
                .addComponent(actionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
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
        completedValueLabel.setText("40");
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
                    .addComponent(completedValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addContainerGap())
        );
        completedActionPanelLayout.setVerticalGroup(
            completedActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completedActionPanelLayout.createSequentialGroup()
                .addComponent(completedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(completedValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
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
        appValueLabel.setText("35");
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
                    .addComponent(appValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
        );
        appActionPanelLayout.setVerticalGroup(
            appActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appActionPanelLayout.createSequentialGroup()
                .addComponent(appLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
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
        overdueValueLabel.setText("15");
        overdueValueLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout overdueActionPanelLayout = new javax.swing.GroupLayout(overdueActionPanel);
        overdueActionPanel.setLayout(overdueActionPanelLayout);
        overdueActionPanelLayout.setHorizontalGroup(
            overdueActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueActionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(overdueActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, overdueActionPanelLayout.createSequentialGroup()
                        .addGap(0, 144, Short.MAX_VALUE)
                        .addComponent(overdueLabel))
                    .addComponent(overdueValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        overdueActionPanelLayout.setVerticalGroup(
            overdueActionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overdueActionPanelLayout.createSequentialGroup()
                .addComponent(overdueLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overdueValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
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
        performanceValueLabel.setText("165%");
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
                    .addComponent(performanceValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addContainerGap())
        );
        teamPerformancePanelLayout.setVerticalGroup(
            teamPerformancePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamPerformancePanelLayout.createSequentialGroup()
                .addComponent(performanceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(performanceValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
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
        executionValueLabel.setText("106%");

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
                    .addComponent(executionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap())
        );
        planExecutionPanelLayout.setVerticalGroup(
            planExecutionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(planExecutionPanelLayout.createSequentialGroup()
                .addComponent(executionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(executionValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
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
        dateValueLabel.setText("2016-11-14");
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
                    .addComponent(dateValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
                .addContainerGap())
        );
        datePanelLayout.setVerticalGroup(
            datePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datePanelLayout.createSequentialGroup()
                .addComponent(dateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateValueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
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

        filterLabelPanel.setBackground(new java.awt.Color(230, 231, 234));
        filterLabelPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 2, new java.awt.Color(252, 254, 252)));
        filterLabelPanel.setMaximumSize(new java.awt.Dimension(164, 50));
        filterLabelPanel.setMinimumSize(new java.awt.Dimension(120, 50));
        filterLabelPanel.setPreferredSize(new java.awt.Dimension(164, 50));
        filterLabelPanel.setLayout(new java.awt.BorderLayout());

        filterLabel.setBackground(new java.awt.Color(230, 231, 234));
        filterLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        filterLabel.setForeground(new java.awt.Color(122, 120, 123));
        filterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filterLabel.setText("Filter by");
        filterLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        filterLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filterLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        filterLabel.setIconTextGap(0);
        filterLabel.setMaximumSize(new java.awt.Dimension(164, 24));
        filterLabel.setMinimumSize(new java.awt.Dimension(80, 24));
        filterLabel.setOpaque(true);
        filterLabel.setPreferredSize(new java.awt.Dimension(100, 24));
        filterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
             }
            public void mouseExited(java.awt.event.MouseEvent evt) {

            }
        });
        filterLabelPanel.add(filterLabel, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(filterLabelPanel, gridBagConstraints);

        statusPanel.setBackground(new java.awt.Color(0, 66, 118));
        statusPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 2, 4, 0, new java.awt.Color(252, 254, 252)));
        statusPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        statusPanel.setMinimumSize(new java.awt.Dimension(710, 50));
        statusPanel.setPreferredSize(new java.awt.Dimension(710, 50));

        statusRadioButton.setBackground(new java.awt.Color(0, 66, 118));
        statusRadioButton.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        statusRadioButton.setForeground(new java.awt.Color(252, 254, 252));
        statusRadioButton.setSelected(true);
        statusRadioButton.setIconTextGap(0);
        statusRadioButton.setMargin(new java.awt.Insets(0, 2, 0, 2));
        statusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             }
        });

        statusComboBox.setBackground(new java.awt.Color(252, 254, 252));
        statusComboBox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        statusComboBox.setForeground(new java.awt.Color(48, 49, 50));
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  --- Select ---", "Completed", "Overdue", "In Process", "Completed APP", "Near to Due Date", "Waiting to Start" }));
        statusComboBox.setBorder(null);
        statusComboBox.setMaximumSize(new java.awt.Dimension(149, 29));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             }
        });

        status2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        status2Label.setForeground(new java.awt.Color(252, 254, 252));
        status2Label.setText("status");

        dateRadioButton.setBackground(new java.awt.Color(0, 66, 118));
        dateRadioButton.setForeground(new java.awt.Color(252, 254, 252));
        dateRadioButton.setSelected(true);
        dateRadioButton.setIconTextGap(0);
        dateRadioButton.setMargin(new java.awt.Insets(0, 2, 0, 2));
        dateRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        dateComboBox.setBackground(new java.awt.Color(252, 254, 252));
        dateComboBox.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dateComboBox.setForeground(new java.awt.Color(48, 49, 50));
        dateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " -- Select --", "start Date", "due Date", "end Date" }));
        dateComboBox.setBorder(null);
        dateComboBox.setMaximumSize(new java.awt.Dimension(106, 29));
        dateComboBox.setMinimumSize(new java.awt.Dimension(90, 29));

        date2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        date2Label.setForeground(new java.awt.Color(252, 254, 252));
        date2Label.setText("date");

        startLabel.setBackground(new java.awt.Color(252, 254, 252));
        startLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        startLabel.setText("start");
        startLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        startLabel.setMinimumSize(new java.awt.Dimension(34, 27));
        startLabel.setPreferredSize(new java.awt.Dimension(27, 27));

        endLabel.setBackground(new java.awt.Color(252, 254, 252));
        endLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        endLabel.setText("end");
        endLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        endLabel.setMinimumSize(new java.awt.Dimension(34, 27));
        endLabel.setPreferredSize(new java.awt.Dimension(25, 27));

        ownerRadioButton.setBackground(new java.awt.Color(6, 66, 118));
        ownerRadioButton.setIconTextGap(0);
        ownerRadioButton.setMargin(new java.awt.Insets(0, 2, 0, 0));
        ownerRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        owner2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        owner2Label.setForeground(new java.awt.Color(252, 254, 252));
        owner2Label.setText("owner");

        owner2TextField.setBackground(new java.awt.Color(252, 254, 252));
        owner2TextField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        owner2TextField.setText("acronym");
        owner2TextField.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 3, 1, 1, new java.awt.Color(252, 254, 252)));
        owner2TextField.setCaretPosition(3);
        owner2TextField.setMinimumSize(new java.awt.Dimension(4, 27));
        owner2TextField.setPreferredSize(new java.awt.Dimension(54, 27));

        contentRadioButton.setBackground(new java.awt.Color(0, 66, 118));
        contentRadioButton.setIconTextGap(0);
        contentRadioButton.setMargin(new java.awt.Insets(0, 2, 0, 2));
        contentRadioButton.setMinimumSize(new java.awt.Dimension(0, 26));
        contentRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        content2Label.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        content2Label.setForeground(new java.awt.Color(252, 254, 252));
        content2Label.setText("content");
        content2Label.setMinimumSize(new java.awt.Dimension(0, 15));

        hintTextField.setBackground(new java.awt.Color(252, 254, 252));
        hintTextField.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        hintTextField.setText("hint");
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
                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date2Label)
                    .addComponent(dateRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(owner2Label)
                    .addComponent(ownerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(owner2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(content2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contentRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(hintTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
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
                        .addComponent(endLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(hintTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(owner2Label)
                        .addGap(2, 2, 2)
                        .addComponent(ownerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addComponent(content2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(contentRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status2Label)
                            .addComponent(date2Label))
                        .addGap(2, 2, 2)
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(statusRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(owner2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1, Short.MAX_VALUE))
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
        buttonsPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        buttonsPanel.setMinimumSize(new java.awt.Dimension(122, 50));
        buttonsPanel.setPreferredSize(new java.awt.Dimension(122, 50));
        buttonsPanel.setLayout(new javax.swing.BoxLayout(buttonsPanel, javax.swing.BoxLayout.LINE_AXIS));

        addIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/plusWhite24.png"))); // NOI18N
        addIcon.setToolTipText("Add Action");
        addIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addIcon.setIconTextGap(0);
        addIcon.setMaximumSize(new java.awt.Dimension(32767, 32767));
        addIcon.setMinimumSize(new java.awt.Dimension(36, 40));
        addIcon.setPreferredSize(new java.awt.Dimension(36, 40));
        buttonsPanel.add(addIcon);

        editIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editWhite24.png"))); // NOI18N
        editIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editIcon.setIconTextGap(0);
        editIcon.setMaximumSize(new java.awt.Dimension(32767, 32767));
        editIcon.setMinimumSize(new java.awt.Dimension(35, 40));
        editIcon.setPreferredSize(new java.awt.Dimension(35, 40));
        buttonsPanel.add(editIcon);

        deleteIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteWhite24.png"))); // NOI18N
        deleteIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteIcon.setIconTextGap(0);
        deleteIcon.setMaximumSize(new java.awt.Dimension(32767, 32767));
        deleteIcon.setMinimumSize(new java.awt.Dimension(35, 40));
        deleteIcon.setPreferredSize(new java.awt.Dimension(35, 40));
        buttonsPanel.add(deleteIcon);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        apInformationPanel.add(buttonsPanel, gridBagConstraints);
    }
}
