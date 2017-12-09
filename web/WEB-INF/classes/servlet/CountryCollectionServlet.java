package servlet;

import dto.UserSessionDto;
import entity.MyCollection;
import service.CatalogService;
import service.CountryService;
import service.MyCollectionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/country-collection", name = "CountryCollection")
public class CountryCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long countryId = Long.valueOf(req.getParameter("id"));
        long userId = ((UserSessionDto) req.getSession().getAttribute("currentUser")).getUserId();
        req.setAttribute("country", CountryService.getInstance().getCountryById(countryId));
        req.setAttribute("themes", MyCollectionService.getInstance().getThemesInCollectionByUserId(userId, countryId));
        req.setAttribute("series" , MyCollectionService.getInstance().getSeriesInCollectionByUserId(userId, countryId));
        req.setAttribute("coins", MyCollectionService.getInstance().getCoinsInCollectionByUserId(userId, countryId));
        getServletContext()
                .getRequestDispatcher(createViewPath("country-collection"))
                .forward(req, resp);
    }
}
