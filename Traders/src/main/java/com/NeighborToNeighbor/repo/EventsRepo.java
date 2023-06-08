package com.NeighborToNeighbor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NeighborToNeighbor.entity.Events;

@Repository
public interface EventsRepo extends JpaRepository <Events, Integer> {
    
}
