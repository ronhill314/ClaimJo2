package com.ElectrifyDealership.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ElectrifyDealership.Entity.User;
import com.ElectrifyDealership.Repo.UserRepo;

@Service

public class UserService {

    @Autowired
    UserRepo userRepo;

    // CREATE
    public User signUp(User user) {
        return userRepo.save(user);
    }


    //READ
    public User signIn(User user) throws Exception {
        
        User loggedInUser = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(loggedInUser == null) {
            throw new Exception("User not found, try again billy.");
        }
        return loggedInUser;
    }

    public User findUserById(Integer id) {
        // Find by id isnt perfect, you need to do .get() on the end
        // to get your object off of the function
        return userRepo.findById(id).get();
    }

    public User findUserByEmail(String email) {

        return userRepo.findByEmail(email);

    }


    //UPDATE
    public User update(User user) throws Exception {

        if(user.getId() == null) {
            // throwing your own exception will stop
            throw new Exception("Try again billy!");
        }

        return userRepo.save(user);
    }



    //DELETE
    public void deleteUserById(Integer id){
        userRepo.deleteById(id);
    }
}
