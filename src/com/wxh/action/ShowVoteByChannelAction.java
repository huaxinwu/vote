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
 * ��ʾĳ��Ƶ����ͶƱ��
 * @author wxh
 * @version $Id: ShowVoteByChannelAction.java, v 0.1 2017��9��16�� ����11:19:49 wxh Exp $
 */
public class ShowVoteByChannelAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = -2089847670696871558L;
    /**
     * Ƶ��ID
     */
    private int channelID;
    /**
     * ��ǰҳ��
     */
    private int currentPage;
    /**
     * ����dao�㴦��ҵ�񣬷���view
     */
    public String execute() throws Exception{
        // ͶƱ����
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // ��ȡĳ��Ƶ����ͶƱ����
        int totalCount = voteDAO.findCountByChannel(channelID);
        // ��ҳ��Ϣ
        Page page = PageUtil.createPage(3, totalCount, currentPage);
        // ��ȡ����ͶƱ��
        List<Vote> votes = voteDAO.findVoteByChannel(page, totalCount);
        // �������ͶƱ��ͶƱѡ��
        List<VoteResult> voteResultList = new ArrayList<>();
        for(Vote vote:votes){
            // ͶƱ�����װ��
            VoteResult voteResult = new VoteResult();
            voteResult.setVote(vote);
            // ��ѯ��ͶƱ������ͶƱѡ��
            List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
            voteResult.setVoteOptions(voteOptions);
            // ���뼯����
            voteResultList.add(voteResult);
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        // ����request������ǰ̨ҳ��ʹ�����е�����
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
