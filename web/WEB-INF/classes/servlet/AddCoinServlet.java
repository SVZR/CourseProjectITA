package servlet;

import dao.SeriesDao;
import dao.ThemeDao;
import service.CountryService;
import service.MetalService;
import service.SeriesService;
import service.ThemeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet("/add-coin")
public class AddCoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countries", CountryService.getInstance().getAllCountries());
        req.setAttribute("themes", ThemeService.getInstance().getAllThemes());
        req.setAttribute("series", SeriesService.getInstance().getAllSeries());
        req.setAttribute("metals", MetalService.getInstance().getAllMetals());

        getServletContext()
                .getRequestDispatcher(createViewPath("add-coin"))
                .forward(req, resp);
    }
}
