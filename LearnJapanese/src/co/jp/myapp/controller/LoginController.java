package co.jp.myapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.myapp.dao.ConnectionDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		ConnectionDao con = new ConnectionDao();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String sql = "SELECT role FROM login_tbl WHERE name = ? AND password = ?";
		try{
			connection = con.connect();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);
			rs = preparedStatement.executeQuery();
			String val = "";
			if(rs.next()){
				val = rs.getString("role");
				if("0".equals(val)){
					RequestDispatcher rd = request.getRequestDispatcher("AdminMenu.jsp");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
					rd.forward(request, response);
				}
			}else{
				request.setAttribute("message", "���[�U�[�A�p�X���[�h���ԈႢ�܂����B");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
					
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
