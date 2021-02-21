package se.iths.lab2webservice.services;

import org.springframework.stereotype.Service;
import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.mappers.BookMapper;
import se.iths.lab2webservice.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookMapper bookMapper;

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

//    @Override
//    public List<BookDto> getAllBooks(){
//        return bookMapper.mapp(bookRepository.findAll());
//    }
//
//    public Optional<BookDto> getOne(Long isbn){
//        return bookMapper.mapp(bookRepository.findById(isbn));
//    }
//
//    public BookDto createBook(BookDto book){
//        if(book.getTitel().isEmpty())
//            throw new RuntimeException();
//        return bookMapper.mapp(bookRepository.save(mapp(book)));
//    }
}
