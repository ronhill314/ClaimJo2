package com.SallysBottomBarrell.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SallysBottomBarrell.entity.Products;

@Repository

public interface ProductsRepo extends JpaRepository <Products, Integer> {


}
