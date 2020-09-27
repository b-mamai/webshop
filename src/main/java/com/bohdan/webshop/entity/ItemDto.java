package com.bohdan.webshop.entity;

import lombok.Data;

@Data
public class ItemDto {
    private Long id;
    private String name;
    private float price;
    private String description;
    private Long basketId;
}
