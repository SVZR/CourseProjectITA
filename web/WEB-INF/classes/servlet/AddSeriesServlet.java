package servlet;

import dao.ThemeDao;
import service.SeriesService;
import service.ThemeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/add-series", name = "AddSeries")
public class AddSeriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("themes", ThemeService.getInstance().getAllThemes());
        getServletContext()
                .getRequestDispatcher(createViewPath("add-series"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SeriesService.getInstance().addSeries(req.getParameter("seiesName"),
                Long.valueOf(req.getParameter("themeId")));
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
