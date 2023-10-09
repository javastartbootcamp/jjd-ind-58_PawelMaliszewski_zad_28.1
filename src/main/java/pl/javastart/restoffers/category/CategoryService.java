package pl.javastart.restoffers.category;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> getListOfDtoCategories() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categoryDtoList.add(categoryMapper.convertToDtoCategory(category)));
        return categoryDtoList;
    }

    public List<String> listOfCategoryNames() {
        return categoryRepository.getCategoryNamesFromDataBase();
    }

    public CategoryDto insertCategory(CategoryDto categoryDto) {
        Category save = categoryRepository.save(categoryMapper.convertToCategory(categoryDto));
        return categoryMapper.convertToDtoCategory(save);
    }

    public Boolean deleteCategoryById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
