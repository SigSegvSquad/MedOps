package medops.screens;

import medops.SharedData;
import medops.TransactionRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShipmentPanel {
    public TransactionRecord shipmentRecord = new TransactionRecord();

    public JPanel shipmentPanel;

    private JButton registerTransactionButton;
    private JButton cancelTransactionButton;
    private JButton addMedicineButton;
    private JTextArea generatedReceipt;
    private JButton generateRecieptButton;
    private JTextArea additionalNotes;

    ShipmentPanel() {
        addMedicineButton.addActionListener(e -> {
            SelectMedicine selectMedicine = new SelectMedicine();

            JFrame selectMedicineFrame = new JFrame();
            selectMedicineFrame.setTitle("Select Medicine");
            selectMedicineFrame.setContentPane(selectMedicine.panel);
            selectMedicineFrame.setSize(400, 200);
            selectMedicineFrame.setVisible(true);
        });

        generateRecieptButton.addActionListener(e -> {
            if(SharedData.selectedMedicine != null) {
                shipmentRecord.addMedicine(SharedData.selectedMedicine.getName(), SharedData.selectedMedicine.getQty(), SharedData.selectedMedicine.getPrice());
                shipmentRecord.addToTotalPrice(SharedData.selectedMedicine.getQty() * SharedData.selectedMedicine.getPrice());
                SharedData.selectedMedicine = null;
            }

            shipmentRecord.setEmployeeId(SharedData.currentEmployee.getID());
            shipmentRecord.setTransactionId(TransactionRecord.lastTransactionID++);
            shipmentRecord.setType("Purchase");
            generatedReceipt.setText(shipmentRecord + "\n\n Additional Notes: " + additionalNotes.getText());
        });

        registerTransactionButton.addActionListener(e -> {
            shipmentRecord = new TransactionRecord();
            generatedReceipt.setText("");
        });

        cancelTransactionButton.addActionListener(e -> {
            shipmentRecord = new TransactionRecord();
            generatedReceipt.setText("");
        });
    }
}
