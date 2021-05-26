package medops.screens;

import medops.Medicine;

import javax.swing.*;

public class AddNewMedicine {
    public JPanel panel;
    private JButton addNewMedicineButton;
    private JTextField nameField;
    private JTextField priceField;


    public AddNewMedicine() {
        addNewMedicineButton.addActionListener(e -> {
            if (nameField.getText().equals("")) {
                System.out.println("Medicine Name is empty, try again");
            } else if (priceField.getText().equals("")) {
                System.out.println("Medicine Price is empty, try again");
            } else {
                try {
                    String name = nameField.getText();
                    int price = Integer.parseInt(priceField.getText());

                    Medicine newMedicine = new Medicine(Medicine.lastID++, name, 0, price);
                    EmployeeScreen.storeRecord.medicineList.add(newMedicine);

                    System.out.println("Succesfully Added " + name + " to the medicine list");

                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(panel);
                    topFrame.dispose();
                } catch (Exception textException) {
                    System.out.println("Error in adding New Medicine, please try again");
                    nameField.setText("");
                    priceField.setText("");
                }
            }
        });
    }
}
