package com.OnePercenterTravel.Service;

import java.util.List;

import org.hibernate.loader.custom.ResultRowProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnePercenterTravel.Entity.Reservation;
import com.OnePercenterTravel.Repo.ReservationRepo;

@Service
public class ReservationService {
    
    @Autowired
    ReservationRepo reservationRepo;

    // create

    public Reservation save(Reservation reservation) {
        return reservationRepo.save(reservation);

    }

    // read

    public Reservation findByID(Integer id) {
        return reservationRepo.findById(id).get();

    }

    public List<Reservation> findAll() {
        return reservationRepo.findAll();
    }

    //update

    public Reservation update(Reservation reservation) throws Exception{
        if(reservation.getId() == null) {
            throw new Exception("No id present, go away billy");
        }
        return reservationRepo.save(reservation);
    }

    //delete

    public void deleteById(Integer id) {
        reservationRepo.deleteById(id);
    }

}
