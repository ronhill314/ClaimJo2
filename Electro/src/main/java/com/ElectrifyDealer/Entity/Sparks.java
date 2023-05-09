package com.ElectrifyDealer.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="sparks")
public class Sparks {

    // ID lets you know its an id, and the primary key for the class
    @Id
    // Column maps to the same name as the column name in the database, it is case sensitive
    @Column(name = "id")
    // This will configure your id to be auto generated, now you don't need a setter for your id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price", precision = 10, scale = 2)
    private Double price;
    @Column(name = "imgUrl")
    private String imgUrl;
    public Integer getId() {
        return id;
    }
    
    public Sparks() {
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    @Override
    public String toString() {
        return "Sparks [id=" + id + ", name=" + name + ", price=" + price + ", imgUrl=" + imgUrl + "]";
    }


    
}
