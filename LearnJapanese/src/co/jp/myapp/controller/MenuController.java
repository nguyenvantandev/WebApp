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
 * Servlet implementation class MenuController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ConnectionDao con = new ConnectionDao();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String getmax = "SELECT Max(id) max FROM news_tbl";
		String sql = "SELECT title, japanese, vietnamese FROM news_tbl WHERE id = ?";
		
	try{
		connection = con.connect();
		preparedStatement = connection.prepareStatement(getmax);
		rs = preparedStatement.executeQuery();
		int id = 0;
		if(rs.next()){
			id = rs.getInt("max");
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			if(rs.next()){
				request.setAttribute("title", rs.getString("title")+"�ɂ���");
				request.setAttribute("news", rs.getString("japanese"));
				request.setAttribute("honyakupan", rs.getString("vietnamese"));
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	request.setAttribute("actionVal", "1");
	RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
	rd.forward(request, response);
		
	}

}
