package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.Stand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StandRepo extends JpaRepository<Stand, String> {

    List <Stand> findAll();

    Stand getStandByQrCode(Integer qrCode);

    List<Stand> findByActiveTrue();

    

    

}
