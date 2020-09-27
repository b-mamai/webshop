package com.bohdan.webshop.controller.rest;

import com.bohdan.webshop.entity.Item;
import com.bohdan.webshop.entity.ItemDto;
import com.bohdan.webshop.repo.BasketRepo;
import com.bohdan.webshop.repo.ItemRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/api/items")
public class ItemController {
    private final ItemRepo itemRepo;
    private final BasketRepo basketRepo;

    public ItemController(ItemRepo itemRepo, BasketRepo basketRepo) {
        this.itemRepo = itemRepo;
        this.basketRepo = basketRepo;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @PostMapping
    public Item createItem(@RequestBody ItemDto item) {
        Item it = new Item();
        it.setName(item.getName());
        it.setDescription(item.getDescription());
        it.setPrice(item.getPrice());
        it.setBasket(basketRepo.findById(item.getId()).orElseThrow(NoSuchElementException::new));
        itemRepo.save(it);
        return it;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody Item item) {
        item.setId(id);
        itemRepo.save(item);
    }
}
