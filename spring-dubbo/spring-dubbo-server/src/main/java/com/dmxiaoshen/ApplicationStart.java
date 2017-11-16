package com.dmxiaoshen;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hzhsg on 2017/11/16.
 */
public class ApplicationStart {

    public static void main(String[] args) throws InterruptedException{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        context.start();
        System.out.println("------start-------");
        while (true){
            Thread.sleep(1000);
        }
    }
}
