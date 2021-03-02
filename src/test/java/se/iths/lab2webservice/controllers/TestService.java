package se.iths.lab2webservice.controllers;

import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.dtos.BookTitle;
import se.iths.lab2webservice.services.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class TestService implements Service{

    @Override
    public List<BookDto> getAllBooks() {
        return List.of(new BookDto(1, "test", "test", 1, Date.valueOf("2000-01-01"), "test"));
    }

    @Override
    public Optional<BookDto> getOne(Long isbn) {
        if(isbn == 1)
            return Optional.of(new BookDto(1, "test", "test", 1, Date.valueOf("2000-01-01"), "test"));
        return Optional.empty();
    }

    @Override
    public BookDto createBook(BookDto book) {
        return null;
    }

    @Override
    public void delete(Long isbn) {

    }

    @Override
    public BookDto replace(Long isbn, BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto update(Long isbn, BookTitle bookTitle) {
        return null;
    }

    @Override
    public List<BookDto> searchByCategoryOrLanguageOrTitle(String searcher) {
        return null;
    }
}
