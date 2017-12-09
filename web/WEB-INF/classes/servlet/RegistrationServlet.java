package servlet;

import dto.CreateNewUserDto;
import dto.UserSessionDto;
import entity.UserRole;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet(urlPatterns = "/registration", name = "Registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = UserService.getInstance().createNewUser(createHeroDto(req));
        if (userId > 0) {
            System.out.println(userId);
            resp.sendRedirect("/login");
        } else {
            req.setAttribute("problem", "Something wrong");
            resp.sendRedirect("/registration");
        }
    }
    private CreateNewUserDto createHeroDto(HttpServletRequest request) {
        return new CreateNewUserDto(request.getParameter("login"), request.getParameter("password"),
                request.getParameter("email"), UserRole.USER);
    }
}
