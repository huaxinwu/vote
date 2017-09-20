/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.VoteOptionDAO;
import com.wxh.dao.impl.VoteOptionDAOImpl;

/**
 * 投票选项工厂类
 * @author wxh
 * @version $Id: VoteOptionDAOFactory.java, v 0.1 2017年8月10日 下午11:13:14 wxh Exp $
 */
public class VoteOptionDAOFactory {

    /**
     * 生产VoteOptionDAO
     * @return
     */
    public static VoteOptionDAO getVoteOptionDAOInstance(){
        return new VoteOptionDAOImpl();
    }
}
