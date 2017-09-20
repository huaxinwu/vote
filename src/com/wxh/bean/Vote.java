/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;

/**
 * ͶƱʵ����
 * @author wxh
 * @version $Id: Vote.java, v 0.1 2017��8��5�� ����5:00:30 wxh Exp $
 */
/**
 * @author wxh
 * @version $Id: Vote.java, v 0.1 2017��8��5�� ����5:02:02 wxh Exp $
 */
public class Vote implements Serializable{

    /**
     * ���л�ID
     */
    private static final long serialVersionUID = -794001798521275374L;
    
    /**
     * ͶƱ���
     */
    private int voteID;
    /**
     * ͶƱ����
     */
    private String voteName;
    /**
     * ����Ƶ�����
     */
    private int channelID;

    
    public Vote() {
    }


    public Vote(int voteID, String voteName, int channelID) {
        super();
        this.voteID = voteID;
        this.voteName = voteName;
        this.channelID = channelID;
    }


    public int getVoteID() {
        return voteID;
    }


    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }


    public String getVoteName() {
        return voteName;
    }


    public void setVoteName(String voteName) {
        this.voteName = voteName;
    }


    public int getChannelID() {
        return channelID;
    }


    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }
    
}