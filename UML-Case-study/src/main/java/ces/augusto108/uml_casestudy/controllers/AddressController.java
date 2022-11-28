package ces.augusto108.uml_casestudy.controllers;

import ces.augusto108.uml_casestudy.domain.entities.Address;
import ces.augusto108.uml_casestudy.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Address> list(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }
}
