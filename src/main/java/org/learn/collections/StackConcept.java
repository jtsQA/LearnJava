package org.learn.collections;

import java.util.*;

public class StackConcept {

    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>();

        for (int i = 0; i < 10; i++) {
            stack1.push(i);
        }

        System.out.println("cStack.main - push 0 to 9 = " + stack1);
        System.out.println("cStack.main - pop = " + stack1.pop());
        System.out.println("cStack.main - peek = " + stack1.peek());
        System.out.println("cStack.main - add(10) = " + stack1.add(10));
        System.out.println("cStack.main - stack1 = " + stack1);
        System.out.println("cStack.main - capacity = " + stack1.capacity());
        System.out.println("cStack.main - size = " + stack1.size());

    }

}
