package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.Expo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpoRepo extends JpaRepository<Expo, Integer> {

    Expo findByExpoName(String name);
}
