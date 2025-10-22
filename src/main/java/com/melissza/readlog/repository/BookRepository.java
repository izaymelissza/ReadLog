package com.melissza.readlog.repository;

import com.melissza.readlog.model.Book;
import com.melissza.readlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Keresés cím alapján (tartalmazza)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Keresés szerző alapján
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Keresés műfaj alapján
    List<Book> findByGenre(String genre);

    // Keresés kiadási év alapján
    List<Book> findByPublicationYear(Integer year);

    // Ki adta hozzá a könyvet
    List<Book> findByAddedBy(User user);

    // Összetett keresés - cím VAGY szerző
    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(b.author) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Book> searchByTitleOrAuthor(@Param("searchTerm") String searchTerm);

    // Összes könyv rendezve cím szerint
    List<Book> findAllByOrderByTitleAsc();

    // Legújabb könyvek
    List<Book> findTop10ByOrderByCreatedAtDesc();
}