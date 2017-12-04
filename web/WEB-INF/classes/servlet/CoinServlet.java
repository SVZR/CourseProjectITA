package servlet;

import service.CoinDescriptionService;
import service.CoinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet("/coin")
public class CoinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long coinId = Long.valueOf(req.getParameter("id"));
        req.setAttribute("coin", CoinService.getInstance().getCoinFullInfo(coinId));
        req.setAttribute("coinDescription", CoinDescriptionService.getInstance().getAllCoinDescriptionsByCoinId(coinId));
        getServletContext()
                .getRequestDispatcher(createViewPath("coin"))
                .forward(req, resp);
    }
}
