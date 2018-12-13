package com.my.servicefeign;

import org.springframework.stereotype.Component;

/**
 * @author ppp
 * @date 2018-11-05 21:28
 */

@Component
public class SchedualServiceHiImpl implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }
}
