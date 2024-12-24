package com.aaron.identity_service.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreationRequest {

    @NotNull(message = "username must be not null")
    @Size(min = 8, max = 30, message = "username must be between 8 and 30 characters")
    private String username;

    private String password;

    @Size(min = 3, max = 30, message = "firstName must be between 8 and 30 characters")
    private String firstName;

    @Size(min = 3, max = 30, message = "lastName must be between 8 and 30 characters")
    private String lastName;

    private LocalDate dob;

    private UserCreationRequest() {

    }

    private UserCreationRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dob = builder.dob;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public static class Builder {
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private LocalDate dob;

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

        public UserCreationRequest build() {
            return new UserCreationRequest(this);
        }

    }

}
