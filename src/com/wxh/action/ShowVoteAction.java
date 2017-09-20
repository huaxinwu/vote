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
 * ��ʾ����ͶƱ
 *  Struts����ԭ��һ��������Struts2����еĴ����ŷ�Ϊ���¼������� 
 *  1���ͻ��˳�ʼ��һ��ָ��Servlet����������Tomcat��������
 *  2��������󾭹�һϵ�еĹ�������Filter������Щ����������һ������ActionContextCleanUp�Ŀ�ѡ��������
 *      �������������Struts2��������ܵļ��ɺ��а��������磺SiteMesh Plugin�� 
 *  3������FilterDispatcher�����ã�FilterDispatcherѯ��ActionMapper������������Ƿ���Ҫ����ĳ��Action 
 * @author wxh
 * @version $Id: ShowVoteAction.java, v 0.1 2017��9��4�� ����10:36:33 wxh Exp $
 */
public class ShowVoteAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = 4056210976607228621L;
    /**
     * ��ǰҳ��
     */
    private int currentPage;
    
    /**
     * ����dao�㴦��ҵ�񣬷���view
     */
    public String execute() throws Exception{
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // ͶƱ�ܼ�¼��
        int totalCount = voteDAO.findAllCount();
        //  ��ҳ����
        Page page = PageUtil.createPage(10, totalCount, currentPage);
        // ��ȡͶƱ��¼�б�
        List<Vote> votes = voteDAO.findAllVote(page);
        // ��ȡͶƱ��װ���б�
        List<VoteResult> voteResultList = new ArrayList<>();
        // �������ݿ��ѯ���������·�װ��VoteResult������
        for(Vote vote:votes){
            // ��ȡͶƱ�е�����ѡ��,����voteId��ȡÿ�ζ�ȡ��ͬ����
            List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(vote.getVoteID());
            VoteResult voteResult = new VoteResult();
            voteResult.setVote(vote);
            voteResult.setVoteOptions(voteOptions);
            voteResultList.add(voteResult);
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        // ͶƱ�б���ҳ��Ϣ����request��
        request.setAttribute("voteResultList", voteResultList);
        request.setAttribute("page", page);
        //  �ɹ�����
        return this.SUCCESS;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    

}
