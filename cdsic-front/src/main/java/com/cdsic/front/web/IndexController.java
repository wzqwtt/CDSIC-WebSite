package com.cdsic.front.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        // TODO 查出数据

        return "index";
    }

}
