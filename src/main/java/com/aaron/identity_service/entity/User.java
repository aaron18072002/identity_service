package com.aaron.identity_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username", columnDefinition = "VARCHAR(30) NOT NULL")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(200) NOT NULL")
    private String password;

    @Column(name = "first_name", columnDefinition = "VARCHAR(30)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(30)")
    private String lastName;

    @Column(name = "dob", columnDefinition = "DATE")
    private LocalDate dob;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role"))
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

}
