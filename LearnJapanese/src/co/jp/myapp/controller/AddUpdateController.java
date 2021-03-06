package co.jp.myapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.jp.myapp.dao.ConnectionDao;

/**
 * Servlet implementation class AddUpdateController
 */
@WebServlet("/AddUpdateController")
public class AddUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String actionStatus = request.getParameter("actionStatus");
		String kotobaid = request.getParameter("kotobaid");

		String kotoba = request.getParameter("kotoba");
		String hiragana = request.getParameter("hiragana");
		String imi = request.getParameter("imi");
		String hinshi = request.getParameter("hinshi");
		String[] level = request.getParameter("level").split("");
		String reibun = request.getParameter("reibun");

		ConnectionDao con = new ConnectionDao();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		if ("追加".equals(actionStatus)) {
			String seqID = "SELECT nextval('id_seq') AS id";
			String sql = "INSERT INTO language_list (id, word, hiragana, meaning, sort, ex, level) VALUES (?, ?, ?, ?, ?, ?, ?)";
			int id = 0;
			try {
				connection = con.connect();
				preparedStatement = connection.prepareStatement(seqID);
				rs = preparedStatement.executeQuery();
				if (rs.next()) {
					id = rs.getInt("id");
				}
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, kotoba);
				preparedStatement.setString(3, hiragana);
				preparedStatement.setString(4, imi);
				preparedStatement.setString(5, hinshi);
				preparedStatement.setString(6, reibun);
				preparedStatement.setString(7, level[1]);
				preparedStatement.executeUpdate();
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("kotoba", kotoba);
			request.setAttribute("hiragana", hiragana);
			request.setAttribute("imi", imi);
			request.setAttribute("hinshi", hinshi);
			request.setAttribute("level", level[0] + level[1]);
			request.setAttribute("reibun", reibun);
			request.setAttribute("kotobaid", id);
			RequestDispatcher rd = request.getRequestDispatcher("AddUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 
		 */
		if ("更新".equals(actionStatus)) {
			String sql = "UPDATE language_list SET word = ?, hiragana = ?, meaning = ?, sort = ?, ex = ?, level = ? WHERE id = ?";
			try {
				connection = con.connect();
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, kotoba);
				preparedStatement.setString(2, hiragana);
				preparedStatement.setString(3, imi);
				preparedStatement.setString(4, hinshi);
				preparedStatement.setString(5, reibun);
				preparedStatement.setString(6, level[1]);
				preparedStatement.setInt(7, Integer.parseInt(kotobaid));
				preparedStatement.executeUpdate();
				connection.commit();
			} catch (Exception e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			request.setAttribute("kotoba", kotoba);
			request.setAttribute("hiragana", hiragana);
			request.setAttribute("imi", imi);
			request.setAttribute("hinshi", hinshi);
			request.setAttribute("level", level[0] + level[1]);
			request.setAttribute("kotobaid", kotobaid);
			request.setAttribute("reibun", reibun);
			RequestDispatcher rd = request.getRequestDispatcher("AddUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		if ("戻る".equals(actionStatus)) {
			request.setAttribute("kanji", session.getAttribute("searchKanji"));
			request.setAttribute("hiragana", session.getAttribute("searchHiragana"));
			request.setAttribute("imi", session.getAttribute("searchImi"));
			request.setAttribute("level", session.getAttribute("searchLevel"));
			request.setAttribute("actionStatus", "検索");
			RequestDispatcher rd = request.getRequestDispatcher("Goi.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
