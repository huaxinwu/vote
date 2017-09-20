/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wxh.bean.Vote;
import com.wxh.bean.VoteOption;
import com.wxh.bean.VoteResult;
import com.wxh.dao.VoteDAO;
import com.wxh.dao.VoteOptionDAO;
import com.wxh.factory.VoteDAOFactory;
import com.wxh.factory.VoteOptionDAOFactory;
import com.wxh.util.Page;
import com.wxh.util.PageUtil;

/**
 * 显示某个频道下投票数
 * @author wxh
 * @version $Id: ShowVoteByChannelAction.java, v 0.1 2017年9月16日 下午11:19:49 wxh Exp $
 */
public class ShowVoteByChannelAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = -2089847670696871558L;
    /**
     * 频道ID
     */
    private int channelID;
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 调用dao层处理业务，返回view
     */
    public String execute() throws Exception{
        // 投票操作
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // 获取某个频道下投票总数
        int totalCount = voteDAO.findCountByChannel(channelID);
        // 分页信息
        Page page = PageUtil.createPage(3, totalCount, currentPage);
        // 获取所有投票数
        List<Vote> votes = voteDAO.findVoteByChannel(page, totalCount);
        // 存放所有投票和投票选项
        List<VoteResult> voteResultList = new ArrayList<>();
        for(Vote vote:votes){
            // 投票结果封装类
            VoteResult voteResult = new VoteResult();
            voteResult.setVote(vote);
            // 查询该投票下所有投票选项
            List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
            voteResult.setVoteOptions(voteOptions);
            // 存入集合中
            voteResultList.add(voteResult);
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        // 共享request，方便前台页面使用其中的数据
        request.setAttribute("voteResultList", voteResultList);
        request.setAttribute("page", page);
        return this.SUCCESS;
    }
    
    public int getChannelID() {
        return channelID;
    }
    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    

}
