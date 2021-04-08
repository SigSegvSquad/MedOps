package medops;

import org.json.JSONArray;

class Transaction {
    Medicine medicine;
    int qty;
}

public class TransactionRecord {
    private int transactionId;
    public String type;
    private JSONArray medicines;
    private String timeOfPurchase;
    private int totalPrice;
    public int employeeId;

    TransactionRecord(int transactionId, String type, JSONArray medicines, String timeOfPurchase, int totalPrice, int employeeId ){
        this.transactionId = transactionId;
        this.type = type;
        this.medicines = medicines;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
        this.employeeId = employeeId;
    }
}
