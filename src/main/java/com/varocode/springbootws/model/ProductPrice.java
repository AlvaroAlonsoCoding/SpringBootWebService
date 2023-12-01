package com.varocode.springbootws.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

/**
 * @author aap
 * Model class representing PRICES ddbb table
 */
@Entity
@Table(name="PRICES")
public class ProductPrice implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brand_id",referencedColumnName = "id")
    private Brand brand;

    private Date startDate;

    private Date endDate;

    private int priceList;

    @Column(nullable = false)
    private int productId;

    private int priority;

    private double price;

    @Column(nullable = false)
    private String currency;


    /**
     * Replaces null values with default ones
     */
    @PrePersist
    public void initDefaultValues(){
        Optional.ofNullable(this.startDate)
                .orElseGet(()-> this.startDate=new Date());
        Optional.ofNullable(this.endDate)
                .orElseGet(()-> this.endDate=new Date());
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
