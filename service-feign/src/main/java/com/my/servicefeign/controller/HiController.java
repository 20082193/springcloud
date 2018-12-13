package com.my.servicefeign.controller;

import com.my.servicefeign.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ppp
 * @date 2018-11-05 20:59
 */
@RestController
public class HiController {

    @Autowired
    private  SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(String name) {
        System.out.println("name = " + name);
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
