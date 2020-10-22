package org.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

public class UITest {
    public static void main(String[] args) {
//        ApplicationContext context = new StaticUiApplicationContext();
        ApplicationContext context = new StaticApplicationContext();
        System.out.println(context);
    }
}
