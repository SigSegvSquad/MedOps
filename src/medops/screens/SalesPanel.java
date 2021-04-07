package medops.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesPanel {
    public JPanel salesPanel;
    private JButton addMedicineButton;
    private JButton doneButton;
    private JButton cancelTransactionButton;
    private JTextArea generatedReceipt;
    private JButton generateRecieptButton;
    private JTextField textField1;

    public SalesPanel() {
        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectMedicine selectMedicine = new SelectMedicine();

                JFrame selectMedicineFrame = new JFrame();
                selectMedicineFrame.setTitle("Select Medicine");
                selectMedicineFrame.setContentPane(selectMedicine.panel);
                selectMedicineFrame.setSize(400,200);
                selectMedicineFrame.setVisible(true);
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        cancelTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
