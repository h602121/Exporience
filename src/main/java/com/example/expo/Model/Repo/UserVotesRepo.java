package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Entity.UserVotes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVotesRepo extends JpaRepository<UserVotes, Integer> {

    @Query("SELECT uv FROM UserVotes uv WHERE uv.user.id = ?1")
    List<UserVotes> findByUser(Integer user);

    
   /*  @Modifying
    @Query("INSERT INTO UserVotes (id, qr_code) VALUES (?1, ?2)")
    void saveUserVote(Integer userId, Integer standQrCode);
 */
    List<UserVotes> findByUserId(Integer userId);
    
    List<UserVotes> findAllByUser_Id(Integer userId);
    
    @Query("SELECT uv FROM UserVotes uv WHERE uv.stand.qrCode IN "
        + "(SELECT es.standId FROM ExhibitorStand es WHERE es.exhibitorId = :userId)")
List<UserVotes> findMyStands(@Param("userId") Integer userId);

    









}
