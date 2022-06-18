package com.wzw.wangziwei.ddd.config;

import java.sql.SQLException;

public class TestClient {
    private static String DB_URL_MYSQL = "jdbc:mysql://localhost:2215/wangziwei?useUnicode=true&useSSL=false";
    public static void main(String[] args) {
        try {
            new org.h2.tools.Console().runTool("-url",DB_URL_MYSQL,"-user","wzw","-password","wzw");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("test");
    }
}