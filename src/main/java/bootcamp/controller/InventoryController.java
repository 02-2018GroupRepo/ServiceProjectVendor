package bootcamp.controller;

import java.util.ArrayList;
import java.util.List;

import bootcamp.model.inventory.InventoryItem;
import bootcamp.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.model.products.Product;
import bootcamp.service.InventoryService;
import bootcamp.model.inventory.Inventory;
import org.springframework.web.client.RestTemplate;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	@Autowired
    private RestTemplate restTemplate;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("inventory/all")
	public List<InventoryItem> showInventory(){
		return inventoryService.getInventory();
	}


	public void getSupplierInventory(String url){
        ArrayList<Inventory> supplierInventory = restTemplate.getForObject(url, ArrayList.class);
    }

	@RequestMapping("/test")
	public String getInventory(){
		return "testing";
	}
//	@RequestMapping(name = "inventory/receive", method=RequestMethod.POST)
//    public void getProduct(@RequestBody List<Product> products) {
//		log.debug("Receiving products");
//    	inventoryService.receiveInventory(products);
//    }
	
}
