import bean.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class OnMyPermissionServlet extends HttpServlet {


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
        String body = sb.toString();
        System.out.println(body);
        if (!body.equals("")) {
            Gson gson = new Gson();
            Person person = gson.fromJson(body, Person.class);
            System.out.println("name =" + person.getName());
            System.out.println("age =" + person.getAge());
        }

        /**
         * 返回json
         */
        // 转成数据流
        InputStream is = new ByteArrayInputStream("{\"code\":1,\"message\":\"成功\",\"body\":{\"userId\":\"a95a87de-fc75-47ee-8250-7d16170f81e4\",\"name\":\"乐无异\",\"enterpriseName\":\"了不起的企业\",\"productName\":\"了不起的产品\",\"versionName\":\"了不起的版本\",\"permissions\":[\"customer:read\",\"customer:write\",\"job:read\",\"job:write\",\"work:read\",\"work:write\",\"task:read\",\"task:read\",\"contact:read\",\"contact:write\"]}}\n".getBytes("utf-8"));
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
