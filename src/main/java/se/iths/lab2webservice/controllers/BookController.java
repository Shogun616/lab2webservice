package se.iths.lab2webservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.dtos.BookTitle;
import se.iths.lab2webservice.services.Service;

import java.util.List;

@RestController
public class BookController {

    private final Service service;

    public BookController(Service service) {
        this.service = service;
    }

    @GetMapping("/Böcker")
    public List<BookDto> allBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/Böcker/{isbn}")
    public BookDto oneBook(@PathVariable long isbn){
        return service.getOne(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Isbn " + isbn + " Not Found."));
    }

    @PostMapping("/Böcker")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@RequestBody BookDto book){
       return service.createBook(book);
    }

    @DeleteMapping("/Böcker/{isbn}")
    public void delete(@PathVariable Long isbn){
        service.delete(isbn);
    }

    @PutMapping("/Böcker/{isbn}")
    public BookDto replace(@RequestBody BookDto bookDto, @PathVariable Long isbn){
        return service.replace(isbn, bookDto);
    }

    @PatchMapping("/Böcker/{isbn}")
    public BookDto update(@RequestBody BookTitle bookTitle, @PathVariable Long isbn){
        return service.update(isbn, bookTitle);
    }
}