/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxh.bean.VoteOption;
import com.wxh.dao.VoteOptionDAO;
import com.wxh.util.DBConnection;

/**
 * ͶƱѡ�����ݲ���ʵ����
 * @author wxh
 * @version $Id: VoteOptionDAOImpl.java, v 0.1 2017��8��10�� ����10:49:11 wxh Exp $
 */
public class VoteOptionDAOImpl implements VoteOptionDAO {

    /**
     * ����ͶƱѡ����Ϣ
     */
    @Override
    public void addVoteOption(VoteOption voteOption) {
        String sql = "insert into tb_voteoption(voteID,voteOptionName,ticketNum) values(?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, voteOption.getVoteID());
            pstmt.setString(2, voteOption.getVoteOptionName());
            pstmt.setInt(3, voteOption.getTicketNum());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        
    }

    /**
     * ����ͶƱѡ����Ϣ
     */
    @Override
    public void updateVoteOption(VoteOption voteOption) {
        String sql = "update tb_voteoption set voteID=?,voteOptionName=?,ticketNum=? where voteOptionID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, voteOption.getVoteID());
            pstmt.setString(2, voteOption.getVoteOptionName());
            pstmt.setInt(3, voteOption.getTicketNum());
            pstmt.setInt(4, voteOption.getVoteOptionID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    /**
     * ͨ��ͶƱѡ����ɾ��ͶƱѡ����Ϣ
     */
    @Override
    public void deletVoteOption(int voteOptionID) {
        String sql = "delete from tb_voteoption where voteOptionID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, voteOptionID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        
    }

    /**
     * ͨ��ͶƱ��Ų�ѯͶƱѡ����Ϣ
     */
    @Override
    public List<VoteOption> findVoteOptionByVoteID(int voteID) {
        String sql = "select * from tb_voteoption where voteID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<VoteOption> list = new ArrayList<VoteOption>();
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, voteID);
            rs = pstmt.executeQuery();
            while(rs.next()){
                VoteOption voteOption = new VoteOption();
                voteOption.setVoteOptionID(rs.getInt(1));
                voteOption.setVoteID(rs.getInt(2));
                voteOption.setVoteOptionName(rs.getString(3));
                voteOption.setTicketNum(rs.getInt(4));
                list.add(voteOption);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return list;
    }

    /**
     * ͨ��ͶƱѡ���Ų�ѯͶƱѡ����Ϣ
     */
    @Override
    public VoteOption findVoteOptionById(int voteOptionID) {
        String sql = "select * from tb_voteoption where voteOptionID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        VoteOption voteOption = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, voteOptionID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                voteOption = new VoteOption();
                voteOption.setVoteOptionID(rs.getInt(1));
                voteOption.setVoteID(rs.getInt(2));
                voteOption.setVoteOptionName(rs.getString(3));
                voteOption.setTicketNum(rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return voteOption;
    }

}
