package phoenix.gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import phoenix.Phoenix;

/**
 * @author Luis
 */
public class Orders extends JPanel {
    Phoenix program;
    JPanel header, content, editable_content, footer;

    public Orders(Phoenix prg) {
        super(null, false);
        program = prg;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        makeHeader();
        makeContent();
        makeFooter();
        
        add(header, 0);
        add(content,1);
        add(footer, 2);
    }

    private void makeHeader() {
        header = new JPanel(null, false);

        header.setBackground(Color.red);

        JButton addorder = new JButton();
        JButton searchorder = new JButton();
        JTextField searchbox = new JTextField("Buscar orden..");

        addorder.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/add.gif")));
        searchorder.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/search.gif")));

        addorder.setBounds(10, 10, 40, 40);
        searchorder.setBounds(Phoenix.FWIDTH-90, 10, 60, 40);
        searchbox.setBounds(Phoenix.FWIDTH-340, 10, 250, 40);

        header.add(addorder);
        header.add(searchorder);
        header.add(searchbox);
    }

    private void makeFooter() {
        footer = new JPanel(null, false);

        footer.setBackground(Color.black);

        JButton addorder = new JButton("yy");
        JButton searchorder = new JButton();
        

        addorder.setBounds(180, 20, 100,100);



        footer.add(addorder);

    }

    private void makeContent() {
        content = new JPanel(null, false);

        content.setPreferredSize(new Dimension(800,20));

        JLabel oid = new JLabel("Numero de orden: ");
        JLabel clientname = new JLabel("Nombre: ");
        JLabel clientsurname = new JLabel("Apellido: ");
        JLabel deliveryto = new JLabel("Lugar de entrega: ");
        JLabel dateadded = new JLabel("Fecha de creacion: ");
        JLabel description = new JLabel("Descripción: ");
        JLabel ammount = new JLabel("Monto: ");
        JLabel status = new JLabel("Estado actual: ");

        oid.setBounds(0, 0, 200, 50);
        clientname.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        clientsurname.setBounds(WIDTH, WIDTH, WIDTH, WIDTH);
        

        content.add(oid);
    }

    private void makeContentEditable() {

    }

}
