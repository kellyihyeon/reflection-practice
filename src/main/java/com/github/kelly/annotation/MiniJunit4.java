package com.github.kelly.annotation;

public class MiniJunit4 {

    @RunTest
    public void uno() {
        System.out.println("MiniJunit4.uno");
    }

    @RunTest
    public void dos() {
        System.out.println("MiniJunit4.dos");
    }

    public void tres() {
        System.out.println("MiniJunit4.tres");
    }
}
