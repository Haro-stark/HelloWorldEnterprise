package com.example.helloworldenterprise;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    {

    }
    public void init() {


//        try{
//            Connection connection = (Connection) getServletContext().getAttribute("connection");
//            Statement statement = connection.createStatement();
//            statement.execute("CREATE TABLE Persons (\n" +
//                    "    PeopleID int,\n" +
//                    "    LastName varchar(255),\n" +
//                    "    FirstName varchar(255),\n" +
//                    "    Address varchar(255),\n" +
//                    "    City varchar(255)\n" +
//                    ");");
//            System.out.println("query executed successfully...");
//
//
//        }catch (SQLException e){
//            System.out.println("error in sql:\n"+e.getMessage());
//        }
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // Hello
        PrintWriter out = response.getWriter();


        try {
            out.println("<html><body>");
            System.out.println("calling.........");
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");

            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><tr>");
            while (rs.next())
            {
                String id = rs.getString("userID");
                String name = rs.getString("userName");
                int salary = rs.getInt("sal");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + salary + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            System.out.println("query executed successfully...");
            DatabaseConnection.endConnection(connection);
        }
        catch(SQLException e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }

        System.out.println("congratss....");



        response.setContentType("text/html");

    }

    public void destroy() {
    }
}