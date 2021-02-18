package com.leodelmiro.casadocodigo.showbook;

import com.leodelmiro.casadocodigo.newbook.Book;

import java.math.BigDecimal;

public class BookDetailsResponse {

    private String title;
    private String resume;
    private String summary;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private AuthorDetailsResponse author;

    public BookDetailsResponse(Book entity){
        this.title = entity.getTitle();
        this.resume = entity.getResume();
        this.summary = entity.getSummary();
        this.price = entity.getPrice();
        this.pages = entity.getPages();
        this.isbn = entity.getIsbn();
        this.author = new AuthorDetailsResponse(entity.getAuthor());
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

    public AuthorDetailsResponse getAuthorName() {
        return author;
    }
}
