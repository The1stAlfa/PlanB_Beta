/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.<a href="
 * https://icons8.com/web-app/98/Plus-Math">Plus math icon credits</a>
 */

package com.lafargeholcim.planb.view;

import com.lafargeholcim.planb.util.CursorToolkit;
import com.lafargeholcim.planb.init.Aps;
import com.lafargeholcim.planb.model.APSummary;
import com.lafargeholcim.planb.model.ActionItemFilter;
import com.lafargeholcim.planb.model.ActionPlan;
import com.lafargeholcim.planb.model.Collaborator;
import com.lafargeholcim.planb.model.Meeting;
import com.lafargeholcim.planb.model.Status;
import com.lafargeholcim.planb.model.WorkTeam;
import com.lafargeholcim.planb.util.Time;
import com.lafargeholcim.planb.view.colors.ColorsDarcula;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.sql.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;

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
    private JPanel contentPanel, highlightPanel, optionsContentPanel, mainPanel, dashboardPanel;
    private static ActionPlansPane actionPlanPanel;
    private MeetingsPane meetingPanel;
    private JLabel initImageLabel; 
    private JTable actionListTable; 
    private JPanel h1,h2,h3,h4,h5,h6,h7;
    private boolean menuFlag = false, clickFlag = false;
       
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
    
    private void createActionPlanPanel() throws Exception{
        actionPlanPanel = new ActionPlansPane(getInterface());
    }
    
    private void createDashboardPanel(){
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());
        dashboardPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        dashboardPanel.setBackground(Color.decode("#3C3F41"));
        initImageLabel = new JLabel();
        initImageLabel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        initImageLabel.setPreferredSize(new Dimension(500,328));
        //BufferedImage img = null;
        //try {
         //   img = ImageIO.read(getClass().getResource("/images/plantAtNight12.png"));
        //} catch (IOException e) {
            //e.printStackTrace();
        //}
        //Image dimg = img.getScaledInstance(200, 200,
        //Image.SCALE_SMOOTH);
        initImageLabel = new JLabel(new ImageIcon(new ImageIcon(
              getClass().getResource("/images/plantAtNight12.png"))
                .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        //initImageLabel.setIcon(new ImageIcon(dimg));
        
        dashboardPanel.add(initImageLabel,BorderLayout.CENTER);
        
    }
    
    private void createMainMenu(){ 
        mainMenu = new JMenuBar();
        dashboardMenu = new JMenuItem("   DashBoard"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        meetingMenu = new JMenuItem("   Meeting"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        actionPlanMenu = new JMenuItem("   Action Plan"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        teamMenu = new JMenuItem("   Team"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        profileMenu = new JMenuItem("   Profile"){ 
            public Point getToolTipLocation(MouseEvent e) {
                return new Point(5, -15);
            }
        };
        settingsMenu = new JMenuItem("   Settings"){ 
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
        mainMenu.setBackground(Color.decode("#3C3F41")); //EDEBEB
        mainMenu.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.decode("#303132")));

        mainMenu.add(createMainMenuItem(menuItem, "menu.png"));
        mainMenu.add(createMainMenuItem(dashboardMenu, "dashboard.png"));
        mainMenu.add(createMainMenuItem(meetingMenu, "meeting.png"));
        mainMenu.add(createMainMenuItem(actionPlanMenu, "actionPlan.png"));
        mainMenu.add(createMainMenuItem(teamMenu, "team.png"));
        mainMenu.add(createMainMenuItem(profileMenu, "user.png"));
        mainMenu.add(Box.createVerticalGlue());
        mainMenu.add(createMainMenuItem(settingsMenu, "settings.png"));
        
        mainMenuEvents(menuItem);
        mainMenuEvents(dashboardMenu);
        mainMenuEvents(meetingMenu);
        mainMenuEvents(actionPlanMenu);
        mainMenuEvents(teamMenu);
        mainMenuEvents(profileMenu);
        mainMenuEvents(settingsMenu);

    }
    
    private JMenuItem createMainMenuItem(JMenuItem item, String iconName){
        item.setBackground(Color.decode("#3C3F41"));
        //item.setFont(new Font("Roboto-Regular", Font.PLAIN, 14));
        item.setForeground(Color.decode("#E3E3E3"));
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
    
    private void createMeetingPanel(){
        meetingPanel = new MeetingsPane();
        meetingPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        meetingPanel.setBackground(Color.decode("#3C3F41"));
    }
    
    private void createOptionsContentPanel() throws Exception{
        optionsContentPanel = new JPanel();
        optionsContentPanel.setBackground(Color.decode("#3C3F41"));
        optionsContentPanel.setMaximumSize(new Dimension(
                Short.MAX_VALUE, Short.MAX_VALUE));
        optionsContentPanel.setPreferredSize(new Dimension(
                Short.MAX_VALUE, Short.MAX_VALUE));
        optionsContentPanel.setLayout(new BorderLayout());
        JPanel startPanel = new JPanel();
        startPanel.setBackground(Color.decode("#45494A"));
        startPanel.setPreferredSize(new Dimension(
                Short.MAX_VALUE, 45));
        startPanel.setMaximumSize(new Dimension(
                Short.MAX_VALUE, 65));
        startPanel.setLayout(new BoxLayout(startPanel, BoxLayout.LINE_AXIS));
        String welcome = "  WELCOME, " + 
                Aps.getTerminal().getUser().getUsername();
        JLabel startLabel = new JLabel(welcome);
        startLabel.setForeground(Color.decode("#FCFEFC"));
        JLabel planbLabel = new JLabel("PlanB System  "); 
        planbLabel.setForeground(Color.decode("#FCFEFC"));
        startPanel.add(startLabel);
        startPanel.add(Box.createHorizontalGlue());
        startPanel.add(planbLabel);
        startPanel.setBorder(BorderFactory
                .createMatteBorder(8,8,4,8, Color.decode("#3C3F41")));
        createDashboardPanel();
        createMeetingPanel();
        createActionPlanPanel();
        initImageLabel = new JLabel();
        initImageLabel.setPreferredSize(new Dimension(500,328));
        initImageLabel.setBorder(BorderFactory
                .createMatteBorder(4,8,4,8, Color.decode("#3C3F41")));
        optionsContentPanel.add(startPanel, BorderLayout.NORTH);
        optionsContentPanel.add(initImageLabel,BorderLayout.CENTER);
    }
    
    public void disableFrame(){
        this.setEnabled(false);
    }
    
    public UITerminal getInterface(){
        return this;
    }
    
    public ActionPlansPane getActionPlansPane(){
        return this.actionPlanPanel;
    }

    private void initComponents() throws FontFormatException, Exception{
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWindowListener();
        setPreferredSize(new Dimension(1000, 700));
        setMinimumSize(new Dimension(800,600));
        setResizable(true);
        
        UIManager.put("ToolTip.background", Color.decode("#303132"));
        UIManager.put("ToolTip.foreground", Color.decode("#C9CDD1"));
        UIManager.put("ProgressBar.selectionForeground", Color.decode("#FCFEFC"));
        UIManager.put("ProgressBar.selectionBackground", Color.decode("#FCFEFC"));
        Border border = BorderFactory.createMatteBorder(1,1,1,1,Color.decode("#3B3C3D"));
        UIManager.put("ToolTip.border", border);
        setIconImage(new ImageIcon(getClass().getResource("/images/planB-27x32.png")).getImage());
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
        highlightPanel.setBackground(Color.decode("#3C3F41"));
        setHighlightPanels();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.decode(ColorsDarcula.BLACK.code));
        contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.decode("#F8FAF8")));
        contentPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(highlightPanel, BorderLayout.WEST);
        contentPanel.add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(optionsContentPanel,BorderLayout.CENTER);
        mainPanel.add(mainMenu,BorderLayout.WEST);
        getContentPane().setBackground(Color.decode(ColorsDarcula.BLACK.code));
        addFonts();
        setContentPane(contentPanel);
        this.getRootPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                if(getInterface().getExtendedState() != 6){
                    mainMenu.setPreferredSize(new Dimension(40,600));
                    mainPanel.repaint();
                    mainPanel.revalidate();
                    menuItem.setToolTipText("Maximize Navigation Bar");
                    menuFlag = false;
                    initImageLabel.setIcon(new ImageIcon(new ImageIcon(
                        getClass().getResource("/images/plantAtNight12.png"))
                        .getImage().getScaledInstance(optionsContentPanel.getSize().width + 100,
                                optionsContentPanel.getSize().height - 45, Image.SCALE_SMOOTH)));
                    mainPanel.repaint();
                }
                else{
                    mainMenu.setPreferredSize(new Dimension(140,600));
                    mainPanel.repaint();
                    mainPanel.revalidate();
                    menuItem.setToolTipText("Minimize Navigation Bar");
                    menuFlag = true;
                    initImageLabel.setIcon(new ImageIcon(new ImageIcon(
                        getClass().getResource("/images/plantAtNight12.png"))
                        .getImage().getScaledInstance(optionsContentPanel.getSize().width ,
                                optionsContentPanel.getSize().height - 65, Image.SCALE_SMOOTH)));
                    mainPanel.repaint();
                }
            }
        });
        pack();
        setExtendedState(6);
        this.setTitle("PlanB v1.0");        
        setVisible(true);
        
    }

    private void mainMenuEvents(JMenuItem item){
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(Color.decode("#4B6EAF")); // CDCFCD
                if(item.equals(menuItem))
                    h1.setBackground(Color.decode("#4B6EAF"));
                if(!item.equals(itemFlag)){    
                    if(item.equals(dashboardMenu))
                        h2.setBackground(Color.decode("#4B6EAF"));
                    else if(item.equals(meetingMenu))
                        h3.setBackground(Color.decode("#4B6EAF"));
                    else if(item.equals(actionPlanMenu))
                        h4.setBackground(Color.decode("#4B6EAF"));
                    else if(item.equals(teamMenu))
                        h5.setBackground(Color.decode("#4B6EAF"));
                    else if(item.equals(profileMenu))
                        h6.setBackground(Color.decode("#4B6EAF"));
                    else if(item.equals(settingsMenu))
                        h7.setBackground(Color.decode("#4B6EAF"));
                }
                item.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                item.setBackground(Color.decode("#3C3F41")); // EDEBEB
                if(item.equals(menuItem))
                    h1.setBackground(Color.decode("#3C3F41"));
                if(!item.equals(itemFlag)){    
                    if(item.equals(dashboardMenu))
                        h2.setBackground(Color.decode("#3C3F41"));
                    else if(item.equals(meetingMenu))
                        h3.setBackground(Color.decode("#3C3F41"));
                    else if(item.equals(actionPlanMenu))
                        h4.setBackground(Color.decode("#3C3F41"));
                    else if(item.equals(teamMenu))
                        h5.setBackground(Color.decode("#3C3F41"));
                    else if(item.equals(profileMenu))
                        h6.setBackground(Color.decode("#3C3F41"));
                    else if(item.equals(settingsMenu))
                        h7.setBackground(Color.decode("#3C3F41"));
                }
                item.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                if(item.equals(menuItem)){
                    if(!menuFlag){
                        mainMenu.setPreferredSize(new Dimension(140,600));
                        mainPanel.repaint();
                        mainPanel.revalidate();
                        if(getInterface().getExtendedState() != 6){
                            initImageLabel.setIcon(new ImageIcon(new ImageIcon(
                            getClass().getResource("/images/plantAtNight12.png"))
                            .getImage().getScaledInstance(optionsContentPanel.getSize().width - 100,
                                    optionsContentPanel.getSize().height - 45, Image.SCALE_SMOOTH)));
                        }
                        else{
                            initImageLabel.setIcon(new ImageIcon(new ImageIcon(
                            getClass().getResource("/images/plantAtNight12.png"))
                            .getImage().getScaledInstance(optionsContentPanel.getSize().width - 100,
                                    optionsContentPanel.getSize().height - 65, Image.SCALE_SMOOTH)));
                        }
                        mainPanel.repaint();
                        menuItem.setToolTipText("Minimize Navigation Bar");
                        menuFlag = true;
                    }
                    else{
                        mainMenu.setPreferredSize(new Dimension(40,600));
                        mainPanel.repaint();
                        if(getInterface().getExtendedState() != 6){
                            initImageLabel.setIcon(new ImageIcon(new ImageIcon(
                            getClass().getResource("/images/plantAtNight12.png"))
                            .getImage().getScaledInstance(optionsContentPanel.getSize().width + 100,
                                    optionsContentPanel.getSize().height - 45, Image.SCALE_SMOOTH)));
                        }
                        else{
                            initImageLabel.setIcon(new ImageIcon(new ImageIcon(
                            getClass().getResource("/images/plantAtNight12.png"))
                            .getImage().getScaledInstance(optionsContentPanel.getSize().width + 100,
                                    optionsContentPanel.getSize().height - 65, Image.SCALE_SMOOTH)));
                        }
                        mainPanel.repaint();
                        menuItem.setToolTipText("Maximize Navigation Bar");
                        menuFlag = false;
                    }
                }
                else if(item.equals(dashboardMenu)){
                    optionsContentPanel.removeAll();
                    optionsContentPanel.add(dashboardPanel, BorderLayout.CENTER);
                    h2.setBackground(Color.decode("#4B6EAF"));
                    h3.setBackground(Color.decode("#3C3F41"));
                    h4.setBackground(Color.decode("#3C3F41"));
                    h5.setBackground(Color.decode("#3C3F41"));
                    h6.setBackground(Color.decode("#3C3F41"));
                    h7.setBackground(Color.decode("#3C3F41"));
                    itemFlag = dashboardMenu;                  
                    optionsContentPanel.repaint();
                }
                else if(item.equals(meetingMenu)){
                    optionsContentPanel.removeAll();
                    optionsContentPanel.add(meetingPanel, BorderLayout.CENTER);
                    h2.setBackground(Color.decode("#3C3F41"));
                    h3.setBackground(Color.decode("#4B6EAF"));
                    h4.setBackground(Color.decode("#3C3F41"));
                    h5.setBackground(Color.decode("#3C3F41"));
                    h6.setBackground(Color.decode("#3C3F41"));
                    h7.setBackground(Color.decode("#3C3F41"));
                    itemFlag = meetingMenu;
                    optionsContentPanel.repaint();
                    optionsContentPanel.revalidate();
                }
                else if(item.equals(actionPlanMenu)){
                    optionsContentPanel.removeAll();
                    optionsContentPanel.add(actionPlanPanel, BorderLayout.CENTER);
                    h2.setBackground(Color.decode("#3C3F41"));
                    h3.setBackground(Color.decode("#3C3F41"));
                    h4.setBackground(Color.decode("#4B6EAF"));
                    h5.setBackground(Color.decode("#3C3F41"));
                    h6.setBackground(Color.decode("#3C3F41"));
                    h7.setBackground(Color.decode("#3C3F41"));
                    itemFlag = actionPlanMenu;
                    optionsContentPanel.repaint();
                    optionsContentPanel.revalidate();
                }
                else if(item.equals(teamMenu)){
                    h2.setBackground(Color.decode("#3C3F41"));
                    h3.setBackground(Color.decode("#3C3F41"));
                    h4.setBackground(Color.decode("#3C3F41"));
                    h5.setBackground(Color.decode("#4B6EAF"));
                    h6.setBackground(Color.decode("#3C3F41"));
                    h7.setBackground(Color.decode("#3C3F41"));
                    itemFlag = teamMenu;
                }
                else if(item.equals(profileMenu)){
                    h2.setBackground(Color.decode("#3C3F41"));
                    h3.setBackground(Color.decode("#3C3F41"));
                    h4.setBackground(Color.decode("#3C3F41"));
                    h5.setBackground(Color.decode("#3C3F41"));
                    h6.setBackground(Color.decode("#4B6EAF"));
                    h7.setBackground(Color.decode("#3C3F41"));
                    itemFlag = profileMenu;
                }
                else if(item.equals(settingsMenu)){
                    h2.setBackground(Color.decode("#3C3F41"));
                    h3.setBackground(Color.decode("#3C3F41"));
                    h4.setBackground(Color.decode("#3C3F41"));
                    h5.setBackground(Color.decode("#3C3F41"));
                    h6.setBackground(Color.decode("#3C3F41"));
                    h7.setBackground(Color.decode("#4B6EAF"));
                    itemFlag = settingsMenu;
                }
            }
        }); 
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
    
    private void setHighlightPanels(){
        h1 = new JPanel();
        h2 = new JPanel();
        h3 = new JPanel();
        h4 = new JPanel();
        h5 = new JPanel();
        h6 = new JPanel();
        h7 = new JPanel();
        
        h1.setBackground(Color.decode("#3C3F41"));
        h2.setBackground(Color.decode("#3C3F41"));
        h3.setBackground(Color.decode("#3C3F41"));
        h4.setBackground(Color.decode("#3C3F41"));
        h5.setBackground(Color.decode("#3C3F41"));
        h6.setBackground(Color.decode("#3C3F41"));
        h7.setBackground(Color.decode("#3C3F41"));
        
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
}
