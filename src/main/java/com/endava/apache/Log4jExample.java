package com.endava.apache;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
    public static final Logger LOGGER = LogManager.getLogger(Log4jExample.class);

    public void doSomething(String s){
        LOGGER.error("Doing something with {}}", s);
    }

    public static void main(String[] args) {
        Log4jExample e = new Log4jExample();
        e.doSomething("Eminescu");
    }
}
