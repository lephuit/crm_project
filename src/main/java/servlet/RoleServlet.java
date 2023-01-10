package servlet;

import config.MysqlConfig;
import service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "roleServlet",urlPatterns = {"/roles"})
public class RoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoleService roleService = new RoleService();
        req.setAttribute("roles",roleService.getAllRole());
        req.getRequestDispatcher("role-table.jsp").forward(req,resp);
    }

}
