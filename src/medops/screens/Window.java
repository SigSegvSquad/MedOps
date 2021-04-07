package medops.screens;

import java.awt.*;
import javax.swing.*;

public class Window {
    public Window(){
        LoginScreen loginScreen = new LoginScreen();

//        if (!loginScreen.isLoggedIn()){
//            //somethings wrong
//            return;
//        }

        EmployeeScreen employeeScreen = new EmployeeScreen();
    }
}
