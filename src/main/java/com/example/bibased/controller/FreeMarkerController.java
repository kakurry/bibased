package com.example.bibased.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于测试跳转网页所建立的Controller
 */
@Controller
public class FreeMarkerController {
    @RequestMapping("index.html")
    public String index(){
        return "freemarker_ceshi";
    }
}