package com.example.libraryManagement.service;

import com.example.libraryManagement.model.Book;
import com.example.libraryManagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Tüm kitapları getir
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Belirli bir kitabı ID ile getir
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Yeni kitap oluştur
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Var olan kitabı güncelle
    public Book updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);  // Güncellenen kitap ID'sini koru
            return bookRepository.save(book);
        }
        return null;  // Kitap bulunamazsa null döndür
    }

    // Kitap sil
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;  // Başarıyla silindi
        }
        return false;  // Kitap bulunamadı
    }

    // Başlığa göre kitapları getir
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Yazara göre kitapları getir
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    // Yayın yılına göre kitapları getir
    public List<Book> getBooksByPublishedYear(int year) {
        return bookRepository.findByPublishedYear(year);
    }
}
