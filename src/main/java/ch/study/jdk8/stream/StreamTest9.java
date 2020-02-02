package ch.study.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * description: 测试stream 跟 parallelStream
 * author: Chen Hao
 * date:   2020/2/2 0002 19:45
 */
public class StreamTest9 {
    public static void main(String[] args) {
        List list1 = new ArrayList(5000000);
        for (int i = 0; i <5000000 ; i++) {
            list1.add(UUID.randomUUID().toString());
        }
        System.out.println("-----------start-------------");
        long start = System.nanoTime();
        list1.stream().sorted();
        list1.parallelStream().sorted();
        long end = System.nanoTime();
        long spendTime = TimeUnit.NANOSECONDS.toMillis(end - start);
        System.out.println("spend time = " + spendTime);
    }
}
