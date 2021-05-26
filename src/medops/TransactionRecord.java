package medops;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class TransactionRecord {
    public static int lastTransactionID = 0;
    public String type;
    public ArrayList<TransactedMedicine> medicines = new ArrayList<>();
    public int employeeId;
    private int transactionId;
    private String timeOfPurchase;
    private float totalPrice;

    public TransactionRecord() {
        timeOfPurchase = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
        totalPrice = 0;
    }

    public TransactionRecord(int transactionId, String type, ArrayList<TransactedMedicine> medicines, String timeOfPurchase, int totalPrice, int employeeId) {
        this.transactionId = transactionId;
        this.type = type;
        this.medicines = medicines;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
        this.employeeId = employeeId;
    }

    public void addMedicine(String name, int quantity, float price) {
        medicines.add(new TransactedMedicine(name, quantity, price));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String price = Float.toString(totalPrice);
        int width = 60;

        result.append("Transaction Number : ").append(transactionId).append("\n");
        result.append("Transaction Type   : ").append(type.toUpperCase(Locale.ROOT)).append("\n");
        result.append("Transaction Time   : ").append(timeOfPurchase).append("\n");
        result.append("Employee ID        : ").append(employeeId).append("\n\n\n");

        for (TransactedMedicine medicine : medicines) {
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
        if (price > 0) {
            this.totalPrice += price;
        }
    }

    public ArrayList<TransactedMedicine> getMedicines() {
        return medicines;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
