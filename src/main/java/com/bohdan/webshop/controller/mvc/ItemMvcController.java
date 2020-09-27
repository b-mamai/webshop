package com.bohdan.webshop.controller.mvc;

import com.bohdan.webshop.repo.ItemRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemMvcController {
    private final ItemRepo itemRepo;

    public ItemMvcController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public String getAllItems(Model model) {
        model.addAttribute("items", itemRepo.findAll());
        return "items";
    }
}
