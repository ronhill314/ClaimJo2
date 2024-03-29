package com.NeighborToNeighbor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="cart")
public class Cart {
        // ID lets you know its an id
        @Id
        // Column maps to the same name as the column name in the database, it is case sensitive
        @Column(name = "id")
        // This will configure your id to be auto generated, now you don't need a setter for your id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
    
        @ManyToMany
        @JoinTable(
            name="cart_products",
            joinColumns=
                @JoinColumn(name="cart_id", referencedColumnName="id"),
            inverseJoinColumns=
                @JoinColumn(name="products_id", referencedColumnName="id")
            )
        private List<Products> itemsInCart;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public List<Products> getItemsInCart() {
            return itemsInCart;
        }

        public void setItemsInCart(List<Products> itemsInCart) {
            this.itemsInCart = itemsInCart;
        }

        public Cart() {
        }

        @Override
        public String toString() {
            return "Cart [id=" + id + ", itemsInCart=" + itemsInCart + "]";
        }
    
        
   
}
