package servlet;


import config.MysqlConfig;
import service.EncryptedPassword;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    //excuteQuery: Select
    //excuteUpdate: Create, edit, update
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = null;
        try {
            password = EncryptedPassword.toHexString(EncryptedPassword.getSHA(req.getParameter("password")));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Lỗi mã hoá password");
            e.printStackTrace();
        }
        LoginService loginService = new LoginService();
        boolean isSuccess= loginService.CheckLogin(email,password);
        if(isSuccess){
            resp.sendRedirect(req.getContextPath()+"/roles");
        }else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

}
