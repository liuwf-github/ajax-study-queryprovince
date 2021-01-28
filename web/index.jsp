<%--
制作一个前端输入省份编号
后端访问数据库找到该省份名称返回到前端页面进行局部刷新
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>使用编号查找省份名称</title>
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
          //更新dom对象,更新页面，部分更新
          document.getElementById("provinceName").value = xmlHttp.responseText;
        }
      }
      //3、初始异步对象xmlHttp.open
      //将输入框中的id传到异步对象中，即传到后端的request对象中
      var provinceId= document.getElementById("provinceId").value;
      xmlHttp.open("get","QueryProvinceServlet?provinceId="+provinceId,true);
      //4、发送请求
      xmlHttp.send();

    }
  </script>

  <div>
    省份编号:<input type="text" id="provinceId"><br />
    省份名称:<input type="text" id="provinceName"><br />
    <input type="submit" value="提交" onclick="myAjax()">
  </div>
  </body>
</html>
