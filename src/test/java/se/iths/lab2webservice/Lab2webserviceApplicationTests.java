package se.iths.lab2webservice;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import se.iths.lab2webservice.dtos.BookDto;
import org.springframework.http.HttpHeaders;

import java.sql.Date;
import java.util.Objects;

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
        assertThat(Objects.requireNonNull(result.getBody()).length).isGreaterThan(0);
    }

    @Test
    void postSomethingToService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");

        BookDto bookDto = new BookDto(1111111111,"test","test", 1, Date.valueOf("2000-01-01"), "test");
        var result = testClient.postForEntity("http://localhost:" + port + "/Böcker", bookDto, BookDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        var verifyPostQuery = testClient.getForEntity("http://localhost:" + port + "/Böcker" + "/1111111111", BookDto.class);

        assertThat(verifyPostQuery.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void deleteSomethingFromService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");

        BookDto bookDto = new BookDto(1,"test","test", 1, Date.valueOf("2000-01-01"), "test");
        var result = testClient.postForEntity("http://localhost:" + port + "/Böcker", bookDto, BookDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        testClient.delete("http://localhost:" + port + "/Böcker" + "/1", BookDto.class);
        var verifyDeleteQuery = testClient.getForEntity("http://localhost:" + port + "/Böcker" + "/1", BookDto.class);

        assertThat(verifyDeleteQuery.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void replaceSomethingFromService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");

        BookDto bookDto = new BookDto(1,"test","test", 1, Date.valueOf("2000-01-01"), "test");
        var result = testClient.postForEntity("http://localhost:" + port
                + "/Böcker", bookDto, BookDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        testClient.put("http://localhost:" + port + "/Böcker" + "/1", new BookDto(1, "test2",
                "test2", 2, Date.valueOf("2020-01-01"), "test2"), BookDto.class);
        var verifyPutQuery = testClient.getForEntity("http://localhost:" + port + "/Böcker" + "/1",
                BookDto.class);

        assertThat(verifyPutQuery.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void updateSomethingToService(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/xml");

        BookDto bookDto = new BookDto(1,"test","test", 1, Date.valueOf("2000-01-01"), "test");
        var result = testClient.postForEntity("http://localhost:" + port + "/Böcker", bookDto, BookDto.class);
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        testClient.patchForObject("http://localhost:" + port + "/Böcker" + "/1", new BookDto(1, "test3", "test", 1,
                Date.valueOf("2000-01-01"), "test"), BookDto.class);

        var verifyPatchQuery = testClient.getForEntity("http://localhost:" + port + "/Böcker" + "/1", BookDto.class);

        assertThat(verifyPatchQuery.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}