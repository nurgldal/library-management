package com.example.libraryManagement.controller;

import com.example.libraryManagement.dto.BorrowerDTO;
import com.example.libraryManagement.dto.BorrowerRequest;

import com.example.libraryManagement.model.Borrower;
import com.example.libraryManagement.model.Member;
import com.example.libraryManagement.model.Book;
import com.example.libraryManagement.service.BorrowerService;
import com.example.libraryManagement.service.MemberService;
import com.example.libraryManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

    private final BorrowerService borrowerService;
    private final MemberService memberService;
    private final BookService bookService;

    @Autowired
    public BorrowerController(BorrowerService borrowerService, MemberService memberService, BookService bookService) {
        this.borrowerService = borrowerService;
        this.memberService = memberService;
        this.bookService = bookService;
    }

    // Tüm Borrower kayıtlarını getir (DTO ile)
    @GetMapping
    public ResponseEntity<List<BorrowerDTO>> getAllBorrowers() {
        return ResponseEntity.ok(borrowerService.getAllBorrowers());
    }

    // ID'ye göre Borrower getir
    @GetMapping("/{id}")
    public ResponseEntity<Borrower> getBorrowerById(@PathVariable Long id) {
        Optional<Borrower> borrower = borrowerService.getBorrowerById(id);
        return borrower.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

 @PostMapping
public ResponseEntity<Borrower> addBorrower(@RequestBody BorrowerRequest borrowerRequest) {
    Optional<Member> memberOpt = memberService.getMemberById(borrowerRequest.getMemberId());
    Optional<Book> bookOpt = bookService.getBookById(borrowerRequest.getBookId());

    if (memberOpt.isEmpty() || bookOpt.isEmpty()) {
        return ResponseEntity.badRequest().build(); // Üye veya kitap bulunamazsa hata döndür
    }

    Borrower borrower = new Borrower();
    borrower.setMember(memberOpt.get());
    borrower.setBook(bookOpt.get());
    borrower.setBorrowDate(borrowerRequest.getBorrowDate());
    borrower.setReturnDate(borrowerRequest.getReturnDate());
    borrower.setReturned(borrowerRequest.isReturned());

    Borrower savedBorrower = borrowerService.addBorrower(borrower);
    return ResponseEntity.ok(savedBorrower);
}



    // Borrower güncelle (Tarih ve iade bilgisi güncellenecek)
    @PutMapping("/{id}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable Long id, @RequestBody Borrower borrower) {
        if (borrower.getBorrowDate() == null || borrower.getReturnDate() == null) {
            return ResponseEntity.badRequest().build();
        }
        Borrower updatedBorrower = borrowerService.updateBorrower(
                id,
                borrower.getBorrowDate(),
                borrower.getReturnDate(),
                borrower.isReturned()
        );
        return ResponseEntity.ok(updatedBorrower);
    }

    // Kitabın iade edildiğini güncelle
    @PutMapping("/{id}/return")
    public ResponseEntity<Borrower> returnBook(@PathVariable Long id) {
        Optional<Borrower> borrowerOpt = borrowerService.getBorrowerById(id);
        if (borrowerOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Borrower borrower = borrowerOpt.get();
        borrower.setReturned(true);
        borrower.setReturnDate(LocalDate.now());

        Borrower updatedBorrower = borrowerService.updateBorrower(id, borrower.getBorrowDate(), borrower.getReturnDate(), true);
        return ResponseEntity.ok(updatedBorrower);
    }

    // Borrower kaydını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrower(@PathVariable Long id) {
        try {
            if (borrowerService.deleteBorrower(id)) {
                return ResponseEntity.noContent().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
