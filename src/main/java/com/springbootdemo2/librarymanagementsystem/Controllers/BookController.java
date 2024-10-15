package com.springbootdemo2.librarymanagementsystem.Controllers;

import com.springbootdemo2.librarymanagementsystem.Entities.Book;
import com.springbootdemo2.librarymanagementsystem.Services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServices bookServices;


    // Insert New Book
    @PostMapping("/insertBook")
    public Book insertBook(@RequestBody Book book) {
        return bookServices.insertBook(book);
    }

    // Get All Books
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookServices.getAllBooks();
    }

    // Get Book By Id
    @GetMapping("/getBookById")
    public Book getBookById(@RequestParam Integer id) {
        return bookServices.getBookById(id);
    }

    // Update Book Information
    @PatchMapping("/updateBook")
    public Book updateBook(@RequestParam Integer id,@RequestBody Book book) {
        return bookServices.updateBook(id,book);
    }

    // Delete Book By Id
    @DeleteMapping("/deleteBook")
    public void deleteBookById(@RequestParam Integer id) {
        this.bookServices.RemoveBook(id);
    }
}
