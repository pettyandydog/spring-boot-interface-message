package com.andy.controllers;

/**
 * Created by andy on 2016/12/22.
 */

import com.andy.annotation.MethodDescription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test3")
public class Test3Controller {

    @RequestMapping("/getname")
    @MethodDescription(description = "获取名称")
    public String getName(){
        return "andy";
    }
}
