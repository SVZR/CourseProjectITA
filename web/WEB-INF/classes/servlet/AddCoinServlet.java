package servlet;

import dto.ViewCoinForAddingDto;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/add-coin", name = "AddCoin")
public class AddCoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("series", SeriesService.getInstance().getAllSeries());
        getServletContext()
                .getRequestDispatcher(createViewPath("add-coin"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewCoinForAddingDto dto = new ViewCoinForAddingDto(
        Long.valueOf(req.getParameter("seriesId")),
        req.getParameter("coinName"),
                LocalDate.parse(req.getParameter("releaseDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
        req.getParameter("designer"),
        req.getParameter("mintedBy"),
        req.getParameter("descriptionObverse"),
        req.getParameter("descriptionReverse"));
        CoinService.getInstance().addCoin(dto);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
