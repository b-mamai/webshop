package com.bohdan.webshop.controller.mvc;

import com.bohdan.webshop.entity.Basket;
import com.bohdan.webshop.entity.Item;
import com.bohdan.webshop.entity.User;
import com.bohdan.webshop.repo.BasketRepo;
import com.bohdan.webshop.repo.ItemRepo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private final ItemRepo itemRepo;
    private final BasketRepo basketRepo;

    public UserController(ItemRepo itemRepo, BasketRepo basketRepo) {
        this.itemRepo = itemRepo;
        this.basketRepo = basketRepo;
    }

    @GetMapping("/personal")
    public String personal(@AuthenticationPrincipal User user,
                           Map<String, Object> model) {
        model.put("username", user.getUsername());
        Basket basket = basketRepo.findByUserId(user.getId());
        List<Item> items = basket == null ? new ArrayList<>() : itemRepo.findByBasketId(basket.getId());
        model.put("items", items);
        return "personal";
    }
}
