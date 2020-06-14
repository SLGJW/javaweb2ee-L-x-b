package com.servelt;

import com.bean.Course;
import com.bean.Student;
import com.service.CourseOperation;
import com.service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentAddCourseServlet")
public class StudentAddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(request.getParameter("sid"));
        StudentOperation so = new StudentOperation();
        Student s = so.getStudentById(sid);
        List<Object[]> list = so.findNotCourseByStudent(s);
        if(list!=null&&list.size()>0){
            request.setAttribute("list",list);
            request.setAttribute("s",s);
            request.getRequestDispatcher("/studentAddCourse.jsp").forward(request,response);
        }else{
            request.setAttribute("info2","没有可选的课程！");
            request.setAttribute("sid",sid);
            request.getRequestDispatcher("/studentServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
