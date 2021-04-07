package medops.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectMedicine {
    private JComboBox comboBox1;
    private JButton doneButton;
    public JPanel panel;
    private JButton addNewMedicineButton;
    private JTextField textField1;

    public SelectMedicine() {
        addNewMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddNewMedicine addNewMedicine = new AddNewMedicine();

                JFrame selectMedicineFrame = new JFrame();
                selectMedicineFrame.setTitle("Add Medicine");
                selectMedicineFrame.setContentPane(addNewMedicine.panel);
                selectMedicineFrame.setSize(400, 200);
                selectMedicineFrame.setVisible(true);
            }
        });
    }
}
