package product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import product.entity.Product;
import product.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Stasia on 30.11.16.
 */
@Service("productService")
public class ProductService {
    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepo;


    public Iterable<Product> findAll() {
        LOGGER.info("ProductEntity findAll request");

        return productRepo.findAll();
    }

    public Product findById(int id) {
        LOGGER.info("ProductEntity findById request: " + id);

        return productRepo.findOne(id);
    }

    public List<Product> findByLine(String model) {
        LOGGER.info("ProductEntity findByModel request: " + model);

        return productRepo.findByModel(model);
    }

    public void save(Product product) {
        LOGGER.info("ProductEntity save request: " + product.toString());
        productRepo.save(product);
    }

    public void delete(Integer id) {
        LOGGER.info("ProductEntity delete request: " + id);
        productRepo.delete(id);
    }
}
