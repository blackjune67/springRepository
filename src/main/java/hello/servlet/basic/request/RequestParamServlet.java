package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---- 전체 request 조회 START ---- ");
//        Enumeration<String> parameterNames = req.getParameterNames();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));
        System.out.println("---- 전체 request 조회 END ---- ");

        System.out.println("[단일파라미터 조회]");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("[중복파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        Arrays.stream(usernames).forEach(dd -> System.out.println(">>> " + dd));
//        for (String s : usernames) {
//            System.out.println("s = " + s);
//        }
        resp.getWriter().write("ok");
    }
}
