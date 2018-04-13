package bootcamp.model.inventory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class InventoryItem {
    private int number_available;
    private BigDecimal retail_price;
    private int id;


    public InventoryItem(){

    }

    public InventoryItem(int number_available, BigDecimal retail_price, int id) {
        this.number_available = number_available;
        this.retail_price = retail_price;
        this.id = id;
    }


    public int getNumber_available() {
        return number_available;
    }

    public void setNumber_available(int number_available) {
        this.number_available = number_available;
    }

    public BigDecimal getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(BigDecimal retail_price) {
        this.retail_price = retail_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
