/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * ���ݿ�
 * @author wxh
 * @version $Id: DBConnection.java, v 0.1 2017��7��18�� ����9:35:39 wxh Exp $
 */
public class DBConnection {
    /*
     * ��̬��ʼ��������ݿ������ļ�
     * 1.Ӳ���������ļ�
     * 2.��ȡ�����ļ���ͨ��Properties����
     */
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/db_votemanage";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";
    
    /**
     *  ��һ�����ݿ�����
     * @return Connection
     */
    public static Connection getConnection(){
        // ����һ�����Ӷ���
        Connection conn = null;
        try {
            // ע�����ݿ�����
            Class.forName(DRIVER);
            // ����һ������
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    /**
     * �ر�һ�����Ӷ���
     * @param connection
     */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    /**
     * �ر�һ��Ԥ�������
     * @param pstmt
     */
    public static void close(PreparedStatement pstmt){
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * �ر�һ�����������
     * @param rs
     */
    public static void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
