package servlet;

import dto.UserSessionDto;
import service.MyCollectionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-coin-to-collection")
public class AddCoinToCollectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserSessionDto userSessionDto = (UserSessionDto) req.getSession().getAttribute("currentUser");
        long amount = Long.valueOf(req.getParameter("coinAmount"));
        long coinDescriptionId = Long.valueOf(req.getParameter("coinDescriptionId"));
        System.out.println("addcoinservlet");
        MyCollectionService.getInstance().addCoinToCellection(userSessionDto.getUserId(), coinDescriptionId, amount);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
