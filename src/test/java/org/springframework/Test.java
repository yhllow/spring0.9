package org.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
            ((Test) context.getBean("test")).test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        System.out.println("this is a bean from spring");
    }
}