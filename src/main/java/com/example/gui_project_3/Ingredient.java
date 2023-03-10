package com.example.gui_project_3;

public class Ingredient {
    private String name;
    private String taste;

    public Ingredient(String name, String taste) {
        this.name = name;
        this.taste = taste;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
