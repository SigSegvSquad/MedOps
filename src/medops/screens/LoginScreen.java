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
    }

    private String getFileString(FileReader fileObj) throws IOException {
        String output="";
        int i;
        while((i=fileObj.read()) != -1){
            output += (char)i;
        }
        return output;
    }

    private void verifyLoginInfo(String username, String password) {
        boolean everythingChecksOut = false;
        //do stuff
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir")+ File.separator+"database/users.json");

            JSONObject usersData =(JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();

            try {
                String userDataStr = usersData.get(username).toString();
                JSONObject userData = (JSONObject) new JSONTokener(userDataStr).nextValue();

                if(userData.get("password").toString().equals(password)) {
                    everythingChecksOut = true;
                    if (everythingChecksOut) {
                        frame.setVisible(false);
                        EmployeeScreen employeeScreen = new EmployeeScreen();

                    }
                }
                else{
                    System.out.println("Wrong Password");
                }
            }
            catch (JSONException e) {
                System.out.println("Username not found!");
            }
        }
        catch(IOException e){
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

        JButton registerButton = new JButton("register");
        registerButton.setBounds(180, 80, 80, 25);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifyLoginInfo(userText.getText(), String.valueOf(passwordText.getPassword()));
            }
        });
    }
}
