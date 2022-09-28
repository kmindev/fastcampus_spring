package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WebServlet("접근시 사용할 URL")
 * 어노테이션 방신으로 클라이언트 접근을 허용
 */
@WebServlet("/calculate")

public class CalculatorServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("init");   // 서블릿이 최초로 호출되었을 때 서블릿 컨테이너가 자동 실행, 서블릿 객체가 생성된 후, 한번만 실행(초기화 작업 담당)
        this.servletConfig = servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        logger.info("service");  // 클라이언트의 요청이 있을 때마다 매번 서블릿 컨테이너가 자동으로 실행
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

    @Override
    public void destroy() {
        // resource release : 자원 해제
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
