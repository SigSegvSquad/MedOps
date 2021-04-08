package medops.screens;

import medops.SharedData;
import medops.TransactionRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesPanel {
    public TransactionRecord salesRecord = new TransactionRecord();

    public JPanel salesPanel;
    private JButton addMedicineButton;
    private JButton registerTransactionButton;
    private JButton cancelTransactionButton;
    private JTextArea generatedReceipt;
    private JButton generateRecieptButton;
    private JTextArea additionalNotes;

    public SalesPanel() {
        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectMedicine selectMedicine = new SelectMedicine();

                JFrame selectMedicineFrame = new JFrame();
                selectMedicineFrame.setTitle("Select Medicine");
                selectMedicineFrame.setContentPane(selectMedicine.panel);
                selectMedicineFrame.setSize(400, 200);
                selectMedicineFrame.setVisible(true);
            }
        });

        generateRecieptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (SharedData.selectedMedicine != null) {
                    salesRecord.addMedicine(SharedData.selectedMedicine.getName(), SharedData.selectedMedicine.getQty());
                    salesRecord.addToTotalPrice(SharedData.selectedMedicine.getQty() * SharedData.selectedMedicine.getPrice());
                    SharedData.selectedMedicine = null;
                }
                salesRecord.setEmployeeId(SharedData.currentEmployee.getID());
                salesRecord.setTransactionId(TransactionRecord.lastTransactionID++);
                salesRecord.setType("Sale");
                generatedReceipt.setText(salesRecord + "\n\n Additional Notes: " + additionalNotes.getText());
            }

        });

        registerTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salesRecord = new TransactionRecord();
                generatedReceipt.setText("");
            }
        });

        cancelTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salesRecord = new TransactionRecord();
                generatedReceipt.setText("");
            }
        });
    }
}
