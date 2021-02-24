package se.iths.lab2webservice.services;

import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.dtos.BookTitle;

import java.util.List;
import java.util.Optional;

public interface Service {

    List<BookDto> getAllBooks();

    Optional<BookDto> getOne(Long isbn);

    BookDto createBook(BookDto book);

    void delete(Long isbn);

    BookDto replace(Long isbn, BookDto bookDto);

    BookDto update(Long isbn, BookTitle bookTitle);
}
