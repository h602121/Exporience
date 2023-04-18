package com.example.expo.Model.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.expo.Model.Entity.Winner;


public interface WinnerTimeRepo extends JpaRepository<Winner, Long> {

    List<Winner> findByActiveTrue();

    List<Winner> findByCurrentTrue();
}
