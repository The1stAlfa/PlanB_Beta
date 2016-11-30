import java.awt.event.*;
import javax.swing.*;

public class WaitEnabledDialog extends JDialog {
  public WaitEnabledDialog(final JFrame owner, String title) {
    super(owner, title, false);
    addWindowListener(new WindowAdapter() {
      public void windowOpened(WindowEvent e) {
        CursorToolkitTwo.startWaitCursor(owner.getRootPane());
      }
      public void windowClosing(WindowEvent e) {
        CursorToolkitTwo.stopWaitCursor(owner.getRootPane());
      }
    });
  }
}