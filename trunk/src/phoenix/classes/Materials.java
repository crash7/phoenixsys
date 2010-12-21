package phoenix.classes;

import javax.swing.JComboBox;

/**
 * @author Chris
 */
public class Materials {
    private JComboBox materials_combo;

    public Materials() {
        materials_combo = new JComboBox();
        materials_combo.addItem("Snowboarding");
        materials_combo.addItem("Rowing");
        materials_combo.addItem("Chasing toddlers");
        materials_combo.addItem("Speed reading");
        materials_combo.addItem("Teaching high school");
        materials_combo.addItem("None");

    }

    public JComboBox getMaterials() {
        return materials_combo;
    }
}
