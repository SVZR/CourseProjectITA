package servlet;

import dto.ViewCountryInfoDto;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        ViewCountryInfoDto country = CountryService.getInstance().getCountryById(id);
        req.setAttribute("country", country);
        req.setAttribute("themes", CatalogService.getInstance().getCatalogCoinsByCountry(id).getThemes()); //get themes by country_id
        req.setAttribute("series" , CatalogService.getInstance().getCatalogCoinsByCountry(id).getSeries()); //get series by theme_id
        req.setAttribute("coins", CatalogService.getInstance().getCatalogCoinsByCountry(id).getCoins()); //get coins by series_id
        getServletContext()
                .getRequestDispatcher(createViewPath("country"))
                .forward(req, resp);
    }
}
