package ru.kulsha.persist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        this.productRepository.insert(new Product("TV", 300000));
        this.productRepository.insert(new Product("Fridge", 120000));
        this.productRepository.insert(new Product("Microwave Oven", 20560));
        this.productRepository.insert(new Product("Vacuum Cleaner", 35600));
        this.productRepository.insert(new Product("Iron", 5200));
        this.productRepository.insert(new Product("Laptop", 89999));
        this.productRepository.insert(new Product("iPhone", 65300));
        this.productRepository.insert(new Product("Headphones", 2650));
        this.productRepository.insert(new Product("E-book", 12300));
        this.productRepository.insert(new Product("Coffee machine", 39900));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th>Id</th>");
        writer.println("<th>ProductName</th>");
        writer.println("<th>Cost</th>");
        writer.println("</tr>");

        for (Product product : productRepository.findAll()) {
            writer.println("<tr>");

            writer.println("<td>" + product.getId() + "</td>");
            writer.println("<td>" + product.getProductName() + "</td>");
            writer.println("<td>" + product.getCost() + "</td>");

            writer.println("</tr>");
        }
        writer.println("</table>");
    }
}
