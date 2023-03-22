package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<Vote, Integer> {

    public Vote getVoteById(int id);

}
