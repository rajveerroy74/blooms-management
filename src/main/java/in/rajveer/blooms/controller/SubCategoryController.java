package in.rajveer.blooms.controller;

import in.rajveer.blooms.dto.SubCategoryRequest;
import in.rajveer.blooms.dto.SubCategoryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {
    private final List<SubCategoryResponse> subCategories = new ArrayList<>();

    @PostMapping
    public SubCategoryResponse createSubCategory(@RequestBody SubCategoryRequest request) {
        SubCategoryResponse response = new SubCategoryResponse(
                request.getName(),
                request.getDesc(),
                request.getCategoryId());
        response.setId(UUID.randomUUID().toString());
        subCategories.add(response);
        return response;
    }

    @GetMapping("/category/{categoryId}")
    public List<SubCategoryResponse> getSubCategoriesByCategoryId(@PathVariable String categoryId) {
        List<SubCategoryResponse> result = new ArrayList<>();
        for (SubCategoryResponse sub : subCategories) {
            if (sub.getCategoryId().equals(categoryId)) {
                result.add(sub);
            }
        }
        return result;
    }
}