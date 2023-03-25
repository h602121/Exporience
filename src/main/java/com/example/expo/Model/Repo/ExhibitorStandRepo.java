package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.ExhibitorStand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitorStandRepo extends JpaRepository<ExhibitorStand, Integer> {

    ExhibitorStand findByExhibitorId(Integer userId);
}
