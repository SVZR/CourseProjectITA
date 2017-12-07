package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/usersearch", name = "UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        req.setAttribute("user", UserService.getInstance().getUserFullInfoByUserName(username));
        req.setAttribute("userRoles", UserService.getInstance().getAllUserRoles());
        resp.sendRedirect("/users");
    }
}
