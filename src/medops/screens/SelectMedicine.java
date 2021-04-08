package medops.screens;

import medops.Medicine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectMedicine {
    private JComboBox<Medicine> medicineList;
    private JButton doneButton;
    public JPanel panel;
    private JButton addNewMedicineButton;
    private JTextField textField1;

    public SelectMedicine() {

        addNewMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewMedicine addNewMedicine = new AddNewMedicine();

                JFrame addMedicineFrame = new JFrame();
                addMedicineFrame.setTitle("Add Medicine");
                addMedicineFrame.setContentPane(addNewMedicine.panel);
                addMedicineFrame.setSize(400, 200);
                addMedicineFrame.setVisible(true);

                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                topFrame.dispose();
            }
        });

        for (int i = 0; i < EmployeeScreen.storeRecord.medicineList.size(); i++) {
            Medicine medicine = EmployeeScreen.storeRecord.medicineList.get(i);
            medicineList.addItem(new Medicine(medicine));
        }
    }
}
