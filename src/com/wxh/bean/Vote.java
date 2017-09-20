/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;

/**
 * 投票实体类
 * @author wxh
 * @version $Id: Vote.java, v 0.1 2017年8月5日 下午5:00:30 wxh Exp $
 */
/**
 * @author wxh
 * @version $Id: Vote.java, v 0.1 2017年8月5日 下午5:02:02 wxh Exp $
 */
public class Vote implements Serializable{

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -794001798521275374L;
    
    /**
     * 投票编号
     */
    private int voteID;
    /**
     * 投票名称
     */
    private String voteName;
    /**
     * 所属频道编号
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