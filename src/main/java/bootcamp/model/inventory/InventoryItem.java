package bootcamp.model.inventory;

public class InventoryItem {
    private int quantity;
    private int id;


    public InventoryItem(){

    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryItem(int quantity, int id) {
        this.quantity = quantity;
        this.id = id;
    }
}
