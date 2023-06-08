package com.NeighborToNeighbor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.NeighborToNeighbor.entity.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Integer>{

    @Query(value="select * from vendor where email = ?1 and password = ?2", nativeQuery = true)
    public Vendor signIn(String email, String password);

    @Query(value="select * from vendor where email = ?1", nativeQuery = true)
    public Vendor findByEmail(String email);
    
}
