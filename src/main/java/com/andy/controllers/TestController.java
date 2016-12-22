package com.andy.controllers;

import com.andy.annotation.MethodDescription;
import com.andy.annotation.ParamterDescription;
import com.andy.configuration.InterfaceDescription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andy on 2016/12/21.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    @MethodDescription(description = "springboot的say hello页面")
    public String sayHello() {
        return "hello spring boot!!!";
    }

    @RequestMapping("/input")
    @MethodDescription(description = "测试input")
    public String getInput(@ParamterDescription(name = "input", description = "你需要输入的值") String input) {
        return input;
    }

    @RequestMapping("/interface")
    @MethodDescription(description = "获取接口信息")
    public Map receiveInterfaces() {
        Map interfaces = new HashMap();
        interfaces.put("interface message", InterfaceDescription.getInterfaceDescription());
        return interfaces;
    }


    @RequestMapping("/yourInfo")
    @MethodDescription(description = "输出你的信息")
    public String getYourInfo(@ParamterDescription(name = "name", description = "你的姓名") String name,
                              @ParamterDescription(name = "age", description = "你的年龄") int age) {

        return "name:"+name+",age:"+age;
    }

}
