/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.VoteDAO;
import com.wxh.dao.impl.VoteDAOImpl;

/**
 * ͶƱdao������
 * @author wxh
 * @version $Id: VoteDAOFactory.java, v 0.1 2017��8��10�� ����11:11:49 wxh Exp $
 */
public class VoteDAOFactory {

    /**
     *  ����VoteDAO
     * @return
     */
    public static VoteDAO getVoteDAOInstance(){
        return new VoteDAOImpl();
    }
}
