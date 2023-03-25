package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepo extends JpaRepository<Vote, Integer> {

     Vote getVoteById(int id);

     List<Vote> findAll();

     List<Vote> findAllByIdIn(List<Integer> votesId);


}
