package com.springbootdemo2.librarymanagementsystem.Repositories;

import com.springbootdemo2.librarymanagementsystem.Entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingBookRepo extends JpaRepository<BorrowingRecord, Integer> {
    boolean existsByBookId(int bookId);
    boolean existsByPatronId(int patronId);
    boolean existsByPatronIdAndBookId(int patronId,int bookId);

    Optional<BorrowingRecord>findByPatronIdAndBookId(int patronId,int bookId);
}
