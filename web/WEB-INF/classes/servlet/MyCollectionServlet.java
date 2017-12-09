package servlet;

import dto.UserSessionDto;
import service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/my-collection", name = "MyCollection")
public class MyCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSessionDto userSessionDto = (UserSessionDto) req.getSession().getAttribute("currentUser");
        req.setAttribute("countries", CountryService.getInstance().getCountriesWithAmountOfUserCoins(userSessionDto.getUserId()));
        getServletContext()
                .getRequestDispatcher(createViewPath("my-collection"))
                .forward(req, resp);
    }
}