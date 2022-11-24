package ces.augusto108.uml_casestudy;

import ces.augusto108.uml_casestudy.domain.entities.Category;
import ces.augusto108.uml_casestudy.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class UmlCaseStudyApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(UmlCaseStudyApplication.class, args);
    }

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Computers");
        Category category2 = new Category(null, "Office");
        Category category3 = new Category(null, "Clothes");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
    }
}
