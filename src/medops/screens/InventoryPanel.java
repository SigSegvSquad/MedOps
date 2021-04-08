package medops.screens;

import medops.Medicine;

import javax.swing.*;

public class InventoryPanel {
    public JPanel inventoryPanel;
    private JList list1;
    private DefaultListModel<Medicine> tempList;
    private JTextArea medicineDetailsTextArea;
    private JButton updateButton;

    public InventoryPanel(){
        tempList = new DefaultListModel<>();
        for (int i = 0; i < EmployeeScreen.storeRecord.medicineList.size(); i++) {
            Medicine medicine = EmployeeScreen.storeRecord.medicineList.get(i);
            tempList.addElement(medicine);
        }
        list1 = new JList(tempList);
    }

}
