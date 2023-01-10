package service;

import ripository.UsersRipository;

public class LoginService {
    public boolean CheckLogin(String email, String password){
        UsersRipository usersRipository = new UsersRipository();
        int count = usersRipository.countUserByEmailAndPassword(email,password);
        return count>0;
    }
}
