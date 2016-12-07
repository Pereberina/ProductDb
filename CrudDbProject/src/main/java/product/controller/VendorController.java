package product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import product.entity.Vendor;
import product.service.DbService;

/**
 * Created by Stasia on 07.12.16.
 */

// TODO: requestBody for each entity
// TODO: в сервис убрать save
// TODO: get by Id
// TODO: code refactoring

@Controller("VendorController")
public class VendorController {
    private static Logger LOGGER = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    DbService dbService;

    @RequestMapping(value = "/vendors", method = RequestMethod.GET)
    public ResponseEntity findAllVendors() {
        LOGGER.info("VendorContoller REQUEST findAll");

        Iterable<Vendor> vendorList = dbService.findAllVendors();
        ResponseEntity responseEntity = new ResponseEntity<>(vendorList, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/vendors", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addVendor(@RequestBody Vendor vendor) {
        LOGGER.info("VendorContoller REQUEST addVendor");

        dbService.saveVendor(vendor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/vendors/{id}", method = RequestMethod.PUT)
    public ResponseEntity setVendor(@PathVariable("id") Integer id, @RequestBody Vendor vendor) {
        LOGGER.info("VendorContoller REQUEST setVendor");

        Vendor oldVendor = dbService.findOneVendor(id);
        oldVendor.setCountry(vendor.getCountry());
        oldVendor.setName(vendor.getName());
        oldVendor.setOfficialUrl(vendor.getOfficialUrl());

        dbService.saveVendor(oldVendor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/vendors/{id}", method = RequestMethod.PATCH)
    public ResponseEntity updateVendor(@PathVariable("id") Integer id, @RequestBody Vendor vendor) {
        LOGGER.info("VendorContoller REQUEST updateVendor");
        Vendor oldVendor = dbService.findOneVendor(id);
        if (vendor.getCountry() != null) {
            oldVendor.setCountry(vendor.getCountry());
        }
        if (vendor.getName() != null) {
            oldVendor.setName(vendor.getName());
        }
        if (vendor.getOfficialUrl() != null) {
            oldVendor.setOfficialUrl(vendor.getOfficialUrl());
        }


        dbService.saveVendor(oldVendor);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/vendors/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteVendor(@PathVariable("id") Integer id) {
        LOGGER.info("VendorContoller REQUEST deleteVendor");
        dbService.deleteVendor(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}

