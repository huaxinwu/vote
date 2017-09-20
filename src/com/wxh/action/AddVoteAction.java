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
 * ����ͶƱ������(Struts2 ֻ�ܷ����ַ�������)
 * @author wxh
 * @version $Id: AddVoteAction.java, v 0.1 2017��8��10�� ����10:36:28 wxh Exp $
 */
public class AddVoteAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = -4702604764241806754L;
    
    /**
     * �����������(Ƶ����š�ͶƱ���ơ�ͶƱѡ���)
     */
    private int channel;
    private String voteName;
    private String[] voteOption;
    
    /**
     * ����dao�㴦��ҵ�񣬷���view
     */
    public String execute() throws Exception{
        // ��ȡͶƱ��ͶƱѡ��daoʵ��
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        
        // ����ͶƱʵ��
        Vote vote = new Vote();
        vote.setChannelID(channel);
        vote.setVoteName(voteName);
        // �������ݿ�
        voteDAO.addVote(vote);
        
        int voteID = voteDAO.findVoteByName(voteName).getVoteID();
        for(String voteOptionName:voteOption){
            VoteOption voteOption = new VoteOption();
            voteOption.setVoteID(voteID);
            voteOption.setVoteOptionName(voteOptionName);
            // �������ݿ�
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
