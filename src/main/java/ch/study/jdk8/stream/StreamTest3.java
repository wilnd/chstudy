package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * description: 每个元素*2 求和
 * author: Chen Hao
 * date:   2020/2/2 0002 13:57
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer sum = list.stream().map(i -> 2 * i).reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
