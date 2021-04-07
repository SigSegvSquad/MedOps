package medops;

import java.util.List;

public class StoreRecord {
    public int balance;
    public List<Employee> employeeList;
    public List<Medicine> medicineList;
    public List<SalesRecord> salesRecordList;

    StoreRecord(){
        loadEmployeeList("users.json");
    }

    void loadEmployeeList(String path){
        //stuff
    }
}
