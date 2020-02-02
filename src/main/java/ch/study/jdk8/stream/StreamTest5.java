package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description:流中元素的处理
 * map
 * flatMap
 * author: Chen Hao
 * date:   2020/2/2 0002 16:34
 */
public class StreamTest5 {

    public static void main(String[] args) {
        //转大写
        List<String> list = Arrays.asList("hello ", "world", "hello world");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------");
        //平方
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("----------------");
        // flatMap 将list打平
        Stream<List<Integer>> stream1 = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        stream1.flatMap(Collection::stream).map(item -> item * item).forEach(System.out::println);
    }

}
