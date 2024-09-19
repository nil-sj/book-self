package com.bookself.bookself_api.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String bio;

    @Lob // To store binary large object data (e.g., images)
    @Column(name = "profile_photo", columnDefinition = "BLOB")
    private byte[] profilePhoto;

    @Enumerated(EnumType.STRING)  // Maps enum to its string value in the database
    @Column(name = "role")
    private Set<UserRole> roles = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_wishlist_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> wishlistBooks = new HashSet<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    private LocalDateTime lastLoginAt;

    // Constructors
    public User() {
    }

    public User(String email, String password, String name, String bio,
                byte[] profilePhoto, Set<UserRole> roles, Set<Book> wishlistBooks, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastLoginAt) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.bio = bio;
        this.profilePhoto = profilePhoto;
        this.roles = roles;
        this.wishlistBooks = wishlistBooks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLoginAt = lastLoginAt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public Set<Book> getWishlistBooks() {
        return wishlistBooks;
    }

    public void setWishlistBooks(Set<Book> wishlistBooks) {
        this.wishlistBooks = wishlistBooks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(LocalDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    // Lifecycle callback methods
    /*
    @PrePersist is a JPA (Java Persistence API) annotation that marks a method
    to be executed before an entity is persisted (i.e., inserted)
    into the database for the first time.
     */
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    /*
    @PreUpdate is a JPA (Java Persistence API) annotation that marks a method
    to be executed before an entity is updated in the database.
    */
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
