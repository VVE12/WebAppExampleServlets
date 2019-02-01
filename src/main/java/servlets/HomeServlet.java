package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    // in the case of a GET request, you should simply give the home page.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }

    // processing a request that should change the color of the header.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the request parameter.
        String color = req.getParameter("color");
        // create a cookie with this value.
        Cookie colorCookie = new Cookie("color", color);
        // put in response.
        resp.addCookie(colorCookie);
        // redirect the user back to the home page.
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
