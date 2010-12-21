package phoenix;

import java.io.IOException;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import phoenix.gui.MainMenu;


/**
 * @author Chris
 */
public class Phoenix extends JFrame {
    public static Properties settings;
    public static final int FWIDTH = 800;
    public static final int FHEIGHT = 700;

    private MainMenu menu = null;

    public static void main(String[] args) {
        Phoenix program = new Phoenix();
    }

    public static String getSetting(String ppty) {
        return settings.getProperty(ppty);
    }

    public Phoenix() {
       super();
       
        loadSettings();

        setTitle(getSetting("title"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        java.awt.Dimension screen_size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screen_size.width - FWIDTH) / 2, (screen_size.height - FHEIGHT) / 2, FWIDTH, FHEIGHT);

        setContentPane(getMainMenu());

        setVisible(true);
    }

    public void changePanel(JPanel toshow) {
        getContentPane().setVisible(false);
        setContentPane(toshow);
        getContentPane().setVisible(true);

    }

    public JPanel getMainMenu() {
        if(menu == null) {
            menu = new MainMenu(this);
        }
        return menu;
    }

    public void showMainMenu() {
        changePanel(getMainMenu());
    }
    
    private void loadSettings() {
        settings = new Properties();
        try {
            settings.load(getClass().getClassLoader().getResourceAsStream("phoenix/resources/Settings.ini"));
        } catch (IOException e) {
            System.out.println("Settings.ini " + e.getMessage());
            System.exit(1);
        }
    }

}
