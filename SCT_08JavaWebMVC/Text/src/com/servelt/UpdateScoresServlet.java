package com.servelt;

import com.service.TeacherOperation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateScoresServlet")
public class UpdateScoresServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        double scores = Double.parseDouble(request.getParameter("scores"));
        int sid = Integer.parseInt(request.getParameter("sid"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        int tid = Integer.parseInt(request.getParameter("tid"));
        TeacherOperation to = new TeacherOperation();
        boolean flag = to.upDateScores(sid, cid, scores);
        if(flag){
            request.setAttribute("tid", tid);
            request.getRequestDispatcher("/teacherServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
