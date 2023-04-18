package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.Stand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StandRepo extends JpaRepository<Stand, String> {

    List<Stand> findAll();

    Stand getStandByQrCode(Integer id);

}
