package com.springbootdemo2.librarymanagementsystem.Services;

import com.springbootdemo2.librarymanagementsystem.Entities.Patron;
import com.springbootdemo2.librarymanagementsystem.Repositories.PatronRepo;
import com.springbootdemo2.librarymanagementsystem.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronServices {
    @Autowired
    private PatronRepo patronRepo;

    // Add New Patron
    public Patron addNewPatron(Patron patron) {
        return patronRepo.save(patron);
    }

    // Get ALl Patrons
    public List<Patron> getAllPatrons(){
        return patronRepo.findAll();
    }

    // Get Patron By Id
    public Patron getPatronById(int id) {
        return patronRepo.findById(id).get();
    }

    // Update Patron Information
    public Patron updatePatron(Integer id,Patron patron) {
        Optional<Patron> optionalPatron = patronRepo.findById(id);
        if(optionalPatron.isPresent()) {
            Patron updatedPatron = optionalPatron.get();
            if(patron.getName()!=null) {
                updatedPatron.setName(patron.getName());
            }
            if(patron.getContactInformation()!=null) {
                updatedPatron.setContactInformation(patron.getContactInformation());
            }
            return patronRepo.save(updatedPatron);
        }
        else{
            throw new ResourceNotFoundException("Patron not found , Please try again");
        }
    }

    // Remove Patron
    public void deletePatron(int id) {
        patronRepo.deleteById(id);
    }
}
