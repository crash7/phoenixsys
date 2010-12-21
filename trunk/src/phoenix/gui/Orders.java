package phoenix.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import phoenix.Phoenix;
import phoenix.classes.Help;
import phoenix.classes.Order;

/**
 * @author Chris
 */
public class Orders extends JPanel {

    Phoenix program;
    JPanel header, content;
    boolean editing;
    Order currentorder;
    FDialog currentdialog;

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
        JButton mainmenu = new JButton();
        JTextField searchbox = new JTextField("Buscar orden...");

        addorder.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/add.gif")));
        mainmenu.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/home.png")));
        searchorder.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/search.gif")));

        addorder.setBounds(10, 10, 40, 40);
        seeorders.setBounds(100, 10, 200, 40);
        mainmenu.setBounds(Phoenix.FWIDTH - 60 , 10, 50, 50);
        searchorder.setBounds(Phoenix.FWIDTH - 80 - 90, 10, 60, 40);
        searchbox.setBounds(Phoenix.FWIDTH -80 - 340, 10, 250, 40);

        addorder.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        newOrder();
                    }
                });
        mainmenu.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        program.showMainMenu();
                    }
                });
        seeorders.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //cargar trabajos con estado finalizado?
                    }
                }
        );
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
                    field.setText("Buscar orden...");
                }
            }
        });

        header.add(addorder, 0);
        header.add(seeorders, 1);
        header.add(searchorder, 2);
        header.add(searchbox, 3);
        header.add(mainmenu, 4);
    }

    private void makeEmptyContent() {
        Dimension size = new Dimension(Phoenix.FWIDTH, Phoenix.FHEIGHT - 95);

        content.removeAll();
        content.setBackground(java.awt.Color.LIGHT_GRAY);

        content.setPreferredSize(size);
        content.setMinimumSize(size);
        content.setMaximumSize(size);

        updateUI();
    }

    private void loadOrder(int order) {
        makeEmptyContent();

        editing = false;

        JLabel oid = new JLabel("Numero de orden: ");
        JLabel dateadded = new JLabel("Fecha: ");
        JLabel clientname = new JLabel("Nombre: ");
        JLabel clientsurname = new JLabel("Apellido: ");
        JLabel deliveryto = new JLabel("Lugar de entrega: ");
        JLabel description = new JLabel("Descripción: ");
        JLabel ammount = new JLabel("Monto restante: ");
        JLabel status = new JLabel("Estado actual:");

        JButton createpreorder = new JButton("Nuevo presupuesto");
        JButton currentpreorder = new JButton("Presupuesto asignado");
        JButton seepreorders = new JButton("Ver presupuestos");
        JButton history = new JButton("Ver historial");
        JButton billthis = new JButton("Facturar");
        JButton editorder = new JButton();

        JLabel clientname_value = new JLabel();
        JLabel clientsurname_value = new JLabel();
        JLabel deliveryto_value = new JLabel();
        JLabel description_value = new JLabel();
        JLabel status_value = new JLabel();

        JSeparator sepone = new JSeparator();
        JSeparator septwo = new JSeparator();

        oid.setFont(new Font("Trebuchet MS", 1, 12));
        dateadded.setFont(new Font("Trebuchet MS", 1, 12));
        status.setFont(new Font("Trebuchet MS", 1, 12));
        clientname.setFont(new Font("Trebuchet MS", 1, 12));
        clientsurname.setFont(new Font("Trebuchet MS", 1, 12));
        description.setFont(new Font("Trebuchet MS", 1, 12));
        deliveryto.setFont(new Font("Trebuchet MS", 1, 12));

        clientname_value.setFont(new Font("Trebuchet MS", 0, 12));
        clientsurname_value.setFont(new Font("Trebuchet MS", 0, 12));
        status_value.setFont(new Font("Trebuchet MS", 0, 12));
        deliveryto_value.setFont(new Font("Trebuchet MS", 0, 12));
        description_value.setFont(new Font("Trebuchet MS", 2, 12));

        createpreorder.setFont(new Font("Trebuchet MS", 1, 14));
        currentpreorder.setFont(new Font("Trebuchet MS", 1, 14));
        history.setFont(new Font("Trebuchet MS", 1, 14));
        seepreorders.setFont(new Font("Trebuchet MS", 1, 14));
        ammount.setFont(new Font("Trebuchet MS", 1, 14));

        editorder.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/edit.png")));

        oid.setBounds(500, 20, 170, 20);
        dateadded.setBounds(500, 50, 170, 20);
        status.setBounds(500, 80, 80, 20);
        clientname.setBounds(30, 120, 55, 20);
        clientsurname.setBounds(30, 150, 60, 20);
        description.setBounds(30, 200, 80, 20);
        deliveryto.setBounds(30, 300, 105, 20);
        ammount.setBounds(600, 450, 190, 20);

        clientname_value.setBounds(100, 120, 400, 20);
        clientsurname_value.setBounds(100, 150, 400, 20);
        description_value.setBounds(50, 230, 700, 20);
        deliveryto_value.setBounds(140, 300, 500, 20);
        status_value.setBounds(585, 80, 120, 20);

        createpreorder.setBounds(20, 540, 160, 45);
        currentpreorder.setBounds(370, 540, 180, 45);
        seepreorders.setBounds(200, 540, 150, 45);
        history.setBounds(80, 30, 200, 45);
        billthis.setBounds(650, 480, 130, 40);
        editorder.setBounds(725, 30, 60, 60);

        sepone.setBounds(20, 110, 760, 10);
        septwo.setBounds(20, 180, 760, 10);

        createpreorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        PreOrders preorder = new PreOrders(program, "");
                        preorder.newPreOrder(1);
                    }
                });
        currentpreorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        PreOrders preorder = new PreOrders(program, "");
                        preorder.loadPreOrder(1);
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
                        JButton b = (JButton) e.getSource();
                        editing = !editing;
                        if (editing) {
                            b.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/save.png")));
                            makeOrderEditable();
                        } else {
                            b.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/edit.png")));
                            saveOrderData();
                        }
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

        content.add(sepone, 8);
        content.add(septwo, 9);

        content.add(createpreorder, 10);
        content.add(currentpreorder, 11);
        content.add(seepreorders, 12);
        content.add(history, 13);
        content.add(billthis, 14);
        content.add(editorder, 15);

        content.add(clientname_value, 16);
        content.add(clientsurname_value, 17);
        content.add(deliveryto_value, 18);
        content.add(description_value, 19);
        content.add(status_value, 20);

        currentorder = new Order();
        currentorder.setIdorden(order);

        if (currentorder.loadFromDb()) {
            oid.setText(oid.getText() + order);
            clientname_value.setText(currentorder.getNombrecliente());
            clientsurname_value.setText(currentorder.getApecliente());
            deliveryto_value.setText(currentorder.getEntrega());
            dateadded.setText(dateadded.getText() + currentorder.getDate().toString());
            description_value.setText(currentorder.getDescription());
            ammount.setText(ammount.getText() + currentorder.getMontorestante());
            status_value.setText(currentorder.getNombreEstado());
            updateUI();
        } else {
            System.out.println("Se cago todo");
            makeEmptyContent();
        }
    }

    private void makeOrderEditable() {
        JComboBox status_combo = new JComboBox();
        JTextField description = new JTextField();
        JTextField deliveryplace = new JTextField();

        status_combo.setModel(new javax.swing.DefaultComboBoxModel(Help.getHistoryTypes()));
        status_combo.setSelectedIndex(currentorder.getEstado()-1);
        description.setText(currentorder.getDescription());
        deliveryplace.setText(currentorder.getEntrega());

        description.setFont(new java.awt.Font("Trebuchet MS", 0, 12));
        deliveryplace.setFont(new java.awt.Font("Trebuchet MS", 0, 12));

        status_combo.setBounds(585, 80, 130, 20);
        description.setBounds(50, 230, 700, 20);
        deliveryplace.setBounds(140, 300, 500, 20);

        //Que #$€%%
        content.add(deliveryplace, 18);
        content.add(description, 19);
        content.add(status_combo, 20);

        updateUI();
    }

    private void saveOrderData() {
        JComboBox combo;
        JTextField text;

        combo = (JComboBox) content.getComponent(20);
        currentorder.setEstado(combo.getSelectedIndex()+1);

        text = (JTextField) content.getComponent(18);
        currentorder.setEntrega(text.getText());

        text = (JTextField) content.getComponent(19);
        currentorder.setDescription(text.getText());

        currentorder.save();

        loadOrder(currentorder.getIdorden());
    }

    private void searchThis(String term) {
        FDialog resultwindow = new FDialog(program, "Resultados de la busqueda para: " + term);
        JTable table = Order.search(term, null, null);
        JScrollPane tablepanel = new JScrollPane(table);

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
        resultwindow.setDialogSize(600, 200);
        tablepanel.setBounds(0, 0, 596, 198);
        resultwindow.setVisible(true);
    }

    private void newOrder() {
        makeEmptyContent();
        JLabel clientname = new JLabel("Nombre: ");
        JLabel clientsurname = new JLabel("Apellido: ");
        JLabel delivery = new JLabel("Lugar de entrega: ");
        JLabel description = new JLabel("Descripción: ");
        JSeparator sepone = new JSeparator();
        JSeparator septwo = new JSeparator();
        JLabel clientid_value = new JLabel();
        JLabel clientname_value = new JLabel();
        JLabel clientsurname_value = new JLabel();
        JTextField description_value = new JTextField();
        JTextField delivery_value = new JTextField();
        JButton search_client = new JButton();
        JButton addorder = new JButton("Agregar orden");

        search_client.setIcon(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/search_32.png")));

        clientname.setFont(new Font("Trebuchet MS", 1, 12));
        clientsurname.setFont(new Font("Trebuchet MS", 1, 12));
        description.setFont(new Font("Trebuchet MS", 1, 12));
        delivery.setFont(new Font("Trebuchet MS", 1, 12));
        clientid_value.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
        clientname_value.setFont(new java.awt.Font("Trebuchet MS", 0, 12));
        clientsurname_value.setFont(new java.awt.Font("Trebuchet MS", 0, 12));
        description_value.setFont(new java.awt.Font("Trebuchet MS", 0, 12));
        delivery_value.setFont(new java.awt.Font("Trebuchet MS", 0, 12));
        addorder.setFont(new Font("Trebuchet MS", 1, 14));

        clientname.setBounds(30, 120, 55, 20);
        clientsurname.setBounds(30, 150, 60, 20);
        description.setBounds(30, 200, 80, 20);
        delivery.setBounds(30, 300, 105, 20);
        sepone.setBounds(20, 80, 760, 10);
        septwo.setBounds(20, 180, 760, 10);
        clientid_value.setBounds(30, 90, 55, 20);
        clientname_value.setBounds(100, 120, 400, 20);
        clientsurname_value.setBounds(100, 150, 400, 20);
        description_value.setBounds(50, 230, 700, 20);
        delivery_value.setBounds(140, 300, 500, 20);
        search_client.setBounds(530, 120, 50, 50);
        addorder.setBounds(300, 450, 200, 60);

        search_client.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        currentdialog = new FDialog(program, "Clientes");
                        JTable table = phoenix.classes.Client.getClients();
                        JScrollPane tablepanel = new JScrollPane(table);

                        table.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                if (e.getButton() == MouseEvent.BUTTON1) {
                                    JTable table = (JTable) e.getSource();
                                    // Ahora viene una parte de codigo horrible
                                    JLabel tlabel;
                                    tlabel = (JLabel) content.getComponent(6);
                                    tlabel.setText(table.getModel().getValueAt(table.rowAtPoint(e.getPoint()), 0).toString());
                                    tlabel = (JLabel) content.getComponent(7);
                                    tlabel.setText(table.getModel().getValueAt(table.rowAtPoint(e.getPoint()), 1).toString());
                                    tlabel = (JLabel) content.getComponent(8);
                                    tlabel.setText(table.getModel().getValueAt(table.rowAtPoint(e.getPoint()), 2).toString());
                                    currentdialog.setVisible(false);
                                }
                            }
                        });

                        currentdialog.getContentPane().add(tablepanel);
                        currentdialog.setDialogSize(500, 200);
                        tablepanel.setBounds(0, 0, 496, 198);
                        currentdialog.setVisible(true);
                    }
                });
        addorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JLabel temp;
                        JTextField temp2;
                        currentorder = new Order();

                        temp = (JLabel) content.getComponent(6);
                        currentorder.setIdcliente(new Integer(temp.getText()));
                        temp2 = (JTextField) content.getComponent(10);
                        currentorder.setEntrega(temp2.getText());
                        currentorder.setEstado(1);
                        temp2 = (JTextField) content.getComponent(9);
                        currentorder.setDescription(temp2.getText());

                        currentorder.add();

                        loadOrder(currentorder.getIdorden());
                    }
                });

        content.add(clientname, 0);
        content.add(clientsurname, 1);
        content.add(delivery, 2);
        content.add(description, 3);
        content.add(sepone, 4);
        content.add(septwo, 5);
        content.add(clientid_value, 6);
        content.add(clientname_value, 7);
        content.add(clientsurname_value, 8);
        content.add(description_value, 9);
        content.add(delivery_value, 10);
        content.add(search_client, 11);
        content.add(addorder, 12);
    }
}
