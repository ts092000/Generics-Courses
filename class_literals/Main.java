package com.bkitsolution.class_literals;

public class Main {

    public static void main(String[] args) {
	    Injector injector = new Injector().with("Hello World");

        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
}
