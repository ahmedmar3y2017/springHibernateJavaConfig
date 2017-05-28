package com.controllers;

import Entities.student;
import configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import service.studentService;

import java.util.Date;
import java.util.List;

/**
 * Created by ahmed on 5/28/2017.
 */
public class main {


    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        studentService service = (studentService) context.getBean("studentService");
        List<student> list = service.GetAllStudents();

        for (student student : list) {


            System.out.println(student.getUsername() + "       \t " + student.getAddress());

        }

//        context.close();

    }
}
