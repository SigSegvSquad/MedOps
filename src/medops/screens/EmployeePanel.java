package medops.screens;

import medops.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeePanel {
    public JPanel employeePanel;
    private JList list1;
    private DefaultListModel<Employee> tempList;
    private JTextArea textArea1;
    private JButton addEmployeeButton;
    private JButton updateEmployeeDetailsButton;

    public EmployeePanel(){
        tempList = new DefaultListModel<>();

        for(int i=0;i<EmployeeScreen.storeRecord.employeeList.size();i++){
            tempList.addElement(EmployeeScreen.storeRecord.employeeList.get(i));
        }

        list1.setModel(tempList);

        list1.addListSelectionListener(e->{
            int idxOfSelectedEmp = list1.getSelectedIndex();

            String newLine = System.getProperty("line.separator");

            String empInfo = tempList.get(idxOfSelectedEmp).getName()+
                    newLine+
                    "Salary: " + tempList.get(idxOfSelectedEmp).getSalaryInRupees();

            textArea1.setText(empInfo);
        });

       addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddEmployee addEmployee = new AddEmployee();

                JFrame addEmployeeFrame = new JFrame();
                addEmployeeFrame.setTitle("Add Employee");
                addEmployeeFrame.setContentPane(addEmployee.addEmployeePanel);
                addEmployeeFrame.setSize(400, 200);
                addEmployeeFrame.setVisible(true);
                addEmployeeFrame.setLocationRelativeTo(null);
            }
        });

    }

}
