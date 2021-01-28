<%--
制作一个前端输入省份编号
后端访问数据库找到该省份名称返回到前端页面进行局部刷新
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>使用编号查找省份所有信息</title>
  </head>
  <body>

  <script type="text/javascript">
    function myAjax() {
      //在这边响应提交按钮的动作
      //alert(1);

      //Ajax操作分为4步
      //1、创建异步对象
      var xmlHttp = new XMLHttpRequest();
      //2、绑定事件
      xmlHttp.onreadystatechange = function () {
        //在这边判断网络请求成功过，并且返回已经处理完的数据
        //alert("xmlHttp.readyState"+xmlHttp.readyState + "|xmlHttp.status="+xmlHttp.status);
        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
          //alert("xmlHttp.readyState"+xmlHttp.readyState + "|xmlHttp.status="+xmlHttp.status);
          //alert(xmlHttp.responseText);
          //获取json字符串
          var date = xmlHttp.responseText;
          //alert("date="+date);
          //将json字符串转化为json对象
          var jsonObject = eval("("+date+")");

          //更新dom对象,更新页面，部分更新
          callback(jsonObject);
        }
      }
      //3、初始异步对象的请求参数
      //将输入框中的id传到异步对象中，即传到后端的request对象中
      var provinceId= document.getElementById("provinceId").value;
      xmlHttp.open("get","QueryProvinceInfoServlet?provinceId="+provinceId,true);
      //4、发送请求
      xmlHttp.send();

      //定义一个函数进行dom更新
      function callback(jsonObject) {
        document.getElementById("provinceName").value = jsonObject.name;
        document.getElementById("provinceJianCheng").value = jsonObject.jiancheng;
        document.getElementById("provinceShengHui").value = jsonObject.shenghui;
      }
    }
  </script>
    <table>
      <tr>
        <td>省份编号</td>
        <td>
          <input type="text" id="provinceId">
        </td>
        <td>
          <input type="submit" value="提交" onclick="myAjax()">
        </td>
      </tr>
      <tr>
        <td>省份名称</td>
        <td>
          <input type="text" id="provinceName">
        </td>
      </tr>
      <tr>
        <td>省份简称</td>
        <td>
          <input type="text" id="provinceJianCheng">
        </td>
      </tr>
      <tr>
        <td>省份省会</td>
        <td>
          <input type="text" id="provinceShengHui">
        </td>
      </tr>
    </table>

  </body>
</html>
