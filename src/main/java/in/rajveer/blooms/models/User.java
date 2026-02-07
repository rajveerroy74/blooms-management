package in.rajveer.blooms.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id; // 1. Unique ID har user ke liye
    private String username; // 2. Username login id jise daal kar wo login karega (Unique honi chahiye)
    private String email; // 3. Contact Info
    private String name; // 4. Real Name: Display karne ke liye(Eg., "Rajveer Roy")
    private String profileUrl;// 5. Photo Link: Profile picture ka url String
    // 6. Security Key: Login karne ke liye
    // NOTE: Real projects mein hum isse Encrypt (Hash) karke rakhte hain.
    private String password;

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }

    public User(String username, String email, String name, String password, String profileUrl, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.profileUrl = profileUrl;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
