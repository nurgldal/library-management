package com.example.libraryManagement.dto;

import java.time.LocalDate;

public class BorrowerDTO {
    private Long id;
    private String memberName;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isReturned;

    public BorrowerDTO(Long id, String memberName, String bookTitle, LocalDate borrowDate, LocalDate returnDate, boolean isReturned) {
        this.id = id;
        this.memberName = memberName;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
    }

    public Long getId() { return id; }
    public String getMemberName() { return memberName; }
    public String getBookTitle() { return bookTitle; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isReturned() { return isReturned; }

    // Yeni eklenen metod: Boolean değeri "Yes" veya "No" olarak döndürür
    public String getReturnedStatus() {
        return isReturned ? "Yes" : "No";
    }
}
