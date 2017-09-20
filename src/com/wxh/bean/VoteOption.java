/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;

/**
 * ͶƱѡ��ʵ����
 * @author wxh
 * @version $Id: VoteOption.java, v 0.1 2017��8��5�� ����5:04:04 wxh Exp $
 */
public class VoteOption implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -1134986676239782056L;

    /**
     * ѡ����
     */
    private int voteOptionID;
    /**
     * ����ͶƱ���
     */
    private int voteID;
    /**
     * ѡ������
     */
    private String voteOptionName;
    /**
     * ��Ʊ��
     */
    private int ticketNum;
    
    public VoteOption() {
    }

    public VoteOption(int voteOptionID, int voteID, String voteOptionName, int ticketNum) {
        super();
        this.voteOptionID = voteOptionID;
        this.voteID = voteID;
        this.voteOptionName = voteOptionName;
        this.ticketNum = ticketNum;
    }

    public int getVoteOptionID() {
        return voteOptionID;
    }

    public void setVoteOptionID(int voteOptionID) {
        this.voteOptionID = voteOptionID;
    }

    public int getVoteID() {
        return voteID;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

    public String getVoteOptionName() {
        return voteOptionName;
    }

    public void setVoteOptionName(String voteOptionName) {
        this.voteOptionName = voteOptionName;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }
    
}
