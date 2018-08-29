import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeaderServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型

//        response.sendError(404, "Need authentication!!!" );
        //1. 重定向的第一种方式：
//        response.sendRedirect("https://www.baidu.com/");

        //2. 重定向的第二种方式：
        response.setStatus(response.SC_MOVED_PERMANENTLY);
        response.setHeader("Location","https://github.com/Tencent/mars#mars_cn");



//        response.setContentType("text/html;charset=UTF-8");
//
//        PrintWriter out = response.getWriter();
//        String title = "HTTP Header 数据列表";
//        String docType =
//                "<!DOCTYPE html> \n";
//        out.println(docType +
//                "<html>\n" +
//                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
//                "<body bgcolor=\"#f0f0f0\">\n" +
//                "<h1 align=\"center\">" + title + "</h1>\n" +
//                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
//                "<tr bgcolor=\"#949494\">\n" +
//                "<th>Header 名称</th><th>Header 值</th>\n"+
//                "</tr>\n");
//
//        Enumeration headerNames = request.getHeaderNames();
//
//        while(headerNames.hasMoreElements()) {
//            String paramName = (String)headerNames.nextElement();
//            out.print("<tr><td>" + paramName + "</td>\n");
//            String paramValue = request.getHeader(paramName);
//            out.println("<td> " + paramValue + "</td></tr>\n");
//        }
//        out.println("</table>\n</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
