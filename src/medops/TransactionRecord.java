package medops;

class Transaction {
    Medicine medicine;
    int qty;
}

public class TransactionRecord {
    private int employeeId;
    private Transaction[] transactions;
    private String timeOfPurchase;
    private int totalPrice;

    TransactionRecord(){

    }
}
