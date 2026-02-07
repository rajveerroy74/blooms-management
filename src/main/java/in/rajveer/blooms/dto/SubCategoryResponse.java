package in.rajveer.blooms.dto;

public class SubCategoryResponse {
    private String name;
    private String desc;
    private String categoryId;
    private String id;

    public SubCategoryResponse() {
    }

    public SubCategoryResponse(String name, String desc, String categoryId) {
        this.name = name;
        this.desc = desc;
        this.categoryId = categoryId;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}