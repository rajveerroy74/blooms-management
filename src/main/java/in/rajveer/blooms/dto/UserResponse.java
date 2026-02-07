package in.rajveer.blooms.dto;

public class UserResponse {
    private String username;
    private String email;
    private String name;
    private String profileUrl;
    private String phoneNumber;

    public UserResponse(String username, String email, String name, String profileUrl, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.profileUrl = profileUrl;
        this.phoneNumber = phoneNumber;
    }

    public UserResponse() {
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}