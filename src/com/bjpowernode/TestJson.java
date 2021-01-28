package com.bjpowernode;

import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJson {

    public static void main(String[] args) throws JsonProcessingException {
        //测试Jackson将java对象转为json字符串

        //1、创建一个java对象
        Province province = new Province();
        province.setId(1);
        province.setName("福建");
        province.setJiancheng("闽");
        province.setShenghui("福州");
        //2.转化为json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(province);

        System.out.println("json"+json);
    }
}
