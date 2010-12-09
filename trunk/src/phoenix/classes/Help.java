/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phoenix.classes;

import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Chris
 */
public class Help {
    public static Object[] getHistoryTypes() {
        Object[] types = null;
        Database db;
        try {
            db = new Database();
            db.select("TiposHistorial", "idTipoHistorial, TipoHistorial", null, null);
            ResultSet r = db.getResult();
            types = new Object[db.nrows];
            while (r.next()) {
                types[r.getRow()-1] = r.getString("TipoHistorial");
            }
        } catch (SQLException e) { System.out.println("Error getHistoryTypes"); }
        
        return types;
    }
}
