package servlet;

import model.UsersModel;
import ripository.UsersRipository;
import service.UserSevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = {"/user-table"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSevice userSevice = new UserSevice();
        //int id_role = userSevice.getNameRole(userSevice.getAllUser().set(6,));
        req.setAttribute("users", userSevice.getAllUser());

        req.getRequestDispatcher("user-table.jsp").forward(req,resp);
    }
}
