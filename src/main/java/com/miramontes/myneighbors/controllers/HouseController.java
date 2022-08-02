package com.miramontes.myneighbors.controllers;

import com.miramontes.myneighbors.model.House;
import com.miramontes.myneighbors.repositories.HouseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/houses")
public class HouseController {

    private static final String BASE_PATH = "houses";
    private static final String HOUSES_LIST_VIEW = BASE_PATH + "/list";
    private static final String HOUSES_FORM_VIEW = BASE_PATH + "/form";
    private static final String REDIRECT_PREFIX = "redirect:/";
    private static final String REDIRECT_LIST = REDIRECT_PREFIX + BASE_PATH;

    private final HouseRepository repository;

    public HouseController(HouseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listHouses(Model model) {
        model.addAttribute("list", repository.findAll());
        return HOUSES_LIST_VIEW;
    }

    @GetMapping("/new")
    public String displayNewForm(Model model) {
        model.addAttribute("house", new House());
        return HOUSES_FORM_VIEW;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute House house) {
        repository.save(house);
        return REDIRECT_LIST;
    }
}
