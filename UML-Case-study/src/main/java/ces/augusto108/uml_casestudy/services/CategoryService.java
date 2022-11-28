package ces.augusto108.uml_casestudy.services;

import ces.augusto108.uml_casestudy.domain.entities.Category;
import ces.augusto108.uml_casestudy.repositories.CategoryRepository;
import ces.augusto108.uml_casestudy.services.exceptions.InstanceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new InstanceNotFoundException(
                        "Instance not found. Id: " + id + ", Type: " + Category.class.getName()
                )
        );
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
}
