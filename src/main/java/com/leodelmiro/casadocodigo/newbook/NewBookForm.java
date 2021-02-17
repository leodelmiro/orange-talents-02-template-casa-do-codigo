package com.leodelmiro.casadocodigo.newbook;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.leodelmiro.casadocodigo.newauthor.Author;
import com.leodelmiro.casadocodigo.newcategory.Category;
import com.leodelmiro.casadocodigo.validation.ExistsId;
import com.leodelmiro.casadocodigo.validation.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;


public class NewBookForm {

    @NotBlank
    @UniqueValue(fieldName = "title", domainClass = Book.class)
    private String title;

    @NotBlank
    @Size(max = 500)
    private String resume;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @NotNull
    @DecimalMin("20.00")
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer pages;

    @NotBlank
    @UniqueValue(fieldName = "isbn", domainClass = Book.class)
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate release;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Author.class)
    private Long authorId;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Category.class)
    private Long categoryId;

    @Deprecated
    public NewBookForm() {

    }

    public NewBookForm(@NotBlank String title,
                       @NotBlank @Size(max = 500) String resume, String summary,
                       @NotNull @DecimalMin("20.00") BigDecimal price,
                       @NotNull @Min(100) Integer pages,
                       @NotBlank String isbn,
                       @Future LocalDate release,
                       @NotNull Long authorId,
                       @NotNull Long categoryId) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.release = release;
        this.authorId = authorId;
        this.categoryId = categoryId;
    }

    public Book toModel(EntityManager entityManager) {
        @NotNull Author author = entityManager.find(Author.class, authorId);
        @NotNull Category category = entityManager.find(Category.class, categoryId);

        Assert.state(author != null, "Você está querendo cadastrar um livro para um autor que não existe no banco " + authorId);
        Assert.state(category != null, "Você está querendo cadastrar um livro para uma categoria que não existe" + categoryId);

        return new Book(this.title, this.resume, this.summary, this.price, this.pages, this.isbn, this.release, author, category);
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
