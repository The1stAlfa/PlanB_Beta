package com.lafargeholcim.planb.view;

import com.sun.awt.AWTUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JWindow;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public final class SplashWindow extends JWindow{

	private static final long serialVersionUID = 1L;

	public SplashWindow(String filename, Frame frame, int waitTime){
		super(frame);
                JLabel splashLabel = new JLabel(new ImageIcon(getClass().getResource("/images/"+filename)));
                AWTUtilities.setWindowOpaque(this,false);
		getContentPane().add(splashLabel, BorderLayout.CENTER);
                setProgressBar();
                pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension labelSize = splashLabel.getPreferredSize();
		setLocation(screenSize.width/2 - (labelSize.width/2),screenSize.height/2 - (labelSize.height/2));

		final int pause = waitTime;
		final Runnable closerRunner = new Runnable(){
			public void run(){
				setVisible(false);
				dispose();
			}
		};
		
		Runnable waitRunner = new Runnable(){
			public void run(){
				try{
					Thread.sleep(pause);
					SwingUtilities.invokeAndWait(closerRunner);
				}
				catch(Exception e){
					e.printStackTrace();
                                }
			}
		};
		setVisible(true);
		Thread splashThread = new Thread(waitRunner, "SplashThread");
		splashThread.start();
	}
        
        public void setProgressBar(){
            JProgressBar progressBar = new JProgressBar();
            progressBar.setForeground(Color.decode("#1160AE"));
            progressBar.setValue(50);
            //progressBar.setIndeterminate(true);
            this.getContentPane().add(progressBar, BorderLayout.SOUTH);
        }
}
