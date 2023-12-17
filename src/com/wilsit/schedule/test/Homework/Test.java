package com.wilsit.schedule.test.Homework;

import java.util.ArrayList;


public class Test {
    public static void main(String[] args) {
        //1、实例化几个学生对象病在泛型集合对象中保存学生信息
        Student stu1 = new Student(1, "sb1");
        Student stu2 = new Student(2, "sb2");
        ArrayList<Student> arr1 = new ArrayList<>();
        arr1.add(stu1);
        arr1.add(stu2);
        //2、实例化几个课程对象病在泛型集合中保存课程的信息
        Course cou1 = new Course(1, "水课");
        Course cou2 = new Course(2, "一堆水课");
        ArrayList<Course> arr2 = new ArrayList<>();
        arr2.add(cou1);
        arr2.add(cou2);
        //3、实例化几个成绩对象并在泛型集合中保存成绩信息
        Score sc1 = new Score(1, 1, 0.0F);
        Score sc2 = new Score(1, 2, 0.0F);
        Score sc3 = new Score(2, 2, 0.0F);
        ArrayList<Score> arr3 = new ArrayList<>();
        arr3.add(sc1);
        arr3.add(sc2);
        arr3.add(sc3);
        //4、根据成绩泛型集合中的学号和课程编号查询学生集合和课程集合得到学生姓名和课程名
        System.out.println(arr1.get(arr3.get(0).sId).stuName);
        System.out.println(arr2.get(arr3.get(0).cId).cName);
        //5、打印学生各科成绩
        for (Score sco : arr3) {
            for (Student stu : arr1) {
                if (sco.sId.equals(stu.stuID)) {
                    System.out.println(stu.stuName + "\t" + "课程：" + sco.cId + "\t" + sco.grade);
                }
            }
        }
        //6、统计每课参加考试的人数和平均分
        int population1 = 0;
        int population2 = 0;
        float sum1 = 0.0F;
        float sum2 = 0.0F;

        for (Score s : arr3) {

            if (s.cId == 1) {
                sum1 += s.grade;
                population1++;
            }
            if (s.cId == 2) {
                sum2 += s.grade;
                population2++;
            }
        }
        //7、计算并保存课程平均分
        float avg1 = sum1 / population1;
        float avg2 = sum2 / population2;
        //8、打印各科平均分
        for (Course c : arr2) {
            if (c.cId == 1) {
                System.out.println(c.cName + "平均分：" + avg1);
            } else if (c.cId == 2) {
                System.out.println(c.cName + "平均分：" + avg2);
            }
        }
    }
}
