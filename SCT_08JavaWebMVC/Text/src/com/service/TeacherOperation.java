package com.service;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.dao.TeacherDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherOperation {
    //教师登录验证
    public Teacher loginTeacher(int tid,String password){
        return TeacherDao.loginTeacher(tid,password);
    }
    public Teacher getTeacherByTid(int tid){return  TeacherDao.getTeacherByTid(tid);}

    //教师注册
    public boolean registerTeacher(Teacher t,String[] cnames){
        return TeacherDao.newTeacher(t,cnames);
    }

    //通过教师获取所教课程
    public List<Course> getAllCourseByTeacher(Teacher t){
        return TeacherDao.getAllCourseByTeacher(t);
    }

    //通过课程获取学生信息
    public List<Student> getAllStudentByCourse(Course c){
        return TeacherDao.getAllStudentByCourse(c);
    }

    //获取某教师所教所有课程及选择该课程的所有学生
    public Map<Course, List<Student>> getCoursesAndStudents(Teacher t){
        Map<Course,List<Student>> map = new HashMap<>();
        List<Course> courses = getAllCourseByTeacher(t);
        if(courses!=null) {
            for (Course course : courses) {
                List<Student> studentList = getAllStudentByCourse(course);
                map.put(course, studentList);
            }
        }
        return map;
    }

    //获取学生某课的成绩
    public double getScores(Student s,int cid){
        return TeacherDao.getScores(s,cid);
    }

    //修改学生成绩
    public boolean upDateScores(int sid,int cid,double scores){
        return TeacherDao.upDateScores(sid,cid,scores);
    }

    //为教师添加课程
    public boolean TeacherAddCourse(int tid,String[] cnames){
        return TeacherDao.TeacherAddCourse(tid,cnames);
    }

    //删除门课程
    public boolean TeacherDeleteCourse(int cid){
        return TeacherDao.TeacherDeleteCourse(cid);
    }
}
