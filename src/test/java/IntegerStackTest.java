import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tasks.IntegerStackUsingArray;

public class IntegerStackTest {

    private IntegerStackUsingArray stack;

    @BeforeEach
    public void setUpStack() {
        int[] intStack = new int[]{10, 20, 30};
        stack = new IntegerStackUsingArray(intStack.length);
        for (int value : intStack) {
            stack.push(value);
        }
    }

    @Test
    public void testPop() {
        Assertions.assertEquals(30, stack.pop(), "The last value removed from stack is not matching");
        Assertions.assertEquals(20, stack.pop(), "The last value removed from stack is not matching");
        Assertions.assertEquals(10, stack.pop(), "The last value removed from stack is not matching");
    }

    @Test
    public void testPeek() {
        Assertions.assertEquals(30, stack.peek(), "The last value in stack is not matching");
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(3, stack.size(), "The stack size is not matching");
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertFalse(stack.isEmpty(), "The stack is empty");
        while (!stack.isEmpty()) {
            stack.pop();
        }
        Assertions.assertTrue(stack.isEmpty(), "The stack is not empty");
    }

    @Test
    public void testIsFull() {
        Assertions.assertTrue(stack.isFull(), "The stack is not full");
        stack.pop();
        Assertions.assertFalse(stack.isFull(), "The stack is full");
    }

}
