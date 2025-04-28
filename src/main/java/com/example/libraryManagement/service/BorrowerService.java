package com.example.libraryManagement.service;

import com.example.libraryManagement.dto.BorrowerDTO;
import com.example.libraryManagement.model.Borrower;
import com.example.libraryManagement.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    // Tüm Borrower kayıtlarını getir (DTO ile)
    public List<BorrowerDTO> getAllBorrowers() {
        return borrowerRepository.findAllBorrowersWithNames();
    }

    // ID'ye göre Borrower getir
    public Optional<Borrower> getBorrowerById(Long id) {
        return borrowerRepository.findById(id);
    }

    //  Yeni Borrower Ekleme
    public Borrower addBorrower(Borrower borrower) {
        borrower.setReturned(false); // Varsayılan olarak iade edilmemiş olacak
        return borrowerRepository.save(borrower);
    }

    // Mevcut Borrower güncelle (Tarih ve iade bilgisi)
    public Borrower updateBorrower(Long id, LocalDate borrowDate, LocalDate returnDate, boolean isReturned) {
        Borrower borrower = borrowerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Borrower not found with ID: " + id));

        borrower.setBorrowDate(borrowDate);
        borrower.setReturnDate(returnDate);
        borrower.setReturned(isReturned);

        return borrowerRepository.save(borrower);
    }

    // Borrower kaydını sil
    public boolean deleteBorrower(Long id) {
        if (!borrowerRepository.existsById(id)) {
            throw new IllegalArgumentException("Borrower not found with ID: " + id);
        }
        borrowerRepository.deleteById(id);
        return true;
    }
}
