package com.NeighborToNeighbor.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Events {

     // ID lets you know its an id
     @Id
     // Column maps to the same name as the column name in the database, it is case sensitive
     @Column(name = "id")
     // This will configure your id to be auto generated, now you don't need a setter for your id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Column(name = "eventName")
     private String eventName;
     @Column(name = "vendorName")
     private String vendorName;
     @Column(name = "eventDate")
     private Date eventDate;
     @Column(name = "eventAddress")
     private String eventAddress;
     @Column(name = "eventLocation")
     private String eventLocation;

    public Events() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {
        return "Events [id=" + id + ", eventName=" + eventName + ", vendorName=" + vendorName + ", eventDate="
                + eventDate + ", eventAddress=" + eventAddress + ", eventLocation=" + eventLocation + "]";
    }
    
}
