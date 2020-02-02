package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * description: 流的创建方式
 * author: Chen Hao
 * date:   2020/2/2 0002 13:52
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = {"hello", "world", "hello world"};
        Stream<String> stream2 = Arrays.stream(myArray);
        Stream<String> stream3 = Stream.of(myArray);

        List<String> list = Arrays.asList(myArray);
        Stream<String> stream4 = list.stream();

    }
}
