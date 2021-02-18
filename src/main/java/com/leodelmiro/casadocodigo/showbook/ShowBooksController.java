package com.leodelmiro.casadocodigo.showbook;

import com.leodelmiro.casadocodigo.newbook.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ShowBooksController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping
    @Transactional(readOnly = true)
    public List<AllBooksResponse> allBooks(){
        List<Book> list= entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();

        return list.stream().map(AllBooksResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<BookDetailsResponse> bookDetails(@PathVariable Long id) {
        Book bookSearched = entityManager.find(Book.class, id);

        if (bookSearched == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        BookDetailsResponse bookDetailsResponse = new BookDetailsResponse(bookSearched);
        return ResponseEntity.ok(bookDetailsResponse);
    }
}
