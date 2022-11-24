package ces.augusto108.uml_casestudy.repositories;

import ces.augusto108.uml_casestudy.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
