import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Set;

public class HTMLServlet extends HttpServlet {

    private String message;

    public HTMLServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        message = "执行Servlet初始化方法: init()";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String str = request.getContextPath();
        String str1 = request.getQueryString();
        String str2 = request.getRequestURI();
        String str3 = request.getServletPath();
        String str4 = request.getContentType();
        String method=request.getMethod();
        String [] strings= request.getParameterValues("a");
        Enumeration<String> enumeration= request.getParameterNames();
        String  parameterNames="";
        while (enumeration.hasMoreElements())
        {
            parameterNames+=enumeration.nextElement()+'、';
        }
        String title = "使用 GET 方法读取表单数据";
        String name = request.getParameter("name");
        String url = request.getParameter("url");
        out.println(
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名</b>："
                + name + "\n" +
                "  <li><b>网址名</b>："
                + url+ "\n" +
                "  <li><b>请求方法</b>："
                + parameterNames+ "\n" +
                "</ul>\n" +

                "</body>" + "</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");    //设置响应的字符集格式为UTF-8
        response.setContentType("text/html");  //设置响应正文的MIME类型
        PrintWriter out = response.getWriter();    //返回一个PrintWriter对象，Servlet使用它来输出字符串形式的正文数据
        //以下为输出的HTML正文数据
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>动态生成的HTML文档</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("    <table border='0' align='center'>");
        out.println("            <tr><td bgcolor='skyblue'colspan=2>动态生成HTML文档</td></tr>");
        out.println("     </table>");
        out.println("<h3>" + message + "</h3>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }


}
