/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.util.List;

/**
 *  投票结果实体类(封装投票实体类、投票选项实体集合)
 * @author wxh
 * @version $Id: VoteResult.java, v 0.1 2017年8月5日 下午5:07:43 wxh Exp $
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
