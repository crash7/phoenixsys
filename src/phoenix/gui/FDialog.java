package phoenix.gui;

/**
 * @author Chris
 */
public class FDialog extends javax.swing.JDialog {
    
    public FDialog(javax.swing.JFrame parent, String title) {
        super(parent, title);
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(null);
    }

    public FDialog(javax.swing.JDialog parent, String title) {
        super(parent, title);
        setModal(true);
        setResizable(false);
        getContentPane().setLayout(null);
    }

    public void setDialogSize(int w, int h) {
        setBounds(getParent().getX() + ((getParent().getWidth() - w) / 2), getParent().getY() + ((getParent().getHeight() - h) / 2), w, h);
    }

    public void addToTitle(String term) {
        setTitle(getTitle() + term );
    }
}
