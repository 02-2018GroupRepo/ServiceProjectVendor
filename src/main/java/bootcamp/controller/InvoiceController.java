package bootcamp.controller;
import bootcamp.model.invoice.Payment;
import bootcamp.model.inventory.InventoryItem;
import bootcamp.model.invoice.Invoice;
import bootcamp.model.order.Order;
import bootcamp.model.products.Product;
import bootcamp.service.InventoryService;
import bootcamp.service.OrderService;
import bootcamp.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;


//    @Autowired
//    private Payment invoice;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/testLowestPrice")
    public void testLowestPrice() {
        InventoryItem inventoryItem = new InventoryItem();
        inventoryItem.setId(1);
        inventoryItem.setRetail_price(BigDecimal.valueOf(1.00));
        inventoryItem.setNumber_available(5);
        List<InventoryItem> lowInventoryList = new ArrayList<InventoryItem>();
        lowInventoryList.add(inventoryItem);
        orderService.createOrderList(lowInventoryList);
    }

    @PostMapping("/order")
    public Invoice order() {
        Product invoicedProduct = new Product();
        invoicedProduct.setId(1);
        invoicedProduct.setName("Cola");
        invoicedProduct.setDescription("");
        invoicedProduct.setRetail_price(2.00);
        invoicedProduct.setWholesale_price(1.90);
        Invoice invoice = new Invoice(invoicedProduct, 5);
        return invoice;
    }


    @RequestMapping(value="/order", method=RequestMethod.POST)
    public Order makeOrder() {
        return new Order();

    }


//    @RequestMapping("inventory/{id}")
//    public InventoryItem showInventoryById(@PathVariable Integer id){
//        log.debug("Retreiving product " + id);
//        return inventoryService.getInventoryItemById(id);
//
//    }
//    @RequestMapping(value="order/{id}-{quantity}", method=RequestMethod.GET)
//    public Order makeOrder(@PathVariable("id") int id, @PathVariable("quantity") int quantity ) {
//        productService.getProductById(id)
//        return new Order(id, quantity);
//
//    }





    @PostMapping("/payment")
    public Boolean payment(@RequestBody Payment payment) {
        return true;
    }

    @RequestMapping("makeApiCalls")
    public void makeAPI() {
        orderService.makeApiCalls();
    }

    @RequestMapping("inventory/A")
    public List<InventoryItem> showInventoryA(){
        return inventoryService.getInventory();
    }

    @RequestMapping("inventory/B")
    public List<InventoryItem> showInventoryB(){
        return inventoryService.getInventory();
    }

    @RequestMapping("inventory/C")
    public List<InventoryItem> showInventoryC(){
        return inventoryService.getInventory();
    }
}
