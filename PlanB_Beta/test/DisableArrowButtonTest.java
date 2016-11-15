import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;

public final class DisableArrowButtonTest {
  public JComponent makeUI() {
    String[] items = {
      "JComboBox 111111111:", "JComboBox 222:", "JComboBox 33:"
    };
    JComboBox<String> comboBox0 = new JComboBox<>(items);
    JComboBox<String> comboBox1 = new MyComboBox1<>(items);
    JComboBox<String> comboBox2 = new MyComboBox2<>(items);
    comboBox0.setEditable(true);
    comboBox1.setEditable(true);
    comboBox2.setEditable(true);

    JPanel p = new JPanel();
    p.add(comboBox0);
    p.add(Box.createRigidArea(new Dimension(300, 40)));
    p.add(comboBox1);
    p.add(Box.createRigidArea(new Dimension(300, 40)));
    p.add(comboBox2);
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new DisableArrowButtonTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class MyComboBox1<E> extends JComboBox<E> {
  public MyComboBox1(E[] list) {
    super(list);
  }
  @Override public void updateUI() {
    super.updateUI();
    setUI(new BasicComboBoxUI() {
      @Override protected JButton createArrowButton() {
        return new JButton() {
          @Override public int getWidth() {
            return 0;
          }
        };
      }
    });
    setBorder(BorderFactory.createLineBorder(Color.GRAY));
  }
}

class MyComboBox2<E> extends JComboBox<E> {
  public MyComboBox2(E[] list) {
    super(list);
  }
  @Override public void updateUI() {
    super.updateUI();
    UIManager.put("ComboBox.squareButton", Boolean.FALSE);
    setUI(new BasicComboBoxUI() {
      @Override protected JButton createArrowButton() {
        JButton b = new JButton();
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setVisible(false);
        return b;
      }
    });
    setBorder(BorderFactory.createLineBorder(Color.GRAY));
  }
}