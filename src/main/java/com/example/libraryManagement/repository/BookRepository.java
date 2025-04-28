package com.example.libraryManagement.repository;

import com.example.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Belirli bir başlığa göre kitapları bulma
    List<Book> findByTitle(String title);

    // Belirli bir yazara göre kitapları bulma
    List<Book> findByAuthor(String author);

    // Belirli bir yıl içinde yayımlanan kitapları bulma
    List<Book> findByPublishedYear(int publishedYear);
}
