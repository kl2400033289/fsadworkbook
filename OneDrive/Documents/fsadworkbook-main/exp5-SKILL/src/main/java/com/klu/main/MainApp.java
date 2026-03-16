package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.klu.config.Appconfig;
import com.klu.model.Student;

public class MainApp {

    private static ApplicationContext context;

	public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(Appconfig.class);

        Student student = context.getBean(Student.class);
        student.display();
    }
}
