package ch.study.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * description:
 * author: Chen Hao
 * date:   2020/2/2 0002 16:51
 */
public class StreamTest6 {

    public static void main(String[] args) {
        //生成stream对象
        Stream<String> stream1 = Stream.generate(UUID.randomUUID()::toString);
        stream1.findFirst().ifPresent(System.out::println);

        //iterator 生成一个无限的串行流
        //stream的调用最好如此写成方法链的形式
        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, item -> item + 2).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();

        //测试流是否可以反复使用
        Stream<Integer> stream2 = Stream.iterate(1, item -> item + 2).limit(6);
        System.out.println(stream2);
        stream2.filter(item -> item > 2);
        stream2.distinct(); // 这一句会报错,因为流只能使用一次

        Stream stream3 = stream2.filter(item -> item > 2);
        Stream stream4 = stream3.distinct(); //这里不会报错 但是stream2里面已经没有东西了



    }

}
