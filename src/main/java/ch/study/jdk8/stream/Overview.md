### 代码概要
- StreamTest1 流创建的三种方式
- StreamTest2 IntStream range方法的使用
- StreamTest3 map reduce的简单使用
- StreamTest4 流转换成数组或集合
- StreamTest5 map的简单使用
- StreamTest6 流的各操作使用顺序以及重复使用问题
- StreamTest7 没啥东西
- StreamTest8 iterator的使用
- StreamTest9 stream 跟 parallelStream
- StreamTest10 流的短路情况
- StreamTest11 flatMap使用实例1
- StreamTest12 flatMap使用实例2
- StreamTest13 分组及分区
### 笔记记录
##### 流由三部分构成：
1. 源
2. 零个或多个中间操作
3. 终止操作
##### 流操作分类：
1. 惰性求值(中间操作),都会返回stream对象
    - 过滤
    - 映射
    - 排序
2. 及早求值(终止操作) 如果一个流操作没有及早求值,则内部动作不会运行
    - 短路

所有返回stream的操作都是惰性求值.只有在遇到终止操作的时候,才会执行中间操作的内容
##### 特性
1. 流不存储值，
2. 操作会生成结果，不会修改底层的数据源
3. 遇到汇聚操作，会及早求值，否则都是惰性求值
4. 流操作类似sql
    ```
    伪代码如下:
    sql:
        select name 
        from student 
        where age > 20 and address = 'beijing' 
        order by age desc
    stream:
        student.stream()
        .filter(student -> student.getAge() > 20)
        .filter(student -> student.getAddress().equals("beijing")
        .sorted(...)
        .foreach(student -> System.out.println(student.getName))
    ```
5. Stream的多个操作是通过串行传递的,无法重复使用或消费
6. Stream可以理解为一个容器,各操作方法如,filter,map,sort等不一定是按照写代码的顺序执行的,strea会自己优化,得到较优的执行顺序
7. 并行流必须是无状态的,不然会很麻烦,fork join,类似动态规划算法
8. 集合关注的是数据与数据存储本身,流关注的是对数据的计算

##### 迭代
- 内部迭代 通过stream去迭代
- 外部迭代 jdk8之前的迭代方式

##### 分组分区
- 分组是指按照某个字段进行分组
- 分区是指根据某个条件将数据分为两个部分
