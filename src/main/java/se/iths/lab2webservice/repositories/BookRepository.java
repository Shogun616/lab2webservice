package se.iths.lab2webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import se.iths.lab2webservice.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor {
//    List<Book> findAllByIsbn13orSpråkOrKategoriOrTitelOrPris(long isbn13, String språk, String katgori, String titel, float pris);
}