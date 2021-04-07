package medops;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class StoreRecord {
    public String name;
    public int balance;
    public List<Employee> employeeList = new List<Employee>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Employee> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Employee employee) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Employee> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Employee> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Employee get(int index) {
            return null;
        }

        @Override
        public Employee set(int index, Employee element) {
            return null;
        }

        @Override
        public void add(int index, Employee element) {

        }

        @Override
        public Employee remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Employee> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Employee> listIterator(int index) {
            return null;
        }

        @Override
        public List<Employee> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    public List<Manager> managerList = new List<Manager>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Manager> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Manager manager) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Manager> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Manager> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Manager get(int index) {
            return null;
        }

        @Override
        public Manager set(int index, Manager element) {
            return null;
        }

        @Override
        public void add(int index, Manager element) {

        }

        @Override
        public Manager remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Manager> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Manager> listIterator(int index) {
            return null;
        }

        @Override
        public List<Manager> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    public List<Medicine> medicineList = new List<Medicine>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Medicine> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Medicine medicine) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Medicine> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Medicine> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Medicine get(int index) {
            return null;
        }

        @Override
        public Medicine set(int index, Medicine element) {
            return null;
        }

        @Override
        public void add(int index, Medicine element) {

        }

        @Override
        public Medicine remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Medicine> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Medicine> listIterator(int index) {
            return null;
        }

        @Override
        public List<Medicine> subList(int fromIndex, int toIndex) {
            return null;
        }
    };
    public List<TransactionRecord> transactionRecordList = new List<TransactionRecord>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<TransactionRecord> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(TransactionRecord transactionRecord) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends TransactionRecord> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends TransactionRecord> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public TransactionRecord get(int index) {
            return null;
        }

        @Override
        public TransactionRecord set(int index, TransactionRecord element) {
            return null;
        }

        @Override
        public void add(int index, TransactionRecord element) {

        }

        @Override
        public TransactionRecord remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<TransactionRecord> listIterator() {
            return null;
        }

        @Override
        public ListIterator<TransactionRecord> listIterator(int index) {
            return null;
        }

        @Override
        public List<TransactionRecord> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    StoreRecord() {
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
                System.out.println(medicine.get("name"));
                medicineList.add(new Medicine((int) medicine.get("id"), (String) medicine.get("name"), (int) medicine.get("stock"), (int) medicine.get("price")));
            }
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
                System.out.println(transaction.get("employeeId"));
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
