package se.iths.lab2webservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import se.iths.lab2webservice.dtos.BookDto;
import se.iths.lab2webservice.services.Service;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
public class MvcTest {

    @MockBean
    Service service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper jsonmapper;

    @Test
    void callingWithBookShouldReturnAllBookAsJson() throws Exception{
        when(service.getAllBooks()).thenReturn(List.of(new BookDto(1,"","",
                1, Date.valueOf("2000-01-01"), "")));

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/Böcker")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void callingPOSTWithNewBookShouldSaveBookToServiceAndReturnWithIsbn() throws Exception{

        var bookDto = new BookDto(1,"test","test", 1, Date.valueOf("2000-01-01"), "test");

        when(service.createBook(eq(bookDto))).thenReturn(new BookDto(1,"test","test", 1,
                Date.valueOf("2000-01-01"), "test"));

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/Böcker")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonmapper.writeValueAsBytes(bookDto))
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result.getResponse().getStatus()).isEqualTo(201);
    }

}
