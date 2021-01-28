package com.bjpowernode.controller;

import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QueryProvinceInfoServlet")
public class QueryProvinceInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //接收前端传进来的request,并处理后返回json对象
        String provinceId = request.getParameter("provinceId");
        //System.out.println("provinceId=" + provinceId);
        //接下来在这边处理传过来的参数，访问数据库查询编号对应的省份名称
        ProvinceDao provinceDao = new ProvinceDao();

        Province province = new Province();
        String json = "{}";
        //强制装换
        //判断传入的provinceId不为空且不等于空字符串
        if (provinceId != null && provinceId.trim().length()>0 ) {
            province = provinceDao.getProinceById(Integer.valueOf(provinceId));
        }
        //现在已经拿到编号对应的数据,是用java对象存储的
        //将对象转化为json字符串传回前端
        ObjectMapper objectMapper = new ObjectMapper();
        json = objectMapper.writeValueAsString(province);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        //将java对象对应的json字符串传到前端的response
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
