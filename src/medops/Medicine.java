package medops;

public class Medicine {
    private int id;
    private String name;
    private float price;
    private int qty;

    Medicine(int id, String name, int quantity, int price){
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = quantity;
    }

    public Medicine(Medicine medicine){
        this.id = medicine.id;
        this.name = medicine.name;
        this.price = medicine.price;
        this.qty = medicine.qty;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
