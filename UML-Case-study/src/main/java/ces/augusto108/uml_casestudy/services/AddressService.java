package ces.augusto108.uml_casestudy.services;

import ces.augusto108.uml_casestudy.domain.entities.Address;
import ces.augusto108.uml_casestudy.repositories.AddressRepository;
import ces.augusto108.uml_casestudy.services.exceptions.InstanceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address findById(Integer id) {
        return addressRepository.findById(id).orElseThrow(
                () -> new InstanceNotFoundException(
                        "Instance not found. Id: " + id + ", Type: " + Address.class.getName()
                )
        );
    }
}
