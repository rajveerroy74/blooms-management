package in.rajveer.blooms;

import in.rajveer.blooms.controller.CategoryController;
import in.rajveer.blooms.controller.SubCategoryController;
import in.rajveer.blooms.controller.UserController;
import in.rajveer.blooms.dto.*;

import in.rajveer.blooms.services.UserService;
import java.util.List;

public class UiClient {
    public static void main(String[] args) {
        System.out.println("--- UI Client Started ---");

        // Category Controller
        CategoryController categoryController = new CategoryController();

        System.out.println("Step 1: Creating Categories...");

        CategoryRequest req1 = new CategoryRequest(
                "Technology",
                "All about Java and Coding",
                "https://tech-image.com/java.png");
        categoryController.createCategory(req1);

        CategoryRequest req2 = new CategoryRequest(
                "Health",
                "Fitness and Diet Tips",
                "https://health-image.com/yoga.png");
        categoryController.createCategory(req2);

        System.out.println("\nStep 2: Fetching All Categories...");
        List<CategoryResponse> categoryResponseList = categoryController.getCategories();

        for (CategoryResponse cat : categoryResponseList) {
            System.out.println("----------------------------");
            System.out.println("ID: " + cat.getId());
            System.out.println("Title: " + cat.getTitle());
            System.out.println("Description: " + cat.getDesc());
            // FIXED getter name — adjust to your DTO
            System.out.println("Image URL: " + cat.getCUrl());
            System.out.println("----------------------------");
        }

        CategoryController catController = new CategoryController();
        CategoryRequest catReq = new CategoryRequest("Technology", "Tech Stuff", "url");
        catController.createCategory(catReq);

        String techId = catController.getCategories().get(0).getId();
        System.out.println("Tech Category ID mil gayi: " + techId);

        SubCategoryController subController = new SubCategoryController();
        System.out.println("\n--- Creating SubCategories ---");

        SubCategoryRequest javaReq = new SubCategoryRequest(techId, "Java", "Core Java");
        subController.createSubCategory(javaReq);

        SubCategoryRequest pythonReq = new SubCategoryRequest(techId, "Python", "AI ML");
        subController.createSubCategory(pythonReq);

        SubCategoryRequest errorReq = new SubCategoryRequest("9999", "Alien Tech", "Sci-Fi Stuff");
        subController.createSubCategory(errorReq);

        System.out.println("\n--- Fetching SubCategories for Technology ---");
        List<SubCategoryResponse> techSub = subController.getSubCategoriesByCategoryId(techId);

        for (SubCategoryResponse sub : techSub) {
            System.out.println("Found: " + sub.getName());
        }

        System.out.println("\n--- TESTING USER MODULE ---");
        // Create Mock Service and Controller
        UserService mockService = new MockUserService();
        UserController userController = new UserController(mockService);

        UserRequest user1 = new UserRequest(
                "superadmin",
                "admin@blooms.in",
                "Super Admin",
                "admin123",
                "avatar.png",
                "1234567890");

        String result = userController.registerUser(user1);
        System.out.println(result);

        String result2 = userController.registerUser(user1);
        System.out.println("Duplicate Check: " + result2);

        System.out.println("\n--- Trying Wrong Login ---");
        userController.loginUser("superadmin", "wrongpass");

        System.out.println("\n--- Trying Correct Login ---");
        UserResponse loggedInUser = userController.loginUser("superadmin", "admin123");

        if (loggedInUser != null) {
            System.out.println("Welcome Dashboard: " + loggedInUser.getName());
        }
    }

    // Mock Service for standalone testing
    static class MockUserService extends in.rajveer.blooms.services.UserService {
        private java.util.Map<String, in.rajveer.blooms.models.User> users = new java.util.HashMap<>();

        public MockUserService() {
            super(null);
        }

        @Override
        public String registerUser(in.rajveer.blooms.models.User user) {
            if (users.containsKey(user.getUsername())) {
                return "Error: Username " + user.getUsername() + " already exists!";
            }
            user.setId(java.util.UUID.randomUUID().toString());
            users.put(user.getUsername(), user);
            return "Success: User registered with ID: " + user.getId();
        }

        @Override
        public in.rajveer.blooms.dto.UserResponse loginUser(String username, String password) {
            in.rajveer.blooms.models.User u = users.get(username);
            if (u != null && u.getPassword().equals(password)) {
                return new in.rajveer.blooms.dto.UserResponse(
                        u.getUsername(),
                        u.getEmail(),
                        u.getName(),
                        u.getProfileUrl(),
                        u.getPhoneNumber());
            }
            return null;
        }
    }
}