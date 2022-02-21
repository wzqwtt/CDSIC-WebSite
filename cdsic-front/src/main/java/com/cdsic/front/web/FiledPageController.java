package com.cdsic.front.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FiledPageController {

    @GetMapping({"/filed", "/filed.html"})
    public String filedPage() {
        return "filed";
    }
}
