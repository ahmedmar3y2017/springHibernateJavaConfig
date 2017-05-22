package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ahmed on 5/22/2017.
 */
@Controller
public class controller {

    @RequestMapping("/")
    public String GetView(){
        return "hello";

    }


}
