/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.util.List;

/**
 *  ͶƱ���ʵ����(��װͶƱʵ���ࡢͶƱѡ��ʵ�弯��)
 * @author wxh
 * @version $Id: VoteResult.java, v 0.1 2017��8��5�� ����5:07:43 wxh Exp $
 */
public class VoteResult {
    private Vote vote;
    private List<VoteOption> voteOptions;
    public Vote getVote() {
        return vote;
    }
    public void setVote(Vote vote) {
        this.vote = vote;
    }
    public List<VoteOption> getVoteOptions() {
        return voteOptions;
    }
    public void setVoteOptions(List<VoteOption> voteOptions) {
        this.voteOptions = voteOptions;
    }
    
}
