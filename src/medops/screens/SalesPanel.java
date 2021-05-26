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
    private JLabel employeeName;
    private JCheckBox addToHospitalBillCheckBox;

    public SalesPanel() {
        addMedicineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectMedicine selectMedicine = new SelectMedicine(salesRecord);

                JFrame selectMedicineFrame = new JFrame();
                selectMedicineFrame.setTitle("Select Medicine");
                selectMedicineFrame.setContentPane(selectMedicine.panel);
                selectMedicineFrame.setSize(400, 200);
                selectMedicineFrame.setVisible(true);
                selectMedicineFrame.setLocationRelativeTo(null);
            }
        });

        generateRecieptButton.addActionListener(e -> {
            if (SharedData.selectedMedicine != null) {
                salesRecord.addMedicine(SharedData.selectedMedicine.getName(), SharedData.selectedMedicine.getQty(), SharedData.selectedMedicine.getPrice());
                salesRecord.addToTotalPrice(SharedData.selectedMedicine.getQty() * SharedData.selectedMedicine.getPrice());
                SharedData.selectedMedicine = null;
            }

            salesRecord.setEmployeeId(SharedData.currentEmployee.getID());
            salesRecord.setTransactionId(TransactionRecord.lastTransactionID++);
            salesRecord.setType("Sale");
            generatedReceipt.setText(salesRecord + "\n\n Additional Notes: " + additionalNotes.getText());
        });

        registerTransactionButton.addActionListener(e -> {
            if (SharedData.processTransaction(salesRecord)) {
                EmployeeScreen.storeRecord.transactionRecordList.add(salesRecord);
                generatedReceipt.setText("");
            } else {
                generatedReceipt.setText("Error in processing, Try again");
            }

            salesRecord = new TransactionRecord();
        });

        cancelTransactionButton.addActionListener(e -> {
            salesRecord = new TransactionRecord();
            generatedReceipt.setText("");
        });

        employeeName.setText(SharedData.currentEmployee.getName());
    }
}
