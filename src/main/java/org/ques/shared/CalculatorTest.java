package org.ques.shared;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {

    public static int getSum(int... a) {
        int counter = a.length;
        int sum = 0;

        while (counter > 0) {
            sum += a[counter - 1];
            counter--;
        }

        return sum;
    }

    @Test
    public void testSumOfNumbersWithNegativeInputs() {
        Assert.assertEquals(-10, getSum(-7, -3));
    }

    @Test
    public void testSumOfNumbersWithPositiveInputs() {
        Assert.assertEquals(11, getSum(7, 3, 1));
    }

    @Test
    public void testSumOfNumbersWithPositiveAndNegativeInputs() {
        Assert.assertEquals(14, getSum(7, 3, -3, 6, -1, 2));
    }

    @Test
    public void testSumOfNumbersWithZeroes() {
        Assert.assertEquals(0, getSum(0));
    }

}
