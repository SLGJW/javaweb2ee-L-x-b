package com.service;

import com.bean.Student;
import com.dao.StudentDao;

import java.util.List;

public class StudentOperation {
    //学生登录验证
    public Student loginStudent(int sid, String password){
        return StudentDao.loginStudent(sid,password);
    }

    //通过学号确定学生
    public Student getStudentById(int sid){
        return StudentDao.getStudentById(sid);
    }

    //获取学生的选课信息（课程编号，课程名以及任课教师）
    public List<Object[]> findCourseByStudent(Student student){
        return StudentDao.findCourseByStudent(student);
    }

    //删除选课
    public boolean studentDeleteCourse(int sid,int cid){
        return StudentDao.studentDeleteCourse(sid,cid);
    }

    //所有可选的课程信息
    public List<Object[]> findNotCourseByStudent(Student student){
        return StudentDao.findNotCourseByStudent(student);
    }

    //添加课程
    public boolean StudentAddCourse(int sid,int[] cids){
        return  StudentDao.StudentAddCourse(sid,cids);
    }
}
