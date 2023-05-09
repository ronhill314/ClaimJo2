package com.ElectrifyDealer.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ElectrifyDealer.Entity.Sparks;

@Repository
public interface SparksRepo extends JpaRepository<Sparks, Integer> {
    
}
