package com.miramontes.myneighbors.controllers;

import com.miramontes.myneighbors.repositories.HouseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/houses")
public class HouseController {

    private final HouseRepository repository;

    public HouseController(HouseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listHouses(Model model) {
        model.addAttribute("list", repository.findAll());
        return "houses/list";
    }
}
