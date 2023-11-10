package com.otabek.restaurant_management.controllers;


import com.otabek.restaurant_management.dao.MenuItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menu")
public class MenuItemController {
    private final MenuItemDAO menuItemDAO;
    @Autowired
    public MenuItemController(MenuItemDAO menuItemDAO) {
        this.menuItemDAO = menuItemDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("menuItems", menuItemDAO.getMenuItems());
        return "menuItem/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("item", menuItemDAO.getItemByID(id));
        return "menuItem/show";
    }
}
