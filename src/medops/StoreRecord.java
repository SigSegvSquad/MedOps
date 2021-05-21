package medops;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        System.out.println("Beginning Loading Data from Memory");
        loadEmployeeList();
        loadMedicineList();
        loadSalesRecordList();
        loadStoreRecord();
        System.out.println("Data loaded from Memory");
    }

    void loadEmployeeList() {
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir") + File.separator + "database/users.json");
            JSONObject employeeData = (JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();

            employeeData.keySet().forEach(keyStr ->
            {
                JSONObject employee = (JSONObject) employeeData.get(keyStr);
                if ((boolean)employee.get("is_admin")) {
                    managerList.add(new Manager((int) employee.get("id"), keyStr, (String) employee.get("name"), (String) employee.get("password"), (int) employee.get("salary")));
                }
                employeeList.add(new Employee((int) employee.get("id"), keyStr, (String) employee.get("name"), (String) employee.get("password"), (int) employee.get("salary"), (boolean) employee.get("is_admin")));
            });

            System.out.println("* Loaded Employee List from Memory");
        } catch (IOException e) {
            System.out.println("* Incorrect file path for Employee List");
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

            System.out.println("* Loaded Medicine List from Memory");
        } catch (IOException e) {
            System.out.println("* Incorrect file path");
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
                ArrayList<TransactedMedicine> transactedMeds = new ArrayList<>();
                for(int j=0;j<transactedMedsJson.length();j++){
                    transactedMeds.add(new TransactedMedicine((String)transactedMedsJson.getJSONObject(j).get("name"),(int)transactedMedsJson.getJSONObject(j).get("qty"), (int)transactedMedsJson.getJSONObject(j).get("price")));
                }
                transactionRecordList.add(new TransactionRecord((int)transaction.get("id"),(String)transaction.get("type"),transactedMeds,(String)transaction.get("time"),(int)transaction.get("amount"),(int)transaction.get("employeeId")));
            }

            System.out.println("* Loaded Transaction List from Memory");
        } catch (IOException e) {
            System.out.println("* Incorrect file path");
        }
    }

    void loadStoreRecord() {
        try {
            FileReader usersDataFileObj = new FileReader(System.getProperty("user.dir") + File.separator + "database/storeRecord.json");
            JSONObject storeData = (JSONObject) new JSONTokener(getFileString(usersDataFileObj)).nextValue();
            this.name = (String) storeData.get("name");
            this.balance = (int) storeData.get("balance");

            System.out.println("* Loaded Miscellaneous Store Details from Memory");
        } catch (IOException e) {
            System.out.println("* Incorrect file path");
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

    public void autoSave(){
        // Saves data in users.json
        JSONObject usersJson = new JSONObject();
        for(int i=0;i<employeeList.size();i++){
            JSONObject userInfo = new JSONObject();
            userInfo.put("id",employeeList.get(i).getID());
            userInfo.put("name",employeeList.get(i).getName());
            userInfo.put("password",employeeList.get(i).getPassword());
            if(employeeList.get(i).isAdmin)
                userInfo.put("is_admin",true);
            else
                userInfo.put("is_admin",false);
            userInfo.put("salary",employeeList.get(i).getSalaryInRupees());
            usersJson.put(employeeList.get(i).getUsername(), userInfo);
        }

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir")+ File.separator+"database/users.json");
            file.write(usersJson.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Saves medicine data in medicines.json
        JSONObject medicinesJson = new JSONObject();
        JSONArray medecineArray = new JSONArray();
        for(int i=0;i<medicineList.size();i++){
            JSONObject medicine = new JSONObject();
            medicine.put("id", medicineList.get(i).getId());
            medicine.put("name", medicineList.get(i).getName());
            medicine.put("stock", medicineList.get(i).getQty());
            medicine.put("price", medicineList.get(i).getPrice());
            medecineArray.put(medicine);
        }
        medicinesJson.put("medicineArray", medecineArray);
        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir")+ File.separator+"database/medicines.json");
            file.write(medicinesJson.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Saves transaction data in transactions.json
        JSONObject transactionRecordJson = new JSONObject();
        JSONArray transactionArray = new JSONArray();
        for(int i=0;i<transactionRecordList.size();i++){
            JSONObject transactionInfo = new JSONObject();

            JSONArray transactedMeds = new JSONArray();
            for(int j=0;j<transactionRecordList.get(i).getMedicines().size();j++){
                JSONObject medObj = new JSONObject();
                medObj.put("name",transactionRecordList.get(i).getMedicines().get(j).medicineName);
                medObj.put("qty",transactionRecordList.get(i).getMedicines().get(j).qty);
                medObj.put("price",transactionRecordList.get(i).getMedicines().get(j).price);
                transactedMeds.put(medObj);
            }

            transactionInfo.put("id", transactionRecordList.get(i).getTransactionId());
            transactionInfo.put("type", transactionRecordList.get(i).getType());
            transactionInfo.put("medicines", transactedMeds);
            transactionInfo.put("amount", transactionRecordList.get(i).getTotalPrice());
            transactionInfo.put("employeeId", transactionRecordList.get(i).getEmployeeId());
            transactionInfo.put("time", transactionRecordList.get(i).getTimeOfPurchase());

            transactionArray.put(transactionInfo);
        }
        transactionRecordJson.put("transactionsArray",transactionArray);

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir")+ File.separator+"database/transactions.json");
            file.write(transactionRecordJson.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Saves store record in storeRecord.json
        JSONObject storeInfo = new JSONObject();
        storeInfo.put("name", name);
        storeInfo.put("balance", balance);

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir")+ File.separator+"database/storeRecord.json");
            file.write(storeInfo.toString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Data auto-saved");
    }
}
