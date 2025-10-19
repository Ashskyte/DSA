package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class practice {
  public static void main(String[] args) {
    //
    List<Integer> integers= Arrays.asList(10,15,8,49,25,98,32,8);
    integers.stream().filter(x -> x % 2 == 0).forEach(System.out::print);
    // todo find numbers starting with 1
    System.out.println();
    integers.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::print);
    // todo find duplicate numbers
    System.out.println();
    Set<Integer> set=new HashSet<>();
    integers.stream().filter(num -> !set.add(num)).forEach(System.out::println);
  }
}
