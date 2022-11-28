package ces.augusto108.uml_casestudy.controllers;

import ces.augusto108.uml_casestudy.domain.entities.Client;
import ces.augusto108.uml_casestudy.domain.enums.ClientType;
import ces.augusto108.uml_casestudy.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Client> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping(value = "add")
    public void save(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String identification,
            @RequestParam Integer type
    ) {
        clientService.save(new Client(null, name, email, identification, ClientType.convertToEnum(type)));
    }
}
