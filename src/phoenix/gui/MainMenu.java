package phoenix.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import phoenix.Phoenix;
import phoenix.classes.Database;

/**
 * @author Chris
 */
public class MainMenu extends JPanel {
    
    public MainMenu() {
        super(null, false);
        
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
                    throw new UnsupportedOperationException("Not supported yet.");
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
                    System.exit(1);
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
