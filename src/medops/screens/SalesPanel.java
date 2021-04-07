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
