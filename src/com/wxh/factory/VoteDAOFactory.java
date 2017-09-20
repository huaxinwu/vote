/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.VoteDAO;
import com.wxh.dao.impl.VoteDAOImpl;

/**
 * 投票dao工厂类
 * @author wxh
 * @version $Id: VoteDAOFactory.java, v 0.1 2017年8月10日 下午11:11:49 wxh Exp $
 */
public class VoteDAOFactory {

    /**
     *  生产VoteDAO
     * @return
     */
    public static VoteDAO getVoteDAOInstance(){
        return new VoteDAOImpl();
    }
}
