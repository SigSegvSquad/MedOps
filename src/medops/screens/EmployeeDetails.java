package medops.screens;

import medops.SharedData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeDetails {
    public JPanel detailsPanel;
    private JTextArea currEmployeeDetails;
    private JButton endShiftAndLogoutButton;

    public EmployeeDetails() {
        String empInfo = SharedData.currentEmployee.getName() + "\n" +
                "Salary: " + SharedData.currentEmployee.getSalaryInRupees();

        currEmployeeDetails.setText(empInfo);

        endShiftAndLogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeScreen.storeRecord.autoSave();
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(detailsPanel);
                topFrame.dispose();
            }
        });
    }
}
