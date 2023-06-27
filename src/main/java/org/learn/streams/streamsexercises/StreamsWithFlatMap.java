package org.learn.streams.streamsexercises;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsWithFlatMap {

    public static void main(String[] args) {
        stringArrayWithFlatMap();
        setWithFlatMap();
        intArrayWithFlatMap();
    }

    public static void stringArrayWithFlatMap() {

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        System.out.println("\nstringArrayWithFlatMap - step by step");
        Stream<String[]> stream = Arrays.stream(data);
        Stream<String> streamFlatMap = stream.flatMap(x -> Arrays.stream(x));
        Stream<String> streamFilter = streamFlatMap.filter(x -> x.equals("a"));
        streamFilter.forEach(System.out::println);

        System.out.println("\nstringArrayWithFlatMap - direct");
        Arrays.stream(data).flatMap(Arrays::stream).filter(x -> x.equals("e")).forEach(System.out::println);
    }

    public static void setWithFlatMap() {

        class Employee {

            private String empName;
            private int empCode;
            private Set<String> devices;

            public String getEmpName() {
                return empName;
            }

            public void setEmpName(String empName) {
                this.empName = empName;
            }

            public int getEmpCode() {
                return empCode;
            }

            public void setEmpCode(int empCode) {
                this.empCode = empCode;
            }

            public Set<String> getDevices() {
                return devices;
            }

            public Employee setDevices(String deviceName) {
                if (this.devices == null) {
                    this.devices = new HashSet<>();
                }
                this.devices.add(deviceName);
                return this;
            }
        }

        Employee emp1 = new Employee();
        emp1.setEmpName("Anil");
        emp1.setEmpCode(1234);
        emp1.setDevices("iPhone14")
                .setDevices("Samsung S21 5G")
                .setDevices("Macbook Pro")
                .setDevices("Sony WH-1000XM5")
                .setDevices("Apple Studio Display");

        Employee emp2 = new Employee();
        emp2.setEmpName("Raghu");
        emp2.setEmpCode(1548);
        emp2.setDevices("iPhone14")
                .setDevices("OnePlus 11 5G")
                .setDevices("Dell XPS 9720 Laptop")
                .setDevices("Sennheiser Momentum 4")
                .setDevices("Apple Studio Display");

        List<Employee> empList = new ArrayList<Employee>();
        empList.add(emp1);
        empList.add(emp2);

        System.out.println("\nsetWithFlatMap - The employees are: ");
        empList.stream().map(x -> x.getEmpName() + " - " + x.getEmpCode()).toList().forEach(System.out::println);

        System.out.println("\nsetWithFlatMap - The distinct devices are: ");
        empList.stream().map(Employee::getDevices).flatMap(Collection::stream).distinct().toList().forEach(System.out::println);
    }

    public static void intArrayWithFlatMap() {

        int[] data = {1, 2, 4, 3, 8, 5, 4, 3, 7, 6, 7, 5, 9};

        System.out.println("\nintArrayWithFlatMap - step by step - distinct - The int values are: ");
        Stream<int[]> streamArray = Stream.of(data);
        IntStream intStream = streamArray.flatMapToInt(Arrays::stream);
        intStream.distinct().forEachOrdered(System.out::println);

        System.out.println("\nintArrayWithFlatMap - Average: " + Arrays.stream(data).average().toString());

        //using sequential
        System.out.println("\nintArrayWithFlatMap - using sequential - The int values are: ");
        Arrays.stream(data).sequential().forEach(System.out::println);

        //using sorted
        System.out.println("\nintArrayWithFlatMap - using sorted - The int values are: ");
        Arrays.stream(data).sorted().forEach(System.out::println);
    }
}


