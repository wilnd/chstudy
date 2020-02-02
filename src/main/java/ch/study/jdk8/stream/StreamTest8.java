package ch.study.jdk8.stream;

import java.util.stream.IntStream;

/**
 * description: 流使用需要注意各方法的使用先后顺序
 * author: Chen Hao
 * date:   2020/2/2 0002 19:14
 */
public class StreamTest8 {

    public static void main(String[] args) {
        //这个会打印0,1 但是这段代码会一直执行不会结束
        //distinct在iterate后面是有风险的
        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);
    }
}
