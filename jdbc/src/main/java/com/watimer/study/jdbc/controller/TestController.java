package com.watimer.study.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param
 * @author yan
 * @Description
 * @date 2020/6/12
 */
@Controller
@RequestMapping("/jdbc")
public class TestController {

//    @Resource
//    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/user")
    @ResponseBody
    public List<Map> list() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Map> list = new ArrayList<>();
        try {
            // 1、获取Connection
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.15:3306/ivt-city?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull","root","Aa123456");
            // 2、获取Statement
            statement = connection.createStatement();
            // 3、准备SQL
            String sql = "SELECT * FROM jj_lavendy_user_info";
            // 4、执行查询,得到ResultSet
            resultSet = statement.executeQuery(sql);
            // 5、处理ResultSet
            Map map = new ConcurrentHashMap();
            while (resultSet.next()){
                map.put("id",resultSet.getString("userId"));
                map.put("lavendy_user_name",resultSet.getString("lavendy_user_name"));
                list.add(map);
            }
        } catch (SQLException e) {
            // 6、关闭数据库资源
            connection.close();
            e.printStackTrace();
        } finally {
            // 6、关闭数据库资源
            connection.close();
        }



//        String sql = "SELECT * FROM jj_lavendy_user_info";
//
//        list = jdbcTemplate.query(sql, new RowMapper<Map>() {
//            Map map = new ConcurrentHashMap();
//            @Override
//            public Map mapRow(ResultSet resultSet, int i) throws SQLException {
//                map.put("id",resultSet.getString("userId"));
//                map.put("lavendy_user_name",resultSet.getString("lavendy_user_name"));
//                return map;
//            }
//        });
        for (Map map:list){
            System.out.println(map.toString());
        }
        return list;
    }
}
