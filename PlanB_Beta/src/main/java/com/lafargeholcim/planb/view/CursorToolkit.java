package com.lafargeholcim.planb.view;

import java.awt.event.*;
import javax.swing.*;

/** Basic CursorToolkit that swallows mouseclicks */
public class CursorToolkit implements Cursors {
  private final static MouseAdapter mouseAdapter = 
    new MouseAdapter() {};

  private CursorToolkit() {}

  /** Sets cursor for specified component to Wait cursor */
  public static void startWaitCursor(JComponent component) { 
    RootPaneContainer root =
      ((RootPaneContainer) component.getTopLevelAncestor()); 
    root.getGlassPane().setCursor(WAIT_CURSOR);
    root.getGlassPane().addMouseListener(mouseAdapter);
    root.getGlassPane().setVisible(true);
  }
  
  /** Sets cursor for specified component to normal cursor */
  public static void stopWaitCursor(JComponent component) { 
    RootPaneContainer root =
      ((RootPaneContainer) component.getTopLevelAncestor()); 
    root.getGlassPane().setCursor(DEFAULT_CURSOR);
    root.getGlassPane().removeMouseListener(mouseAdapter);
    root.getGlassPane().setVisible(false);
  
    }
}