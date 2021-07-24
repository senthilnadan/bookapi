package org.sidsri.plugins.bookstoreapi.author;

import org.sidsri.plugins.bookstoreapi.book.Book;
import org.sidsri.plugins.bookstoreapi.book.BookService;
import org.sidsri.plugins.bookstoreapi.messages.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    Author create(@Valid  @RequestBody Author author) {
        return authorService.save(author);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage())).collect(Collectors.toList());

        return fieldErrorMessages;
    }

    @GetMapping("/author")
    Iterable<Author> read() {
        return authorService.findAll();
    }

    @PutMapping("/author")
    Author update(@RequestBody Author author) {
        return authorService.save(author);
    }

    @DeleteMapping("/author/{id}")
    void delete(@PathVariable Integer id) {
        authorService.deleteById(id);
    }
}
