package com.springbootdemo2.librarymanagementsystem.Services;

import com.springbootdemo2.librarymanagementsystem.Entities.BorrowingRecord;
import com.springbootdemo2.librarymanagementsystem.Repositories.BorrowingBookRepo;
import com.springbootdemo2.librarymanagementsystem.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BorrowingBookServices {

    @Autowired
    private BorrowingBookRepo borrowingBookRepo;

    // Allow a patron to borrow a book
    public BorrowingRecord addBorrowingBook(Integer bookId , Integer patronId) {
        BorrowingRecord borrowingRecord1 = new BorrowingRecord();
        borrowingRecord1.setBookId(bookId);
        borrowingRecord1.setPatronId(patronId);
        return borrowingBookRepo.save(borrowingRecord1);
    }

    // Record the return of a borrowed book by a patron.
    public BorrowingRecord updateReturnDateByPatron(Integer bookId,Integer patronId,BorrowingRecord borrowingRecord) {
        if(borrowingBookRepo.existsByPatronIdAndBookId(patronId,bookId)) {
            Optional<BorrowingRecord> entity = borrowingBookRepo.findByPatronIdAndBookId(patronId, bookId);
            Optional<Integer> borrowId = entity.map(BorrowingRecord::getBorrowId);
            BorrowingRecord borrowingRecord0 = borrowingBookRepo.findById(borrowId.get()).get();

            Optional<BorrowingRecord> borrowingRecordOptional = borrowingBookRepo.findById(borrowingRecord0.getBorrowId());
            if (borrowingRecordOptional.isPresent()) {
                BorrowingRecord borrowingRecord1 = borrowingRecordOptional.get();
                if (borrowingRecord.getBookId() != null) {
                    borrowingRecord1.setBookId(borrowingRecord.getBookId());
                }
                if (borrowingRecord.getPatronId() != null) {
                    borrowingRecord1.setPatronId(borrowingRecord.getPatronId());
                }
                if (borrowingRecord.getBorrowDate() != null) {
                    borrowingRecord1.setBorrowDate(borrowingRecord.getBorrowDate());
                }
                if (borrowingRecord.getReturnDate() != null) {
                    borrowingRecord1.setReturnDate(borrowingRecord.getReturnDate());
                }
                return borrowingBookRepo.save(borrowingRecord1);
            }
            else {
                    throw new ResourceNotFoundException("Book Or Patron not found");
            }
        }
        else {
                throw new ResourceNotFoundException("No Patron Or Book With This Id Is Exit !!");
            }
        }
}
