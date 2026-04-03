package com.sampleapp.order.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String status;
    private BigDecimal totalAmount;
    private LocalDate orderDate;

    // Getters and Setters
    @PrePersist
    public void prePersist() {
        if (orderDate == null) {
            orderDate = LocalDate.now();
        }
        if (status == null) {
            status = "PENDING";
        }
    }

}
