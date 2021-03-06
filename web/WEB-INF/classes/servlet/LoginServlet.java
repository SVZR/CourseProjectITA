package servlet;

import dto.UserSessionDto;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/login", name = "Login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputEmail = req.getParameter("useremail");
        String inputPassword = req.getParameter("userpassword");
        UserSessionDto userSessionDto = UserService.getInstance().getUserSessionInfo(inputEmail, inputPassword);
        if (userSessionDto != null) {
            req.getSession().setAttribute("currentUser", userSessionDto);
            req.getSession().setAttribute("currentUserRole", userSessionDto.getUserRole());
            resp.sendRedirect("/index");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
