package com.example.mybank.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="email", nullable=false, unique=true, length=128)
    private String email;
    
    @Column(nullable=false, length=64)
    private String password;
    
    @Column(name="name", nullable=false, unique=true, length=64)
    private String name;

    @Column(name="address", nullable=false, length=256)
    private String address;

    @Column(name="city", nullable=false, length=64)
    private String city;

    @Column(name="pin", nullable=false, length=6)
    private String pin;

    @Column(name="aadhar", nullable=false, length=12)
    private String aadhar;

    @Column(name="phone", nullable=false, length=10)
    private String phone;
    
    @Column(name="admin", nullable=false)
    private Boolean admin;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAadhar() {
        return aadhar;
    }
    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
