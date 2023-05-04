package com.OnePercenterTravel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.OnePercenterTravel.Entity.User;

/*
 * ALL REPOS ARE INTERFACES NOT CLASSES
 * The job of the repo is to communicate CRUD wise with the database
 * (Remember crud, CREATE READ UPDATE DELETE)
 */
@Repository                      //Give JpaRepo the name of your Class
                                // and the DataType of the Primary Key
public interface UserRepo extends JpaRepository<User, Integer> {

    // @query will allow you to make a query to the DB for the abstract function
    // it will return data from the db to your service
    // value is the select statement you make for you to write basic SQL
    // nativeQuery should always be true, allows you to write basic SQL
    // ?1 and ?2... the arguments you pass the repo function, in order
    @Query(value="select * from user where email = ?1 and password = ?2", nativeQuery = true)
    // This function MUST BE ABSTRACT, NO BRACKETS
    public User findByEmailAndPassword(String email, String password);

    @Query(value="select * from user where email = ?1", nativeQuery = true)
    public User findByEmail(String Email);
    
}
