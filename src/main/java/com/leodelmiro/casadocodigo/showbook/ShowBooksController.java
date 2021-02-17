package com.leodelmiro.casadocodigo.showbook;

import com.leodelmiro.casadocodigo.newbook.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class ShowBooksController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping
    public List<BookDTO> showBooks(){
        List<Book> list= entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();

        return list.stream().map(BookDTO::new).collect(Collectors.toList());
    }
}
