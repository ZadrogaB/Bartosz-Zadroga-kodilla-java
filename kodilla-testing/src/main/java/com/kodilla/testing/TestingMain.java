package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        //Kod z działu 6.1
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        //Kod z działu 6.2
        SimpleUser simpleUser = new SimpleUser("forumUser");
        String result = simpleUser.getUsername();

        if(result.equals("forumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //Zadanie z działu 6.2
        Calculator calculator = new Calculator();
        int add, subtract;

        add = calculator.add(8,5);
        subtract = calculator.subtract(8,5);

        if (add==13 && subtract==3){
            System.out.println("test zadanie 6.2 OK");
        } else {
            System.out.println("test zadanie 6.2 Error!");
        }
    }
}
