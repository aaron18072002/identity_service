package com.aaron.identity_service.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class UserResponse {

    private String userId;
    private String username;

    @JsonIgnore
    private String password;

    private String firstName;
    private String lastName;
    private LocalDate dob;

    private UserResponse() {

    }

    private UserResponse(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dob = builder.dob;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public static class Builder {

        private String userId;
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private LocalDate dob;

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withDob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public UserResponse build() {
            return new UserResponse(this);
        }

    }

}
