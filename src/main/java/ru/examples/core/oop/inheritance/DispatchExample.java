package ru.examples.core.oop.inheritance;

public class DispatchExample {
    public static void main(String args[]) {
        DynamicMethodDispatchExample.A a = new DynamicMethodDispatchExample.A(); // object of type A
        DynamicMethodDispatchExample.B b = new DynamicMethodDispatchExample.B(); // object of type B
        DynamicMethodDispatchExample.C c = new DynamicMethodDispatchExample.C(); // object of type C
        DynamicMethodDispatchExample.A r; // obtain a reference of type A

        r = a; // r refers to an A object
        r.callme(); // calls A's version of callme

        r = b; // r refers to a B object
        r.callme(); // calls B's version of callme

        r = c; // r refers to a C object
        r.callme(); // calls C's version of callme

    }
}
