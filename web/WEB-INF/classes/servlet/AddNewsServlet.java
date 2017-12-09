package servlet;

import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/add-news", name = "AddNews")
public class AddNewsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("add-news"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String headline = req.getParameter("headline");
        String text = req.getParameter("text");
        NewsService.getInstance().createNews(headline, text);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
