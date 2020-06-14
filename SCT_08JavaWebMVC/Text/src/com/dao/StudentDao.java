package com.dao;

import com.bean.Student;
import com.utils.MyUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private static QueryRunner qr = MyUtils.getDataBase();

    //学生登录验证
    public static Student loginStudent(int sid, String password){
        String sql = "select * from student where sid=? and password=?";
        Student s = null;
        try {
            s = qr.query(sql,new BeanHandler<>(Student.class),sid,password);
            if(s!=null){
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过学号确定学生
    public static Student getStudentById(int sid){
        String sql = "select * from student where sid=?";
        try {
            Student s = qr.query(sql,new BeanHandler<>(Student.class), sid);
            if(s!=null){
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取学生的选课信息（课程编号，课程名以及任课教师）
    public static List<Object[]> findCourseByStudent(Student student){
        String sql = "select c.cid,c.cname,t.tname from course as c inner join teacher as t on c.tid = t.tid where t.tid in(select tid from course where cid in(select cid from stu_cou where sid=?))";
        List<Object[]> list = null;
        try {
            list = qr.query(sql, new ArrayListHandler(),student.getSid());
            if(list!=null) {
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除选课
    public static boolean studentDeleteCourse(int sid,int cid){
        String sql = "delete from stu_cou where sid=? and cid=?";
        try {
            int result = qr.update(sql,sid,cid);
            if(result>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //查询所有可选的课程
    public static List<Object[]> findNotCourseByStudent(Student student){
        String sql = "select c.cid,c.cname,t.tname from course as c inner join teacher as t on c.tid = t.tid where t.tid in(select tid from course where cid not in(select cid from stu_cou where sid=?))";
        List<Object[]> list = null;
        try {
            list = qr.query(sql, new ArrayListHandler(),student.getSid());
            if(list!=null) {
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //添加课程
    public static boolean StudentAddCourse(int sid,int[] cids){
        List<Boolean> list = new ArrayList<>();
        boolean flag = true;
        String sql = "insert into stu_cou(sid,cid) values(?,?)";
        for(int cid : cids){
            try {
                int result = qr.update(sql,sid,cid);
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
}
