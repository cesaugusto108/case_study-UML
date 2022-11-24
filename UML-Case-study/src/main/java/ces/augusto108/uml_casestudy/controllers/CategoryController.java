package ces.augusto108.uml_casestudy.controllers;

import ces.augusto108.uml_casestudy.domain.entities.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @GetMapping(value = "/list")
    public List<Category> list() {
        Category category1 = new Category(1, "Computers");
        Category category2 = new Category(2, "Office");

        return Arrays.asList(category1, category2);
    }
}
