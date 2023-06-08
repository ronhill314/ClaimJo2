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

import com.NeighborToNeighbor.entity.Vendor;
import com.NeighborToNeighbor.service.VendorService;

@RestController
@RequestMapping(value="/vendor")
@CrossOrigin("*")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @RequestMapping(
        value = "/signUp",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
)

public ResponseEntity<Object> signUp(@RequestBody Vendor vendor) {

    try {

        Vendor savedVendor = vendorService.save(vendor);

        return new ResponseEntity<Object>(savedVendor, HttpStatus.CREATED);
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
public ResponseEntity<Object> signIn(@RequestBody Vendor vendor) {

    try {
        Vendor loggedInVendor = vendorService.signIn(vendor);
        return new ResponseEntity<Object>(loggedInVendor, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Error e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

@RequestMapping(
    value="/findVendorById/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.GET
)
public ResponseEntity<Object> findVendorById(@PathVariable Integer id) {

    try {
        Vendor foundVendor = vendorService.findById(id);
        return new ResponseEntity<Object>(foundVendor, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Error e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}



@RequestMapping(
    value="/findVendorByEmail/{email}",
    produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.GET
)
public ResponseEntity<Object> findVendorByEmail(@PathVariable String email) {

    try {
        Vendor foundVendor = vendorService.findByEmail(email);
        return new ResponseEntity<Object>(foundVendor, HttpStatus.OK);
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
        List<Vendor> allVendors = vendorService.findAll();
        return new ResponseEntity<Object>(allVendors, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Error e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

@RequestMapping(
    value="/updateVendor",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE,
    method = RequestMethod.POST
)
public ResponseEntity<Object> updateVendor(@RequestBody Vendor vendor) {

    try {
        Vendor updatdVendor = vendorService.update(vendor);
        return new ResponseEntity<Object>(updatdVendor, HttpStatus.OK);
    } catch (Exception e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Error e) {
        System.out.println(e);
        return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

@RequestMapping(
    value="/deleteVendor/{id}",
    method = RequestMethod.DELETE
)
public ResponseEntity<Object> deleteVendor(@PathVariable Integer id) {

    try {
        // 
        vendorService.deleteById(id);
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
