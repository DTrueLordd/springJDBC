package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DAO dao = (DAO) context.getBean("dao");


        printAllUsers(dao);


    }

    public static void printAllUsers(DAO dao){
        List<User> users = dao.getAllUsers();

        for (User user : users) {
            System.out.println("ID: " + user.getId() + ", Name: " + user.getName());
        }
    }
}
