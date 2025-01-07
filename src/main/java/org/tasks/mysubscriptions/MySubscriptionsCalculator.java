package org.tasks.mysubscriptions;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MySubscriptionsCalculator {

    public static void main(String[] args) {


        Map<String, Double> sums = new LinkedHashMap<>();

        Newspapers TOI = new Newspapers();
        Newspapers Hindu = new Newspapers();
        Newspapers ET = new Newspapers();
        Newspapers BM = new Newspapers();
        Newspapers HT = new Newspapers();

        sums.put("TOI", TOI.set(3, 3, 3, 3, 3, 5, 6));
        sums.put("Hindu", Hindu.set(2.5, 2.5, 2.5, 2.5, 2.5, 4, 4));
        sums.put("ET", ET.set(4, 4, 4, 4, 4, 4, 10));
        sums.put("BM", BM.set(1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5));
        sums.put("HT", HT.set(2, 2, 2, 2, 2, 4, 4));
        //sums = {TOI=26.0, Hindu=20.5, ET=34.0, BM=10.5, HT=18.0}

        System.out.println(sums.toString());

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the weekly budget: ");
        int budget = input.nextInt();
        ArrayList<String> keys = new ArrayList(sums.keySet());
        for (int i = 0; i < keys.size() - 1; i++)
            for (int j = i + 1; j < keys.size(); j++)
                if (sums.get(keys.get(i)) + sums.get(keys.get(j)) <= budget)
                    System.out.print("{" + keys.get(i) + "," + keys.get(j) + "},");
    }

}

class Newspapers {

    public double sum;
    private LinkedHashMap<String, Double> price;

    public Newspapers() {
        price = new LinkedHashMap<>();
    }


    public void setData(String day, double amount) {
        price.put(day, amount);
        sum = calcSum();
    }

    public double set(double monday, double tuesday, double wednesday, double thursday, double friday, double saturday, double sunday) {
        setData("Monday", monday);
        setData("Tuesday", tuesday);
        setData("Wednesday", wednesday);
        setData("Thursday", thursday);
        setData("Friday", friday);
        setData("Saturday", saturday);
        setData("Sunday", sunday);
        return sum;
    }

    public double getData(String day) {
        return price.get(day);
    }

    public double calcSum() {
        double sum = 0;
        for (double count : price.values())
            sum += count;
        return sum;
    }

}