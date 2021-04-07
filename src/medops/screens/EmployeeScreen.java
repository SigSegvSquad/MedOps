package medops.screens;

import javax.swing.*;

public class EmployeeScreen {
    boolean isManager;
    int width = 500;
    int height = 200;
    int padding = 20;

    EmployeeScreen() {
        JFrame employeeScreen = new JFrame();
        JTextArea ta = new JTextArea(200, 200);
        JPanel p1 = new SalesPanel();
        JPanel p2 = new ShipmentPanel();
        JPanel p3 = new InventoryPanel();
        p1.add(ta);
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(padding, padding, width, height);
        tp.add("Sale", p1);
        tp.add("Shipment", p2);
        tp.add("Inventory", p3);
        employeeScreen.add(tp);
        employeeScreen.setSize(width + (2*padding), height + (4*padding));
        employeeScreen.setLayout(null);
        employeeScreen.setVisible(true);
    }
}
