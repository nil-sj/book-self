package com.bookself.bookself_api.dto;

public class GenreDTO {
    private Long id;
    private String name;
    private String definition;
    private String category;
    private String categoryDisplayName;

    // Constructors
    public GenreDTO() {}

    public GenreDTO(Long id, String name, String definition, String category, String categoryDisplayName) {
        this.id = id;
        this.name = name;
        this.definition = definition;
        this.category = category;
        this.categoryDisplayName = categoryDisplayName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryDisplayName() {
        return categoryDisplayName;
    }

    public void setCategoryDisplayName(String categoryDisplayName) {
        this.categoryDisplayName = categoryDisplayName;
    }
}
