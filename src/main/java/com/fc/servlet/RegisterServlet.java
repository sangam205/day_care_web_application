package com.fc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fc.util.JDBCUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ChildAndWorkerRegistrationServlet", urlPatterns = "/register",
          initParams = {	 @WebInitParam(name="adminName", value="naysha"),
            		         @WebInitParam(name="adminEmail", value = "naysha@gmail.com")
                       })

public class RegisterServlet extends HttpServlet{
	
	@Override
	public void init() {
		System.out.println("---- RegisterServlet init() ----");
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("---- RegisterServlet service() ----");
		
		//Get the input data submitted by user
		String angelName=request.getParameter("name");
		String angelFatherName=request.getParameter("father_name");
		String angelMotherName=request.getParameter("mother_name");
		String angelGuardianName=request.getParameter("guardian_name");
		String angelMobile=request.getParameter("mobile");
		String angelGuardianMobile=request.getParameter("guardian_mobile");
		String angelEmail=request.getParameter("email");
		String angelDOB=request.getParameter("dob");
		String angelGender=request.getParameter("gender");
		String angelJoin=request.getParameter("joining_period");
		String[] angelApply=request.getParameterValues("applying_for");
		String angelAddress=request.getParameter("address");
		String angelPswrd=request.getParameter("password");
		
		
		

        
	
		//Print input data to Console
		System.out.println("Name: "+angelName);
		System.out.println("Father Name: "+angelFatherName);
		System.out.println("Mother Name: "+angelMotherName);
		System.out.println("Guardian Name: "+angelGuardianName);
		System.out.println("Mobile: "+angelMobile);
		System.out.println("Guardian Mobile: "+angelGuardianMobile);
		System.out.println("Email: "+angelEmail);
		
		System.out.println("DOB: "+angelDOB);
		System.out.println("Gender: "+angelGender);
		System.out.println("Joining Period: "+angelJoin);
		System.out.println("Address: "+angelAddress);
		System.out.println("Password: "+angelPswrd);
		String apply="";
		for(String data: angelApply) {
			apply=apply.concat(data).concat(" ");
		
			System.out.println("Applying For: "+data);
		}
		

		
		try {
			Connection con = JDBCUtils.getMySQLConnection(getServletContext());
			String query = "insert into littleangels values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		    PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,angelName);
			pst.setString(2,angelFatherName);
			pst.setString(3,angelMotherName);
			pst.setString(4,angelGuardianName);
			pst.setLong(5, Long.parseLong(angelMobile));
			pst.setLong(6, Long.parseLong(angelGuardianMobile));
			pst.setString(7,angelEmail);
			
			
			pst.setString(8, angelDOB);
			
			pst.setString(9, angelGender);
			pst.setString(10,angelJoin);
			pst.setString(11, apply);
			pst.setString(12, angelAddress);
			pst.setString(13, angelPswrd);
			
			pst.execute();
			
			PrintWriter pw = response.getWriter();
			pw.print("Registered Successfully.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException | ServletException e) {
			
			e.printStackTrace();
			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.print("System Error: Encountered some error. Try after sometime.");
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("---- RegisterServlet destroy() ----");
	}

}

