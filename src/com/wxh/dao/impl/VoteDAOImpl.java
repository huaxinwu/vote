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

import com.wxh.bean.Vote;
import com.wxh.dao.VoteDAO;
import com.wxh.util.DBConnection;
import com.wxh.util.Page;

/**
 * ͶƱ���ݲ���ʵ����
 * @author wxh
 * @version $Id: VoteDAOImpl.java, v 0.1 2017��8��10�� ����9:47:21 wxh Exp $
 */
public class VoteDAOImpl implements VoteDAO {

    /**
     * ����ͶƱ��Ϣ
     */
    @Override
    public void addVote(Vote vote) {
        String sql = "insert into tb_vote(voteName,channelID) values(?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, vote.getVoteName());
            pstmt.setInt(2, vote.getChannelID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    /**
     * ����ͶƱ��Ϣ
     */
    @Override
    public void updateVote(Vote vote) {
        String sql = "update tb_vote set voteName=?,channelID=? where voteID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, vote.getVoteName());
            pstmt.setInt(2, vote.getChannelID());
            pstmt.setInt(3, vote.getVoteID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    /**
     * ͨ��ͶƱ���ɾ��ͶƱ��Ϣ
     */
    @Override
    public void deleteVote(int voteID) {
        String sql = "delete from tb_vote where voteID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, voteID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
    }

    /**
     * ��ҳ��ѯͶƱ��Ϣ
     */
    @Override
    public List<Vote> findAllVote(Page page) {
        String sql = "select * from tb_vote limit ?,?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Vote> list = new ArrayList<Vote>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, page.getBeginIndex());
            pstmt.setInt(2, page.getEveryPage());
            rs = pstmt.executeQuery();
            while(rs.next()){
                Vote vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
                list.add(vote);
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
     * ��ҳ��ѯÿƵ��ͶƱ��Ϣ
     */
    @Override
    public List<Vote> findVoteByChannel(Page page, int channelID) {
        String sql = "select * from tb_vote where channelID=? limit ?,?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Vote> list = new ArrayList<Vote>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, channelID);
            pstmt.setInt(2, page.getBeginIndex());
            pstmt.setInt(3, page.getEveryPage());
            rs = pstmt.executeQuery();
            while(rs.next()){
                Vote vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
                list.add(vote);
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
     * ͨ��ͶƱ��Ų�ѯͶƱ��Ϣ
     */
    @Override
    public Vote findVoteById(int voteID) {
        String sql = "select * from tb_vote where voteID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vote vote = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, voteID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return vote;
    }

    /**
     * ͨ��ͶƱ���Ʋ�ѯͶƱ��Ϣ
     */
    @Override
    public Vote findVoteByName(String voteName) {
        String sql = "select * from tb_vote where voteName=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vote vote = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, voteName);
            rs = pstmt.executeQuery();
            if(rs.next()){
                vote = new Vote();
                vote.setVoteID(rs.getInt(1));
                vote.setVoteName(rs.getString(2));
                vote.setChannelID(rs.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return vote;
    }

    /**
     * ��ѯ���м�¼��
     */
    @Override
    public int findAllCount() {
        String sql = "select count(*) from tb_vote";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0 ;
        try {
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return count;
    }

    /**
     * ͨ��Ƶ��IDÿƵ���¼�¼��
     */
    @Override
    public int findCountByChannel(int channelID) {
        String sql = "select * from tb_vote where channelID=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, channelID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(connection);
        }
        return count;
    }

}
