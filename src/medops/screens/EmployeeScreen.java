package medops.screens;

import medops.StoreRecord;

import javax.swing.*;

public class EmployeeScreen {
    boolean isManager;
    int width = 1000;
    int height = 600;
    int padding = 20;

    public static StoreRecord storeRecord = new StoreRecord();

    public EmployeeScreen() {

        JFrame employeeScreen = new JFrame();
        employeeScreen.setTitle("Manage Pharmacy");
        JTextArea ta = new JTextArea(200, 200);
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(padding, padding, width, height);
        tp.add("Sale", new SalesPanel().salesPanel);
        tp.add("Shipment", new ShipmentPanel().shipmentPanel);
        tp.add("Inventory", new InventoryPanel().inventoryPanel);

        employeeScreen.add(tp);
        employeeScreen.setSize(width + (2*padding), height + (4*padding));
        employeeScreen.setLayout(null);
        employeeScreen.setVisible(true);
    }
}
