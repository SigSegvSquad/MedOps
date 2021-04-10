package medops;

import java.util.List;

public class Manager extends  Employee{
    private List<Employee> managedEmployees;

    Manager(int id, String username, String name, String password, int salary) {
        super(id, username, name, password, salary, true);
    }
}
