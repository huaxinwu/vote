/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wxh.bean.VoteOption;
import com.wxh.dao.VoteOptionDAO;
import com.wxh.factory.VoteOptionDAOFactory;

/**
 * 投票操作
 * @author wxh
 * @version $Id: DoVoteAction.java, v 0.1 2017年9月17日 上午12:05:16 wxh Exp $
 */
public class DoVoteAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = 8002410838406339361L;
    
    /**
     * 投票选项编号
     */
    private int voteOptionID;
    /**
     * 其他选项名称
     */
    private String otherOption;
    /**
     * 投票编号
     */
    private int voteID;
    /**
     * 频道编号
     */
    private int channelID;
    /**
     * 调用dao层处理业务，返回view
     */
    public String execute() throws Exception{
        // 投票选项操作
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // 判断用户是否进行投票，取出cookies
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        for(Cookie cookie:cookies){
            // 如果用户已经投过票
            if(cookie.getValue().equals(Integer.toString(voteID))){
                this.addActionError("您今天已经投过票了，请明天再来！");
                // 跳转到错误页面
                return this.INPUT;
            }
        }
        // 判断是否选择其他选项,如果没有选择添加新选项信息,否则更新选项信息
        if(voteOptionID == 0){
            VoteOption voteOption = new VoteOption();
            voteOption.setVoteID(voteID);
            voteOption.setVoteOptionName(otherOption);
            voteOption.setTicketNum(1);
            // 插入投票选项 信息
            voteOptionDAO.addVoteOption(voteOption);
        }else{
            VoteOption voteOption = voteOptionDAO.findVoteOptionById(voteOptionID);
            // 获取投票选项投票数
            int ticketNum = voteOption.getTicketNum();
            voteOption.setTicketNum(ticketNum+1);
            // 更新投票选项 信息
            voteOptionDAO.updateVoteOption(voteOption);
            // 更新后，添加cookie，防止重复投票
            Cookie cookie = new Cookie("has Vote"+voteID,Integer.toString(voteID));
            // 将cookie响应给浏览器
            ServletActionContext.getResponse().addCookie(cookie);
        }
        return this.SUCCESS;
    }
    
    public int getVoteOptionID() {
        return voteOptionID;
    }
    public void setVoteOptionID(int voteOptionID) {
        this.voteOptionID = voteOptionID;
    }
    public String getOtherOption() {
        return otherOption;
    }
    public void setOtherOption(String otherOption) {
        this.otherOption = otherOption;
    }
    public int getVoteID() {
        return voteID;
    }
    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }
    public int getChannelID() {
        return channelID;
    }
    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

}
