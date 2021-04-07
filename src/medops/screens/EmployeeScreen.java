package medops.screens;

import javax.swing.*;

public class EmployeeScreen {
    boolean isManager;
    int width = 1000;
    int height = 700;
    int padding = 20;

    EmployeeScreen() {
        JFrame employeeScreen = new JFrame();
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
