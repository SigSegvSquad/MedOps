package medops.screens;

import medops.Medicine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryPanel {
    public JPanel inventoryPanel;
    private JList<Medicine> list1;
    DefaultListModel<Medicine> medicineDefaultListModel;
    private JTextArea medicineDetailsTextArea;
    private JButton updateButton;
    private JButton addMedicineButton;

    public InventoryPanel() {
        medicineDefaultListModel = new DefaultListModel<>();
        for (int i = 0; i < EmployeeScreen.storeRecord.medicineList.size(); i++) {
            Medicine medicine = EmployeeScreen.storeRecord.medicineList.get(i);
            medicineDefaultListModel.addElement(medicine);
        }
        list1.setModel(medicineDefaultListModel);

        list1.addListSelectionListener(e -> {
            int idxOfSelectedMed = list1.getSelectedIndex();

            String newLine = System.getProperty("line.separator");
            String medicineInfo = medicineDefaultListModel.get(idxOfSelectedMed).getName()
                    + newLine
                    + "Price: " + medicineDefaultListModel.get(idxOfSelectedMed).getPrice()
                    + newLine
                    + "Quantity in stock: " + medicineDefaultListModel.get(idxOfSelectedMed).getQty();

            medicineDetailsTextArea.setText(medicineInfo);
        });

        updateButton.addActionListener(e -> {
            DefaultListModel<Medicine> tempList = new DefaultListModel<>();
            for (int i = 0; i < EmployeeScreen.storeRecord.medicineList.size(); i++) {
                Medicine medicine = EmployeeScreen.storeRecord.medicineList.get(i);
                tempList.addElement(medicine);
            }

            if (tempList.size() > medicineDefaultListModel.size()) {
                medicineDefaultListModel = tempList;
                list1.setModel(medicineDefaultListModel);
            }
        });

        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewMedicine addNewMedicine = new AddNewMedicine();

                JFrame addMedicineFrame = new JFrame();
                addMedicineFrame.setTitle("Add Medicine");
                addMedicineFrame.setContentPane(addNewMedicine.panel);
                addMedicineFrame.setSize(400, 200);
                addMedicineFrame.setVisible(true);
            }
        });
    }
}
