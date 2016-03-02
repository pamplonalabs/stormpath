package com.stormpath.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
      ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

      PasswordValidationService obj = (PasswordValidationService) context.getBean("PasswordValidationService");

      System.out.println("'" + args[0] + "' is " + (obj.checkPassword(args[0]) ? "" : "not ") + "valid password.");

    }
}
