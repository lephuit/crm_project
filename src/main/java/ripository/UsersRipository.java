package ripository;

import config.MysqlConfig;
import model.RoleColumn;
import model.UserColumn;
import model.UsersModel;
import service.UserSevice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Chuyên tương tác với bản user ở cơ sở dũ liệu
public class UsersRipository {
    public int countUserByEmailAndPassword(String email, String password) {
        Connection connection = MysqlConfig.getConnection();
        int count = 0;
        String query = " SELECT count(*) as count FROM users where email = '" + email + "' and password ='" + password + "'";
        try {
            //Chuẩn bị câu tư vấn Prepared Statement
            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1,"email");
//            statement.setString(2, "password");
            //Kết quả câu truy vấn lưu vào ResultSet
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
        } catch (
                SQLException e) {
            System.out.println("Lỗi thực thi câu truy vấn login" + e.getMessage());
        }
        return count;
    }
    public List<UsersModel> getAllUser(){
        List<UsersModel> listUser= new ArrayList<>();;
        Connection connection = MysqlConfig.getConnection();
        String query= "SELECT * FROM users;";
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()){
                UsersModel usersModel = new UsersModel();
                usersModel.setId(resultSet.getInt(UserColumn.ID.getValue()));
                usersModel.setPassword(resultSet.getString(UserColumn.PASSWORD.getValue()));
                usersModel.setEmail(resultSet.getString(UserColumn.EMAIL.getValue()));
                usersModel.setAvatar(resultSet.getString(UserColumn.AVATAR.getValue()));
                usersModel.setFullname(resultSet.getString(UserColumn.FULLNAME.getValue()));
                usersModel.setRole_name(getRole_NameRoleByID_role(resultSet.getInt(UserColumn.ROLE_ID.getValue())));
                //usersModel.setRole_id(resultSet.getInt(UserColumn.ROLE_ID.getValue()));
                listUser.add(usersModel);
            }
        } catch (SQLException throwables) {
            System.out.println("Loi cau truy van getAllUser"+throwables.getMessage());
            throwables.printStackTrace();
        }
        return listUser;
    }
    public String getRole_NameRoleByID_role(int id_role){
        Connection connection = MysqlConfig.getConnection();
        String query="SELECT name FROM roles where roles.id='"+id_role+"';";
        String name=null;
        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString("name");
            }
        } catch (SQLException throwables) {
            System.out.println("Lỗi query lấy role name"+throwables.getMessage());
        }
        return name;
    }
}
