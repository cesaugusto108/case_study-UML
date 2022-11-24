package ces.augusto108.uml_casestudy.repositories;

import ces.augusto108.uml_casestudy.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
