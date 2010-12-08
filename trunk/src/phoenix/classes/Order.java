package phoenix.classes;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Leandro
 */
public class Order {

    private String descripcion;
    private Date date;
    private int idorden;
    private int idcliente;
    private String nombrecliente;
    private String apecliente;
    private int montorestante;
    private int estado;
    private String nombre_estado;
    private String entrega;

    public Order() {
        descripcion = null;
        date = null;
        idorden = 0;
        idcliente = 0;
        montorestante = 0;
        estado = 0;
        entrega = null;
        nombrecliente = null;
        apecliente = null;
        nombre_estado = null;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getApecliente() {
        return apecliente;
    }

    public void setApecliente(String apecliente) {
        this.apecliente = apecliente;
    }

    public String getNombreEstado() {
        return nombre_estado;
    }

    public void setNombreEstado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    public int getMontorestante() {
        return montorestante;
    }

    public void setMontorestante(int montorestante) {
        this.montorestante = montorestante;
    }

    public void LoadFromScreen(String s[], Date d) {
        idorden = Integer.parseInt(s[0]);
        idcliente = Integer.parseInt(s[1]);
        descripcion = s[2];
        this.date = d;
        montorestante = Integer.parseInt(s[3]);
        estado = Integer.parseInt(s[4]);
        entrega = s[5];
    }

    public boolean loadFromDb() {
        try {
            Database db = new Database();
            db.select("Ordenes, TiposHistorial, Clientes",
                    "Clientes_idCliente, Descripcion, FechaCreacion, MontoRestante, EstadoActual, LugarEntrega, Nombre, Apellido, TipoHistorial",
                    "idOrden= ? AND Clientes_idCliente = idCliente AND idTipoHistorial = EstadoActual",
                    new String[]{Integer.toString(idorden)});
            ResultSet r = db.getResult();
            r.first();
            idcliente = Integer.parseInt(r.getString("Clientes_idCliente"));
            descripcion = r.getString("Descripcion");
            date = r.getDate("FechaCreacion");
            montorestante = Integer.parseInt(r.getString("MontoRestante"));
            estado = Integer.parseInt(r.getString("EstadoActual"));
            entrega = r.getString("LugarEntrega");
            nombre_estado = r.getString("TipoHistorial");
            nombrecliente = r.getString("Nombre");
            apecliente = r.getString("Apellido");
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public void save() {
        if (idcliente >= 0 && idorden >= 0 && estado >= 0) {
            Database db = new Database();
            db.insert("Ordenes",
                    "idOrden, idCliente, Descripcion, Fecha, MontoRestante, Estado, Entrega",
                    "?, ?, ?, ?, ?, ?, ?",
                    new String[]{
                        Integer.toString(idorden),
                        Integer.toString(idcliente),
                        descripcion,
                        date.toString(),
                        Integer.toString(montorestante),
                        Integer.toString(estado),
                        entrega
                    });
        }
    }
}
