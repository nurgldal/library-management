package com.example.libraryManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {
	
	//Mainpage sayfası
	@GetMapping("/")
	public String mainpage(){
		return "mainpage";    //resources/templates/mainpage.html
	}
	


    // Members sayfası
    @GetMapping("/index")
    public String index() {
        return "index";  // resources/templates/index.html
    }

    // Books sayfası
    @GetMapping("/books")
    public String books() {
        return "books";  // resources/templates/books.html
    }

    // Borrowers sayfası (Ödünç Alınan Kitaplar)
    @GetMapping("/borrowers")
    public String borrowers() {
        return "borrowers";  // resources/templates/borrowers.html
    }
}
