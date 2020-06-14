package com.servelt;

import com.bean.Student;
import com.bean.Teacher;
import com.service.StudentOperation;
import com.service.TeacherOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String info = "";
        if(id==null || id.length()==0){
            info = "请先选择您的登陆身份！";
            request.setAttribute("info",info);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else if("1".equals(id)){
            //以教师身份登录
            Teacher t = doTeacher(request, response);
            if(t!=null){
                request.setAttribute("tid",t.getTid());
                request.getRequestDispatcher("/teacherServlet").forward(request,response);
            }else{
                info = "用户名或密码错误";
                request.setAttribute("info",info);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }else{
            //以学生身份登录
            Student s = doStudent(request, response);
            if(s!=null){
                request.setAttribute("sid",s.getSid());
                request.getRequestDispatcher("/studentServlet").forward(request,response);
            }else{
                info = "用户名或密码错误";
                request.setAttribute("info",info);
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            };
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected Teacher doTeacher(HttpServletRequest request, HttpServletResponse response){
        int tid = Integer.parseInt(request.getParameter("username"));
        String password = request.getParameter("password");
        TeacherOperation to = new TeacherOperation();
        return to.loginTeacher(tid, password);
    }

    protected Student doStudent(HttpServletRequest request, HttpServletResponse response){
        int sid = Integer.parseInt(request.getParameter("username"));
        String password = request.getParameter("password");
        StudentOperation so = new StudentOperation();
        return so.loginStudent(sid, password);
    }
}
