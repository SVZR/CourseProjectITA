package servlet;

import dto.UserSessionDto;
import service.CoinDescriptionService;
import service.CoinService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/coin-in-collection", name = "CoinInCollection")
public class CoinInCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long coinId = Long.valueOf(req.getParameter("id"));
        req.setAttribute("coin", CoinService.getInstance().getCoinFullInfo(coinId));
        req.setAttribute("coinDescription", CoinDescriptionService.getInstance().getAllCoinDescriptionsByCoinId(coinId));
        if (req.getSession().getAttribute("currentUser") != null) {
            UserSessionDto userSessionDto = (UserSessionDto) req.getSession().getAttribute("currentUser");
            req.setAttribute("coinsInCollection", CoinDescriptionService.getInstance()
                    .getAmountCoinInCollectionByCoinId(coinId, userSessionDto.getUserId()));
        }

        getServletContext()
                .getRequestDispatcher(createViewPath("coin-in-collection"))
                .forward(req, resp);
    }
}
