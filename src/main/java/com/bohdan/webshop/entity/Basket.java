package com.bohdan.webshop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
}
