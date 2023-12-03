package com.varocode.springbootws.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author aap
 * Model class representing PRICES ddbb table
 */
@Entity
@Table(name = "PRICES")
public class ProductPrice implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rowId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

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
    @PreUpdate
    public void initDefaultValues() {
        Optional.ofNullable(this.startDate)
                .orElseGet(() -> this.startDate = LocalDateTime.now());
        Optional.ofNullable(this.endDate)
                .orElseGet(() -> this.endDate = LocalDateTime.now());
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
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

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }
}
