package com.example.expo.Model.Service;

import com.example.expo.Model.Entity.Stand;
import com.example.expo.Model.Entity.User;
import com.example.expo.Model.Repo.StandRepo;
import com.example.expo.Model.Repo.StemmerRepo;
import com.example.expo.Model.Repo.UserRepo;
import com.example.expo.util.PassordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.expo.Model.Role.SPECTATOR;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    @Autowired
    public StandRepo standRepo;
    
    @Autowired
    public StemmerRepo stemmerRepo;
    
   public boolean validateLogin(String username, String passord){

       String hash = userRepo.findByEmail(username).getPassword();
       String salt = userRepo.findByEmail(username).getSalt();

       return PassordUtil.validerMedSalt(passord, salt, hash);

   }

    public boolean findUserByEmail(String email) {

        User user = userRepo.findByEmail(email);
        if (user == (null)) {
            return false;
        }
        return true;
    }

    public boolean findJuryByEmailAndPassword(String email, String password) {

        User user = userRepo.findByEmailAndPassword(email, password);
        if (user == (null)) {
            return false;
        }
        return user.getRoleId().equals(SPECTATOR.getRoleID());
    }

    public User findByMail(String eMail){
        User temp=userRepo.findByEmail(eMail);
        return temp;
    }


    public boolean createSpectator(String phonenumber, String firstName, String lastName, String email, String password, Integer role, String salt){
        userRepo.save(new User(phonenumber, firstName, lastName, email, password, role, salt));
        return true;
    }

    public boolean gyldigePost(String email) {
        if (email == null || email.length() > 30) {
            return false;
        }
        if (!email.contains("@")) {
            return false;
        }
        if (email.startsWith("@") || email.endsWith("@")) {
            return false;
        }
        return true;
    }

    public boolean gyldigLastName(String lastName) {
        if (lastName == null || lastName.length() > 20) {
            return false;
        }
        return true;
    }

    public boolean gyldigFirstName(String firstName) {
        if (firstName == null || firstName.length() > 20) {
            return false;
        }
        return true;
    }

    public boolean bruktTlf(String tlf) {
        User temp=userRepo.findByPhonenumber(tlf);
        if(temp==null){
            return true;
        }
        return false;
    }

    public boolean bruktEpost(String epost) {
        User temp=userRepo.findByEmail(epost);
        if(temp==null){
            return true;
        }
        return false;
    }

   
    




}


//package com.example.expo.Model;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import static com.example.expo.Model.Role.SPECTATOR;
//
//@Service
//public class UserService {
//
//    @Autowired
//    public UserRepo userRepo;
//
//    public boolean test(String phonenumber, String firstName, String lastName, String email, String password, Integer role) {
//
//
//        userRepo.save(new User(phonenumber, firstName, lastName, email, password, role));
//        return true;
//    }
//
//    public boolean findSpectatorByEmailAndPassword(String email, String password) {
//
//        User user = userRepo.findByEmailAndPassword(email, password);
//        if (user == (null)) {
//            return false;
//        }
//        return user.getRoleId().equals(SPECTATOR.getRoleID());
//    }
//
//    public boolean createSpectator(String phonenumber, String firstName, String lastName, String email, String password, Integer role){
//        userRepo.save(new User(phonenumber, firstName, lastName, email, password, role));
//        return true;
//    }
//
//
//}
