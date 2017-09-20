/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wxh.bean.Vote;
import com.wxh.bean.VoteOption;
import com.wxh.dao.VoteDAO;
import com.wxh.dao.VoteOptionDAO;
import com.wxh.factory.VoteDAOFactory;
import com.wxh.factory.VoteOptionDAOFactory;

/**
 * 新增投票控制器(Struts2 只能返回字符串类型)
 * @author wxh
 * @version $Id: AddVoteAction.java, v 0.1 2017年8月10日 下午10:36:28 wxh Exp $
 */
public class AddVoteAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = -4702604764241806754L;
    
    /**
     * 接受请求参数(频道编号、投票名称、投票选项集合)
     */
    private int channel;
    private String voteName;
    private String[] voteOption;
    
    /**
     * 调用dao层处理业务，返回view
     */
    public String execute() throws Exception{
        // 获取投票、投票选项dao实例
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        
        // 创建投票实例
        Vote vote = new Vote();
        vote.setChannelID(channel);
        vote.setVoteName(voteName);
        // 插入数据库
        voteDAO.addVote(vote);
        
        int voteID = voteDAO.findVoteByName(voteName).getVoteID();
        for(String voteOptionName:voteOption){
            VoteOption voteOption = new VoteOption();
            voteOption.setVoteID(voteID);
            voteOption.setVoteOptionName(voteOptionName);
            // 插入数据库
            voteOptionDAO.addVoteOption(voteOption);
        }
        return this.SUCCESS;
    }
    
    
    
    public int getChannel() {
        return channel;
    }
    public void setChannel(int channel) {
        this.channel = channel;
    }
    public String getVoteName() {
        return voteName;
    }
    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }
    public String[] getVoteOption() {
        return voteOption;
    }
    public void setVoteOption(String[] voteOption) {
        this.voteOption = voteOption;
    }
}
