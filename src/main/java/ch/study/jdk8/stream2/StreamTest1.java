package ch.study.jdk8.stream2;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * description:
 * author: Chen Hao
 * date:   2020/2/3 0003 12:29
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        Student student5 = new Student("zhaoliu", 70);

        List<Student> students = Arrays.asList(student1, student2, student3, student4,student5);

        List<Student> students1 = students.stream().collect(toList());
        students1.forEach(System.out::println);
        System.out.println("----------------------");
        System.out.println("count : " + students1.stream().collect(counting()));
        System.out.println("count : " + students.stream().count());
        System.out.println("----------------------");
        students1.stream().collect(minBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);
        students1.stream().collect(maxBy(Comparator.comparing(Student::getScore))).ifPresent(System.out::println);
        System.out.println(students1.stream().collect(averagingInt(Student::getScore)));
        System.out.println(students1.stream().collect(summingInt(Student::getScore)));
        IntSummaryStatistics scoreSummary = students1.stream().collect(summarizingInt(Student::getScore));
        System.out.println(scoreSummary);
        System.out.println("----------------------");
        System.out.println(students1.stream().map(Student::getName).collect(joining()));
        System.out.println(students1.stream().map(Student::getName).collect(joining(", ")));
        System.out.println(students1.stream().map(Student::getName).collect(joining(", ","<begin>", "<end>")));
        System.out.println("----------------------");
        Map<String, Map<Integer, List<Student>>> studentGroup = students1.stream().collect(groupingBy(Student::getName, groupingBy(Student::getScore)));
        System.out.println(studentGroup);
        Map<Boolean, Map<Boolean, List<Student>>> studentPartition = students1.stream().collect(partitioningBy(student -> student.getScore() > 80, partitioningBy(student -> student.getScore() > 70)));
        System.out.println(studentPartition);
        System.out.println("----------------------");
        Map<String, Student> handle = students1.stream().collect(groupingBy(Student::getName, collectingAndThen(minBy(Comparator.comparing(Student::getScore)), Optional::get)));
        System.out.println(handle);
    }
}
