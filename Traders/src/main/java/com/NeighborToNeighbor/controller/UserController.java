package com.NeighborToNeighbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.NeighborToNeighbor.entity.Cart;
import com.NeighborToNeighbor.entity.User;
import com.NeighborToNeighbor.service.CartService;
import com.NeighborToNeighbor.service.UserService;

@RestController
@RequestMapping(value="/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;


    @RequestMapping(
    		value = "/signUp",
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		method = RequestMethod.POST
    )
 
    public ResponseEntity<Object> signUp(@RequestBody User user) {

        try {
            Cart cart = cartService.save(new Cart());

            User savedUser = userService.save(user);

            savedUser = userService.addCartToUser(savedUser, cart);

            return new ResponseEntity<Object>(savedUser, HttpStatus.CREATED);
        } catch(DataIntegrityViolationException e) {
            System.out.println("Dupe email");
            return new ResponseEntity<Object>("Dupe Email", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/signIn",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> signIn(@RequestBody User user) {

        try {
            User loggedInUser = userService.signIn(user);
            return new ResponseEntity<Object>(loggedInUser, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/findUserById/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findUserById(@PathVariable Integer id) {

        try {
            User foundUser = userService.findById(id);
            return new ResponseEntity<Object>(foundUser, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    

    @RequestMapping(
        value="/findUserByEmail/{email}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findUserByEmail(@PathVariable String email) {

        try {
            User foundUser = userService.findByEmail(email);
            return new ResponseEntity<Object>(foundUser, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/findAll",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findAll() {

        try {
            List<User> allUsers = userService.findAll();
            return new ResponseEntity<Object>(allUsers, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/updateUser",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> updateUser(@RequestBody User user) {

        try {
            User updatdUser = userService.update(user);
            return new ResponseEntity<Object>(updatdUser, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/deleteUser/{id}",
        method = RequestMethod.DELETE
    )
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {

        try {
            // 
            userService.deleteById(id);
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    }

    