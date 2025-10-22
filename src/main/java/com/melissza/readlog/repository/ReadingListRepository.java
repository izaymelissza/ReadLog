package com.melissza.readlog.repository;

import com.melissza.readlog.model.Book;
import com.melissza.readlog.model.ReadingList;
import com.melissza.readlog.model.ReadingList.ReadingStatus;
import com.melissza.readlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {

    // User összes olvasási listája
    List<ReadingList> findByUser(User user);

    // User olvasási listája státusz szerint
    List<ReadingList> findByUserAndStatus(User user, ReadingStatus status);

    // Létezik-e már ez a könyv a user listáján
    boolean existsByUserAndBook(User user, Book book);

    // Adott könyv az adott user listáján
    Optional<ReadingList> findByUserAndBook(User user, Book book);

    // Statisztika: Hány könyvet olvasott el egy user egy évben
    @Query("SELECT COUNT(r) FROM ReadingList r WHERE r.user = :user " +
            "AND r.status = 'READ' " +
            "AND YEAR(r.finishedReadingAt) = :year")
    Long countBooksReadByUserInYear(@Param("user") User user, @Param("year") int year);

    // Statisztika: Hány könyvet olvasott el egy user egy műfajban
    @Query("SELECT COUNT(r) FROM ReadingList r WHERE r.user = :user " +
            "AND r.status = 'READ' AND r.book.genre = :genre")
    Long countBooksReadByUserAndGenre(@Param("user") User user, @Param("genre") String genre);

    // Legutóbb befejezett könyvek
    List<ReadingList> findTop10ByUserAndStatusOrderByFinishedReadingAtDesc(
            User user, ReadingStatus status);

    // Jelenleg olvasott könyvek
    List<ReadingList> findByUserAndStatusOrderByStartedReadingAtDesc(
            User user, ReadingStatus status);
}