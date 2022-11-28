package ces.augusto108.uml_casestudy.controllers;

import ces.augusto108.uml_casestudy.domain.entities.Category;
import ces.augusto108.uml_casestudy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping(value = "/add")
    public void save(@RequestParam String name) {
        categoryService.save(new Category(null, name));
    }
}
