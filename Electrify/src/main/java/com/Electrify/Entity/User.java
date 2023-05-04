package com.Electrify.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="user")

public class User {
    
    	// ID lets you know its an id
        @Id
        // Column maps to the same name as the column name in the database, it is case sensitive
        @Column(name = "id")
        // This will configure your id to be auto generated, now you don't need a setter for your id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name ="email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "name")
        private String name;

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
            return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + "]";
        }



        
}
