package medops.screens;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import medops.Employee;
import medops.Manager;
import medops.SharedData;
import org.json.JSONException;
import org.json.JSONTokener;
import org.json.JSONObject;

public class LoginScreen {
    JFrame frame;

    LoginScreen() {
        frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private String getFileString(FileReader fileObj) throws IOException {
        String output = "";
        int i;
        while ((i = fileObj.read()) != -1) {
            output += (char) i;
        }
        return output;
    }

    private void verifyLoginInfo(String username, String password) {
        boolean everythingChecksOut = false;
        //do stuff
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir") + File.separator + "database/users.json");

            JSONObject usersData = (JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();

            try {
                String userDataStr = usersData.get(username).toString();
                JSONObject employee = (JSONObject) new JSONTokener(userDataStr).nextValue();

                if (employee.get("password").toString().equals(password)) {
                    frame.dispose();
                    usersData.keySet().forEach(keyStr ->
                    {
                        if ((boolean) employee.get("is_admin")) {
                            //TODO: create CurrentManager?
                        }
                        SharedData.currentEmployee = new Employee((int) employee.get("id"), keyStr, (String) employee.get("name"), (String) employee.get("password"), (int) employee.get("salary"), (boolean) employee.get("is_admin"));
                    });

                    System.out.println("Employee " + employee.get("name") + " has logged in at " + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

                    EmployeeScreen employeeScreen = new EmployeeScreen();
                } else {
                    System.out.println("Wrong Password");
                }
            } catch (JSONException e) {
                System.out.println("Username not found!");
            }
        } catch (IOException e) {
            System.out.println("Failed to read!");
        }
    }


    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifyLoginInfo(userText.getText(), String.valueOf(passwordText.getPassword()));
            }
        });
    }
}
