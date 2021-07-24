package org.sidsri.plugins.bookstoreapi.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {


    @Autowired
    BookService bookService;

    @PostMapping("/book")
    Book create(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/book")
    Iterable<Book> read() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    Optional<Book> read(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PutMapping("/book")
    ResponseEntity<Book> update(@RequestBody Book book) {
        if(bookService.findById(book.getId()).isPresent())
            return new ResponseEntity(bookService.save(book), HttpStatus.OK);
        else
            return new ResponseEntity(book, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/book/{id}")
    void delete(@PathVariable Integer id) {
        bookService.deleteById(id);
    }

}
