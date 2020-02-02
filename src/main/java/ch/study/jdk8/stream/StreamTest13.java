package ch.study.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * description: 分组及分区
 * author: Chen Hao
 * date:   2020/2/2 0002 20:32
 */
public class StreamTest13 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        //分组
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        //根据什么分组， 什么就是key
        Map<String, List<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getName));
        //group的重载版本
        Map<String, Long> map2 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        //分组后获取分数的平均值
        Map<String, Double> map3 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        //分区
        Map<Boolean, List<Student>> map4 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90));

    }
}
