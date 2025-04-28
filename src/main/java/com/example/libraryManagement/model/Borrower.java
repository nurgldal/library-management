package com.example.libraryManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "borrowers")
@Getter
@Setter
@NoArgsConstructor
public class Borrower {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private LocalDate borrowDate;

    private LocalDate returnDate;

    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isReturned;


    @JsonProperty("returnedStatus") // Bu satır, JSON çıktısına "returnedStatus" olarak ekler
    public String getReturnedStatus() {
        return isReturned ? "Yes" : "No";
    }
}
