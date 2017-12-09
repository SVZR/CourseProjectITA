package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/administration", name = "Administration")
public class AdministrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("administration"))
                .forward(req, resp);
    }
}
