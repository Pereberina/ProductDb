package product.controller;

/**
 * Created by Stasia on 30.11.16.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import product.entity.Vendor;
import product.requestBody.ProductInfo;
import product.service.DbService;
import product.entity.*;

@Controller
public class MainController {
    private static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    DbService dbService;

    @RequestMapping(value = "/products", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addProduct(@RequestBody ProductInfo productInfo) {
        LOGGER.info("MainController REQUEST addProduct");

        Product product = new Product(productInfo.getModel(), productInfo.getCost());
        Info info = new Info(productInfo.getQuantity(), productInfo.getLine(), productInfo.getCores());

        Vendor vendor = dbService.findOneVendor(productInfo.getVendorId());


        product.setVendor(vendor);
        product.setInfo(info);
        info.setProduct(product);


        dbService.saveInfo(info);
        dbService.saveProduct(product);


        return new ResponseEntity(HttpStatus.CREATED);
    }


}
