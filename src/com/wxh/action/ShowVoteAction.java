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
 * 显示所有投票
 *  Struts工作原理：一个请求在Struts2框架中的处理大概分为以下几个步骤 
 *  1、客户端初始化一个指向Servlet容器（例如Tomcat）的请求
 *  2、这个请求经过一系列的过滤器（Filter）（这些过滤器中有一个叫做ActionContextCleanUp的可选过滤器，
 *      这个过滤器对于Struts2和其他框架的集成很有帮助，例如：SiteMesh Plugin） 
 *  3、接着FilterDispatcher被调用，FilterDispatcher询问ActionMapper来决定这个请是否需要调用某个Action 
 * @author wxh
 * @version $Id: ShowVoteAction.java, v 0.1 2017年9月4日 下午10:36:33 wxh Exp $
 */
public class ShowVoteAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = 4056210976607228621L;
    /**
     * 当前页码
     */
    private int currentPage;
    
    /**
     * 调用dao层处理业务，返回view
     */
    public String execute() throws Exception{
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // 投票总记录数
        int totalCount = voteDAO.findAllCount();
        //  分页对象
        Page page = PageUtil.createPage(10, totalCount, currentPage);
        // 获取投票记录列表
        List<Vote> votes = voteDAO.findAllVote(page);
        // 获取投票封装类列表
        List<VoteResult> voteResultList = new ArrayList<>();
        // 遍历数据库查询的数据重新封装到VoteResult对象中
        for(Vote vote:votes){
            // 获取投票中的所有选项,根据voteId获取每次都取不同数据
            List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
            VoteResult voteResult = new VoteResult();
            voteResult.setVote(vote);
            voteResult.setVoteOptions(voteOptions);
            voteResultList.add(voteResult);
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        // 投票列表、分页信息存入request中
        request.setAttribute("voteResultList", voteResultList);
        request.setAttribute("page", page);
        //  成功返回
        return this.SUCCESS;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    

}
