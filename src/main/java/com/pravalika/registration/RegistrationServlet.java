package com.pravalika.registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/website_registrations?useSSL=false";
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Connection connection = DriverManager.getConnection(url,"root","Pandu12345");
			PreparedStatement pst = connection.prepareStatement("INSERT INTO registration_users(uname,upwd,uemail,umobile) VALUES(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, upwd);
			pst.setString(3, uemail);
			pst.setString(4, umobile);
			
			int rowaffected = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			
			if(rowaffected > 0) {
				request.setAttribute("status", "success");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request,response);
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
