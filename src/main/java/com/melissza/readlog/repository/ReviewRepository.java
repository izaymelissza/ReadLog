package com.melissza.readlog.repository;

import com.melissza.readlog.model.Book;
import com.melissza.readlog.model.Review;
import com.melissza.readlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Összes értékelés egy könyvhöz
    List<Review> findByBook(Book book);

    // User összes értékelése
    List<Review> findByUser(User user);

    // Adott user adott könyvhöz írt értékelése
    Optional<Review> findByUserAndBook(User user, Book book);

    // Létezik-e már értékelés ettől a usertől erre a könyvre
    boolean existsByUserAndBook(User user, Book book);

    // Átlagos értékelés egy könyvhöz
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.book = :book")
    Double getAverageRatingForBook(@Param("book") Book book);

    // Legújabb értékelések
    List<Review> findTop10ByOrderByCreatedAtDesc();

    // Könyv értékelések rendezve rating szerint (legjobb először)
    List<Review> findByBookOrderByRatingDesc(Book book);

    // User legjobb értékelései (5 csillag)
    List<Review> findByUserAndRating(User user, Integer rating);
}