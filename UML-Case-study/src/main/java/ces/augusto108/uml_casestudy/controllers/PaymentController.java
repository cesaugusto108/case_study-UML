package ces.augusto108.uml_casestudy.controllers;

import ces.augusto108.uml_casestudy.domain.entities.Payment;
import ces.augusto108.uml_casestudy.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Payment> list(@PathVariable Integer id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }
}
