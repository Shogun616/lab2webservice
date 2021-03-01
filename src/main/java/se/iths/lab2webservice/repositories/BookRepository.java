package se.iths.lab2webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.iths.lab2webservice.entities.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByKategori(String kategori);

    List<Book> findAllBySpråkAndKategori(String kategori, String språk);
}
