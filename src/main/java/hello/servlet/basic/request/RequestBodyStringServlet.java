package hello.servlet.basic.request;


import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//http Api 방법, 메세지 바디에 직접 원하는 메시지를 첨가하여 요청하는 방법

@WebServlet(name="requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream(); // body 내용을 바이트 코드로 저장
        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 바이트 코드를 문자로 변환하는 코드

        System.out.println("message = " + message);

        response.getWriter().write("ok");

    }
}
