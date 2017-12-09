package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/all-users", name = "AllUsers")
public class AllUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", UserService.getInstance().getAllUsers());
        getServletContext()
                .getRequestDispatcher(createViewPath("all-users"))
                .forward(req, resp);
    }
}
