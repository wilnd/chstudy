package ch.study.jdk8.stream;

import java.util.stream.Stream;

/**
 * description: 流转换成数组或列表
 * author: Chen Hao
 * date:   2020/2/2 0002 14:07
 */
public class StreamTest4 {
    public static void main(String[] args) {
        //流转数组
        Stream<String> stream = Stream.of("hello", "world", "hello world");
        //toArray的入参是IntFunction,它的入参是int返回值自定义
//        String[] streamArray1 = stream.toArray(length -> new String[length]);
//        String[] streamArray2 = stream.toArray(String[]::new);

        //流转集合
//        List<String> streamList1 = stream.collect(Collectors.toList());//内部实现是下面这一行
//        List<String> streamList2 = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        streamList2.forEach(System.out::println);
//        stream.collect(Collectors.toCollection(HashSet::new));

        //字符串拼接
        StringBuffer streamString = stream.collect(StringBuffer::new, StringBuffer::append, StringBuffer::append);
        System.out.println(streamString.toString());
    }
}
