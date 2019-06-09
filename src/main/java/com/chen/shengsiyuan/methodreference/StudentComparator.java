package com.chen.shengsiyuan.methodreference;

public class StudentComparator {

    public int compareStudentByScore(Student stu1, Student stu2){
        return stu1.getScore() - stu2.getScore();
    }

    public int compareStudentByName(Student stu1, Student stu2){
        return stu1.getName().compareToIgnoreCase(stu2.getName());
    }
}
