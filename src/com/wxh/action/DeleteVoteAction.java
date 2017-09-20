/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wxh.bean.VoteOption;
import com.wxh.dao.VoteDAO;
import com.wxh.dao.VoteOptionDAO;
import com.wxh.factory.VoteDAOFactory;
import com.wxh.factory.VoteOptionDAOFactory;

/**
 * ɾ��ͶƱ
 * @author wxh
 * @version $Id: DeleteVoteAction.java, v 0.1 2017��9��4�� ����11:14:14 wxh Exp $
 */
public class DeleteVoteAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = -5156060965347662602L;
    
    /**
     * ͶƱ���
     */
    private int voteID;
    
    /**
     * ����daoʵ��ҵ��������VIEW
     * @return String
     * @throws Exception
     */
    public String execute() throws Exception{
        System.out.println("11111111111");
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // ��ȡvoteID�µ�����ͶƱѡ�����һɾ��
        List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);
        for(VoteOption voteOption:voteOptions){
            // ͶƱѡ��
            voteOptionDAO.deletVoteOption(voteOption.getVoteOptionID());
        }
        // ɾ��ͶƱ
        voteDAO.deleteVote(voteID);
        return this.SUCCESS;
        
    }

    public int getVoteID() {
        return voteID;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }
    
    

}
