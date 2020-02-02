package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * description:
 * author: Chen Hao
 * date:   2020/2/2 0002 17:38
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello ", "world", "hello world");
        list.stream().map(item -> item.substring(0,1).toUpperCase() + item.substring(1)).forEach(System.out::println);
    }
}
