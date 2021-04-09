package medops.screens;

import medops.Medicine;
import medops.SharedData;
import medops.TransactedMedicine;
import medops.TransactionRecord;

import javax.swing.*;
import java.util.ArrayList;

public class SelectMedicine {
    private JComboBox<Medicine> medicineList;
    private JButton doneButton;
    public JPanel panel;
    private JButton addNewMedicineButton;
    private JTextField AmountField;

    public SelectMedicine(TransactionRecord transactionRecord) {
        addNewMedicineButton.addActionListener(e -> {
            AddNewMedicine addNewMedicine = new AddNewMedicine();

            JFrame addMedicineFrame = new JFrame();
            addMedicineFrame.setTitle("Add Medicine");
            addMedicineFrame.setContentPane(addNewMedicine.panel);
            addMedicineFrame.setSize(400, 200);
            addMedicineFrame.setVisible(true);

            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
            topFrame.dispose();
        });

        doneButton.addActionListener(e -> {
            SharedData.selectedMedicine = (Medicine) medicineList.getSelectedItem();
            if(!AmountField.getText().equals("")) {
                SharedData.selectedMedicine.setQty(Integer.parseInt(AmountField.getText()));
            } else {
                AmountField.setText("Enter Amount");
                return;
            }

            if(SharedData.selectedMedicine != null) {
                transactionRecord.addMedicine(SharedData.selectedMedicine.getName(), SharedData.selectedMedicine.getQty(), SharedData.selectedMedicine.getPrice());
                transactionRecord.addToTotalPrice(SharedData.selectedMedicine.getQty() * SharedData.selectedMedicine.getPrice());
                SharedData.selectedMedicine = null;
            }

            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
            topFrame.dispose();
        });

        for (int i = 0; i < EmployeeScreen.storeRecord.medicineList.size(); i++) {
            Medicine medicine = EmployeeScreen.storeRecord.medicineList.get(i);
            medicineList.addItem(new Medicine(medicine));
        }
    }
}
