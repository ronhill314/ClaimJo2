package com.NeighborToNeighbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.NeighborToNeighbor.entity.Products;
import com.NeighborToNeighbor.service.ProductService;

@RestController

@RequestMapping(value="/product")

@CrossOrigin("*")
public class ProductController {
    @Autowired
    ProductService productService;


    @RequestMapping(
    		value = "/create",
    		consumes = MediaType.APPLICATION_JSON_VALUE,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		method = RequestMethod.POST
    )
   
    public ResponseEntity<Object> create(@RequestBody Products product) {

        try {
            Products savedProducts = productService.save(product);
            return new ResponseEntity<Object>(savedProducts, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/findProductsById/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.GET
    )
    public ResponseEntity<Object> findProductsById(@PathVariable Integer id) {

        try {
            Products foundProducts = productService.findById(id);
            return new ResponseEntity<Object>(foundProducts, HttpStatus.OK);
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
            List<Products> allProducts = productService.findAll();
            return new ResponseEntity<Object>(allProducts, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/updateProducts",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        method = RequestMethod.POST
    )
    public ResponseEntity<Object> updateProducts(@RequestBody Products product) {

        try {
            Products updatdProducts = productService.update(product);
            return new ResponseEntity<Object>(updatdProducts, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Error e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
        value="/deleteProducts/{id}",
        method = RequestMethod.DELETE
    )
    public ResponseEntity<Object> deleteProducts(@PathVariable Integer id) {

        try {
            // 
            productService.deleteById(id);
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
