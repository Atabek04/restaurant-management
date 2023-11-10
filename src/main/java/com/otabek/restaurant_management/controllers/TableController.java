package com.otabek.restaurant_management.controllers;

import com.otabek.restaurant_management.dao.OrderDAO;
import com.otabek.restaurant_management.dao.OrderItemDAO;
import com.otabek.restaurant_management.dao.TableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tables")
public class TableController {
    private final TableDAO tableDAO;
    private final OrderDAO orderDAO;
    private final OrderItemDAO orderItemDAO;

    @Autowired
    public TableController(TableDAO tableDAO, OrderDAO orderDAO, OrderItemDAO orderItemDAO) {
        this.tableDAO = tableDAO;
        this.orderDAO = orderDAO;
        this.orderItemDAO = orderItemDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("tables", tableDAO.getTables());
        return "table/index";
    }

    @GetMapping("/{id}/reserve")
    public String reserve(@PathVariable("id") int id, Model model){
        tableDAO.getTableById(id).setStatus(1);
        return "redirect:/{id}";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("table", tableDAO.getTableById(id));
        return "table/show";
    }
}
