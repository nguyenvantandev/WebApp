package org.o7planning.tutorial.spring;

import org.o7planning.tutorial.spring.helloworld.HelloWorld;
import org.o7planning.tutorial.spring.helloworld.HelloWorldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class HelloProgram {
 
    
   public static void main(String[] args) {
        
       ApplicationContext context =
               new ClassPathXmlApplicationContext("beans.xml");
        
       HelloWorldService service =
            (HelloWorldService) context.getBean("helloWorldService");
        
       HelloWorld hw= service.getHelloWorld();
        
       hw.sayHello();
   }
}