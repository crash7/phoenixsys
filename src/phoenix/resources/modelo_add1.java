/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * test.java
 *
 * Created on 03/12/2010, 20:09:14
 */

package phoenix.resources;

/**
 *
 * @author Chris
 */
public class modelo_add1 extends javax.swing.JFrame {

    /** Creates new form test */
    public modelo_add1() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 432, 770, 0);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(500, 404));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setPreferredSize(new java.awt.Dimension(300, 500));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setResizable(false);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 195, 500, 250);

        jButton1.setText("Cancelar presupuesto");
        getContentPane().add(jButton1);
        jButton1.setBounds(330, 130, 180, 40);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel1.setText("Fecha de creacion: 16/15*2213");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 80, 250, 20);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("Orden asociada: 999999999");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 55, 350, 20);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Subtotal");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 430, 430, 20);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Presupuesto nº 9999999999999");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 5, 500, 40);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("El presupuesto esta vencido");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 475, 200, 40);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Estado del presupuesto: #########");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 140, 300, 20);

        jButton3.setText("Imprimir");
        getContentPane().add(jButton3);
        jButton3.setBounds(145, 520, 250, 40);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setText("Fecha de creacion: 16/15*2213");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 105, 250, 20);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(10, 48, 520, 5);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 180, 520, 5);

        jButton2.setLabel("Ver ficha");
        getContentPane().add(jButton2);
        jButton2.setBounds(345, 70, 150, 40);

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setText("Estado del presupuesto: #########");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 455, 450, 20);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modelo_add1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
