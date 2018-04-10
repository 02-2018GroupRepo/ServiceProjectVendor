package bootcamp.model.order;

public class Order {
   private int id;
    private int number_available;


    public Order(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_available() {
        return number_available;
    }

    public void setNumber_available(int number_available) {
        this.number_available = number_available;
    }

    public Order(int id, int number_available) {
        this.id = id;
        this.number_available = number_available;
    }
}
