package se.iths.lab2webservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import se.iths.lab2webservice.dtos.BookDto;
import org.springframework.http.HttpHeaders;

import java.sql.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Lab2webserviceApplicationTests {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate testClient;

    @Test
    void contextLoads() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");

        var result = testClient.getForEntity("http://localhost:" + port +"/Böcker", BookDto[].class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().length).isGreaterThan(0);
    }

    @Test
    void postSomethingToService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");

        BookDto bookDto = new BookDto(0,"test","test", 0, Date.valueOf("2000-01-01"), "test");
        var result = testClient.postForEntity("http://localhost:" + port +"/Böcker",bookDto, BookDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void deleteSomethingFromService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");


    }

    @Test
    void replaceSomethingFromService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");
    }

    @Test
    void updateSomethingFromService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");
    }
}
