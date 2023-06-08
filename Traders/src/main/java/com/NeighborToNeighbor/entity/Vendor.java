package com.NeighborToNeighbor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name= "vendor")
public class Vendor {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "location")
    private String location;
    @Column(name = "companyName")
    private String comapanyName;
    
    public Vendor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComapanyName() {
        return comapanyName;
    }

    public void setComapanyName(String comapanyName) {
        this.comapanyName = comapanyName;
    }

    @Override
    public String toString() {
        return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", location="
                + location + ", comapanyName=" + comapanyName + "]";
    }

    

}
