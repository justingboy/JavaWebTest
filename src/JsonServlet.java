import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by wanglin on 2018/8/30.
 */
public class JsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");


        /**
         * 接收json
         */
        BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) req.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer("");
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        br.close();
        System.out.println(sb.toString());


        /**
         * 返回json
         */
        // 转成数据流
        InputStream is = new ByteArrayInputStream("{\"name\":\"账单\"}".getBytes("utf-8"));
        // 输出到画面
        ServletOutputStream op = resp.getOutputStream();
        int len;
        byte[] buff = new byte[4096];
        while ((len = is.read(buff)) != -1) {
            op.write(buff, 0, len);
        }
        op.flush();
    }
}
