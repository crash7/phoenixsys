package phoenix.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import phoenix.Phoenix;

/**
 * @author Chris
 */
public class MainMenu extends JPanel {
    Phoenix program;

    public MainMenu(Phoenix prg) {
        super(null, false);
        program = prg;
        
        setBackground(Color.GRAY);
        makeMenu();
    }

    private void makeMenu() {
        JButton clientes = new JButton("Clientes");
        JButton ordenes = new JButton("Ordenes");
        JButton facturas = new JButton("Facturación");
        JButton about = new JButton("?");
        JButton close = new JButton("X");

        clientes.setBounds((Phoenix.FWIDTH - 300)/2, 100, 300, 120);
        ordenes.setBounds((Phoenix.FWIDTH - 300)/2, 250, 300, 120);
        facturas.setBounds((Phoenix.FWIDTH - 300)/2, 400, 300, 120);
        about.setBounds(Phoenix.FWIDTH - 105, 0, 100, 110);
        close.setBounds(Phoenix.FWIDTH - 85, Phoenix.FHEIGHT-105, 80, 80);

        clientes.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        ordenes.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        facturas.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        about.setFont(new Font("Trebuchet MS", Font.BOLD, 62));
        close.setFont(new Font("Trebuchet MS", Font.BOLD, 48));

        clientes.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            }
        );
        ordenes.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    program.changePanel(new Orders(program));
                }
            }
        );
        facturas.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            }
        );
        about.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    FDialog dialog = new FDialog(program, "About");
                    JLabel logo = new JLabel(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/phoenix.gif")));

                    logo.setBounds(0, 0, 200, 200);
                    logo.setToolTipText("This ugly coded system");

                    dialog.setDialogSize(200, 220);
                    dialog.getContentPane().add(logo);
                    dialog.setVisible(true);

                }
            }
        );
        close.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(1);
                }
            }
        );

        add(clientes);
        add(ordenes);
        add(facturas);
        add(about);
        add(close);
    }
}
