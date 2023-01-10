package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConfig {
    private static  String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static  String URL = "jdbc:mysql://localhost:3306/crm_app";
    private static  String USER_NAME = "root";
    private static  String PASSWORD = "123";
    public static Connection getConnection(){
        Connection connection = null;
        try {
            //đăng ký sử dụng driver cho có sở dữ liệu mysql
            Class.forName(DRIVER_NAME);
            //mở kết nối tới CSDL theo driver chỉ định rõ
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }catch (Exception e){
            System.out.println("Kết nối cơ sở dữ liệu"+e.getMessage());
        }
        return connection;
    }
}
