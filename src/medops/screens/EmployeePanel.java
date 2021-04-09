package medops.screens;

import medops.Employee;

import javax.swing.*;

public class EmployeePanel {
    public JPanel EmployeePanel;
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

    }

}
