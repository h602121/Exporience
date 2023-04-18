package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.ExhibitorStand;
import com.example.expo.Model.Entity.Stand;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExhibitorStandRepo extends JpaRepository<ExhibitorStand, Integer> {

    List<ExhibitorStand> findByExhibitorId(Integer userId);

    //Stand findByQrCode(Integer standId);


}
