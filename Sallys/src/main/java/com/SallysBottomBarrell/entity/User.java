package com.SallysBottomBarrell.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Annotate Objects with Entity, lets project know its a Object from the DB
@Entity
// Tells what table the object is coming from
@Table(name="user")
public class User {

    // ID lets you know its an id
    @Id
    // Column maps to the same name as the column name in the database, it is case sensitive
    @Column(name = "id")
    // This will configure your id to be auto generated, now you don't need a setter for your id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<CreditCard> wallet;

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", cart=" + cart + ", wallet="
                + wallet + "]";
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<CreditCard> getWallet() {
        return wallet;
    }

    public void setWallet(List<CreditCard> wallet) {
        this.wallet = wallet;
    }
    
}