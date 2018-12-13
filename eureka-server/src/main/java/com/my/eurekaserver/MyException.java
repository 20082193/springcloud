package com.my.eurekaserver;

import java.util.concurrent.Executors;

/**
 * @author ppp
 * @date 2018-11-12 12:53
 */

public class MyException extends Exception {
    public MyException() {

    }

    public MyException(String s) {
        super(s);
    }

    public MyException(String s, Throwable throwable) {
        super(s, throwable);
    }

}
