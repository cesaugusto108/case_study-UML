package ces.augusto108.uml_casestudy.controllers;

import ces.augusto108.uml_casestudy.domain.entities.Purchase;
import ces.augusto108.uml_casestudy.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/purchases")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Purchase> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(purchaseService.findById(id));
    }
}
