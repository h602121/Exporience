package com.example.expo.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByPhonenumber(String phonenumber);

    public User findByEmailAndPassword(String email, String password);
}
