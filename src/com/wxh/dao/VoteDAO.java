/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Vote;
import com.wxh.util.Page;

/**
 * ͶƱ���ݲ����ӿ�
 * @author wxh
 * @version $Id: VoteDAO.java, v 0.1 2017��8��10�� ����9:30:28 wxh Exp $
 */
public interface VoteDAO {

    /**
     * ����ͶƱ��Ϣ
     * @param vote
     */
    public void addVote(Vote vote);
    /**
     * ����ͶƱ��Ϣ
     * @param vote
     */
    public void updateVote(Vote vote);
    /**
     * ͨ��ͶƱ���ɾ��ͶƱ��Ϣ
     * @param voteID
     */
    public void deleteVote(int voteID);
    /**
     * ��ҳ��ѯͶƱ��Ϣ
     * @param page
     * @return
     */
    public List<Vote> findAllVote(Page page);
    /**
     * ��ҳ��ѯÿƵ��ͶƱ��Ϣ
     * @param page
     * @param channelID
     * @return
     */
    public List<Vote> findVoteByChannel(Page page,int channelID);
    /**
     * ͨ��ͶƱ��Ų�ѯͶƱ��Ϣ
     * @param voteID
     * @return
     */
    public Vote findVoteById(int voteID);
    /**
     * ͨ��ͶƱ���Ʋ�ѯͶƱ��Ϣ
     * @param voteName
     * @return
     */
    public Vote findVoteByName(String voteName);
    /**
     * ��ѯ���м�¼��
     * @return
     */
    public int findAllCount();
    /**
     * ��ѯÿƵ���¼�¼��
     * @param channelID
     * @return
     */
    public int findCountByChannel(int channelID);
}
