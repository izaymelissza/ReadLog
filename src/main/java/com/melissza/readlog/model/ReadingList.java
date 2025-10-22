package com.melissza.readlog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "reading_lists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // N:M kapcsolat - User oldalról
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // N:M kapcsolat - Book oldalról
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ReadingStatus status;

    @Column(name = "added_at", nullable = false)
    private LocalDateTime addedAt;

    @Column(name = "started_reading_at")
    private LocalDateTime startedReadingAt;

    @Column(name = "finished_reading_at")
    private LocalDateTime finishedReadingAt;

    @PrePersist
    protected void onCreate() {
        addedAt = LocalDateTime.now();
        if (status == null) {
            status = ReadingStatus.TO_READ;
        }
    }

    // Status enum
    public enum ReadingStatus {
        TO_READ,
        READING,
        READ
    }
}