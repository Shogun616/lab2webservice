package se.iths.lab2webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.services.BookService;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/Böcker")
    public List<BookDto> allBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/Böcker/{isbn}")
    public BookDto oneBook(@PathVariable long isbn){
        return bookService.getOne(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Isbn " + isbn + " Not Found."));
    }

    @PostMapping("/Böcker")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@RequestBody BookDto book){
       return bookService.createBook(book);
    }
}