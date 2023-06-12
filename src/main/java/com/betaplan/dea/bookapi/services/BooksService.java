package com.betaplan.dea.bookapi.services;

import com.betaplan.dea.bookapi.models.Books;
import com.betaplan.dea.bookapi.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository bookRepository) {
        this.booksRepository = bookRepository;
    }

    public List<Books> allBooks(){
        return booksRepository.findAll();
    }

    public Books createBook(Books books) {
        return booksRepository.save(books);
    }

    public Books findBook(Long id) {
        Optional<Books> optionalBook = booksRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        }else {
            return null;
        }
    }

    public Books updateBook(Books book) {
        return booksRepository.save(book);
    }

    public void deleteBook(Long id) {
        Optional<Books> optionalBook = booksRepository.findById(id);
        if(optionalBook.isPresent()) {
            booksRepository.deleteById(id);
        }
    }
}
