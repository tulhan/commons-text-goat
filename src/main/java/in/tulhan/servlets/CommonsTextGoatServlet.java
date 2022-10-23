package in.tulhan.servlets;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringSubstitutor;

@WebServlet("/api")
public class CommonsTextGoatServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        StringSubstitutor ss = StringSubstitutor.createInterpolator();
        String param = request.getParameter("cmd");
        String template = "${" + param + "}";
        String output = ss.replace(template);
        response.getWriter().println(output);
    }

}
