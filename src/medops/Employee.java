package medops;

public class Employee {
    private final int ID;
    private final String username;
    private final String password;
    private final String name;
    private final int salaryInRupees;
    public boolean isAdmin = false;
    private String shift;

    public Employee(int id, String username, String name, String password, int salary, boolean isAdmin) {
        this.ID = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.salaryInRupees = salary;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getShift() {
        return shift;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getSalaryInRupees() {
        return salaryInRupees;
    }
}
