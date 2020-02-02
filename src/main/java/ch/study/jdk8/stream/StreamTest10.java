package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * description: 流的执行是短路的,在这里,
 * - item == 5, 那么hello符合要求,就不会看其他字符串
 * - item == 7  那么没有一个符合要求,所有字符串都会看到
 * author: Chen Hao
 * date:   2020/2/2 0002 19:53
 */
public class StreamTest10 {
    public static void main(String[] args) {
        // 找出长度为5的第一个字符串
        List<String> list = Arrays.asList("hello", "world", "hello world");
        // 打印长度为5的单词
        list.stream().mapToInt(item -> {
            System.out.println(item);
            return item.length();
        }).filter(item -> item == 5).findFirst().ifPresent(System.out::println);
    }
}
