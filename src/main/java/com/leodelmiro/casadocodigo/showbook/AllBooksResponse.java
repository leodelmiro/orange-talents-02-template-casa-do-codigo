package com.leodelmiro.casadocodigo.showbook;

import com.leodelmiro.casadocodigo.newbook.Book;

public class AllBooksResponse {

    private Long id;
    private String title;

    public AllBooksResponse(Book entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
