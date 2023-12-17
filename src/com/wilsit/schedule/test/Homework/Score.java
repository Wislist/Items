package com.wilsit.schedule.test.Homework;


public class Score {
    Integer sId;//学号
    Integer cId;//课程编号
    Float grade;//成绩

    public Score(Integer sId, Integer cId, Float course) {
        this.sId = sId;
        this.cId = cId;
        this.grade = course;
    }
    public Score() {
    }
}
