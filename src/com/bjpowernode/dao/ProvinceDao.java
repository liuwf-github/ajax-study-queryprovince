package com.bjpowernode.dao;

import com.bjpowernode.entity.Province;

import java.sql.*;

//使用jdbc访问数据库
public class ProvinceDao {
    public String getProinceNameById(Integer provinceId){

        //连接对象
        Connection connection = null;
        //预准备 表 声明
        PreparedStatement prepareStatement = null;
        //接收数据数据对象
        ResultSet resultSet = null;
        //定义sql语句
        String sql = "";

        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "admin";

        String name = "";
        //1、加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(url,username,password);
            //创建PreparedStatement对象
            sql = "select name from province where id=?";
            prepareStatement = connection.prepareStatement(sql);
            //设置参数值 sql中的？表示占用符，用参数来替代占用符
            //设置第一个占位符的位置放置provinceId
            prepareStatement.setInt(1,provinceId);
            //执行sql，将取到的结果放入resultSet中
            resultSet = prepareStatement.executeQuery();

            //遍历resultSet
            /*//适用于取到的resultSet中多于一条的数据时
            while(resultSet.next()){
                name = resultSet.getString("name");
            }*/
            if(resultSet.next()){
                name = resultSet.getString("name");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                //关闭资源
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return name;
    }

    /**
     *
     * @param provinceId
     * @return
     */
    public Province getProinceById(Integer provinceId){

        //连接对象
        Connection connection = null;
        //预准备 表 声明
        PreparedStatement prepareStatement = null;
        //接收数据数据对象
        ResultSet resultSet = null;
        //定义sql语句
        String sql = "";

        String url = "jdbc:mysql://localhost:3306/springdb";
        String username = "root";
        String password = "admin";

        Province province = new Province();
        //1、加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(url,username,password);
            //创建PreparedStatement对象
            sql = "select name,jiancheng,shenghui from province where id=?";
            prepareStatement = connection.prepareStatement(sql);
            //设置参数值 sql中的？表示占用符，用参数来替代占用符
            //设置第一个占位符的位置放置provinceId
            prepareStatement.setInt(1,provinceId);
            //执行sql，将取到的结果放入resultSet中
            resultSet = prepareStatement.executeQuery();

            //遍历resultSet
            /*//适用于取到的resultSet中多于一条的数据时
            while(resultSet.next()){
                name = resultSet.getString("name");
            }*/
            if(resultSet.next()){
                province.setId(provinceId);
                province.setName(resultSet.getString("name"));
                province.setJiancheng(resultSet.getString("jiancheng"));
                province.setShenghui(resultSet.getString("shenghui"));

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                //关闭资源
                if (resultSet != null) {
                    resultSet.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return province;
    }
}
