package ces.augusto108.uml_casestudy.services;

import ces.augusto108.uml_casestudy.domain.entities.Product;
import ces.augusto108.uml_casestudy.repositories.ProductRepository;
import ces.augusto108.uml_casestudy.services.exceptions.InstanceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(
                () -> new InstanceNotFoundException(
                        "Instance not found. Id: " + id + ", Type: " + Product.class.getName()
                )
        );
    }
}
