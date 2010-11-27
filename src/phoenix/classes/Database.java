package phoenix.classes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import phoenix.Phoenix;

/**
 * @author Chris
 */
public class Database {
    private MysqlDataSource dbsource;
    private Connection cnx;
    private PreparedStatement laststatement;
    private ResultSet result;

    public Database() {
        dbsource = new MysqlDataSource();
        dbsource.setUser(Phoenix.getSetting("dbuser"));
        dbsource.setPassword(Phoenix.getSetting("dbpass"));
        dbsource.setServerName(Phoenix.getSetting("dbhost"));
        dbsource.setDatabaseName(Phoenix.getSetting("dbname"));

        try {
            cnx = (Connection) dbsource.getConnection();
        } catch(SQLException e) {
            System.out.println("No se pudo conectar porque " + e.getMessage());
            System.exit(1);
        }
    }
    
    public int insert(String table, String cols, String values, String[] params) {
        try {
            laststatement = (PreparedStatement) cnx.prepareStatement("INSERT INTO " + table + " (" + cols + ") VALUES (" + values + ")", Statement.RETURN_GENERATED_KEYS);
            for(int i=0; i<params.length; i++) {
                laststatement.setString(i+1, params[i]);
            }
            laststatement.executeUpdate();
            result = (ResultSet) laststatement.getGeneratedKeys();
            return 1;
            
        } catch (SQLException e) {
            System.out.println("Mal insert porque " + e.getMessage());
            return 0;
        }
    }

    public int update(String table, String settings, String where, String[] params) {
        try {
            laststatement = (PreparedStatement) cnx.prepareStatement("UPDATE " + table + " SET " + settings + " WHERE " + where);
            for(int i=0; i<params.length; i++) {
                laststatement.setString(i+1, params[i]);
            }
            return laststatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Mal update porque " + e.getMessage());
            return 0;
        }
    }

    public int delete(String table, String where, String[] params) {
        try {
            laststatement = (PreparedStatement) cnx.prepareStatement("DELETE FROM " + table + " WHERE " + where);
            for(int i=0; i<params.length; i++) {
                laststatement.setString(i+1, params[i]);
            }
            return laststatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Mal delete porque " + e.getMessage());
            return 0;
        }
    }

    public void select(String table, String cols, String where, String[] params) {
        try {
            laststatement = (PreparedStatement) cnx.prepareStatement("SELECT " + cols + " FROM " + table + " WHERE " + where);
            for(int i=0; i<params.length; i++) {
                laststatement.setString(i+1, params[i]);
            }
            result = (ResultSet) laststatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Mal select porque " + e.getMessage());
        }
    }

    public ResultSet getResult() {
        return result;
    }
}
