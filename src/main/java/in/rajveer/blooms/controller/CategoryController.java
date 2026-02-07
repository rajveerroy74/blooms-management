package in.rajveer.blooms.controller;

import in.rajveer.blooms.dto.CategoryRequest;
import in.rajveer.blooms.dto.CategoryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryController {
    private final List<CategoryResponse> categories = new ArrayList<>();

    public CategoryResponse createCategory(CategoryRequest request) {
        CategoryResponse response = new CategoryResponse(
                UUID.randomUUID().toString(),
                request.getTitle(),
                request.getDesc(),
                request.getCUrl());
        categories.add(response);
        return response;
    }

    public List<CategoryResponse> getCategories() {
        return categories;
    }
}