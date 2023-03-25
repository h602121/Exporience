package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.ExpoPointsHandler;
import com.example.expo.Model.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpoPointHandlerRepo extends JpaRepository<ExpoPointsHandler, Integer> {

    ExpoPointsHandler getExpoPointsHandlerByUserIdAndStandId(Integer userId, Integer standId);

    List<ExpoPointsHandler> getAllByUserId(Integer userId);

}
