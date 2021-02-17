package com.leodelmiro.casadocodigo.newbook;

import com.leodelmiro.casadocodigo.newauthor.Author;
import com.leodelmiro.casadocodigo.newcategory.Category;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String title;

    @NotBlank
    @Size(max = 500)
    private String resume;

    @Lob
    private String summary;

    @NotNull
    @DecimalMin("20.00")
    private BigDecimal price;

    @NotNull
    @Min(100)
    private Integer pages;

    @NotBlank
    @Column(unique = true)
    private String isbn;

    @Future
    private LocalDate release;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Deprecated
    public Book() {

    }

    public Book(@NotBlank String title,
                @NotBlank @Size(max = 500) String resume,
                String summary,
                @NotNull @DecimalMin("20.00") BigDecimal price,
                @NotNull @Min(100) Integer pages,
                @NotBlank String isbn,
                @Future LocalDate release,
                @NotNull Author author,
                @NotNull Category category) {

        Assert.hasLength(title, "Título é obrigatório!");
        Assert.hasLength(resume, "Resumo é obrigatório!");
        Assert.notNull(price, "Preço é obrigatório!");
        Assert.state(price.compareTo(new BigDecimal("20.00")) >= 0, "Preço é deve ser maior que 20");
        Assert.notNull(price, "Resumo é obrigatório!");
        Assert.notNull(pages, "O número de páginas é obrigatório");
        Assert.state(pages > 100, "O número de páginas deve ser maior que 100");
        Assert.hasLength(isbn, "ISBN é obrigatório!");
        Assert.state(release.compareTo(LocalDate.now()) > 0, "Data de lançamento deve ser futura!");
        Assert.notNull(author, "Autor é obrigatório!");
        Assert.notNull(category, "Categoria é obrigatória!");

        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.release = release;
        this.author = author;
        this.category = category;
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

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }
}
