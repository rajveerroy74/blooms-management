package in.rajveer.blooms.dto;

public class UserRequest {
    private String username;
    private String email;
    private String name;
    private String password;
    private String profileUrl;
    private String phoneNumber;

    public UserRequest(String username, String email, String name, String password, String profileUrl, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.profileUrl = profileUrl;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getProfileUrl() { return profileUrl; }
    public String getPhoneNumber() { return phoneNumber; }
}