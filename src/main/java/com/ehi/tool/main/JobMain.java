package com.ehi.tool.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JobMain {

    private static ApplicationContext context = null;
    static final String[] path = {"classpath:spring.xml"};
    static final String[] classpath = {"spring.xml"};

    private static void init() {
        try {
            context = new FileSystemXmlApplicationContext(path);
        } catch (Exception e) {
            try {
                context = new FileSystemXmlApplicationContext(classpath);
            } catch (Exception e2) {
                try {
                    context = new ClassPathXmlApplicationContext(classpath);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        init();
//        JobMain.class.getResourceAsStream("jdbc.properties");
    }

}
