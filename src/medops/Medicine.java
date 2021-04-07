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
}
