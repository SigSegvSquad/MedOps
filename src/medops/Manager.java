package medops;

import java.util.List;

public class Manager extends  Employee{
    private List<Employee> managedEmployees;

    public Manager(int id, String name, String password, int salary) {
        super(id, name, password, salary);
    }
}
