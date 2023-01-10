package service;

import model.RoleModel;
import ripository.RoleRipository;
import java.util.List;

public class RoleService {
    public List<RoleModel> getAllRole(){
        RoleRipository roleRipository = new RoleRipository();
        return roleRipository.getAllRole();
    }

}
