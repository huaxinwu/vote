/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.action;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionSupport;
import com.wxh.bean.Vote;
import com.wxh.bean.VoteOption;
import com.wxh.dao.VoteDAO;
import com.wxh.dao.VoteOptionDAO;
import com.wxh.factory.VoteDAOFactory;
import com.wxh.factory.VoteOptionDAOFactory;

/**
 * 投票结果
 * @author wxh
 * @version $Id: VoteResultAction.java, v 0.1 2017年9月20日 下午10:27:18 wxh Exp $
 */
public class VoteResultAction extends ActionSupport{
    /**
     * 
     */
    private static final long serialVersionUID = 6627007479733228856L;
    /**
     * 创建报表对象
     */
    private JFreeChart chart;
    /**
     * 投票编号
     */
    private int voteID;
    /**
     * 调用dao层处理业务，返回view
     */
    public String execute() throws Exception{
        return this.SUCCESS;
    }
    
    public JFreeChart getChart() {
        // 投票操作
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        //根据投票ID得到的投票
        Vote vote = voteDAO.findVoteById(voteID);
        // 投票名称
        String voteName = vote.getVoteName();
        // 根据投票ID得到所有的投票选项
        List<VoteOption> voteOptions =  voteOptionDAO.findVoteOptionByVoteID(voteID);
        // 创建数据源
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        // 对投票选项遍历
        for(VoteOption voteOption:voteOptions){
            // 设置数据源
            dcd.setValue(voteOption.getTicketNum(), "", voteOption.getVoteOptionName());
        }
        // 使用工厂类创建柱状图
        JFreeChart chart = ChartFactory.createBarChart3D(
            voteName, 
            "投票选项", 
            "投票数", 
            dcd, 
            PlotOrientation.VERTICAL, 
            false, 
            true, 
            false);
        return chart;
    }
    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }
    public int getVoteID() {
        return voteID;
    }
    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }
    
}
