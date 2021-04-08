package medops;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class StoreRecord {
    public String name;
    public int balance;
    public ArrayList<Employee> employeeList = new ArrayList<>();
    public ArrayList<Manager> managerList = new ArrayList<>();
    public ArrayList<Medicine> medicineList = new ArrayList<>();
    public ArrayList<TransactionRecord> transactionRecordList = new ArrayList<>();

    public StoreRecord() {
        loadEmployeeList();
        loadMedicineList();
        loadSalesRecordList();
        loadStoreRecord();
    }

    void loadEmployeeList() {
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir") + File.separator + "database/users.json");
            JSONObject employeeData = (JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();

            employeeData.keySet().forEach(keyStr ->
            {
                JSONObject employee = (JSONObject) employeeData.get(keyStr);
                if (employee.get("is_admin") == "true") {
                    managerList.add(new Manager((int) employee.get("id"), (String) employee.get("name"), (String) employee.get("password"), (int) employee.get("salary")));
                }
                employeeList.add(new Employee((int) employee.get("id"), (String) employee.get("name"), (String) employee.get("password"), (int) employee.get("salary")));
            });
        } catch (IOException e) {
            System.out.println("wrong path nigga");
        }
    }

    void loadMedicineList() {
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir") + File.separator + "database/medicines.json");
            JSONObject medicineData = (JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();
            JSONArray medicineArray = (JSONArray) medicineData.get("medicineArray");

            for (int i = 0; i < medicineArray.length(); i++) {
                JSONObject medicine = medicineArray.getJSONObject(i);
                medicineList.add(new Medicine((int) medicine.get("id"), (String) medicine.get("name"), (int) medicine.get("stock"), (int) medicine.get("price")));
            }

            Medicine.lastID = medicineArray.length();

        } catch (IOException e) {
            System.out.println("wrong path nigga");
        }
    }

    void loadSalesRecordList() {
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir") + File.separator + "database/transactions.json");
            JSONObject transactionData = (JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();
            JSONArray transactionArray = (JSONArray) transactionData.get("transactionsArray");

            for (int i = 0; i < transactionArray.length(); i++) {
                JSONObject transaction = transactionArray.getJSONObject(i);

                JSONArray transactedMedsJson = (JSONArray) transaction.get("medicines");
                MedicineAmount[] transactedMeds = new MedicineAmount[transactedMedsJson.length()];
                for(int j=0;j<transactedMedsJson.length();j++){
                    transactedMeds[i] = new MedicineAmount((String)transactedMedsJson.getJSONObject(j).get("name"),(int)transactedMedsJson.getJSONObject(j).get("qty"));
                }
                TransactionRecord.lastTransactionID = transactedMeds.length;

                transactionRecordList.add(new TransactionRecord((int)transaction.get("id"),(String)transaction.get("type"),transactedMeds,(String)transaction.get("time"),(int)transaction.get("amount"),(int)transaction.get("employeeId")));
            }
        } catch (IOException e) {
            System.out.println("wrong path nigga");
        }
    }

    void loadStoreRecord() {
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir") + File.separator + "database/storeRecord.json");
            JSONObject storeData = (JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();
            this.name = (String) storeData.get("name");
            this.balance = (int) storeData.get("balance");
            System.out.println(balance);
        } catch (IOException e) {
            System.out.println("wrong path nigga");
        }
    }

    private String getFileString(FileReader fileObj) throws IOException {
        StringBuilder output = new StringBuilder();
        int i;
        while ((i = fileObj.read()) != -1) {
            output.append((char) i);
        }
        return output.toString();
    }
}
