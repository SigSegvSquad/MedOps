package medops;

public class TransactedMedicine {
    String medicineName;
    float price;
    int qty;

    TransactedMedicine(String medicine, int qty, float prc) {
        this.medicineName = medicine;
        this.price = prc;
        this.qty = qty;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public float getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String getFormattedAmount(int width) {
        StringBuilder result = new StringBuilder();
        String quantity = Integer.toString(qty);

        result.append(medicineName);
        result.append(" ".repeat(Math.max(0, width - medicineName.length() - quantity.length())));
        result.append(quantity);

        return result.toString();
    }
}
