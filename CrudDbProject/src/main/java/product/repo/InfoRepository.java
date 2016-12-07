package product.repo;

/**
 * Created by Stasia on 23.11.16.
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import product.entity.Info;
import product.entity.Product;


public interface InfoRepository extends CrudRepository<Info, Integer> {

    List<Info> findByLine(String line);
    List<Info> findByProduct(Product product);
}