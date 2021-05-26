package medops.screens;

import medops.SharedData;
import medops.StoreRecord;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AutoSave implements Runnable {
    @Override
    public void run() {
        System.out.println("Starting AutoSave in Thread");
        EmployeeScreen.storeRecord.autoSave();
    }
}

public class EmployeeScreen {
    public static StoreRecord storeRecord = new StoreRecord();
    boolean isManager;
    int width = 1000;
    int height = 600;
    int padding = 20;

    public EmployeeScreen() {
        JFrame employeeScreen = new JFrame();
        employeeScreen.setTitle("Manage Pharmacy");
        JTabbedPane employeeTabbedPane = new JTabbedPane();
        employeeTabbedPane.setBounds(padding, padding, width, height);
        employeeTabbedPane.add("Sale", new SalesPanel().salesPanel);
        employeeTabbedPane.add("Shipment", new ShipmentPanel().shipmentPanel);
        employeeTabbedPane.add("Inventory", new InventoryPanel().inventoryPanel);
        if (SharedData.currentEmployee.isAdmin)
            employeeTabbedPane.add("Manage Employees", new EmployeePanel().employeePanel);
        employeeTabbedPane.add("Current Shift", new EmployeeDetails().detailsPanel);

        employeeScreen.add(employeeTabbedPane);
        employeeScreen.setSize(width + (2 * padding), height + (4 * padding));
        employeeScreen.setLayout(null);
        employeeScreen.setVisible(true);
        employeeScreen.setLocationRelativeTo(null);

        // On window closing
        employeeScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Thread autoSave = new Thread(new AutoSave());
                autoSave.start();
            }
        });
    }
}
