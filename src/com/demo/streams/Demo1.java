package com.demo.streams;

import java.util.*;
import java.util.stream.Stream;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("Demo Streams for terminal operations!!!");
        List<Integer> lst = Arrays.asList(4,2,3,1,7,6,5);
        List<Integer> lst1 = lst.stream().sorted().toList();
        //lst1.forEach(System.out::println);
        System.out.println("Sorted asc list: "+lst1);
        List<Integer> revLst = lst.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("desc order list: "+revLst);

        /*
        anyMatch()
        allMatch()
        noneMatch()
         */
        Set<String> s = new HashSet<>();
        s.add("One Apple");
        s.add("One Mango");
        s.add("One Orange");
        s.add("Two Apple");
        s.add("Two Mango");
        s.add("Two Orange");

        //anyMatch
        boolean result = s.stream().anyMatch(value->{return value.startsWith("One");});
        System.out.println("match result: "+result);

        //allMatch
        boolean result1 = s.stream().allMatch(value->{return value.startsWith("One");});
        System.out.println("All match result: "+result1);

        //nonMatch
        boolean result2 = s.stream().noneMatch(value -> {return value.startsWith("to");});
        System.out.println("Non Match result: "+result2);

        //======================================

        //findAny
        List<String> lst3 = Arrays.asList("one","two","three","four");
        Optional <String> element = lst3.stream().findAny();
        System.out.println(element.get());

        //findFirst
        /*
        returns first element from the collection
         */

        List<String> lst4 = Arrays.asList("two","three","one");
        Optional<String> str = lst4.stream().findFirst();
        System.out.println(str.get());

        //======================================

        //concat: to concat different streams
        List<String> l1= Arrays.asList("dogs","cats","bats");
        List<String> l2 = Arrays.asList("peacock","parrot","swan");

        Stream<String> s1 = l1.stream();
        Stream<String> s2 = l2.stream();

        List<String>lst5 = Stream.concat(s2,s1).toList();
        System.out.println("concat stream result: "+lst5);

        System.out.println("End!!!");
        //========================================
    }
}

