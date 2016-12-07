package product.repo;

/**
 * Created by Stasia on 23.11.16.
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByModel(String model);
}
