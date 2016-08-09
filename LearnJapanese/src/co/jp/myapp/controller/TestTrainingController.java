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
import co.jp.myapp.model.TestTrainingVal;

@WebServlet("/TestTrainingController")

public class TestTrainingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestTrainingController() {
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

		String level = request.getParameter("levelchoosed");
		String item = request.getParameter("itemchoosed");

		ConnectionDao con = new ConnectionDao();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<TestTrainingVal> list = new ArrayList<TestTrainingVal>();

		String sql = "SELECT id, test_content, question, anwser_1, anwser_2, anwser_3, anwser_4, result_anwser, result_question FROM test_tbl WHERE test_level = ? AND item = ? ORDER BY id ASC";
		try {
			connection = con.connect();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, level);
			preparedStatement.setString(2, item);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TestTrainingVal val = new TestTrainingVal();
				val.setId(resultSet.getString("id"));
				val.setContent(resultSet.getString("test_content"));
				val.setQuestion(resultSet.getString("question"));
				val.setAnwser1(resultSet.getString("anwser_1"));
				val.setAnwser2(resultSet.getString("anwser_2"));
				val.setAnwser3(resultSet.getString("anwser_3"));
				val.setAnwser4(resultSet.getString("anwser_4"));
				val.setResultAnwser(resultSet.getString("result_anwser"));
				val.setResultQuestion(resultSet.getString("result_question"));
				list.add(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("showpage", "1");
		request.setAttribute("levelchoosed", level);
		request.setAttribute("itemchoosed", item);
		request.setAttribute("testform", list);
		RequestDispatcher rd = request.getRequestDispatcher("TestTraining.jsp");
		rd.forward(request, response);
	}

}
