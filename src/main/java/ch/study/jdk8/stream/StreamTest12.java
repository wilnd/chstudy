package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:  flatMap使用实例2
 * author: Chen Hao
 * date:   2020/2/2 0002 20:14
 */
public class StreamTest12 {
    public static void main(String[] args) {
        //希望将list1中的元素三跟list2中的元素组合
        List<String> list1 = Arrays.asList("Hi", "Hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu");
        list1.stream().forEach(item -> list2.stream().forEach(element -> System.out.println(item + " " + element)));//这个是字符串的凭借
        list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);//flatMap在这里将多个stream 转成一个stream

    }
}
