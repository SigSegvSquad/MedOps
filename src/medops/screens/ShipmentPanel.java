package medops.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShipmentPanel {
    public JPanel shipmentPanel;

    private JButton doneButton;
    private JButton cancelTransactionButton;
    private JButton addMedicineButton;
    private JTextArea generatedReceipt;
    private JButton generateRecieptButton;
    private JTextField textField1;
    ShipmentPanel(){
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
