package medops;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;


class Transaction {
    String medicineName;
    int qty;

    Transaction(String medicine, int qty){
        this.medicineName = medicine;
        this.qty = qty;
    }

    public String getFormattedAmount(int width){
        StringBuilder result = new StringBuilder();
        String quantity = Integer.toString(qty);

        result.append(medicineName);
        result.append(" ".repeat(Math.max(0, width - medicineName.length() - quantity.length())));
        result.append(quantity);

        return result.toString();
    }
}

public class TransactionRecord {
    public static int lastTransactionID = 0;

    private int transactionId;
    public String type;
    private ArrayList<Transaction> medicines = new ArrayList<>();
    private String timeOfPurchase;
    private float totalPrice;
    public int employeeId;

    public TransactionRecord(){
        timeOfPurchase = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        totalPrice = 0;
    }

    public TransactionRecord(int transactionId, String type, ArrayList<Transaction> medicines, String timeOfPurchase, int totalPrice, int employeeId){
        this.transactionId = transactionId;
        this.type = type;
        this.medicines = medicines;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
        this.employeeId = employeeId;
    }

    public void addMedicine(String name, int quantity){
        medicines.add(new Transaction(name, quantity));
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        String price = Float.toString(totalPrice);
        int width = 60;

        result.append("Transaction Number : ").append(transactionId).append("\n");
        result.append("Transaction Type   : ").append(type.toUpperCase(Locale.ROOT)).append("\n");
        result.append("Transaction Time   : ").append(timeOfPurchase).append("\n");
        result.append("Employee ID        : ").append(employeeId).append("\n\n\n");

        for(Transaction medicine: medicines){
            result.append(medicine.getFormattedAmount(width)).append("\n");
        }
        result.append("\n");

        result.append("_".repeat(width));
        result.append("\n");

        result.append(" ".repeat(Math.max(0, width - price.length())));
        result.append(price).append("\n\n");

        return result.toString();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(String timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void addToTotalPrice(float price) {
        if(price > 0) {
            this.totalPrice += price;
        }
    }

    public ArrayList<Transaction> getMedicines() {
        return medicines;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
