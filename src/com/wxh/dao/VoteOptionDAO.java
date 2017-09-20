/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.VoteOption;

/**
 * 投票选项数据操作接口
 * @author wxh
 * @version $Id: VoteOptionDAO.java, v 0.1 2017年8月10日 下午10:43:03 wxh Exp $
 */
public interface VoteOptionDAO {

    /**
     * 新增投票选项信息
     * @param voteOption
     */
    public void addVoteOption(VoteOption voteOption);
    /**
     * 更新投票选项信息
     * @param voteOption
     */
    public void updateVoteOption(VoteOption voteOption);
    /**
     * 通过投票选项编号删除投票选项信息
     * @param voteOptionID
     */
    public void deletVoteOption(int voteOptionID);
    /**
     * 通过投票编号查询投票选项信息
     * @param voteID
     * @return
     */
    public List<VoteOption> findVoteOptionByVoteID(int voteID);
    /**
     * 通过投票选项编号查询投票选项信息
     * @param voteOptionID
     * @return
     */
    public VoteOption findVoteOptionById(int voteOptionID);
}
