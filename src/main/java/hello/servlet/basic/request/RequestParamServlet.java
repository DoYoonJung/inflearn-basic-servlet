package hello.servlet.basic.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8080//request-param?username=hello&age=20
//GET 메소드 방식으로 파라미터를 포함하여 보낼때 어떻게 처리하는 지 알려주는 페이지
@WebServlet(name="requestParamServlet", urlPatterns="/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회 - start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        //request.getParameter(paramName) 이게 약간 value 값 출력 느낌, paramName이 key고


        System.out.println("[전체 파라미터 조회 - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        //http://localhost:8080//request-param?username=hello&age=20&username=hello2
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
        response.getWriter().write("ok");

    }
}
