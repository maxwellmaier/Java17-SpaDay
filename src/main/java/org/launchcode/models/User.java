package org.launchcode.models;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank(message = "Username Required")
    @Size(min = 5, max = 15)
    private String username;
    @Email(message = "Must be a valid Email")
    private String email;
    @NotBlank(message = "Password Required")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    private String password;
    private String verify;
    @NotBlank(message = "Password Required")
    @Size(min = 6, message = "Password must be at least 6 characters long.")
    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
        checkPassword();
    }

    public User() {

    }

    public User(String username, String email, String password, String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private void checkPassword () {
        if (password != null && verify != null && !password.equals(verify)) {
            setPassword(null);
        }
    }
}