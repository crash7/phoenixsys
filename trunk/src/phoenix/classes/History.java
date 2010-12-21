/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package phoenix.classes;

import java.sql.Date;

/**
 *
 * @author Izo
 */
public class History {
    private int idhistorial=-1;
    private int idorden=-1;
    private int idtipohistorial=-1;
    private String comm=null;
    private Date fecha=null;

    public History (String s[],Date f)
    {
         idhistorial=Integer.parseInt(s[0]);
        idorden=Integer.parseInt(s[1]);
        idtipohistorial=Integer.parseInt(s[2]);
        fecha=f;
        comm=s[3];
    }

    public void Save ()
    {
        Database d= new Database();

        if (idhistorial!=-1 && idorden!=-1 && idtipohistorial!=-1)
        {
            d.insert("HistorialOrdenes","idHistorial,Ordenes_idOrden,TipoHistorial_idTipoHistorial,Comentario,Fecha", Integer.toString(idhistorial)+" " +Integer.toBinaryString(idorden)+" "+Integer.toString(idtipohistorial)+" "+comm+" "+d.toString(),null);
        }
    }
    

}
