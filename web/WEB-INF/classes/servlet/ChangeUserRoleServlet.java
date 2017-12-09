package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/change-user-role", name = "ChangeUserRole")
public class ChangeUserRoleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newUserRole = req.getParameter("userRole");
        long userId = Long.valueOf(req.getParameter("userId"));
        UserService.getInstance().changeUserRole(userId, newUserRole);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
