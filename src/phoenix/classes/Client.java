package phoenix.classes;

import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 * @author Chris
 */
public class Client {

    public static JTable getClients() {
        Database db = new Database();
        ResultSet r;

        db.select("Clientes", "idCliente, Nombre, Apellido, Direccion", null, null);
        r = db.getResult();

        try {
            Object[][] clientes = new Object[db.nrows][4];
            int row;
            while (r.next()) {
                row = r.getRow()-1;
                clientes[row][0] = r.getInt("idCliente");
                clientes[row][1] = r.getString("Nombre");
                clientes[row][2] = r.getString("Apellido");
                clientes[row][3] = r.getString("Direccion");
            }

            JTable table = new JTable();
            table.setModel(new javax.swing.table.DefaultTableModel(clientes, new String[]{"Nº cliente", "Nombre", "Apellido", "Dirección"}));
            table.getTableHeader().setReorderingAllowed(false);
            table.getTableHeader().setResizingAllowed(false);
            table.setEnabled(false);

            return table;
        } catch (SQLException e) { System.out.println("Error getClients"); }
        
        return null;
    }
}
