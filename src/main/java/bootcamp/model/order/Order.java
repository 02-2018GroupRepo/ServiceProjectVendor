package bootcamp.model.order;

public class Order {
   private int id;
    private int quantity;


    public Order(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
