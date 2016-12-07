package product.service;

/**
 * Created by Stasia on 23.11.16.
 */
import org.springframework.beans.factory.annotation.Autowired;
import product.entity.Info;
import product.entity.Product;
import product.entity.Vendor;
import product.repo.InfoRepository;
import product.repo.ProductRepository;
import product.repo.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("dbService")
public class DbService {
    @Autowired
    private VendorService vendorService;

    @Autowired
    private InfoService infoService;

    @Autowired
    private ProductService productService;


    public void saveProduct(Product product) {
        productService.save(product);
    }

    public void saveProduct(String model, String line, Integer cores, Integer cost, Integer quantity, Vendor vendor) {
        Product product = new Product(model, cost);
        Info info = new Info(quantity, line, cores);
        product.setVendor(vendor);

        info.setProduct(product);
        product.setInfo(info);

        infoService.save(info);
        productService.save(product);
    }

    public void deleteProduct(Integer id) {
        productService.delete(id);
    }

    public void saveVendor(Vendor vendor) {
        vendorService.save(vendor);
    }

    public void deleteVendor(Integer id) {vendorService.delete(id); }

    public void saveVendor(String country, String name, String officialUrl) {
        vendorService.save(new Vendor(country, name, officialUrl));
    }

    public Iterable<Vendor> findAllVendors() {
        return vendorService.findAll();
    }

    public Vendor findOneVendor(Integer id) {
        return vendorService.findById(id);
    }

    public List<Vendor> findVendorByName(String name) {
        return vendorService.findByName(name);
    }

    public Iterable<Product> findAllProducts() {
        return productService.findAll();
    }

    public Product findOneProduct(Integer id) {
        return productService.findById(id);
    }

    public Iterable<Info> findAllInfo() {
        return infoService.findAll();
    }

    public Info findOneInfo(Integer id) {
        return infoService.findById(id);
    }

    public List<Info> findInfoByLine(String line) {
        return infoService.findByLine(line);
    }

    public List<Info> findInfoByProduct(Product product) {
        return infoService.findByProduct(product);
    }

    public void saveInfo(Info info) {
        infoService.save(info);
    }

    public void deleteInfo(Integer id) {
        infoService.delete(id);
    }

}
