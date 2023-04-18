package com.example.expo.Model.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.Stemmer;

@Repository
public interface StemmerRepo extends JpaRepository<Stemmer, Integer> {
     
    
    @Query("SELECT s FROM Stemmer s JOIN s.stand t WHERE t.qrCode = :qrCode")
    public Stemmer findByQrCode(@Param("qrCode") Integer qrCode);

    @Query("SELECT s FROM Stemmer s JOIN s.stand st WHERE st.active = true")
    List<Stemmer> findByActiveStand();


    
    
   

    
}


