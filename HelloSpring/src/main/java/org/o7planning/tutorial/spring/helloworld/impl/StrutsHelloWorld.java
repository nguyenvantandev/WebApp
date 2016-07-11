package org.o7planning.tutorial.spring.helloworld.impl;

import org.o7planning.tutorial.spring.helloworld.HelloWorld;

public class StrutsHelloWorld implements HelloWorld {
 
   @Override
   public void sayHello() {
       System.out.println("Struts Say Hello!!");
   }
 
}