import java.util.Enumeration;

import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class ListProperties {
    public static void main(String args[]) throws Exception {
        //UIManager.setLookAndFeel(
          //    UIManager.getCrossPlatformLookAndFeelClassName());
        UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
        UIDefaults defaults = UIManager.getDefaults();
        Enumeration newKeys = defaults.keys();

        while (newKeys.hasMoreElements()) {
            Object obj = newKeys.nextElement();
            if(String.valueOf(obj).contains("Slider"))
                System.out.printf("%50s : %s\n", obj, UIManager.get(obj));
        }
    }
}