import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        addCookie(request, response);
        readCookie(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //创建Cookie
    private void addCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //创建Cookie
        Cookie cookie1 = new Cookie("name", "hxx");
        Cookie cookie2 = new Cookie("password", "123456");
        cookie1.setMaxAge(60*5);
        cookie2.setMaxAge(60*5);
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        //设置响应内容的类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "设置 Cookie 实例";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名：</b>："
                + request.getParameter("name") + "\n</li>" +
                "  <li><b>站点 URL：</b>："
                + request.getParameter("password") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");
    }


    //读取Cookie
    private void readCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        // 获取与该域相关的 Cookie 的数组
        cookies = request.getCookies();

        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Delete Cookie Example";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        if (cookies != null) {
            out.println("<h2>Cookie 名称和值</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if ((cookie.getName()).compareTo("name") == 0) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    out.print("已删除的 cookie：" +
                        cookie.getName() + "<br/>");
            }
                out.print("名称：" + cookie.getName() + "，");
                out.print("值：" + URLDecoder.decode(cookie.getValue(), "utf-8") + " <br/>");
            }
        } else {
            out.println(
                    "<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
