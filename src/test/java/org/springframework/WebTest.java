package org.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.IOException;

public class WebTest {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new XmlWebApplicationContext(
                    new ClassPathXmlApplicationContext("spring-web.xml"), "spring-web");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
