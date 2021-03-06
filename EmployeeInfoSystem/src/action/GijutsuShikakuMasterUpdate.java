package action;

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

import connectionDB.DBconnection;

/**
 * Servlet implementation class GijutsuShikakuMasterUpdate
 */
@WebServlet("/GijutsuShikakuMasterUpdate")
public class GijutsuShikakuMasterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GijutsuShikakuMasterUpdate() {
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

		String shikakuId = request.getParameter("shikakuId");
		String shikakumei = request.getParameter("shikakumei");
		String seiseki = request.getParameter("seiseki");

		String skillListFrom_shikakuId = request.getParameter("skillListFrom_shikakuId");
		String search_id = request.getParameter("hidden_shikakuId");
		String search_name = request.getParameter("hidden_shikakumei");
		String search_seisekinashi = request.getParameter("hidden_seisekinashi");
		String search_seisekiari = request.getParameter("hidden_seisekiari");
		String search_sakujosumi = request.getParameter("hidden_sakujosumi");

		String actionValue = request.getParameter("actionValue");
		String actionName = request.getParameter("actionName");

		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		/*
		 * 初期表示 ↓
		 */
		if ("初期表示".equals(actionName)) {
			String sql = "SELECT license_id, license_name, record_flg FROM skill_lic_mas WHERE license_id = ? AND del_flg = ?";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setString(1, skillListFrom_shikakuId);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					request.setAttribute("shikakuId", rs.getString("license_id"));
					request.setAttribute("shikakumei", rs.getString("license_name"));
					request.setAttribute("sex", rs.getString("record_flg"));
				} else {
					request.setAttribute("errorMessage", "該当の資格情報が更新された可能性があります。再度、技術資格マスタ一覧画面で確認してください。");
				}
			} catch (Exception e) {
				request.setAttribute("serverErrorMessage", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
			request.setAttribute("buttonChange", "1");
			request.setAttribute("hidden_shikakuId", search_id);
			request.setAttribute("hidden_shikakumei", search_name);
			request.setAttribute("hidden_seisekinashi", search_seisekinashi);
			request.setAttribute("hidden_seisekiari", search_seisekiari);
			request.setAttribute("hidden_sakujosumi", search_sakujosumi);
			RequestDispatcher rd = request.getRequestDispatcher("SkillListUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 戻るボタン押下 処理時、エラーが発生する場合 ↓
		 */
		if ("戻る".equals(actionName) || "エラー".equals(actionName)) {
			request.setAttribute("hidden_shikakuId", search_id);
			request.setAttribute("hidden_shikakumei", search_name);
			request.setAttribute("hidden_seisekinashi", search_seisekinashi);
			request.setAttribute("hidden_seisekiari", search_seisekiari);
			request.setAttribute("hidden_sakujosumi", search_sakujosumi);
			request.setAttribute("saikensaku", "再検索");
			RequestDispatcher rd = request.getRequestDispatcher("SkillList.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 登録ボタン押下する ↓
		 * 
		 */
		if ("登録".equals(actionName)) {
			String sql = "INSERT INTO skill_lic_mas (license_id, license_name, record_flg, del_flg, reg_date) VALUES (?, ?,?,?,current_timestamp)";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setString(1, shikakuId);
				preparedstatement.setString(2, shikakumei);
				if ("あり".equals(seiseki)) {
					preparedstatement.setString(3, "0");
				} else {
					preparedstatement.setString(3, "1");
				}
				preparedstatement.setString(4, "0");
				preparedstatement.executeUpdate();
				connection.commit();
			} catch (Exception e) {
				try {
					request.setAttribute("serverErrorMessage", "サーバー処理で例外が発生しました。");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.setAttribute("serverErrorMessage", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
			request.setAttribute("completeMessage", "資格情報の登録処理が完了しました。");
			request.setAttribute("skillListFrom_shikakuId", shikakuId);
			request.setAttribute("hidden_shikakuId", search_id);
			request.setAttribute("hidden_shikakumei", search_name);
			request.setAttribute("hidden_seisekinashi", search_seisekinashi);
			request.setAttribute("hidden_seisekiari", search_seisekiari);
			request.setAttribute("hidden_sakujosumi", search_sakujosumi);
			RequestDispatcher rd = request.getRequestDispatcher("SkillListUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 更新ボタン押下 ↓
		 * 
		 */
		if ("更新".equals(actionName)) {
			String check = "SELECT license_id FROM skill_lic_mas WHERE license_id = ? AND del_flg = ?";
			String sql = "UPDATE skill_lic_mas SET license_name = ?, record_flg = ?, upd_date = current_timestamp WHERE license_id = ? AND del_flg = ?";

			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(check);
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					preparedstatement = connection.prepareStatement(sql);
					preparedstatement.setString(1, shikakumei);
					if ("あり".equals(seiseki)) {
						preparedstatement.setString(2, "0");
					} else {
						preparedstatement.setString(2, "1");
					}
					preparedstatement.setString(3, actionValue);
					preparedstatement.setString(4, "0");
					preparedstatement.executeUpdate();
					connection.commit();
					request.setAttribute("completeMessage", "資格情報の更新処理が完了しました。");
				} else {
					request.setAttribute("errorMessage", "資格ID [" + actionValue + "] が見つかりません。");
				}

			} catch (Exception e) {
				try {
					request.setAttribute("serverErrorMessage", "サーバー処理で例外が発生しました。");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.setAttribute("serverErrorMessage", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}

			request.setAttribute("skillListFrom_shikakuId", actionValue);
			request.setAttribute("hidden_shikakuId", search_id);
			request.setAttribute("hidden_shikakumei", search_name);
			request.setAttribute("hidden_seisekinashi", search_seisekinashi);
			request.setAttribute("hidden_seisekiari", search_seisekiari);
			request.setAttribute("hidden_sakujosumi", search_sakujosumi);
			RequestDispatcher rd = request.getRequestDispatcher("SkillListUpdate.jsp");
			rd.forward(request, response);
			return;
		}

	}

}
