package ru.examples.core.oop.inheritance;

public class DynamicMethodDispatchExample {

    // Dynamic Method Dispatch
    static class A {
        void callme() {
            System.out.println("Inside A's callme method");
        }
    }

    static class B extends A {
        // override callme()
        void callme() {
            System.out.println("Inside B's callme method");
        }
    }

    static class C extends A {
        // override callme()
        void callme() {
            System.out.println("Inside C's callme method");
        }
    }

}
