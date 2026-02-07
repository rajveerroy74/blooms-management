package in.rajveer.blooms.controller;

import in.rajveer.blooms.dto.SubCategoryRequest;
import in.rajveer.blooms.dto.SubCategoryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SubCategoryController {
    private final List<SubCategoryResponse> subCategories = new ArrayList<>();

    public SubCategoryResponse createSubCategory(SubCategoryRequest request) {
        SubCategoryResponse response = new SubCategoryResponse(
                request.getName(),
                request.getDesc(),
                request.getCategoryId()
        );
        response.setId(UUID.randomUUID().toString());
        subCategories.add(response);
        return response;
    }

    public List<SubCategoryResponse> getSubCategoriesByCategoryId(String categoryId) {
        List<SubCategoryResponse> result = new ArrayList<>();
        for (SubCategoryResponse sub : subCategories) {
            if (sub.getCategoryId().equals(categoryId)) {
                result.add(sub);
            }
        }
        return result;
    }
}