package com.servelt;

import com.bean.Teacher;
import com.service.TeacherOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int tid = Integer.parseInt(request.getParameter("tid"));
        String tname = request.getParameter("tname");
        String password = request.getParameter("password");
        int sex = Integer.parseInt(request.getParameter("sex"));
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String[] cnames = request.getParameterValues("cname");
        TeacherOperation to = new TeacherOperation();
        Teacher teacher = new Teacher(tid,tname,sex,email,phone_number,password);
        boolean flag = to.registerTeacher(teacher, cnames);
        if(flag){
            request.setAttribute("info","添加成功！请登录！");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            request.setAttribute("info","添加失败！");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
