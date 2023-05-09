package com.NeighborToNeighbor.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NeighborToNeighbor.entity.Cart;
import com.NeighborToNeighbor.entity.User;
import com.NeighborToNeighbor.repo.UserRepo;

@Service 
public class UserService {
    	
    @Autowired
    UserRepo userRepo;
	
	public User save(User user) {
		
	    return userRepo.save(user);
	}
	
	public User update(User user) throws Exception {

        if(user.getId() != null) {
	        return userRepo.save(user);
        }

        throw new AccountNotFoundException("Account does not exist! id not present");
	}
    
    public User findById(Integer userId) throws Error {
        
    	
        if(userRepo.findById(userId).isPresent()) {
            return userRepo.findById(userId).get();
        }
        
        throw new Error("No user id present, User not found, send an id billy, dumbass");
        
    }

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User signIn(User user) throws Exception {

		User loggedInUser = userRepo.signIn(user.getEmail(), user.getPassword());
		if(loggedInUser == null) {
			throw new Exception("User was not found");
		}
		return loggedInUser;

	}

    public void deleteById(Integer id) {
	    userRepo.deleteById(id);
	}

	public User addCartToUser(User user, Cart cart) {
		
		user.setCart(cart);
		return userRepo.save(user);

	}

}

