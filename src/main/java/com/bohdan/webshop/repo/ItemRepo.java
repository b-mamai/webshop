package com.bohdan.webshop.repo;

import com.bohdan.webshop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    List<Item> findByBasketId(Long basketId);
}
