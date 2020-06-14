package com.dao;

import com.bean.Course;
import com.bean.Student;
import com.bean.Teacher;
import com.utils.MyUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeacherDao {
    private static QueryRunner qr = MyUtils.getDataBase();

    //创建新教师
    public static boolean newTeacher(Teacher t,String[] cnames){
        String sql1 = "insert into teacher values(?,?,?,?,?,?)";
        String sql2 = "update course set tid=? where cname=?";
        List<Boolean> flag = new ArrayList<>();
        boolean f = true;
        try {
            int result = qr.update(sql1,t.getTid(),t.getTname(),t.getSex(),t.getEmail(),t.getPhone_number(),t.getPassword());
            flag.add(result>0);
            for(String cname : cnames){
                result = qr.update(sql2,t.getTid(),cname);
                flag.add(result>0);
            }
            for(Boolean b : flag){
                if(b==false){
                    f = false;
                    break;
                }
            }
            return f;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //教师登录验证
    public static Teacher loginTeacher(int tid,String password){
        String sql = "select * from teacher where tid=? and password=?";
        Teacher t = null;
        try {
            t = qr.query(sql,new BeanHandler<>(Teacher.class),tid,password);
            if(t!=null){
                return t;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Teacher getTeacherByTid(int tid){
        String sql = "select * from teacher where tid=?";
        try {
            Teacher teacher = qr.query(sql, new BeanHandler<>(Teacher.class), tid);
            if(teacher!=null){
                return teacher;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询所教所有课程信息
    public static List<Course> getAllCourseByTeacher(Teacher teacher){
        String sql = "select * from course where tid=?";
        List<Course> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Course.class), teacher.getTid());
            if(list!=null){
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查询选择某门课程的所有学生信息
    public static List<Student> getAllStudentByCourse(Course course){
        String sql = "select s.* from student s,stu_cou s_c where s_c.cid=? and s.sid=s_c.sid";
        List<Student> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Student.class), course.getCid());
            if(list!=null){
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过学生和课程获取成绩
    public static double getScores(Student student,int cid){
        String sql = "select scores from stu_cou where sid=? and cid=?";
        try {
            Object obj = qr.query(sql, new ScalarHandler(), student.getSid(), cid);
            if(obj!=null){
                return (double)obj;
            }else{
                return -1.0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //修改学生成绩
    public static boolean upDateScores(int sid,int cid,double scores){
        String sql = "update stu_cou set scores=? where sid=? and cid=?";
        try {
            int result = qr.update(sql,scores,sid,cid);
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //为教师添加课程
    public static boolean TeacherAddCourse(int tid,String[] cnames){
        List<Boolean> list = new ArrayList<>();
        boolean flag = true;
        String sql = "update course set tid=? where cname=?";
        for(String cname : cnames){
            try {
                int result = qr.update(sql,tid,cname);
                list.add(result>0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for(Boolean b : list){
            if(b==false){
                flag = false;
                break;
            }
        }
        return flag;
    }

    //删除某门课程
    public static boolean TeacherDeleteCourse(int cid){
        String sql = "update course set tid=null where cid=?";
        try {
            int result = qr.update(sql,cid);
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
