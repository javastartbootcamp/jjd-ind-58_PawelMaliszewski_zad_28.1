package pl.javastart.restoffers.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    ResponseEntity<List<CategoryDto>> listOfDtoCategories() {
        if (categoryService.getListOfDtoCategories().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoryService.getListOfDtoCategories());
    }

    @GetMapping("/names")
    ResponseEntity<List<String>> listOfCategoryNames() {
        if (categoryService.listOfCategoryNames().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryService.listOfCategoryNames());
    }

    @PostMapping
    ResponseEntity<CategoryDto> insertCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto saved = categoryService.insertCategory(categoryDto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCategoryByID(@PathVariable Long id) {
        Boolean deleted = categoryService.deleteCategoryById(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
