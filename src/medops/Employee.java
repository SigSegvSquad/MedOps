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

    Employee(int id, String name, String password, int salary){
        this.ID = id;
        this.name = name;
        this.password = password;
        this.salaryInRupees = salary;
    }
}
