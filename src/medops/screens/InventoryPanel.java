package medops.screens;

import medops.Medicine;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryPanel {
    public JPanel inventoryPanel;
    private JList<Medicine> list1;
    DefaultListModel<Medicine> tempList;
    private JTextArea medicineDetailsTextArea;
    private JButton updateButton;

    public InventoryPanel(){
        tempList = new DefaultListModel<>();
        for (int i = 0; i < EmployeeScreen.storeRecord.medicineList.size(); i++) {
            Medicine medicine = EmployeeScreen.storeRecord.medicineList.get(i);
            tempList.addElement(medicine);
        }
        list1.setModel(tempList);

        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int idxOfSelectedMed = list1.getSelectedIndex();

                String newLine = System.getProperty("line.separator");
                String medicineInfo = tempList.get(idxOfSelectedMed).getName()
                        + newLine
                        + "Price: " + tempList.get(idxOfSelectedMed).getPrice()
                        + newLine
                        + "Quantity in stock: " + tempList.get(idxOfSelectedMed).getPrice();

                medicineDetailsTextArea.setText(medicineInfo);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempList = new DefaultListModel<>();
                for (int i = 0; i < EmployeeScreen.storeRecord.medicineList.size(); i++) {
                    Medicine medicine = EmployeeScreen.storeRecord.medicineList.get(i);
                    tempList.addElement(medicine);
                }
                list1.setModel(tempList);
            }
        });
    }
}
