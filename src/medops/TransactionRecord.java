package medops;

import org.json.JSONArray;

class Transaction {
    String medicine;
    int qty;

    Transaction(String medicine, int qty){
        this.medicine = medicine;
        this.qty = qty;
    }
}

public class TransactionRecord {
    private int transactionId;
    public String type;
    private Transaction[] medicines;
    private String timeOfPurchase;
    private int totalPrice;
    public int employeeId;

    TransactionRecord(int transactionId, String type, Transaction[] medicines, String timeOfPurchase, int totalPrice, int employeeId ){
        this.transactionId = transactionId;
        this.type = type;
        this.medicines = medicines;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
        this.employeeId = employeeId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getType() {
        return type;
    }

    public Transaction[] getMedicines() {
        return medicines;
    }

    public String getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getEmployeeId() {
        return employeeId;
    }

}
