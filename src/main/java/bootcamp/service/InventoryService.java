package bootcamp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bootcamp.dao.InventoryDao;
import bootcamp.dao.ProductDao;
import bootcamp.model.inventory.Inventory;
import bootcamp.model.inventory.InventoryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bootcamp.model.products.Product;

@Component
public class InventoryService {

	@Autowired
	private InventoryDao dao;

	@Autowired
	private List<Product> inventoryList;
	private static final Logger log = LoggerFactory.getLogger(InventoryService.class);
	 
	 @Autowired
	 private SimpleDateFormat dateFormat;
	
//	public void receiveInventory(List<Product> products) {
//		inventoryList.addAll(products);
//	}

	public List<InventoryItem> getInventory(){
		return dao.getInventory();
	}

	public List<InventoryItem> getInventoryById(Integer id){
		return dao.getInventory();
	}
	public void addToInventory(int productID, int quantity, double wholeSalePrice){
		dao.addToInventory(productID, quantity, wholeSalePrice);
	}
	@Scheduled(cron = "${inventory.status.schedule}")
    public void inventoryStatus() {
        log.info("Checking on inventory status at {}", dateFormat.format(new Date()));
        log.debug("Debug goes here");
    }
}
