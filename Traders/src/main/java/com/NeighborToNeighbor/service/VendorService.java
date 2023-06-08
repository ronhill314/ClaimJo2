package com.NeighborToNeighbor.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NeighborToNeighbor.entity.Vendor;
import com.NeighborToNeighbor.repo.VendorRepo;

@Service
public class VendorService {
    
    @Autowired
    VendorRepo vendorRepo;

    public Vendor save(Vendor vendor) {
		
	    return vendorRepo.save(vendor);
	}
	
	public Vendor update(Vendor vendor) throws Exception {

        if(vendor.getId() != null) {
	        return vendorRepo.save(vendor);
        }

        throw new AccountNotFoundException("Account does not exist! id not present");
	}
    
    public Vendor findById(Integer vendorId) throws Error {
        
    	
        if(vendorRepo.findById(vendorId).isPresent()) {
            return vendorRepo.findById(vendorId).get();
        }
        
        throw new Error("No vendor id present, Vendor not found, send an id billy, dumbass");
        
    }

	public Vendor findByEmail(String email) {
		return vendorRepo.findByEmail(email);
	}

	public List<Vendor> findAll() {
		return vendorRepo.findAll();
	}

	public Vendor signIn(Vendor vendor) throws Exception {

		Vendor loggedInVendor = vendorRepo.signIn(vendor.getEmail(), vendor.getPassword());
		if(loggedInVendor == null) {
			throw new Exception("Vendor was not found");
		}
		return loggedInVendor;

	}

    public void deleteById(Integer id) {
	    vendorRepo.deleteById(id);
	}

}
