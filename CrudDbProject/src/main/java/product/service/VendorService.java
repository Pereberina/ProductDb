package product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import product.entity.Vendor;
import product.repo.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Stasia on 30.11.16.
 */
@Service("vendorService")
public class VendorService {
    private static Logger LOGGER = LoggerFactory.getLogger(VendorService.class);

    @Autowired
    private VendorRepository vendorRepo;


    public Iterable<Vendor> findAll() {
        LOGGER.info("VendorEntity findAll request");
       return vendorRepo.findAll();
    }

    public Vendor findById(int id) {
        LOGGER.info("VendorEntity findById request: " + id);

        return vendorRepo.findOne(id);
    }

    public List<Vendor> findByName(String name) {
        LOGGER.info("VendorEntity findByName request: " + name);

        return vendorRepo.findByName(name);
    }

    public void save(Vendor vendor) {
        LOGGER.info("VendorEntity save request: " + vendor.toString());
        vendorRepo.save(vendor);
    }

    public void delete(Integer id) {
        LOGGER.info("VendorEntity delete request: " + id);
        vendorRepo.delete(id);
    }

}
