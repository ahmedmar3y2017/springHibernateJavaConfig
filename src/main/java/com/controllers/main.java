package com.controllers;

import Entities.student;
import Entities.studentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by ahmed on 5/26/2017.
 */

public class main {
    /*
    *
    *     this.id = id;
            this.username = username;
            this.password = password;
            this.address = address;
            this.mobile = mobile;
            this.birthDate = birthDate;
    * */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        studentDao studentDao = (Entities.studentDao) context.getBean("d");
        studentDao.insert(new student("ahme", "123", "tanta", Long.parseLong("123"), new Date()));

    }

}
