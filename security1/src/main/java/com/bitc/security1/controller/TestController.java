package com.bitc.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/all")
    public String exAll() throws Exception {


        return "exAll";
    }

    @RequestMapping(value = "/admin")
    public String exAdmin() throws Exception {

        return "exAdmin";
    }

    @RequestMapping(value = "/member")
    public String exMember() {

        return "exMember";
    }

    @RequestMapping(value = "/success")
    public String exSuccess() {

        return "exSuccess";
    }
}
