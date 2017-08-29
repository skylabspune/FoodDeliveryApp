package com.userinfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jadhavrao.connection.DbConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.getWriter().append("Served at: LOGIN SERVLET").append(request.getContextPath());
		PreparedStatement ps=null;
		ResultSet rs=null;
		String loginquery="select * from register where email=? and password=?";
		Connection con=null;

		try {

			String vemail=request.getParameter("email");
			String vpassword=request.getParameter("password");
			con=DbConnection.getdbconnection();
			ps=con.prepareStatement(loginquery);
			ps.setString(1,vemail);
			ps.setString(2,vpassword);


			System.out.println("printing request parameters");
			System.out.println("---------------------------");
			System.out.println(vemail);
			System.out.println(vpassword);
			System.out.println("---------------------------");
			rs=ps.executeQuery();
			int flag=0;
				while(rs.next()){

					System.out.println("printing db colums ");
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));

					System.out.println("---------------------------");
					System.out.println(rs.getString("email"));
					System.out.println(rs.getString("password"));
					
					System.out.println("---------------------------");
					
					if(vemail.equals(rs.getString(2)) && vpassword.equals(rs.getString(3))){
						flag=1;
						System.out.println("Login sucessful");
						RequestDispatcher rd=request.getRequestDispatcher("/Menu");
						rd.forward(request, response);
					
						break;
					}
					else{
						
						if(flag==0){
							System.out.println("Login failed");
						}
							
						
						
				}
					
		}
			
			
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
	}

}
