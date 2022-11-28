package ces.augusto108.uml_casestudy.services;

import ces.augusto108.uml_casestudy.domain.entities.Payment;
import ces.augusto108.uml_casestudy.repositories.PaymentRepository;
import ces.augusto108.uml_casestudy.services.exceptions.InstanceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment findById(Integer id) {
        return paymentRepository.findById(id).orElseThrow(
                () -> new InstanceNotFoundException(
                        "Instance not found. Id: " + id + ", Type: " + Payment.class.getName()
                )
        );
    }
}
