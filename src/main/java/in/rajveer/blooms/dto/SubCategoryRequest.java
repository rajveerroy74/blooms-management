package in.rajveer.blooms.dto;

public class SubCategoryRequest {
    private String categoryId;
    private String name;
    private String desc;

    public SubCategoryRequest() {}

    public SubCategoryRequest(String categoryId, String name, String desc) {
        this.categoryId = categoryId;
        this.name = name;
        this.desc = desc;
    }

    // Getters & Setters
    public String getCategoryId() { return categoryId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}