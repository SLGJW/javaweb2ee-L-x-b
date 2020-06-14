package com.dao;

import com.bean.Course;
import com.utils.MyUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CourseDao {
    private static QueryRunner qr = MyUtils.getDataBase();
    //没有教师教的所有课程
    public static List<Course> noTeachCourses(){
        String sql = "select * from course where tid is null";
        List<Course> courses = null;
        try {
            courses = qr.query(sql,new BeanListHandler<>(Course.class));
            if(courses!=null){
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //有教师教的所有课程
    public static List<Course> haveTeachCourses(){
        String sql = "select * from course where tid is not null";
        List<Course> courses = null;
        try {
            courses = qr.query(sql,new BeanListHandler<>(Course.class));
            if(courses!=null){
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询某们课程是否有学生上课
    public static boolean haveStudentAddCourse(int cid){
        String sql = "select * from stu_cou where cid=?";
        try {
            Object[] query = qr.query(sql, new ArrayHandler(), cid);
            if(query!=null&&query.length>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
