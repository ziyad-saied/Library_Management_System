package com.springbootdemo2.librarymanagementsystem.Controllers;

import com.springbootdemo2.librarymanagementsystem.Entities.Patron;
import com.springbootdemo2.librarymanagementsystem.Services.PatronServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patron")
public class PatronController {
    @Autowired
    private PatronServices patronServices;

    // Insert new Patron
    @PostMapping("/addPatron")
    public Patron addPatron(@RequestBody Patron patron) {
        return patronServices.addNewPatron(patron);
    }

    // Get All Patrons
    @GetMapping("/getAllPatrons")
    public List<Patron> getAllPatrons(){
        return patronServices.getAllPatrons();
    }

    // Get Patron By Id
    @GetMapping("getPatronById")
    public Patron getPatronById(@RequestParam int id) {
        return patronServices.getPatronById(id);
    }

    // Update Patron Information
    @PatchMapping("/updatePatron")
    public Patron updatePatron(@RequestParam Integer id,@RequestBody Patron patron) {
        return patronServices.updatePatron(id,patron);
    }

    // Delete Patron
    @DeleteMapping("/deletePatron")
    public void deletePatron(@RequestParam int id) {
        patronServices.deletePatron(id);
    }
}
