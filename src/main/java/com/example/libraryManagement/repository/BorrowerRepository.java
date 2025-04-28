package com.example.libraryManagement.repository;

import com.example.libraryManagement.model.Borrower;
import com.example.libraryManagement.model.Member;
import com.example.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

    List<Borrower> findByMember(Member member);

    List<Borrower> findByBook(Book book);

    List<Borrower> findByIsReturned(boolean isReturned);

    @Query("SELECT new com.example.libraryManagement.dto.BorrowerDTO(b.id, b.member.name, b.book.title, b.borrowDate, b.returnDate, b.isReturned) FROM Borrower b")
    List<com.example.libraryManagement.dto.BorrowerDTO> findAllBorrowersWithNames();
}
