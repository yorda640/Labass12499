

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private List<User> userList;

    public LoginService() {
        this.userList = new ArrayList<>();
        // Add sample user(s) - replace with your user data
        userList.add(new User("admin", "admin123"));
    }

    public void authenticateUser(String enteredUsername, String enteredPassword) {
        try {
            // Implement authentication logic with exception handling
            // Check if the entered username and password match any user in the userlist
            // Throw appropriate exceptions for incorrect username, incorrect password, blank input, etc.

            // Example:
            User authenticatedUser = findUserByUsername(enteredUsername);

            if (authenticatedUser != null && authenticatedUser.getPassword().equals(enteredPassword)) {
                System.out.println("Login successful! Welcome, " + authenticatedUser.getUsername() + "!");
            } else {
                throw new AuthenticationException("Invalid username or password.");
            }
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // Return null if no matching user is found
    }

    public static void main(String[] args) {
        LoginService loginService = new LoginService();

        // Example usage - replace with user input or your testing scenario
        loginService.authenticateUser("admin", "admin123");
    }
}

class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

