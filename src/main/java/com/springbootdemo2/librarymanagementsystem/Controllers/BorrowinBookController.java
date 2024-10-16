package com.springbootdemo2.librarymanagementsystem.Controllers;

import com.springbootdemo2.librarymanagementsystem.Entities.BorrowingRecord;
import com.springbootdemo2.librarymanagementsystem.Services.BorrowingBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("borrow")
public class BorrowinBookController {

    @Autowired
    private BorrowingBookServices borrowingBookServices;

    // Allow Patron To Borrow A Book
    @PostMapping("/borrowBook")
    public BorrowingRecord addBorrowinBook(@RequestParam Integer bookId , @RequestParam Integer patronId) {
        return borrowingBookServices.addBorrowingBook(bookId, patronId);
    }

    // Record the return of a borrowed book by a patron.
    @PutMapping("/recordReturnDatePatron")
    public BorrowingRecord recordReturnBook(@RequestParam Integer bookId ,@RequestParam Integer patronId,@RequestBody BorrowingRecord borrowingRecord) {
        return borrowingBookServices.updateReturnDateByPatron(bookId,patronId,borrowingRecord);
    }
}
