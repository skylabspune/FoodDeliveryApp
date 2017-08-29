package com.userinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jadhavrao.connection.DbConnection;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside get method");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=null;
		String registerquery="insert into register(fname,lname,mobile,address,email,password)values(?,?,?,?,?,?)";
		
		int result=0;
		String ufname=request.getParameter("fname");
		String ulname=request.getParameter("lname");
		String umobile=request.getParameter("mobile");
		String uaddress=request.getParameter("address");
		String uemail=request.getParameter("email");
		String upassword=request.getParameter("password");
		
		System.out.println(ufname);
		System.out.println(ulname);
		System.out.println(umobile);
		System.out.println(uaddress);
		System.out.println(uemail);
		System.out.println(upassword);
		
	
		con=DbConnection.getdbconnection();
	
			try {
				ps=con.prepareStatement(registerquery);
				ps.setString(1,ufname);
				ps.setString(2, ulname);
				ps.setString(3, umobile);
				ps.setString(4, uaddress);
				ps.setString(5, uemail);
				ps.setString(6, upassword);

				result=ps.executeUpdate();
				
				
				if(result!=0){
			
					System.out.println("Registeration data insert success..");
				}
				
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		System.out.println("inside Post method");
	}

}
