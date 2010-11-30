package phoenix.gui;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import phoenix.Phoenix;

/**
 * @author Luis
 */
public class Orders extends JPanel {
    Phoenix program;
    JPanel header, content, editable_content, footer;

    public Orders(Phoenix prg) {
        super(null, false);
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        program = prg;
        makeHeader();
        makeContent();
        makeFooter();
        add(header);
        add(footer);
        //add(content);
        
    }

    private void makeHeader() {
        header = new JPanel(null, false);

        JButton addorder = new JButton("xx");
        JButton searchorder = new JButton();
        JTextField searchbox = new JTextField();

        addorder.setBounds(80, 20, 100,100);



        header.add(addorder);

    }

    private void makeFooter() {
        footer = new JPanel(null, false);

        JButton addorder = new JButton("yy");
        JButton searchorder = new JButton();
        

        addorder.setBounds(180, 20, 100,100);



        footer.add(addorder);

    }

    private void makeContent() {
        content = new JPanel(null, false);
    }

    private void makeContentEditable() {

    }

}
