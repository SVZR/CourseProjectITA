package servlet;

import dto.CreateNewUserDto;
import entity.UserRole;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ServletUtil.createViewPath;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(createViewPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("password").equals(req.getParameter("confirmPassword"))) {
            System.out.println(req.getParameter("login") + " - " + req.getParameter("password") + " - " + req.getParameter("email"));
            Long createdUserId = UserService.getInstance().createNewUser(createHeroDto(req));
        } else {
            System.out.println("pass != confpass");
        }
        resp.sendRedirect("/registration"/* + createdUserId*/);
    }
    private CreateNewUserDto createHeroDto(HttpServletRequest request) {
        return new CreateNewUserDto(request.getParameter("login"), request.getParameter("password"),
                request.getParameter("email"), UserRole.USER);
    }
}
