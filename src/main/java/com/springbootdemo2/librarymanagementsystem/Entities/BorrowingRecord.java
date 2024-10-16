package com.springbootdemo2.librarymanagementsystem.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowid")
    private Integer borrowId;

    @Column(name = "borrowDate")
    private LocalDateTime borrowDate=LocalDateTime.now();

    @Column(name = "returnDate")
    private LocalDateTime returnDate=LocalDateTime.now().plusDays(10);

    @Column(name = "bookid")
    private Integer bookId;
    @Column(name = "patronid")
    private Integer patronId;

    @ManyToOne
    @JoinColumn(name = "bookid", insertable = false, updatable = false)
    @JsonBackReference
    private Book book;
}
