package com.leodelmiro.casadocodigo.newbook;

import java.math.BigDecimal;
import java.time.LocalDate;


public class CreatedBookResponse {

    private Long id;
    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private LocalDate release;
    private Long authorId;
    private Long categoryId;

    @Deprecated
    public CreatedBookResponse() {

    }

    public CreatedBookResponse(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.resume = entity.getResume();
        this.summary = entity.getSummary();
        this.price = entity.getPrice();
        this.pages = entity.getPages();
        this.isbn = entity.getIsbn();
        this.release = entity.getRelease();
        this.authorId = entity.getAuthor().getId();
        this.categoryId = entity.getCategory().getId();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getRelease() {
        return release;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}
