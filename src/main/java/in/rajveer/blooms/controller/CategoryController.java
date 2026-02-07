package in.rajveer.blooms.controller;

import in.rajveer.blooms.dto.CategoryRequest;
import in.rajveer.blooms.dto.CategoryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final List<CategoryResponse> categories = new ArrayList<>();

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request) {
        CategoryResponse response = new CategoryResponse(
                UUID.randomUUID().toString(),
                request.getTitle(),
                request.getDesc(),
                request.getCUrl());
        categories.add(response);
        return response;
    }

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return categories;
    }
}