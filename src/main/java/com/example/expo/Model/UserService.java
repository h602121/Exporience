package com.example.expo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.expo.Model.Role.SPECTATOR;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    public boolean test(String phonenumber, String firstName, String lastName, String email, String password, Integer role) {


        userRepo.save(new User(phonenumber, firstName, lastName, email, password, role));
        return true;
    }

    public boolean findSpectatorByEmailAndPassword(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email, password);
        if (user == (null)) {
            return false;
        }
        return user.getRoleId().equals(SPECTATOR.getRoleID());
    }

    public boolean createSpectator(String phonenumber, String firstName, String lastName, String email, String password, Integer role){
        userRepo.save(new User(phonenumber, firstName, lastName, email, password, role));
        return true;
    }


}
