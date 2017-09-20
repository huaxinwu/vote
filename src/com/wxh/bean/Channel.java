/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;

/**
 * 投票频道实体类
 * @author wxh
 * @version $Id: Channel.java, v 0.1 2017年8月5日 下午4:57:32 wxh Exp $
 */
public class Channel implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -6478146851903774964L;
    
    /**
     * 频道编号
     */
    private int channelID;
    /**
     * 频道名称
     */
    private String channelName;
    
    public Channel() {
    }
    
    public Channel(int channelID, String channelName) {
        super();
        this.channelID = channelID;
        this.channelName = channelName;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    
}
