package org.o7planning.tutorial.spring.helloworld.impl;

import org.o7planning.tutorial.spring.helloworld.HelloWorld;

public class SpringHelloWorld implements HelloWorld {
 
   @Override
   public void sayHello() {
       System.out.println("Spring Say Hello!!");
   }
 
}