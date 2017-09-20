/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.VoteOptionDAO;
import com.wxh.dao.impl.VoteOptionDAOImpl;

/**
 * ͶƱѡ�����
 * @author wxh
 * @version $Id: VoteOptionDAOFactory.java, v 0.1 2017��8��10�� ����11:13:14 wxh Exp $
 */
public class VoteOptionDAOFactory {

    /**
     * ����VoteOptionDAO
     * @return
     */
    public static VoteOptionDAO getVoteOptionDAOInstance(){
        return new VoteOptionDAOImpl();
    }
}
