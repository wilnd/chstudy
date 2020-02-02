package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: flatMap使用实例1
 * author: Chen Hao
 * date:   2020/2/2 0002 20:04
 */
public class StreamTest11 {

    public static void main(String[] args) {
        //找出所有单词,而且去重
        List<String> list1 = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");
        list1.stream().map(item -> item.split(" ")).distinct().collect(Collectors.toList()).forEach(System.out::println);//错误的, 因为map返回的是一个字符串数组,字符串数组不会重复
        list1.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println); // map处理后,通过flatMap将map的多个数组打平成一个数组

    }

}
