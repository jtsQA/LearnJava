package org.learn.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsFilters {

    private static List<Customer> customersList;

    public static void main(String[] args) {

        customersList = Arrays.asList(
                new Customer("Ram", 28),
                new Customer("Prakash", 32),
                new Customer("Sid", 46),
                new Customer("Krishna", 39),
                new Customer("Logan", 26),
                new Customer("Anil", 55));

        filterFindAnyOrElse();
        filterMap();

    }

    public static void filterFindAnyOrElse() {
        System.out.println("Filter - Find Any Or ELse:");

        //1. filter - find any
        Customer customer1 = customersList.stream()   //convert list to streams
                .filter(x -> x.getName().contains("a") && x.getAge() < 35)  //filter name containing 'a' and age less than 35
                .findAny() //find any result satisfying the conditions
                .orElse(null);  //return null if not result obtained

        assert customer1 != null;
        System.out.println("Customer 1 - name: " + customer1.getName() + ", and age:" + customer1.getAge());

        //2. filter - did not find any or else
        Customer customer2 = customersList.stream()
                .filter(x -> x.getName().contains("a") && x.getAge() > 55)
                .findAny()
                .orElse(null);
        System.out.println("\nCustomer 2: " + customer2);
        System.out.println("Customer 2 - name: " + (customer2 != null ? customer2.getName() : null) + ", and age:" + (customer2 != null ? customer2.getAge() : 0));
    }

    public static void filterMap() {
        System.out.println("\nFilter - Map:");

        //3. filter - map - print name satisfying the condition
        String customer3 = customersList.stream()
                .filter(x -> x.getName().contains("i") && x.getAge() < 45)
                .map(Customer::getName)
                .findAny()
                .orElse(null);
        System.out.println("Customer 3: " + customer3);

        //4. filter - map - print all names
        System.out.println("\nNames of all customers:");
        List<String> customerNames = customersList.stream()
                .map(Customer::getName)
                .filter(x -> x.contains("a"))
                .filter(x -> !x.contains("i"))
                .toList();
        customerNames.forEach(System.out::println);
    }

}

class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}