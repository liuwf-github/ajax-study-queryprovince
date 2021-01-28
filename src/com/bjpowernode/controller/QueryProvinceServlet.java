package com.bjpowernode.controller;

import com.bjpowernode.dao.ProvinceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryProvinceServlet")
public class QueryProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收到前端传来的provinceId
        String provinceId = request.getParameter("provinceId");
        System.out.println("provinceId=" + provinceId);
        //接下来在这边处理传过来的参数，访问数据库查询编号对应的省份名称
        ProvinceDao provinceDao = new ProvinceDao();

        String provinceName = "default";
        //强制装换
        //判断传入的provinceId不为空且不等于空字符串
        if (provinceId != null && !("").equals(provinceId.trim())) {
            provinceName = provinceDao.getProinceNameById(Integer.valueOf(provinceId));
            System.out.println("provinceName=" + provinceName);
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(provinceName);
        pw.flush();
        pw.close();

    }
}
