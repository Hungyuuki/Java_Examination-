package com.company.Model;

import java.io.Serializable;

public class Book implements Serializable {
    private String id;
    private String name;
    private String category;
    private Integer amount;
    private String author;

    public Book() {}

    public Book(String id, String name, String category, Integer amount, String author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\n Book{" +
                "id='" + id + '\'' +
                "| name='" + name + '\'' +
                "| category='" + category + '\'' +
                "| amount=" + amount +
                "| author='" + author + '\'' +
                '}';
    }
}
