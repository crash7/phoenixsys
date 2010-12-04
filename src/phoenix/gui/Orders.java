package phoenix.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import phoenix.Phoenix;

/**
 * @author Chris
 */
public class Orders extends JPanel {

    Phoenix program;
    JPanel header, content;

    public Orders(Phoenix prg) {
        super(null, false);
        program = prg;

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBackground(java.awt.Color.GRAY);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                requestFocus();
            }
        });

        header = new JPanel(null, false);
        content = new JPanel(null, false);

        makeHeader();
        makeEmptyContent();

        add(header, 0);
        add(content, 1);
    }

    private void makeHeader() {
        Dimension size = new Dimension(Phoenix.FWIDTH, 70);

        header.setBackground(getBackground());

        header.setPreferredSize(size);
        header.setMinimumSize(size);
        header.setMaximumSize(size);

        JButton addorder = new JButton();
        JButton seeorders = new JButton("Ver trabajos realizados");
        JButton searchorder = new JButton();
        JTextField searchbox = new JTextField("Buscar orden..");

        addorder.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/add.gif")));
        searchorder.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/search.gif")));

        addorder.setBounds(10, 10, 40, 40);
        seeorders.setBounds(100, 10, 200, 40);
        searchorder.setBounds(Phoenix.FWIDTH - 90, 10, 60, 40);
        searchbox.setBounds(Phoenix.FWIDTH - 340, 10, 250, 40);

        addorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        seeorders.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //cargar trabajos con estado finalizado?
                    }
                });
        searchorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton r = (JButton) e.getSource();
                        JTextField tf = (JTextField) r.getParent().getComponent(3);
                        searchThis(tf.getText());
                    }
                });
        searchbox.addFocusListener(new FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JTextField field = (JTextField) evt.getSource();
                field.setText("");
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                JTextField field = (JTextField) evt.getSource();
                if (field.getText().isEmpty()) {
                    field.setText("Buscar orden..");
                }
            }
        });

        header.add(addorder, 0);
        header.add(seeorders, 1);
        header.add(searchorder, 2);
        header.add(searchbox, 3);
    }

    private void makeEmptyContent() {
        Dimension size = new Dimension(Phoenix.FWIDTH, Phoenix.FHEIGHT - 70);

        content.removeAll();
        content.setBackground(getBackground());

        content.setPreferredSize(size);
        content.setMinimumSize(size);
        content.setMaximumSize(size);

        updateUI();
    }

    private void loadOrder(int order) {
        makeEmptyContent();

        JLabel oid = new JLabel("Numero de orden: " + order);
        JLabel clientname = new JLabel("Nombre: ");
        JLabel clientsurname = new JLabel("Apellido: ");
        JLabel deliveryto = new JLabel("Lugar de entrega: ");
        JLabel dateadded = new JLabel("Fecha de creacion: ");
        JLabel description = new JLabel("Descripción: ");
        JLabel ammount = new JLabel("Monto: ");
        JLabel status = new JLabel("Estado actual: ");

        JButton createpreorder = new JButton("Crear presupuesto");
        JButton currentpreorder = new JButton("Ver presupuesto asignado");
        JButton seepreorders = new JButton("Ver presupuestos");
        JButton history = new JButton("Ver historial");
        JButton billthis = new JButton("Facturar");
        JButton editorder = new JButton("Editar");

        JLabel clientname_value = new JLabel("Fofito");
        JLabel clientsurname_value = new JLabel("Salta");
        JLabel deliveryto_value = new JLabel("#esta");
        JLabel dateadded_value = new JLabel("27-10-2010");
        JLabel description_value = new JLabel("Vamo lo pibe'");
        JLabel ammount_value = new JLabel("99999");
        JLabel status_value = new JLabel("Muerto");

        oid.setBounds(0, 0, 200, 10);
        clientname.setBounds(0, 15, 200, 10);
        clientsurname.setBounds(0, 30, 200, 10);
        deliveryto.setBounds(0, 45, 200, 10);
        dateadded.setBounds(0, 60, 200, 10);
        description.setBounds(0, 75, 200, 10);
        ammount.setBounds(0, 90, 200, 10);
        status.setBounds(0, 105, 200, 10);

        createpreorder.setBounds(10, 200, 100, 40);
        currentpreorder.setBounds(10, 250, 100, 40);
        seepreorders.setBounds(10, 300, 100, 40);
        history.setBounds(10, 350, 100, 40);
        billthis.setBounds(10, 400, 100, 40);
        editorder.setBounds(10, 450, 100, 40);

        clientname_value.setBounds(200, 15, 200, 10);
        clientsurname_value.setBounds(200, 30, 200, 10);
        deliveryto_value.setBounds(200, 45, 200, 10);
        dateadded_value.setBounds(200, 60, 200, 10);
        description_value.setBounds(200, 75, 200, 10);
        ammount_value.setBounds(200, 90, 200, 10);
        status_value.setBounds(200, 105, 200, 10);


        createpreorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        currentpreorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        seepreorders.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        history.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        billthis.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
        editorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        makeOrderEditable();
                    }
                });

        content.add(oid, 0);
        content.add(clientname, 1);
        content.add(clientsurname, 2);
        content.add(deliveryto, 3);
        content.add(dateadded, 4);
        content.add(description, 5);
        content.add(ammount, 6);
        content.add(status, 7);

        content.add(clientname_value, 8);
        content.add(clientsurname_value, 9);
        content.add(deliveryto_value, 10);
        content.add(dateadded_value, 11);
        content.add(description_value, 12);
        content.add(ammount_value, 13);
        content.add(status_value, 14);

        content.add(createpreorder, 15);
        content.add(currentpreorder, 16);
        content.add(seepreorders, 17);
        content.add(history, 18);
        content.add(billthis, 19);
        content.add(editorder, 20);

        updateUI();
    }

    private void makeOrderEditable() {
        

        updateUI();
    }

    private void searchThis(String term) {
        FDialog resultwindow = new FDialog(program, "Resultados de la busqueda para: " + term);
        JTable table = new JTable();
        JScrollPane tablepanel = new JScrollPane(table);

        /* BEGIN Traer resultados de la busqueda */
        Object[][] results = new Object[5][4];

        results[0][0] = 1;
        results[1][0] = 2;
        results[2][0] = 3;
        results[3][0] = 4;
        results[4][0] = 666;

        /* END Traer resultados de la busqueda */

        table.setEnabled(false);
        table.setModel(new javax.swing.table.DefaultTableModel(results, new String[]{"Numero de orden", "Cliente", "Fecha", "Fofito"}));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    // Perdona mi falta de luz aca, tengo sueño :(
                    JTable table = (JTable) e.getSource();
                    loadOrder(new Integer(table.getModel().getValueAt(table.rowAtPoint(e.getPoint()), 0).toString()));
                }
            }
        });

        resultwindow.getContentPane().add(tablepanel);
        resultwindow.setDialogSize(400, 200);
        resultwindow.addToTitle(term);
        resultwindow.setVisible(true);
    }
}