package cn.web.Servlet.Servlet_first;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/Servlet1")
public class Servlet_first implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException{

    }

    @Override
    public ServletConfig getServletConfig(){
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello cpu_code Servlet3.0");
    }

    @Override
    public String getServletInfo(){
        return null;
    }

    @Override
    public void destroy(){

    }
}
