package com.service;

import com.bean.Course;
import com.dao.CourseDao;

import java.util.List;

public class CourseOperation {
    //无教师交的课程
    public List<Course> noTeachCourses(){
        return CourseDao.noTeachCourses();
    }

    //查询是否有学生上某门课
    public boolean haveStudentAddCourse(int cid){
        return CourseDao.haveStudentAddCourse(cid);
    }

    //
}
