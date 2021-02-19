package se.iths.lab2webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class Controller {

    private BookRepository bookRepository;

    @Autowired
    public Controller(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    @GetMapping("/hello")
//    public Optional<Book> sayHello(){
//
//        bookRepository.save(new Book(0));
//
//        return bookRepository;
//    }
}
