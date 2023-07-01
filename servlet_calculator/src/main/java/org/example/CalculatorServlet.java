package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WebServlet("접근시 사용할 URL")
 * 어노테이션 방신으로 클라이언트 접근을 허용
 */
@WebServlet("/calculate")

/**
 * HttpServlet : 추상 메소드
 * 필요한 것만 오버라이딩
 * Get, Post, put, delete 등 중 필요한 것만 오버라이딩 해서 사용
 */
public class CalculatorServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // GET 요청이 있을 때 자동으로 호출
        logger.info("service");  // 클라이언트의 요청이 있을 때마다 매번 서블릿 컨테이너가 자동으로 실행
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }
}
