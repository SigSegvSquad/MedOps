package medops;

class Shift{
    int shiftDurationMinutes;
    int shiftStartTime;
    int shiftEndTime;

    Shift(int duration, int start, int end){
        this.shiftDurationMinutes = duration;
        this.shiftStartTime = start;
        this.shiftEndTime = end;
    }

    boolean isShiftOver(){
        return true;
    }

    void startShift(){

    }

    void endShift() {

    }
}

public class Employee {
    private int ID;
    private Shift shift;
    private String password;
    private String name;
    private int salaryInRupees;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalaryInRupees() {
        return salaryInRupees;
    }

    public void setSalaryInRupees(int salaryInRupees) {
        this.salaryInRupees = salaryInRupees;
    }

    public Employee(int id, String name, String password, int salary){
        this.ID = id;
        this.name = name;
        this.password = password;
        this.salaryInRupees = salary;
    }
}
