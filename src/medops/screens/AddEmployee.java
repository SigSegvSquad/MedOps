package medops.screens;

import medops.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee {
    public JPanel addEmployeePanel;
    private JComboBox isAdmin;
    private JTextField setSalary;
    private JTextField setUsername;
    private JTextField setName;
    private JButton addEmployeeButton;
    private JPasswordField setPassword;

    public AddEmployee() {
        isAdmin.addItem("No");
        isAdmin.addItem("Yes");

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = EmployeeScreen.storeRecord.employeeList.size() + 1;
                String name = setName.getText();
                String username = setUsername.getText();
                String password = LoginScreen.sha256(String.valueOf(setPassword.getPassword()));
                int salary = Integer.parseInt(setSalary.getText());
                boolean adminStatus = (isAdmin.getSelectedItem()).equals("Yes");
                EmployeeScreen.storeRecord.employeeList.add(new Employee(id, username, name, password, salary, adminStatus));
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(addEmployeePanel);
                topFrame.dispose();
            }
        });
    }
}
