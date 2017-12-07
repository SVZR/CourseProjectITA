package servlet;

import dto.ViewUserFullInfoDto;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change-user-role")
public class ChangeUserRoleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newUserRole = req.getParameter("userRole");
        Object userObj = req.getAttribute("user");
        ViewUserFullInfoDto user =userObj instanceof ViewUserFullInfoDto ? ((ViewUserFullInfoDto) userObj) : null;
        long userId = user.getId();
        UserService.getInstance().changeUserRole(userId, newUserRole);
        resp.sendRedirect("/users");
    }
}
