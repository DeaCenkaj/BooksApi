package com.betaplan.dea.bookapi.controllers;

import com.betaplan.dea.bookapi.models.Books;
import com.betaplan.dea.bookapi.services.BooksService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksApi {
    private final BooksService bookService;

    public BooksApi(BooksService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/api/books")
    public List<Books> index() {
        return bookService.allBooks();
    }

    @RequestMapping(value="/api/books", method= RequestMethod.POST)
    public Books create(
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages){
        Books book = new Books(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    @RequestMapping("/api/books/{id}")
    public Books show(@PathVariable("id") Long id) {
        Books book = bookService.findBook(id);
        return book;
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Books update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Books book = new Books(title, desc, lang, numOfPages);
        book.setId(id);
        return bookService.updateBook(book);
    }

    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}


