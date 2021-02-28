package se.iths.lab2webservice.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.dtos.BookTitle;
import se.iths.lab2webservice.entities.Book;
import se.iths.lab2webservice.mappers.BookMapper;
import se.iths.lab2webservice.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements se.iths.lab2webservice.services.Service{

    private final BookMapper bookMapper;
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAllBooks(){
        return bookMapper.mapp(bookRepository.findAll());
    }

    @Override
    public Optional<BookDto> getOne(Long isbn){
        return bookMapper.mapp(bookRepository.findById(isbn));
    }

    @Override
    public BookDto createBook(BookDto book){
        if(book.getTitel().isEmpty())
            throw new RuntimeException();
        return bookMapper.mapp(bookRepository.save(bookMapper.mapp(book)));
    }

    @Override
    public void delete(Long isbn){
        bookRepository.deleteById(isbn);
    }

    @Override
    public BookDto replace(Long isbn, BookDto bookDto) {
        Optional<Book> book = bookRepository.findById(isbn);
        if(book.isPresent()){
            Book updatedBook = book.get();
            updatedBook.setTitel(bookDto.getTitel());
            updatedBook.setPris(bookDto.getPris());
            return bookMapper.mapp(bookRepository.save(updatedBook));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Isbn " + isbn + " not found.");
    }

    @Override
    public BookDto update(Long isbn, BookTitle bookTitle) {
        Optional<Book> book = bookRepository.findById(isbn);
        if(book.isPresent()){
            Book updatedBook = book.get();
            if(bookTitle.titel != null)
                updatedBook.setTitel(bookTitle.titel);
            return bookMapper.mapp(bookRepository.save(updatedBook));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Isbn " + isbn + " not found.");
    }

    @Override
    public List<BookDto> searchByCategory(String searchTerm) {
        return bookMapper.mapp(bookRepository.findAllByKategori(searchTerm));
    }
}