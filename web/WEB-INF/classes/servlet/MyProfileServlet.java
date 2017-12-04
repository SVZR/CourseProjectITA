package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/my-profile")
public class MyProfileServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userEmail = String.valueOf(req.getSession().getAttribute("currentUser"));
        if (req.getSession().isNew()) {
            long userId = UserService.getInstance().getUserLoginInfo(userEmail).getId();

        }
    }
}
