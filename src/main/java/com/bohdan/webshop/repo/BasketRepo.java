package com.bohdan.webshop.repo;

import com.bohdan.webshop.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepo extends JpaRepository<Basket, Long> {
    Basket findByUserId(Long userId);
}
