package se.iths.lab2webservice.mappers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.entities.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookMapper(){
    }

    public BookDto mapp(Book book){
        return new BookDto(book.getIsbn13(), book.getTitel(), book.getSpråk(),
                book.getPris(), book.getUtgivningsdatum(), book.getKategori());
    }

    public Book mapp(BookDto bookDto){
        return new Book(bookDto.getIsbn13(), bookDto.getTitel(), bookDto.getSpråk(),
                bookDto.getPris(), bookDto.getUtgivningsdatum(), bookDto.getKategori());
    }

    public Optional<BookDto> mapp(Optional<Book> optionalBook){
        if(optionalBook.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalBook.get()));
    }

    public List<BookDto> mapp(List<Book> all) {

        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}