package bootcamp.model.inventory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class InventoryItem {
    private int number_available;
    private BigDecimal wholesale_price;
    private int id;


    public InventoryItem(){

    }

    public int getNumber_available() {
        return number_available;
    }

    public void setNumber_available(int number_available) {
        this.number_available = number_available;
    }

    public BigDecimal getWholesale_price() {
        return wholesale_price;
    }

    public void setWholesale_price(BigDecimal wholesale_price) {
        this.wholesale_price = wholesale_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryItem(int number_available, BigDecimal wholesale_price, int id) {
        this.number_available = number_available;
        this.wholesale_price = wholesale_price;
        this.id = id;
    }
}
