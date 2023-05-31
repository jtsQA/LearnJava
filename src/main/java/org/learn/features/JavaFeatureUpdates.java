package org.learn.features;

import java.util.*;
import java.util.stream.Stream;

public class JavaFeatureUpdates {

    public static void main(String[] args) {
        jdk8();   /* Stream, Method Reference and Optional */
//        jdk9();   /* JShell and Factory methods for immutable collections */
//        jdk10();  /* var keyword */
//        jdk12();  /* new switch expression */
//        jdk13();  /* multi-line String for JSON & XML */
//        jdk14();  /* record used for pojo class and instance of */
//        jdk15();  /* sealed classes */
    }

    private static void jdk8() {
        //Stream and Method Reference
        System.out.println("\nEven Numbers: ");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        System.out.println("\nAppended Strings: ");
        Stream.of("selenium", "testNG")
                .map(s -> s + " - java")
                .forEach(System.out::println);

        //Optional
        System.out.println("\nOptional: ");
        String[] strArray = new String[5];
//        strArray[3] = "Java 8 - Optional Class";

        Optional<String> isNullStr = Optional.ofNullable(strArray[3]);
        isNullStr.ifPresentOrElse(value -> System.out.println("Value is available: " + value)
                , () -> System.out.println("Value is not available"));

        Optional<String[]> isNullStrArr = Optional.ofNullable(strArray);
        isNullStrArr.ifPresentOrElse(value -> System.out.println("Value is available: " + Arrays.toString(value))
                , () -> System.out.println("Value is not available"));

        Optional<String> nothing = Optional.empty();
        nothing.ifPresentOrElse(value -> System.out.println("Value is available")
                , () -> System.out.println("Value is not available"));
    }

    private static void jdk9() {
        //JShell - https://www.geeksforgeeks.org/jshell-java-9-new-feature/
        /*
        //Executed in the terminal
        mac terminal ~ % java --version
        openjdk 17.0.7 2023-04-18
        OpenJDK Runtime Environment Homebrew (build 17.0.7+0)
        OpenJDK 64-Bit Server VM Homebrew (build 17.0.7+0, mixed mode, sharing)
        mac terminal~ % jshell --enable-preview
                |  Welcome to JShell -- Version 17.0.7
                |  For an introduction type: /help intro

        jshell> int x = 10
        x ==> 10

        jshell> int y = 15
        y ==> 15

        jshell> x+y
        $3 ==> 25

        jshell> x+y/y
        $4 ==> 11

        jshell> System.out.println(x+y+55)
        80

        jshell> System.out.println(x+ "hello" )
        10hello
        */

        //Factory methods for immutable collections
        System.out.println("\nFactory methods for immutable collections: ");
        System.out.println("\nInteger List: ");
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8); //previously used before JDK 9
        intList.forEach(System.out::println);

        System.out.println("\nString list: ");
        List<String> strList = List.of("aby", "allan", "anil", "anu", "azman"); //preferred from JDK 9
        strList.forEach(System.out::println);
    }

    private static void jdk10() {
        //var keyword
        System.out.println("var keyword: ");

        System.out.println("\nvar used for int: ");
        var x = 10;
        System.out.println(" x + 10 = " + (x + 10));

        System.out.println("\nvar used for HashSet<String>: ");
        var h = new HashSet<String>();
        h.add("arun");
        h.add("anil");
        h.remove("arun");
        System.out.println(" h = " + h);

        System.out.println("\nvar used for ArrayList<Integer>: ");
        var a = new ArrayList<Integer>();
        a.add(2);
        a.add(5);
        a.add(8);
        a.remove(1);
        System.out.println(" a = " + a);
    }

    private static void jdk12() {
        //new switch expression
        System.out.println("\nOld switch case: ");
        String browser1 = "chrome";
        String driver1 = "";

        switch (browser1.toLowerCase()) {
            case "chrome":
                driver1 = "ChromeDriver";
                break;
            case "firefox":
                driver1 = "GeckoDriver";
                break;
            case "safari":
                driver1 = "SafariDriver";
                break;
            default:
                driver1 = "No Suitable driver found";
        }
        System.out.println("Driver 1: " + driver1);

        System.out.println("\nNew switch expression: ");
        var browser2 = "safari";
        var driver2 = switch (browser2.toLowerCase()) {
            case "chrome" -> "ChromeDriver";
            case "firefox" -> "GeckoDriver";
            case "safari" -> "SafariDriver";
            default -> "No Suitable driver found";
        };
        System.out.println("Driver 2: " + driver2);

    }

    private static void jdk13() {
        //multi-line String for JSON & XML
        System.out.println("\nMulti-line String: ");
        var response = """
                {
                  "statusCode": 200,
                  "Message": "Successful",
                  "Error": ""
                }""";
        System.out.println("response = \n" + response);
    }

    private static void jdk14() {
        //record - for pojo class
        System.out.println("\nrecord: ");
        record Employee(String empName, int empCode, String empRole) {
        }
        Employee employee1 = new Employee("Aby", 1468, "IT Admin");
        System.out.println("Employee 1 = " + employee1);

        var empName = employee1.empName;
        System.out.println("Employee 1 Name = " + empName);

        //instance of
        System.out.println("\nInstance of: ");
        Object ob = new String("Java - Instance of");

        if (ob instanceof String) {
            System.out.println("Old intanceof - String length: " + ((String) ob).length());
        }

        if (ob instanceof String str) {
            System.out.println("New intanceof - String length: " + str.length());
        }
    }

    private static void jdk15() {
        /*
        sealed interface Bank permits ICICIBank, AXISBank {
            public String getName();
        }


        final class ICICIBank implements Bank {
            @Override
            public String getName() {
                return "ICICI";
            }
        }

        final class AXISBank implements Bank {
            @Override
            public String getName() {
                return "AXIS";
            }
        }

        final class HDFCBank implements Bank {
            @Override
            public String getName() {
                return "HDFC";
            }
        }
        */
    }
}
