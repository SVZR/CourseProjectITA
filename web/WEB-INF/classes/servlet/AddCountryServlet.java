package servlet;

import dto.CreateNewCountryDto;
import service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/add-country", name = "AddCountry")
public class AddCountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("add-country"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewCountryDto createNewCountryDto = new CreateNewCountryDto();
        createNewCountryDto.setName(req.getParameter("countryName"));
        CountryService.getInstance().createNewCountry(createNewCountryDto);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
