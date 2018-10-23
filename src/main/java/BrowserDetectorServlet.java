import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BrowserDetectorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String useragent = request.getHeader("User-Agent");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        writer.println("<h2>" + useragent + "</h2>");
        String browser = "none";
        if (useragent.contains("Firefox")) {
            browser = "Firefox";
        } else if (useragent.contains("OPR")) {
            browser = "Opera";
        } else if (useragent.contains("Safari")) {
            if (useragent.contains("Chrome")) {
                browser = "Chrome";
            } else browser = "Safari";
        }
        writer.println("<h2>Your browser is: " + browser + "</h2>");

        writer.println("</html>");
    }
}
