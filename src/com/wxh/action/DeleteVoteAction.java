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
 * 删除投票
 * @author wxh
 * @version $Id: DeleteVoteAction.java, v 0.1 2017年9月4日 下午11:14:14 wxh Exp $
 */
public class DeleteVoteAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = -5156060965347662602L;
    
    /**
     * 投票编号
     */
    private int voteID;
    
    /**
     * 调用dao实现业务处理，返回VIEW
     * @return String
     * @throws Exception
     */
    public String execute() throws Exception{
        System.out.println("11111111111");
        VoteDAO voteDAO = VoteDAOFactory.getVoteDAOInstance();
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // 获取voteID下的所有投票选项，并逐一删除
        List<VoteOption> voteOptions = voteOptionDAO.findVoteOptionByVoteID(voteID);
        for(VoteOption voteOption:voteOptions){
            // 投票选项
            voteOptionDAO.deletVoteOption(voteOption.getVoteOptionID());
        }
        // 删除投票
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
