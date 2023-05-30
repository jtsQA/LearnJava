package org.learn.concepts;

import org.checkerframework.checker.units.qual.C;

public class FinalConcepts {

    public static void main(String[] args) {
        System.out.println("final is a keyword");

        //static polymorphism
        System.out.println("FinalConcepts.main - Child c = new Child()");
        Child c = new Child();
        c.test();

        System.out.println("FinalConcepts.main - Parent p = new Parent()");
        Parent p = new Parent();
        p.test();

        //dynamic polymorphism
        System.out.println("FinalConcepts.main - Parent pc = new Child()");
        Parent pc = new Child();
        pc.test();

        /*// throws ClassCastException as Parent cannot be the reference object for Child class
        Child cp = (Child) new Parent();
        cp.test();*/
    }

}

//the 'final' keyword below is commented to utilize the class
//to prevent Class inheritance
//to prevent Method inheritance
//to declare constant values

/*final*/ class Parent {
    /*final*/ int i = 1;
    public /*final*/ void test() {
        System.out.println("Parent.test");
    }
}

class Child extends Parent {
    @Override
    public void test() {
        System.out.println("Child.test");
        Parent p = new Parent();
        p.i = 100;
        System.out.println("Parent.i = "+p.i);
    }
}