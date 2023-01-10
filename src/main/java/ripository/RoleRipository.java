package ripository;

import config.MysqlConfig;
import model.RoleColumn;
import model.RoleModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRipository {
    public List<RoleModel> getAllRole(){
        List<RoleModel> listRoles = new ArrayList<>();
        Connection connection = MysqlConfig.getConnection();
        String query = "SELECT * FROM roles";
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()){
                RoleModel roleModel = new RoleModel();
                roleModel.setId(resultSet.getInt(RoleColumn.ID.getValue()));
                roleModel.setName(resultSet.getString(RoleColumn.NAME.getValue()));
                roleModel.setDescription(resultSet.getString(RoleColumn.DESCRIPTION.getValue()));
                listRoles.add(roleModel);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi câu query getAllRole"+e.getMessage());
        }
        return listRoles;
    }
}
