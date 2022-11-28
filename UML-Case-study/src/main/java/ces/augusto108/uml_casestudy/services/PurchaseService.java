package ces.augusto108.uml_casestudy.services;

import ces.augusto108.uml_casestudy.domain.entities.Purchase;
import ces.augusto108.uml_casestudy.repositories.PurchaseRepository;
import ces.augusto108.uml_casestudy.services.exceptions.InstanceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase findById(Integer id) {
        return purchaseRepository.findById(id).orElseThrow(
                () -> new InstanceNotFoundException(
                        "Instance not found. Id: " + id + ", Type: " + Purchase.class.getName()
                )
        );
    }
}
