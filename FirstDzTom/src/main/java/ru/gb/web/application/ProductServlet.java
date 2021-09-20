package ru.gb.web.application;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        message = "Hello, First Servlet333!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();
        Product [] product=new Product[9];
        for(int i=0;i<=9;i++) {
            product[i]=new Product(i,i,i);
            out.println("<html><body>");
            out.println("<h1>"+"Cost-" + product[i].getCost()+"Title-" +product[i].getTitle()+"Id-"+product[i].getId() + "</h1>");
            out.println("</body></html>");
        }
    }

    @Override
    public void destroy() {
    }
}
