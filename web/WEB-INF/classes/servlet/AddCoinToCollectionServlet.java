package servlet;

import dto.UserSessionDto;
import service.MyCollectionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-coin-to-collection", name = "AddCoinToCollection")
public class AddCoinToCollectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSessionDto userSessionDto = (UserSessionDto) req.getSession().getAttribute("currentUser");
        long amount = Long.valueOf(req.getParameter("coinAmount"));
        System.out.println(amount);
        long coinDescriptionId = Long.valueOf(req.getParameter("coinDescriptionId"));
        System.out.println(coinDescriptionId);
        if (amount >= 0) {
            MyCollectionService.getInstance().addCoinToCellection(userSessionDto.getUserId(), coinDescriptionId, amount);
        } else {
            req.setAttribute("error", "INVALID COIN AMOUNT ENTERED");
            req.setAttribute("errorCoinId", coinDescriptionId);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
