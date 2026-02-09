package com.library.foxwearmanagement.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {
    @GetMapping
    public String admin() {
        return "admin/admin";
    }

    @GetMapping("/products")
    public String products() {
        return "admin/products/products";
    }

    @GetMapping("/products/add")
    public String addProduct() {
        return "admin/products/add";
    }

    @GetMapping("/users")
    public String user() {
        return "admin/users";
    }

    @GetMapping("/sales")
    public String sales() {
        return "admin/sales";
    }

    @GetMapping("/orders")
    public String orders() {
        return "admin/orders";
    }

    @GetMapping("/messages")
    public String messages() {
        return "admin/messages";
    }

    @GetMapping("/settings")
    public String settings() {
        return "admin/settings";
    }
}
