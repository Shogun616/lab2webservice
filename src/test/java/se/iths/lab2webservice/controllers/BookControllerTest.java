package se.iths.lab2webservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest {

    @Test
    void callingOneWithValidReturnsOneBook(){
        BookController bookController = new BookController(new TestService());

        var book = bookController.oneBook(1);

        assertThat(book.getIsbn13()).isEqualTo(1);
        assertThat(book.getTitel()).isEqualTo("test");
        assertThat(book.getSpråk()).isEqualTo("test");
        assertThat(book.getPris()).isEqualTo(1);
        assertThat(book.getUtgivningsdatum()).isEqualTo("2000-01-01");
        assertThat(book.getKategori()).isEqualTo("test");
    }

    @Test
    void callingOneWithInvalidThrowsExceptionWithResponseStatus404(){

        BookController bookController = new BookController(new TestService());

        var exception = assertThrows(ResponseStatusException.class, () -> bookController.oneBook(2));
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
