package com.springbootdemo2.librarymanagementsystem.Services;

import com.springbootdemo2.librarymanagementsystem.Entities.Book;
import com.springbootdemo2.librarymanagementsystem.Repositories.BookRepo;
import com.springbootdemo2.librarymanagementsystem.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {
    @Autowired
    private BookRepo bookRepo;

    // Insert New Book
    public Book insertBook(Book book) {
        return bookRepo.save(book);
    }
    // Return All Books
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    // Return Book By Id
    public Book getBookById(int id) {
        return bookRepo.findById(id).get();
    }
    // Update Book Information
    public Book updateBook(Integer id,Book book) {
        Optional<Book> bookOptional = bookRepo.findById(id);
        if (bookOptional.isPresent()) {
            Book bookToUpdate = bookOptional.get();
            if(book.getAuthor()!=null) {
                bookToUpdate.setAuthor(book.getAuthor());
            }
            if(book.getTitle()!=null) {
                bookToUpdate.setTitle(book.getTitle());
            }
            if(book.getIsbn()!=null) {
                bookToUpdate.setIsbn(book.getIsbn());
            }
            if(book.getPublicationYear()!=null){
                bookToUpdate.setPublicationYear(book.getPublicationYear());
            }
            return bookRepo.save(bookToUpdate);
        }
        else {
            throw new ResourceNotFoundException("Book Not Found , Please Insert Another Book");
        }
    }
    // Remove Book By Id
    public void RemoveBook(int id) {
        bookRepo.deleteById(id);
    }

}
