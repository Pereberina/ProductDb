package product.repo;

/**
 * Created by Stasia on 23.11.16.
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import product.entity.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Integer> {

    List<Vendor> findByName(String name);
}