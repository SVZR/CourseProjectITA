package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;


@WebServlet(urlPatterns = "/logout", name = "Logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("currentUser");
        req.getSession().removeAttribute("currentUserRole");
        getServletContext()
                .getRequestDispatcher(createViewPath("login"))
                .forward(req, resp);

    }
}
