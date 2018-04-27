package bootcamp

import bootcamp.model.inventory.InventoryItem
import bootcamp.model.products.Product

import spock.lang.Specification


class RequestProductSpec extends Specification {
    def "Request the product when is low"(){
        given: "A product id"
        Product product = new Product()
        product.setId(1);
        and: "An inventory"
        InventoryItem inventory = new InventoryItem()
        when: "The inventory for the product is low"
          inventory.checkQuantity();
        then: "The product is requested"
    }



}