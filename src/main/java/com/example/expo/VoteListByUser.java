package com.example.expo;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Vote;

import java.util.List;

public class VoteListByUser {

    private Vote votes;
    private Stand stands;

    public VoteListByUser(Vote votes, Stand stands) {
        this.votes = votes;
        this.stands = stands;
    }

    public Vote getVotes() {
        return votes;
    }

    public void setVotes(Vote votes) {
        this.votes = votes;
    }

    public Stand getStands() {
        return stands;
    }

    public void setStands(Stand stands) {
        this.stands = stands;
    }
}

