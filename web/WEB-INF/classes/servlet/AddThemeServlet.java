package servlet;

import service.CountryService;
import service.ThemeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/add-theme", name = "AddTheme")
public class AddThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countries", CountryService.getInstance().getAllCountries());
        getServletContext()
                .getRequestDispatcher(createViewPath("add-theme"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThemeService.getInstance().createNewTheme(Long.valueOf(req.getParameter("countryId")),
                req.getParameter("themeName"));
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
