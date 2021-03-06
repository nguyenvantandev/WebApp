package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.DBconnection;

/**
 * Servlet implementation class KeirekishoUpdate
 */
@WebServlet("/KeirekishoUpdate")
public class KeirekishoUpdate extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KeirekishoUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		/*
		 * 社員マスタ検索パラメーター
		 */
		String shain_shainId = request.getParameter("shain_shainId");
		String shain_namae = request.getParameter("shain_namae");
		String shain_sebetsu = request.getParameter("shain_sebetsu");
		String shain_sakujo = request.getParameter("shain_sakujo");
		/*
		 * 経歴書検索パラメーター
		 */
		String keireki_shainId = request.getParameter("keireki_shainId");
		String keireki_namae = request.getParameter("keireki_namae");
		String keireki_sakujocheck = request.getParameter("keireki_sakujocheck");
		String keireki_gyumumei = request.getParameter("keireki_gyumumei");
		String keireki_gyoushu = request.getParameter("keireki_gyoushu");
		String keireki_shokumunaiyou = request.getParameter("keireki_shokumunaiyou");
		String keireki_shiyougengo = request.getParameter("keireki_shiyougengo");
		String keireki_db = request.getParameter("keireki_db");
		String keireki_sonohoka = request.getParameter("keireki_sonohoka");
		String whatpage = request.getParameter("whatpage");

		String actionName = request.getParameter("actionName");
		String actionValue = request.getParameter("actionValue");
		String actionId = request.getParameter("actionId");

		/*
		 * パラメーター取得
		 */
		String start_year = request.getParameter("year");
		String start_month = request.getParameter("month");
		String start_day = request.getParameter("day");
		String start_time = start_year + "-" + start_month + "-" + start_day;

		String end_year = request.getParameter("itaru_year");
		String end_month = request.getParameter("itaru_month");
		String end_day = request.getParameter("itaru_day");
		String end_time = end_year + "-" + end_month + "-" + end_day;

		String gyoushu = request.getParameter("gyoushu");
		String gyumumei = request.getParameter("gyumumei");
		String shokumunaiyo = request.getParameter("shokumunaiyo");
		String os = request.getParameter("os");
		String shiyogengo = request.getParameter("shiyogengo");
		String db = request.getParameter("db");
		String sonohoka = request.getParameter("sonohoka");

		/*
		 * パラメーター取得
		 */
		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		/*
		 * 経歴書画面から更新ボタンを押下する場合
		 */
		if ("初期検索".equals(actionName)) {
			StringBuffer sql = new StringBuffer();
			sql.append(
					"SELECT emp_id, start_date, end_date, system_name, industry_name, progress_name, os_name, language, db_name, other");
			sql.append(" FROM emp_resume WHERE emp_id = ? AND start_date = ? AND del_flg = ?");
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql.toString());
				preparedstatement.setString(1, actionId);
				preparedstatement.setDate(2, java.sql.Date.valueOf(actionValue));
				preparedstatement.setString(3, "0");
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					request.setAttribute("shainId", rs.getString("emp_id"));

					String[] start_date = rs.getString("start_date").split("-");
					request.setAttribute("start_year", start_date[0]);
					request.setAttribute("start_month", start_date[1]);
					request.setAttribute("start_day", start_date[2]);

					String[] end_date = rs.getString("end_date").split("-");
					request.setAttribute("end_year", end_date[0]);
					request.setAttribute("end_month", end_date[1]);
					request.setAttribute("end_day", end_date[2]);

					request.setAttribute("gyumumei", rs.getString("system_name"));
					request.setAttribute("gyoushu", rs.getString("industry_name"));
					request.setAttribute("shokumunaiyo", rs.getString("progress_name"));
					request.setAttribute("os", rs.getString("os_name"));
					request.setAttribute("shiyogengo", rs.getString("language"));
					request.setAttribute("db", rs.getString("db_name"));
					request.setAttribute("sonohoka", rs.getString("other"));
				} else {
					request.setAttribute("notFindMes", "該当の経歴書情報が更新された可能性があります。再度、経歴書画面で確認してください。");

				}

			} catch (Exception e) {
				request.setAttribute("serverErrorMs", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
			/*
			 * 社員マスタ検索と経歴書検索のパラメーター
			 */
			request.setAttribute("shain_shainId", shain_shainId);
			request.setAttribute("shain_namae", shain_namae);
			request.setAttribute("shain_sebetsu", shain_sebetsu);
			request.setAttribute("shain_sakujo", shain_sakujo);

			request.setAttribute("keireki_shainId", keireki_shainId);
			request.setAttribute("keireki_namae", keireki_namae);
			request.setAttribute("keireki_sakujocheck", keireki_sakujocheck);
			request.setAttribute("keireki_gyumumei", keireki_gyumumei);
			request.setAttribute("keireki_gyoushu", keireki_gyoushu);
			request.setAttribute("keireki_shokumunaiyou", keireki_shokumunaiyou);
			request.setAttribute("keireki_shiyougengo", keireki_shiyougengo);
			request.setAttribute("keireki_db", keireki_db);
			request.setAttribute("keireki_sonohoka", keireki_sonohoka);
			request.setAttribute("whatpage", whatpage);

			request.setAttribute("actionValue", actionValue);
			RequestDispatcher rd = request.getRequestDispatcher("ResumeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 戻るボタンを押下する
		 */
		if ("戻る".equals(actionName)) {
			request.setAttribute("actionId", actionId);

			/*
			 * 社員マスタ検索と経歴書検索のパラメーター
			 */
			request.setAttribute("shain_shainId", shain_shainId);
			request.setAttribute("shain_namae", shain_namae);
			request.setAttribute("shain_sebetsu", shain_sebetsu);
			request.setAttribute("shain_sakujo", shain_sakujo);

			request.setAttribute("keireki_shainId", keireki_shainId);
			request.setAttribute("keireki_namae", keireki_namae);
			request.setAttribute("keireki_sakujocheck", keireki_sakujocheck);
			request.setAttribute("keireki_gyumumei", keireki_gyumumei);
			request.setAttribute("keireki_gyoushu", keireki_gyoushu);
			request.setAttribute("keireki_shokumunaiyou", keireki_shokumunaiyou);
			request.setAttribute("keireki_shiyougengo", keireki_shiyougengo);
			request.setAttribute("keireki_db", keireki_db);
			request.setAttribute("keireki_sonohoka", keireki_sonohoka);
			request.setAttribute("whatpage", whatpage);

			RequestDispatcher rd = request.getRequestDispatcher("Resume.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 登録ボタンを押下する
		 */
		if ("登録".equals(actionName)) {

			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO emp_resume");
			sql.append(
					" (emp_id, start_date, end_date, system_name, industry_name, progress_name, os_name, language, db_name, other, del_flg, reg_date)");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp )");
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql.toString());
				preparedstatement.setString(1, actionId);
				preparedstatement.setDate(2, java.sql.Date.valueOf(start_time));
				preparedstatement.setDate(3, java.sql.Date.valueOf(end_time));
				preparedstatement.setString(4, gyumumei);
				preparedstatement.setString(5, gyoushu);
				preparedstatement.setString(6, shokumunaiyo);
				preparedstatement.setString(7, os);
				preparedstatement.setString(8, shiyogengo);
				preparedstatement.setString(9, db);
				preparedstatement.setString(10, sonohoka);
				preparedstatement.setString(11, "0");
				preparedstatement.executeUpdate();
				connection.commit();
				request.setAttribute("completeMs", "経歴書情報の登録処理が完了しました。");
			} catch (Exception e) {
				try {
					request.setAttribute("serverErrorMs", "サーバー処理で例外が発生しました。");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.setAttribute("serverErrorMs", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
			/*
			 * 社員マスタ検索と経歴書検索のパラメーター
			 */
			request.setAttribute("shain_shainId", shain_shainId);
			request.setAttribute("shain_namae", shain_namae);
			request.setAttribute("shain_sebetsu", shain_sebetsu);
			request.setAttribute("shain_sakujo", shain_sakujo);

			request.setAttribute("keireki_shainId", keireki_shainId);
			request.setAttribute("keireki_namae", keireki_namae);
			request.setAttribute("keireki_sakujocheck", keireki_sakujocheck);
			request.setAttribute("keireki_gyumumei", keireki_gyumumei);
			request.setAttribute("keireki_gyoushu", keireki_gyoushu);
			request.setAttribute("keireki_shokumunaiyou", keireki_shokumunaiyou);
			request.setAttribute("keireki_shiyougengo", keireki_shiyougengo);
			request.setAttribute("keireki_db", keireki_db);
			request.setAttribute("keireki_sonohoka", keireki_sonohoka);
			request.setAttribute("whatpage", whatpage);

			request.setAttribute("actionId", actionId);
			request.setAttribute("actionName", "更新");
			request.setAttribute("actionValue", start_time);
			RequestDispatcher rd = request.getRequestDispatcher("ResumeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 更新ボタンを押下する
		 */
		if ("更新".equals(actionName)) {

			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE emp_resume");
			sql.append(
					" SET start_date = ?, end_date = ?, system_name = ?, industry_name = ?, progress_name = ?, os_name = ?, language = ?, db_name = ?, other = ?, upb_date = current_timestamp");
			sql.append(" WHERE emp_id = ? AND start_date = ?");
			String checkVal = "SELECT COUNT (emp_id) AS count FROM emp_resume WHERE emp_id = ? AND del_flg = ?";
			
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(checkVal);
				preparedstatement.setString(1, actionId);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				int count = 0;
				if(rs.next()){
					count = rs.getInt("count");
				}
				if(count > 0){
					preparedstatement = connection.prepareStatement(sql.toString());
					preparedstatement.setDate(1, java.sql.Date.valueOf(start_time));
					preparedstatement.setDate(2, java.sql.Date.valueOf(end_time));
					preparedstatement.setString(3, gyumumei);
					preparedstatement.setString(4, gyoushu);
					preparedstatement.setString(5, shokumunaiyo);
					preparedstatement.setString(6, os);
					preparedstatement.setString(7, shiyogengo);
					preparedstatement.setString(8, db);
					preparedstatement.setString(9, sonohoka);
					preparedstatement.setString(10, actionId);
					preparedstatement.setDate(11, java.sql.Date.valueOf(actionValue));
					preparedstatement.executeUpdate();
					connection.commit();
					request.setAttribute("completeMs", "経歴書情報の更新処理が完了しました。");
				}else{
					request.setAttribute("notFindMes", "経歴書情報が見つかりません。");
				}

			} catch (Exception e) {
				try {
					request.setAttribute("serverErrorMs", "サーバー処理で例外が発生しました。");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.setAttribute("serverErrorMs", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
			/*
			 * 社員マスタ検索と経歴書検索のパラメーター
			 */
			request.setAttribute("shain_shainId", shain_shainId);
			request.setAttribute("shain_namae", shain_namae);
			request.setAttribute("shain_sebetsu", shain_sebetsu);
			request.setAttribute("shain_sakujo", shain_sakujo);

			request.setAttribute("keireki_shainId", keireki_shainId);
			request.setAttribute("keireki_namae", keireki_namae);
			request.setAttribute("keireki_sakujocheck", keireki_sakujocheck);
			request.setAttribute("keireki_gyumumei", keireki_gyumumei);
			request.setAttribute("keireki_gyoushu", keireki_gyoushu);
			request.setAttribute("keireki_shokumunaiyou", keireki_shokumunaiyou);
			request.setAttribute("keireki_shiyougengo", keireki_shiyougengo);
			request.setAttribute("keireki_db", keireki_db);
			request.setAttribute("keireki_sonohoka", keireki_sonohoka);
			request.setAttribute("whatpage", whatpage);

			request.setAttribute("actionId", actionId);
			request.setAttribute("actionName", "更新");
			request.setAttribute("actionValue", start_time);
			RequestDispatcher rd = request.getRequestDispatcher("ResumeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
