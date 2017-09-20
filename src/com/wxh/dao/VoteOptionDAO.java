/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.VoteOption;

/**
 * ͶƱѡ�����ݲ����ӿ�
 * @author wxh
 * @version $Id: VoteOptionDAO.java, v 0.1 2017��8��10�� ����10:43:03 wxh Exp $
 */
public interface VoteOptionDAO {

    /**
     * ����ͶƱѡ����Ϣ
     * @param voteOption
     */
    public void addVoteOption(VoteOption voteOption);
    /**
     * ����ͶƱѡ����Ϣ
     * @param voteOption
     */
    public void updateVoteOption(VoteOption voteOption);
    /**
     * ͨ��ͶƱѡ����ɾ��ͶƱѡ����Ϣ
     * @param voteOptionID
     */
    public void deletVoteOption(int voteOptionID);
    /**
     * ͨ��ͶƱ��Ų�ѯͶƱѡ����Ϣ
     * @param voteID
     * @return
     */
    public List<VoteOption> findVoteOptionByVoteID(int voteID);
    /**
     * ͨ��ͶƱѡ���Ų�ѯͶƱѡ����Ϣ
     * @param voteOptionID
     * @return
     */
    public VoteOption findVoteOptionById(int voteOptionID);
}
