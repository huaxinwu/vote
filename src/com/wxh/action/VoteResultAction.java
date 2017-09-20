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
 * ͶƱ���
 * @author wxh
 * @version $Id: VoteResultAction.java, v 0.1 2017��9��20�� ����10:27:18 wxh Exp $
 */
public class VoteResultAction extends ActionSupport{
    /**
     * 
     */
    private static final long serialVersionUID = 6627007479733228856L;
    /**
     * �����������
     */
    private JFreeChart chart;
    /**
     * ͶƱ���
     */
    private int voteID;
    /**
     * ����dao�㴦��ҵ�񣬷���view
     */
    public String execute() throws Exception{
        return this.SUCCESS;
    }
    
    public JFreeChart getChart() {
        // ͶƱ����
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        //����ͶƱID�õ���ͶƱ
        Vote vote = voteDAO.findVoteById(voteID);
        // ͶƱ����
        String voteName = vote.getVoteName();
        // ����ͶƱID�õ����е�ͶƱѡ��
        List<VoteOption> voteOptions =  voteOptionDAO.findVoteOptionByVoteID(voteID);
        // ��������Դ
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        // ��ͶƱѡ�����
        for(VoteOption voteOption:voteOptions){
            // ��������Դ
            dcd.setValue(voteOption.getTicketNum(), "", voteOption.getVoteOptionName());
        }
        // ʹ�ù����ഴ����״ͼ
        JFreeChart chart = ChartFactory.createBarChart3D(
            voteName, 
            "ͶƱѡ��", 
            "ͶƱ��", 
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
