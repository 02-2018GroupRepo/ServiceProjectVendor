package bootcamp.dao;

import bootcamp.model.inventory.Inventory;
import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
public class InventoryDao {
    private final String GET_PRODUCTS = "SELECT Product.id, Product.retail_price, Inventory.number_available FROM Product INNER JOIN Inventory ON Product.id=Inventory.id";

    private final String GET_LOW_PRODUCTS = "SELECT id, number_available from Inventory where number_available < 10";


    private final String GET_PRODUCT_BY_ID_SQL = GET_PRODUCTS + " where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("#{'${listOfThings}'.split(',')}")
    private List<String> listOfThings;

//    @Autowired
//    private List<InventoryItem> items;

//    public List<InventoryItem> getInventory() {
//        return jdbcTemplate.query(GET_PRODUCTS, new BeanPropertyRowMapper<>(InventoryItem.class));
//    }

    public List<InventoryItem> getInventory() {
        return jdbcTemplate.query(GET_PRODUCTS, new BeanPropertyRowMapper<>(InventoryItem.class));
    }
    public List<InventoryItem> getLowInventory() {
        return jdbcTemplate.query(GET_LOW_PRODUCTS, new BeanPropertyRowMapper<>(InventoryItem.class));
    }

    public InventoryItem getInventoryById(Integer id) {
        return jdbcTemplate.queryForObject(GET_PRODUCT_BY_ID_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(InventoryItem.class));
    }

    public List<String> getListOfThings() {
        return listOfThings;
    }

    public void addToInventory(int productID, int quantity, double wholeSalePrice){

        String updating_wholesale_price= "UPDATE product SET wholesale_price = " + wholeSalePrice + ", retail_price = " + wholeSalePrice + " * 1.50 WHERE id = " + productID;
        String updating_quantity = "UPDATE inventory SET number_available = number_available +" + quantity + " WHERE id = " + productID;

       jdbcTemplate.update(updating_wholesale_price);
       jdbcTemplate.update(updating_quantity);
    }
//

//    public List<InventoryItem> getListOfInventory() {
//        return items;
//    }


}
