package com.springbootdemo2.librarymanagementsystem.Repositories;

import com.springbootdemo2.librarymanagementsystem.Entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronRepo extends JpaRepository<Patron, Integer> {
}
