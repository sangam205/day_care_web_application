package com.fc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fc.util.JDBCUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name = "ChildAndWorkerLoginServlet", urlPatterns = "/login")

public class LoginServlet extends HttpServlet{
	

	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("---- LoginServlet service() ----");
		
		//Get the input data submitted by user
		String userName=request.getParameter("username");
		String password=request.getParameter("pswrd");
		
		System.out.println("User: "+ userName);
		System.out.println("Password: "+ password);
		
		//Get the context parameters
				ServletContext context = getServletContext();
				try {
					Connection connection=JDBCUtils.getMySQLConnection(context);
					String searchQuery = "select name, password from littleangels where mobile = ?";
					PreparedStatement statement = connection.prepareStatement(searchQuery);
					statement.setLong(1,Long.parseLong(userName));
					ResultSet resultSet = statement.executeQuery();
					
					int count = 0;
					String pswrd=null;
					while(resultSet.next()) {
						++count;
					//	String name=resultSet.getString(1);
						pswrd=resultSet.getString(2);
						
					}
					
					if(count==1) {
						if(pswrd!=null && password.equals(pswrd)) {
						    RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.html");
						    dispatcher.forward(request, response);
						}  else {
							RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
							dispatcher.forward(request, response);
						}
					} else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
						dispatcher.forward(request, response);
					}
					
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					response.setContentType("text/html");
					PrintWriter pw = response.getWriter();
					pw.print("System Error: Encountered some error. Try after sometime.");
					
				}
				
	}
	
}
