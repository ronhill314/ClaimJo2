package com.NeighborToNeighbor.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NeighborToNeighbor.entity.Events;
import com.NeighborToNeighbor.repo.EventsRepo;

@Service
public class EventsService {

    @Autowired
    EventsRepo eventsRepo;

    public Events save(Events events) {
		
	    return eventsRepo.save(events);
	}
	
	public Events update(Events events) throws Exception {

        if(events.getId() != null) {
	        return eventsRepo.save(events);
        }

        throw new AccountNotFoundException("Account does not exist! id not present");
	}


    public Events findById(Integer eventsId) throws Error {
    	
        if(eventsRepo.findById(eventsId).isPresent()) {
            return eventsRepo.findById(eventsId).get();
        }
        
        throw new Error("No user id present, User not found, send an id billy, dumbass");
        
    }

    public List<Events> findAll() {
		return eventsRepo.findAll();
	}

    public void deleteById(Integer id) {
	    eventsRepo.deleteById(id);
	}
    
}
