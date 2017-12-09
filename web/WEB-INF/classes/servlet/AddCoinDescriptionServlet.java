package servlet;

import dto.CoinDescriptionAddingDto;
import service.CoinDescriptionService;
import service.CoinService;
import service.MetalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/add-coin-description", name = "AddCoinDescription")
public class AddCoinDescriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("metals", MetalService.getInstance().getAllMetals());
        req.setAttribute("coins", CoinService.getInstance().getAllCoinsId());
        getServletContext()
                .getRequestDispatcher(createViewPath("add-coin-description"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CoinDescriptionAddingDto coin = new CoinDescriptionAddingDto(
            Long.valueOf(req.getParameter("coinId")),
            Long.valueOf(req.getParameter("metalId")),
            Long.valueOf(req.getParameter("denomination")),
            Long.valueOf(req.getParameter("mintage")),
            Double.valueOf(req.getParameter("weight")),
            Double.valueOf(req.getParameter("diameter")),
            req.getParameter("imageObverse"),
            req.getParameter("imageReverse"));
        CoinDescriptionService.getInstance().addCoinDescription(coin);
    }
}
