package service;

import model.UsersModel;
import ripository.UsersRipository;
import java.util.List;

public class UserSevice {
    public List<UsersModel> getAllUser(){
        UsersRipository usersRipository= new UsersRipository();

        return usersRipository.getAllUser();
    }
    public String[] convertName(String fullName) {
        String [] name = new String[2];
        name[0]  = fullName.substring(0, fullName.indexOf(" "));
        name[1] = fullName.substring(fullName.indexOf(" "));
        return name ;
    }
}
