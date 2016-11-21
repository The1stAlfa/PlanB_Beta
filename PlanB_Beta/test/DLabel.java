import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DLabel extends JLabel
{

    Dimension size = new Dimension(70, 80);

    public DLabel(String text)
    {
        this.setText(text);
        this.setPreferredSize(size);
        this.setBorder(BorderFactory.createBevelBorder(TOP, Color.white, Color.black));
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = new Color(226, 218, 145);
        Color color2 = color1.brighter();
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(
                0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(20, 20, w, h);
        super.paintComponent(g);
    }

    public static void main(String[] args){
        JFrame f = new JFrame();
        DLabel l = new DLabel("HOLA");
        l.setForeground(Color.decode("#FCFEFC"));
        f.getContentPane().add(l);
        f.setMinimumSize(new Dimension(150, 150));
        f.setPreferredSize(new Dimension(200, 200));
        f.setVisible(true);

    }
}