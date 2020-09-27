package com.bohdan.webshop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @Column
    private String description;

    @JoinColumn(name = "basket_id")
    @ManyToOne
    private Basket basket;
}
