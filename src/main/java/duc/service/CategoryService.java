package duc.service;

import duc.model.Category;
import org.springframework.stereotype.Component;

public interface CategoryService {
    Iterable<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    Category remove(Long id);
}
