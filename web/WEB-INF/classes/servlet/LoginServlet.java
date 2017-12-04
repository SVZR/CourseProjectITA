package servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().getAttribute("userID");
        getServletContext()
                .getRequestDispatcher(createViewPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputEmail = req.getParameter("inputEmail");
        String inputPassword = req.getParameter("inputPassword");
        long userId = UserService.getInstance().isUserExist(inputEmail, inputPassword);
        if (userId != -1) {
            req.getSession().setAttribute("userId", userId);
            resp.sendRedirect("/index");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
