package medops.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShipmentPanel {
    public JPanel shipmentPanel;

    private JButton registerTransactionButton;
    private JButton cancelTransactionButton;
    private JButton addMedicineButton;
    private JTextArea generatedReceipt;
    private JButton generateRecieptButton;
    private JTextArea textArea1;

    ShipmentPanel() {
        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectMedicine selectMedicine = new SelectMedicine();

                JFrame selectMedicineFrame = new JFrame();
                selectMedicineFrame.setTitle("Select Medicine");
                selectMedicineFrame.setContentPane(selectMedicine.panel);
                selectMedicineFrame.setSize(400, 200);
                selectMedicineFrame.setVisible(true);

                selectMedicineFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {

                    }
                });
            }
        });

        registerTransactionButton.addActionListener(new ActionListener() {
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
