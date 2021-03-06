package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Value.ResumeValue;
import connectionDB.DBconnection;

/**
 * Servlet implementation class Keirekisho
 */
@WebServlet("/Keirekisho")
public class Keirekisho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Keirekisho() {
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
		/*
		 * 処理使用パラメーター
		 */
		String actionId = request.getParameter("actionId");
		String whatpage = request.getParameter("whatpage");
		String actionName = request.getParameter("actionName");
		String actionValue = request.getParameter("actionValue");

		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<ResumeValue> listVal = new ArrayList<ResumeValue>();
		if ("初期検索".equals(actionName)) {
			StringBuffer sql = new StringBuffer();
			sql.append(
					"SELECT resume.emp_id, mas.name, resume.start_date, resume.end_date, resume.system_name, resume.industry_name, resume.progress_name, resume.os_name, resume.language, resume.db_name, resume.other");
			sql.append(" FROM emp_resume AS resume");
			sql.append(" LEFT JOIN emp_mas AS mas");
			sql.append(" ON resume.emp_id = mas.emp_id");
			sql.append(" WHERE resume.emp_id = ? AND resume.del_flg = ?");
			sql.append(" ORDER BY resume.start_date");

			String shainName = "SELECT name FROM emp_mas WHERE emp_id = ? AND del_flg = ?";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql.toString());
				preparedstatement.setString(1, actionId);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				int count = 1;
				while (rs.next()) {
					ResumeValue val = new ResumeValue();
					val.setNum(String.valueOf(count));
					val.setStartdate(rs.getString("start_date"));
					val.setEnddate(rs.getString("end_date"));
					val.setSystemname(rs.getString("system_name"));
					val.setIndustryname(rs.getString("industry_name"));
					val.setProgressname(rs.getString("progress_name"));
					val.setOsname(rs.getString("os_name"));
					val.setLanguage(rs.getString("language"));
					val.setDbname(rs.getString("db_name"));
					val.setOther(rs.getString("other"));
					listVal.add(val);
					count = count + 1;
				}
				preparedstatement = connection.prepareStatement(shainName);
				preparedstatement.setString(1, actionId);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					request.setAttribute("namae", rs.getString("name"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("shainId", actionId);
			request.setAttribute("memberList", listVal);
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
		 * 戻るボタン押下処理
		 */
		if ("戻る".equals(actionName)) {
			if ("社員検索".equals(whatpage)) {
				request.setAttribute("id", shain_shainId);
				request.setAttribute("name", shain_namae);
				request.setAttribute("sex", shain_sebetsu);
				if ("on".equals(shain_sakujo)) {
					request.setAttribute("del", "1");
				} else {
					request.setAttribute("del", shain_sakujo);
				}
				request.setAttribute("sakujoButton", "検索");
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeSearch.jsp");
				rd.forward(request, response);
				return;

			}
			if ("経歴書検索".equals(whatpage)) {
				request.setAttribute("shainId", keireki_shainId);
				request.setAttribute("namae", keireki_namae);
				request.setAttribute("hidden_sakujocheck", keireki_sakujocheck);
				request.setAttribute("gyumumei", keireki_gyumumei);
				request.setAttribute("gyoushu", keireki_gyoushu);
				request.setAttribute("shokumunaiyou", keireki_shokumunaiyou);
				request.setAttribute("shiyougengo", keireki_shiyougengo);
				request.setAttribute("db", keireki_db);
				request.setAttribute("sonohoka", keireki_sonohoka);
				request.setAttribute("actionName", "再検索");
				RequestDispatcher rd = request.getRequestDispatcher("ResumeSearch.jsp");
				rd.forward(request, response);
				return;
			}

		}
		/*
		 * 新規追加ボタン押下処理
		 */
		if ("新規追加".equals(actionName)) {
			request.setAttribute("actionName", actionName);
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

			RequestDispatcher rd = request.getRequestDispatcher("ResumeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 更新ボタン押下処理
		 */
		if ("更新".equals(actionName)) {
			request.setAttribute("actionName", actionName);
			request.setAttribute("actionValue", actionValue);
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

			RequestDispatcher rd = request.getRequestDispatcher("ResumeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 削除ボタン押下処理
		 */
		if ("削除".equals(actionName)) {
			String searchsql = "SELECT emp_id FROM emp_resume WHERE emp_id = ? AND start_date = ? AND del_flg = ?";
			String sql = "UPDATE emp_resume SET del_flg = ?, upb_date = current_timestamp WHERE emp_id = ? AND start_date = ? AND del_flg = ?";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(searchsql);
				preparedstatement.setString(1, actionId);
				preparedstatement.setDate(2, java.sql.Date.valueOf(actionValue));
				preparedstatement.setString(3, "0");
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					preparedstatement = connection.prepareStatement(sql);
					preparedstatement.setString(1, "1");
					preparedstatement.setString(2, actionId);
					preparedstatement.setDate(3, java.sql.Date.valueOf(actionValue));
					preparedstatement.setString(4, "0");
					preparedstatement.executeUpdate();
					connection.commit();
					request.setAttribute("completeMs", "経歴書情報の削除処理が完了しました。");
				} else {
					request.setAttribute("notFindMes", "経歴書情報が見つかりません。");
				}
			} catch (Exception e) {
				try {
					connection.rollback();
					request.setAttribute("serverErrorMs", "サーバー処理で例外が発生しました。");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
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
			RequestDispatcher rd = request.getRequestDispatcher("Resume.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
