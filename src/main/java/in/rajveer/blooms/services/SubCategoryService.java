
package in.rajveer.blooms.services;

import in.rajveer.blooms.models.SubCategory;
import in.rajveer.blooms.repositories.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    // Create
    public SubCategory createSubCategory(SubCategory subCategory) {

        return subCategoryRepository.save(subCategory);
    }

    // Get By Category Id
    public List<SubCategory> getSubCategoriesByCategory(String categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }

    // Delete
    public boolean deleteSubCategory(String id) {
        if (subCategoryRepository.existsById(id)) {
            subCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // get All
    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }
}