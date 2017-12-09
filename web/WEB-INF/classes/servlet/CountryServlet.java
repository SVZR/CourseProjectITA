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

@WebServlet(urlPatterns = "/country", name = "CountryServlet")
public class CountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long countryId = Long.valueOf(req.getParameter("id"));
        ViewCountryInfoDto country = CountryService.getInstance().getCountryById(countryId);
        req.setAttribute("country", country);
        req.setAttribute("themes", CatalogService.getInstance().getCatalogCoinsByCountry(countryId).getThemes());
        req.setAttribute("series" , CatalogService.getInstance().getCatalogCoinsByCountry(countryId).getSeries());
        req.setAttribute("coins", CatalogService.getInstance().getCatalogCoinsByCountry(countryId).getCoins());
        getServletContext()
                .getRequestDispatcher(createViewPath("country"))
                .forward(req, resp);
    }
}
