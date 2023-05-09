package com.ElectrifyDealer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ElectrifyDealer.Entity.Sparks;
import com.ElectrifyDealer.Repo.SparksRepo;

@Service
public class SparksService {
    
    @Autowired
    SparksRepo sparksRepo;
    
    //Create

    public Sparks save(Sparks sparks) {
        return sparksRepo.save(sparks);
    }
    
    // Read

    public Sparks findById(Integer id) {
        return sparksRepo.findById(id).get();
    }

    public List<Sparks> findAll() {
        return sparksRepo.findAll();
    }

    // Update

    public Sparks update(Sparks sparks) throws Exception {

        if(sparks.getId() == null) {
            throw new Exception("No id present, go away billy");
        }

        return sparksRepo.save(sparks);

    }

    // Delete

    public void deleteById(Integer id) {
        sparksRepo.deleteById(id);
    }

}
