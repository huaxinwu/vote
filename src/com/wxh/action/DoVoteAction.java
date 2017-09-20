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
 * ͶƱ����
 * @author wxh
 * @version $Id: DoVoteAction.java, v 0.1 2017��9��17�� ����12:05:16 wxh Exp $
 */
public class DoVoteAction extends ActionSupport{

    /**
     * 
     */
    private static final long serialVersionUID = 8002410838406339361L;
    
    /**
     * ͶƱѡ����
     */
    private int voteOptionID;
    /**
     * ����ѡ������
     */
    private String otherOption;
    /**
     * ͶƱ���
     */
    private int voteID;
    /**
     * Ƶ�����
     */
    private int channelID;
    /**
     * ����dao�㴦��ҵ�񣬷���view
     */
    public String execute() throws Exception{
        // ͶƱѡ�����
        VoteOptionDAO voteOptionDAO = VoteOptionDAOFactory.getVoteOptionDAOInstance();
        // �ж��û��Ƿ����ͶƱ��ȡ��cookies
        Cookie[] cookies = ServletActionContext.getRequest().getCookies();
        for(Cookie cookie:cookies){
            // ����û��Ѿ�Ͷ��Ʊ
            if(cookie.getValue().equals(Integer.toString(voteID))){
                this.addActionError("�������Ѿ�Ͷ��Ʊ�ˣ�������������");
                // ��ת������ҳ��
                return this.INPUT;
            }
        }
        // �ж��Ƿ�ѡ������ѡ��,���û��ѡ�������ѡ����Ϣ,�������ѡ����Ϣ
        if(voteOptionID == 0){
            VoteOption voteOption = new VoteOption();
            voteOption.setVoteID(voteID);
            voteOption.setVoteOptionName(otherOption);
            voteOption.setTicketNum(1);
            // ����ͶƱѡ�� ��Ϣ
            voteOptionDAO.addVoteOption(voteOption);
        }else{
            VoteOption voteOption = voteOptionDAO.findVoteOptionById(voteOptionID);
            // ��ȡͶƱѡ��ͶƱ��
            int ticketNum = voteOption.getTicketNum();
            voteOption.setTicketNum(ticketNum+1);
            // ����ͶƱѡ�� ��Ϣ
            voteOptionDAO.updateVoteOption(voteOption);
            // ���º����cookie����ֹ�ظ�ͶƱ
            Cookie cookie = new Cookie("has Vote"+voteID,Integer.toString(voteID));
            // ��cookie��Ӧ�������
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
