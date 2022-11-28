package ces.augusto108.uml_casestudy.controllers;

import ces.augusto108.uml_casestudy.domain.entities.Product;
import ces.augusto108.uml_casestudy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Product> list(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }
}
