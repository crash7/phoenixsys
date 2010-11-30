package phoenix.gui;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import phoenix.Phoenix;

/**
 * @author Luis
 */
public class Orders extends JPanel {
    Phoenix program;
    JPanel header, content;

    public Orders(Phoenix prg) {
        super(null, false);
        program = prg;
        makeHeader();
        makeContent();
        add(header);
        add(content);
    }

    private void makeHeader() {
        JButton addorder, searchorder;
        JTextField searchbox;


    }

    private void makeContent() {

    }

    private void makeContentEditable() {

    }

}
