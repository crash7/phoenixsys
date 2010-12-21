package phoenix.classes;

import com.mysql.jdbc.ResultSet;
import java.sql.SQLException;

/**
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

    public static Object[] getMaterials() {
        Object[] types = null;
        Database db;
        try {
            db = new Database();
            db.select("Materiales", "idMaterial, Material", null, null);
            ResultSet r = db.getResult();
            types = new Object[db.nrows];
            while (r.next()) {
                types[r.getRow()-1] = r.getString("Material");
            }
        } catch (SQLException e) { System.out.println("Error getMaterials"); }

        return types;
    }
}
