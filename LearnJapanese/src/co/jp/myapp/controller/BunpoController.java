package co.jp.myapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.jp.myapp.dao.ConnectionDao;
import co.jp.myapp.model.BunpoVal;

@WebServlet("/BunpoController")
public class BunpoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BunpoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String actionId = request.getParameter("actionId");
		String bunposearch = request.getParameter("bunposearch");
		String level = request.getParameter("level");
		String other = request.getParameter("other");

		ConnectionDao con = new ConnectionDao();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<BunpoVal> list = new ArrayList<BunpoVal>();

		if ("0001".equals(actionId)) {
			String sql = "SELECT grammar, syntax, meaning, example, b_comment, b_note, b_level, b_group FROM bunpou WHERE b_group = ? ORDER BY b_level DESC";
			if(!"".equals(bunposearch)){
				sql = "SELECT grammar, syntax, meaning, example, b_comment, b_note, b_level, b_group FROM bunpou WHERE b_group = ? AND grammar LIKE ? ORDER BY b_level DESC";
			}
			if(!"".equals(level)){
				sql = "SELECT grammar, syntax, meaning, example, b_comment, b_note, b_level, b_group FROM bunpou WHERE b_group = ? AND b_level = ? ORDER BY b_level DESC";
			}
			if(!"".equals(other)){
				sql = "SELECT grammar, syntax, meaning, example, b_comment, b_note, b_level, b_group FROM bunpou WHERE b_group = ? ORDER BY b_level DESC";
			}
			try {
				connection = con.connect();
				preparedStatement = connection.prepareStatement(sql);
				
				if(!"".equals(bunposearch)){
					preparedStatement.setString(1, "0");
					preparedStatement.setString(2, "%"+bunposearch+"%");
				}
				if(!"".equals(level)){
					preparedStatement.setString(1, "0");
					preparedStatement.setString(2, level);
				}
				if(!"".equals(other)){
					preparedStatement.setString(1, other);
				}else{
					preparedStatement.setString(1, "0");
				}
				
				rs = preparedStatement.executeQuery();
				int count = 1;
				while (rs.next()) {
					BunpoVal val = new BunpoVal();
					val.setGrammar(count + ". " + rs.getString("grammar"));
					val.setMeaning(rs.getString("meaning"));
					val.setSyntax(rs.getString("syntax"));
					val.setExample(rs.getString("example"));
					val.setComment(rs.getString("b_comment"));
					val.setNote(rs.getString("b_note"));
					list.add(val);
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("Valshow", list);
		request.setAttribute("loadAction", "1");
		RequestDispatcher rd = request.getRequestDispatcher("Bunpo.jsp");
		rd.forward(request, response);
	}
}
