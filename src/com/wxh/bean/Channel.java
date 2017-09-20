/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;

/**
 * ͶƱƵ��ʵ����
 * @author wxh
 * @version $Id: Channel.java, v 0.1 2017��8��5�� ����4:57:32 wxh Exp $
 */
public class Channel implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -6478146851903774964L;
    
    /**
     * Ƶ�����
     */
    private int channelID;
    /**
     * Ƶ������
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
