
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalSliderUI;
import javax.swing.plaf.metal.OceanTheme;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AI-Saac
 */
public class TestSlider extends MetalSliderUI{
    private Icon icon;
    
    public TestSlider(Icon icon) {
        this.icon = icon;
    }

     
    public void paintTrack(Graphics g)
    {
      Color shadowColor = MetalLookAndFeel.getControlShadow();
      if (slider.getOrientation() == JSlider.HORIZONTAL)
        {
          int trackX = trackRect.x;
          int trackY = trackRect.y + (trackRect.height - getTrackWidth()) / 2;
          int trackW = trackRect.width;
          int trackH = getTrackWidth();
          
          // draw border
          if (slider.isEnabled())
            BasicGraphicsUtils.drawEtchedRect(g, trackX, trackY, trackW, trackH, 
                darkShadowColor, shadowColor, darkShadowColor, highlightColor);
          else
            {
              g.setColor(MetalLookAndFeel.getControlShadow());
              g.drawRect(trackX, trackY, trackW - 2, trackH - 2);
            }
  
          // fill track (if required)
          if (true)
            {
             if (slider.isEnabled())
               {
                 int xPos = xPositionForValue(slider.getValue());
                 int x = slider.getInverted() ? xPos : trackRect.x;
                 int w = slider.getInverted() ? trackX + trackW - xPos 
                                              : xPos - trackRect.x;
                 //g.setColor(Color.decode("#999999"));
                 g.setColor(MetalLookAndFeel.getBlack());
                 g.drawLine(x + 1, trackY + 1, x + w - 3, trackY + 1);
                 g.setColor(Color.decode("#75fe10"));
                 //g.setColor(UIManager.getColor("Slider.altTrackColor"));
                 g.drawLine(x + 1, trackY + 2, x + w - 3, trackY + 2);
                 g.setColor(Color.decode("#75fe10"));
                 //g.setColor(MetalLookAndFeel.getControlShadow());
                 g.drawLine(x + 1, trackY + 3, x + w - 3, trackY + 3);
                 g.setColor(Color.decode("#75fe10"));
                 //g.setColor(MetalLookAndFeel.getPrimaryControlShadow());
                 g.drawLine(x + 1, trackY + 4, x + w - 3, trackY + 4);
               }
           }
         else if (filledSlider) 
           {
             int xPos = xPositionForValue(slider.getValue());
             int x = slider.getInverted() ? xPos : trackRect.x;
             int w = slider.getInverted() ? trackX + trackW - xPos 
                                         : xPos - trackRect.x;
             g.setColor(Color.decode("#1160AE"));
             //g.setColor(MetalLookAndFeel.getControlShadow());
             g.fillRect(x + 1, trackY + 1, w - 3, getTrackWidth() - 3);
             if (slider.isEnabled())
               {
                   g.setColor(Color.decode("#1160AE"));
                 //g.setColor(MetalLookAndFeel.getControl());
                 g.drawLine(x + 1, trackY + 1, x + w - 3, trackY + 1);
                 g.drawLine(x + 1, trackY + 1, x + 1, 
                            trackY + getTrackWidth() - 3);
               }
           }
       }
     else
       {
         int trackX = trackRect.x  + (trackRect.width - getTrackWidth()) / 2;
         int trackY = trackRect.y;
         int trackW = getTrackWidth();
         int trackH = trackRect.height;
          if (slider.isEnabled())
            BasicGraphicsUtils.drawEtchedRect(g, trackX, trackY, trackW, trackH, 
                darkShadowColor, shadowColor, darkShadowColor, highlightColor);
          else
            {
              g.setColor(MetalLookAndFeel.getControlShadow());
              g.drawRect(trackX, trackY, trackW - 2, trackH - 2);
            }
  
          // Fill track if necessary.
          if (MetalLookAndFeel.getCurrentTheme() instanceof OceanTheme)
            {
              if (slider.isEnabled())
                {
                  int yPos = yPositionForValue(slider.getValue());
                  int y = slider.getInverted() ? trackY : yPos;
                  int h = slider.getInverted() ? yPos - trackY 
                          : trackY + trackH - yPos;
                  
                  g.setColor(MetalLookAndFeel.getWhite());
                  g.drawLine(trackX + 1, y + 1, trackX + 1, y + h - 3);
                  g.setColor(UIManager.getColor("Slider.altTrackColor"));
                  g.drawLine(trackX + 2, y + 1, trackX + 2, y + h - 3);
                  //g.setColor(Color.decode("#11160AE"));
                  g.setColor(MetalLookAndFeel.getControlShadow());
                  g.drawLine(trackX + 3, y + 1, trackX + 3, y + h - 3);
                  g.setColor(MetalLookAndFeel.getPrimaryControlShadow());
                  g.drawLine(trackX + 4, y + 1, trackX + 4, y + h - 3);
                }
            }
          else if (filledSlider) 
            {
           int yPos = yPositionForValue(slider.getValue());
           int y = slider.getInverted() ? trackY : yPos;
           int h = slider.getInverted() ? yPos - trackY 
                   : trackY + trackH - yPos;
           g.setColor(MetalLookAndFeel.getControlShadow());
           g.fillRect(trackX + 1, y + 1, getTrackWidth() - 3, h - 3);
           if (slider.isEnabled())
             {
               g.setColor(MetalLookAndFeel.getControl());
               g.drawLine(trackX + 1, y + 1, trackX + trackW - 3, y + 1);
               g.drawLine(trackX + 1, y + 1, trackX + 1, y + h - 3);
             }
           }
       }
   }
   
    public void paintFocus(Graphics g)
    {
      paintThumb(g);
      thumbColor = getFocusColor();
      paintThumb(g);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Icon i = null;
        try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.metal.MetaLookAndFeel");
                //i = UIManager.getIcon("Slider.horizontalThumbIcon");
                //UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
                
        } catch (Exception ex) {
                System.out.println("MALito");
        }
        JSlider slider = new JSlider();
        slider.setValue(30);
        //slider.setPaintTicks(true);
        //slider.setPaintLabels(true);
        //slider.setMinorTickSpacing(5);
        //slider.setMajorTickSpacing(25);
        slider.setUI(new TestSlider(i));

        frame.add(slider);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
