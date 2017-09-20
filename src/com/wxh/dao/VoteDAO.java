/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Vote;
import com.wxh.util.Page;

/**
 * 投票数据操作接口
 * @author wxh
 * @version $Id: VoteDAO.java, v 0.1 2017年8月10日 下午9:30:28 wxh Exp $
 */
public interface VoteDAO {

    /**
     * 新增投票信息
     * @param vote
     */
    public void addVote(Vote vote);
    /**
     * 更新投票信息
     * @param vote
     */
    public void updateVote(Vote vote);
    /**
     * 通过投票编号删除投票信息
     * @param voteID
     */
    public void deleteVote(int voteID);
    /**
     * 分页查询投票信息
     * @param page
     * @return
     */
    public List<Vote> findAllVote(Page page);
    /**
     * 分页查询每频道投票信息
     * @param page
     * @param channelID
     * @return
     */
    public List<Vote> findVoteByChannel(Page page,int channelID);
    /**
     * 通过投票编号查询投票信息
     * @param voteID
     * @return
     */
    public Vote findVoteById(int voteID);
    /**
     * 通过投票名称查询投票信息
     * @param voteName
     * @return
     */
    public Vote findVoteByName(String voteName);
    /**
     * 查询所有记录数
     * @return
     */
    public int findAllCount();
    /**
     * 查询每频道下记录数
     * @param channelID
     * @return
     */
    public int findCountByChannel(int channelID);
}
