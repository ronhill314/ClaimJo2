package com.OnePercenterTravel.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// allow spring to see your file as an entity
//Entitys are classes that you use to create objects
//that will eventually be stored in the database
@Entity
// tell spring that the entity will correlate to the table in the
// database with name given
@Table(name ="user")
public class User {

    // ID lets you know its an id
    @Id
    // Column maps to the same name as the column name in the database, it is case sensitive
    @Column(name = "id")

    // This will configure your id to be auto generated, now you don't need a setter for your id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

     // Column maps to the same name as the column name in the database, it is case sensitive
     @Column(name = "email")
     private String email;

    // Column maps to the same name as the column name in the database, it is case sensitive
    @Column(name = "password")
    private String password;

     // Column maps to the same name as the column name in the database, it is case sensitive
     @Column(name = "name")
     private String name;

    // Column maps to the same name as the column name in the database, it is case sensitive
    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @OneToMany
    // on the one to many, you state the parent as the foreign key, to be placed on the child
    @JoinColumn(name="user_id")
    private List<Reservation> reservation;

    

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", isAdmin="
                + isAdmin + ", reservation=" + reservation + "]";
    }

 

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

     

    
}
