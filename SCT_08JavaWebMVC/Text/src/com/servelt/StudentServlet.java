package com.servelt;

import com.bean.Student;
import com.service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(request.getAttribute("sid").toString());
        StudentOperation so = new StudentOperation();
        Student student = so.getStudentById(sid);
        List<Object[]> list = so.findCourseByStudent(student);
        if(list!=null){
            String info = "欢迎" + student.getSname() + "同学访问！";
            request.setAttribute("info", info);
            request.setAttribute("s", student);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/student.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
