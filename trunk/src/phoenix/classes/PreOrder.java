package phoenix.classes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 * @author Chris
 */
public class PreOrder {
    private int preorderid;
    private int orderid;
    private String statusvalue;
    private int status;
    private String date;
    private String expirationdate;
    private float price;
    private String fichapath;
    private Object[][] elements;


    public PreOrder(int preorderid) {
        this.preorderid = preorderid;
        orderid = 0;
        status = 0;
        statusvalue = "";
        date = "";
        expirationdate = "";
        price = 0;
        elements = null;
        fichapath = "phoenix/resources/wrongficha.png";
    }

    public PreOrder() {
        preorderid = 0;
        orderid = 0;
        status = 0;
        statusvalue = "";
        date = "";
        expirationdate = "";
        price = 0;
        elements = null;
        fichapath = "phoenix/resources/wrongficha.png";
    }

    public void setOrderId(int oid) {
        orderid = oid;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExpirationDate(String expire) {
        expirationdate = expire;
    }

    public void setFichaPath(String ficha) {
        //fichapath = ficha;
    }

    public boolean getFromDb() {

        elements =  new Object [][] {{null, null, null, null}};

        return true;
    }

    public boolean checkDates() {
        return false;
    }

    public JTable getElementsTable() {
        JTable table = new JTable(elements, new String [] {"Title 1", "Title 2", "Title 3", "Title 4"});
        return table;
    }

    public int getId() {
        return preorderid;
    }

    public int getOrderId() {
        return orderid;
    }

    public String getDate() {
        return date;
    }

    public String getExpirationDate() {
        return expirationdate;
    }

    public String getStatusValue() {
        return statusvalue;
    }

    public float getPrice() {
        return price;
    }

    public JLabel getFichaLabel() {
        JLabel result = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("phoenix/resources/wrongficha.png")));
        result.setBounds(0, 0, result.getIcon().getIconWidth(), result.getIcon().getIconHeight());
        return result;
    }

    public void printPreOrder() {
        
    }

    public boolean cancelPreOrder() {

        return true;
    }

    public boolean saveNewPreOrder() {
        return true;
    }
}
