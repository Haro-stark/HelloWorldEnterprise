package com.example.helloworldenterprise;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userInfo", value = "/user-info")
public class UserInfo extends HttpServlet {
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<User> userList = new ArrayList<User>();


        try {
            System.out.println("calling.........");
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");

            while (rs.next())
            {
                User user = new User();
                user.setUserId(rs.getString("userID"));
                user.setUserName(rs.getString("userName"));
                user.setSalary(rs.getInt("sal"));
                userList.add(user);
            }


            for (User u: userList) {
                System.out.println("id: "+u.getUserId()+"\nname: "+u.getUserName());

            }

            System.out.println("query executed successfully...");
            DatabaseConnection.endConnection(connection);
        }
        catch(SQLException e) {
            System.out.println("SQLException caught: " +e.getMessage());
        }

        request.setAttribute("userList", userList);
        RequestDispatcher rd = request.getRequestDispatcher("user-display.jsp");
        rd.forward(request, response);

        System.out.println("congratss....");

        response.setContentType("text/html");

    }

    public void destroy() {
    }
}