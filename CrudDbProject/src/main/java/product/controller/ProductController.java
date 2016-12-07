package product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import product.entity.Product;
import product.service.DbService;

/**
 * Created by Stasia on 07.12.16.
 */
@Controller("ProductController")
public class ProductController {
    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    DbService dbService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity findAllProduct() {
        LOGGER.info("ProductContoller REQUEST findAll");

        Iterable<Product> productList = dbService.findAllProducts();
        ResponseEntity responseEntity = new ResponseEntity<>(productList, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.PATCH)
    public ResponseEntity updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        LOGGER.info("ProductContoller REQUEST update");

        Product updateProduct = dbService.findOneProduct(id);
        if (product.getModel() != null) {
            updateProduct.setModel(product.getModel());
        }

        if (product.getCost() != null) {
            updateProduct.setCost(product.getCost());
        }

        dbService.saveProduct(updateProduct);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id) {
        LOGGER.info("ProductContoller REQUEST delete");

        dbService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
