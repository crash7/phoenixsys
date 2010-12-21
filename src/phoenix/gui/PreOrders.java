package phoenix.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import phoenix.classes.Materials;
import phoenix.classes.PreOrder;

/**
 * @author Chris
 */
public class PreOrders {
    private PreOrder preorder;
    private FDialog dialog;
    private String fichapath;
    private Materials materials;

    public PreOrders(JFrame parent, String title) {
        dialog = new FDialog(parent, title);
    }

    public void newPreOrder(int orderid) {
        dialog.setTitle("Nuevo presupuesto");
        preorder = new PreOrder();
        preorder.setOrderId(orderid);
        materials = new Materials();
        
        JLabel newpreorder = new JLabel("Nuevo presupuesto");
        JLabel order_data = new JLabel("Orden asociada: " + preorder.getOrderId());
        JLabel date = new JLabel("Fecha de creacion: ");
        JLabel expirationdate = new JLabel("Fecha de vencimiento: ");
        JButton addpreorder = new JButton("Agregar presupuesto");
        JButton uploadficha = new JButton("Agregar orden técnica");
        JFormattedTextField date_value = new JFormattedTextField();
        JFormattedTextField expirationdate_value = new JFormattedTextField();
        JTable table = new JTable();
        Object[][] elements;
        JScrollPane tablepanel = new JScrollPane(table);
        JSeparator sep1 = new JSeparator();

        newpreorder.setFont(new Font("Trebuchet MS", 1, 14));
        order_data.setFont(new Font("Trebuchet MS", 0, 12));
        date.setFont(new Font("Trebuchet MS", 0, 12));
        expirationdate.setFont(new Font("Trebuchet MS", 0, 12));
        addpreorder.setFont(new Font("Trebuchet MS", 0, 12));
        uploadficha.setFont(new Font("Trebuchet MS", 0, 12));
        date_value.setFont(new Font("Trebuchet MS", 0, 12));
        expirationdate_value.setFont(new Font("Trebuchet MS", 0, 12));

        newpreorder.setBounds(20, 10, 180, 40);
        order_data.setBounds(20, 50, 250, 20);
        date.setBounds(20, 80, 130, 20);
        expirationdate.setBounds(20, 110, 130, 20);
        addpreorder.setBounds(300, 480, 200, 40);
        uploadficha.setBounds(20, 410, 300, 30);
        date_value.setBounds(160, 80, 80, 20);
        expirationdate_value.setBounds(160, 110, 80, 20);
        tablepanel.setBounds(20, 160, 500, 230);
        sep1.setBounds(10, 150, 520, 5);

        addpreorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String date, expire;
                        JFormattedTextField temp = (JFormattedTextField) dialog.getContentPane().getComponent(0);
                        date = temp.getText();
                        temp = (JFormattedTextField) dialog.getContentPane().getComponent(1);
                        expire = temp.getText();
                        if(!date.isEmpty() && !expire.isEmpty()) {
                            preorder.setDate(date);
                            preorder.setExpirationDate(expire);
                            preorder.saveNewPreOrder();
                            dialog.setVisible(false);
                            dialog.getContentPane().removeAll();
                            loadPreOrder(preorder.getId());
                        }
                    }
                }
        );
        uploadficha.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        fichapath = "";
                        preorder.setFichaPath(fichapath);
                    }
                }
        );

        date_value.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        expirationdate_value.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        date_value.setText(Calendar.getInstance().get(Calendar.DATE) + "/" + Calendar.getInstance().get(Calendar.MONTH) + "/" + Calendar.getInstance().get(Calendar.YEAR));
        expirationdate_value.setText(Calendar.getInstance().get(Calendar.DATE) + "/" + Calendar.getInstance().get(Calendar.MONTH) + "/" + Calendar.getInstance().get(Calendar.YEAR));

        elements = new Object [5][4];
        table.setModel(new javax.swing.table.DefaultTableModel(elements, new String [] {"Cantidad", "Materiales", "Precio unitario", "Precio total"}));
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(materials.getMaterials()));
        table.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if(e.getType() == TableModelEvent.UPDATE) {
                    JTable table = (JTable) e.getSource();

                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    JTable table = (JTable) e.getSource();
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    if(table.rowAtPoint(e.getPoint()) == model.getRowCount()-1) {
                        model.setRowCount(model.getRowCount()+5);
                    }
                }
            }
        });

        dialog.getContentPane().add(date_value, 0);
        dialog.getContentPane().add(expirationdate_value, 1);
        dialog.getContentPane().add(newpreorder);
        dialog.getContentPane().add(order_data);
        dialog.getContentPane().add(date);
        dialog.getContentPane().add(expirationdate);
        dialog.getContentPane().add(addpreorder);
        dialog.getContentPane().add(uploadficha);
        dialog.getContentPane().add(tablepanel);
        dialog.getContentPane().add(sep1);
        dialog.setDialogSize(540, 560);
        dialog.setVisible(true);
    }

    public void loadPreOrder(int preorderid) {
        dialog.setTitle("Presupuesto asignado");

        JLabel preorder_data;
        JLabel order_data;
        JLabel preorder_date;
        JLabel preorder_expirationdate;
        JLabel preorder_status;
        JLabel preorder_total;
        JLabel alert;
        JButton cancelpreorder;
        JButton ficha;
        JButton print;
        JSeparator sep1;
        JSeparator sep2;
        JScrollPane tablepanel;
        
        preorder = new PreOrder(preorderid);
        if(preorder.getFromDb()) {
            preorder_data = new JLabel("Presupuesto nº " + preorder.getId());
            order_data = new JLabel("Orden asociada nº " + preorder.getOrderId());
            preorder_date = new JLabel("Fecha de creacion: " + preorder.getDate());
            preorder_expirationdate = new JLabel("Fecha de vencimiento:" + preorder.getExpirationDate());
            preorder_status = new JLabel("Estado del presupuesto: " + preorder.getStatusValue());
            preorder_total = new JLabel("Subtotal $" + preorder.getPrice());
            alert = new JLabel("El presupuesto esta vencido");
            cancelpreorder = new JButton("Cancelar presupuesto");
            print = new JButton("Imprimir");
            ficha = new JButton("Ver ficha");
            tablepanel = new JScrollPane(preorder.getElementsTable());
            sep1 = new JSeparator();
            sep2 = new JSeparator();

            preorder_data.setFont(new Font("Trebuchet MS", 0, 14));
            order_data.setFont(new Font("Trebuchet MS", 0, 12));
            preorder_date.setFont(new Font("Trebuchet MS", 0, 12));
            preorder_expirationdate.setFont(new Font("Trebuchet MS", 0, 12));
            preorder_status.setFont(new Font("Trebuchet MS", 0, 12));
            preorder_total.setFont(new Font("Trebuchet MS", 0, 12));
            alert.setFont(new Font("Trebuchet MS", 1, 14));
            cancelpreorder.setFont(new Font("Trebuchet MS", 0, 12));
            print.setFont(new Font("Trebuchet MS", 0, 12));
            ficha.setFont(new Font("Trebuchet MS", 0, 12));

            preorder_data.setBounds(20, 5, 500, 40);
            order_data.setBounds(20, 55, 350, 20);
            preorder_date.setBounds(20, 80, 250, 20);
            preorder_expirationdate.setBounds(20, 105, 250, 20);
            preorder_status.setBounds(20, 140, 300, 20);
            preorder_total.setBounds(20, 455, 450, 20);
            alert.setBounds(150, 475, 200, 40);
            cancelpreorder.setBounds(330, 130, 180, 40);
            print.setBounds(145, 520, 250, 40);
            ficha.setBounds(345, 70, 150, 40);
            tablepanel.setBounds(20, 195, 500, 250);
            sep1.setBounds(10, 48, 520, 5);
            sep2.setBounds(10, 180, 520, 5);

            cancelpreorder.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(preorder.cancelPreOrder()) {
                            JLabel status = (JLabel) dialog.getContentPane().getComponentAt(20, 140);
                            status.setText("Estado del presupuesto: Cancelado");
                        }
                    }
                });
            ficha.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        FDialog ficha = new FDialog(dialog, "Ficha técnica");
                        JLabel lficha = preorder.getFichaLabel();
                        ficha.setDialogSize(lficha.getWidth(), lficha.getHeight());
                        ficha.getContentPane().add(lficha);
                        ficha.setVisible(true);
                    }
                });
            print.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        javax.swing.JOptionPane.showMessageDialog(dialog, "Se esta imprimiento el presupuesto");
                    }
                });

            dialog.getContentPane().add(preorder_data);
            dialog.getContentPane().add(order_data);
            dialog.getContentPane().add(preorder_date);
            dialog.getContentPane().add(preorder_expirationdate);
            dialog.getContentPane().add(preorder_status);
            dialog.getContentPane().add(preorder_total);
            dialog.getContentPane().add(cancelpreorder);
            dialog.getContentPane().add(ficha);
            dialog.getContentPane().add(print);
            dialog.getContentPane().add(tablepanel);
            dialog.getContentPane().add(sep1);
            dialog.getContentPane().add(sep2);
            if(!preorder.checkDates()) {
                dialog.getContentPane().add(alert);
            }

            dialog.setDialogSize(540, 600);
            dialog.setVisible(true);
        }
    }
}
