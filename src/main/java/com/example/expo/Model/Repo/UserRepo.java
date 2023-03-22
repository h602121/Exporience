package com.example.expo.Model.Repo;

import com.example.expo.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByPhonenumber(String tlf);

    public User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}


//package com.example.expo.Model;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface UserRepo extends JpaRepository<User, Integer> {
//
//    public User findByPhonenumber(String phonenumber);
//
//    public User findByEmailAndPassword(String email, String password);
//}
