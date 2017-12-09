package servlet;

import service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete-news", name = "DeleteNews")
public class DeleteNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService.getInstance().deleteNews(Long.valueOf(req.getParameter("deleteNews")));
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
