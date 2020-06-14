package com.servelt;

import com.service.StudentOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentAddCourseServlet2")
public class StudentAddCourseServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int sid = Integer.parseInt(request.getParameter("sid"));
        String[] courses = request.getParameterValues("cids");
        int[] cids = new int[courses.length];
        for(int i = 0;i<cids.length ; i++){
            cids[i]=Integer.parseInt(courses[i]);
        }
        StudentOperation so = new StudentOperation();
        boolean b = so.StudentAddCourse(sid, cids);
        if(b){
            request.setAttribute("sid",sid);
            request.getRequestDispatcher("/studentServlet").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
