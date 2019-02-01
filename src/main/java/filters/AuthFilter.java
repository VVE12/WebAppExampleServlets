package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/home")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    // the input filter receives a request, a response, as well as a chain of filters to which the request should be sent further
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        // perform Servlet request-response transformation into HTTP request-response.
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        // see if there is a session for this request (the presence of a cookie with the name JSESSIONID is checked.
        HttpSession session = request.getSession(false);

        // if the session was not, or the session has no user attribute, redirect the user to the page with login.
        if (session == null || session.getAttribute("user") == null) {
            servletRequest.getServletContext().getRequestDispatcher("/login").forward(request, response);
        }
        // give the request further to the filter chain.
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
