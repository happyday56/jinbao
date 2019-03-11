package com.perfect.jinbao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("goods", "I am goods");
        return "index";
    }
}
