package com.springbootdemo2.librarymanagementsystem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private Integer bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publication-year")
    private String publicationYear;
    @Column(name = "isbn")
    private Integer isbn;

    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    private List<BorrowingRecord> borrowingRecords;
}
