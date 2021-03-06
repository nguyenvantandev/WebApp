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

import Value.SkillListValue;
import connectionDB.DBconnection;

/**
 * Servlet implementation class GijutsuShikakuMasterIchiran
 */
@WebServlet("/GijutsuShikakuMasterIchiran")
public class GijutsuShikakuMasterIchiran extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GijutsuShikakuMasterIchiran() {
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

		String search_id = request.getParameter("shikakuId");
		String search_name = request.getParameter("shikakumei");
		String search_seisekinashi = request.getParameter("seisekinashi");
		String search_seisekiari = request.getParameter("seisekiari");
		String search_sakujosumi = request.getParameter("sakujosumi");

		String actionName = request.getParameter("actionName");
		String actionValue = request.getParameter("actionValue");

		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<String> Val = new ArrayList<String>();

		ArrayList<SkillListValue> list = new ArrayList<SkillListValue>();

		/*
		 * 検索ボタン押下処理 ↓
		 */
		if ("検索".equals(actionName)) {
			String sql = "SELECT license_id, license_name, record_flg, del_flg FROM skill_lic_mas";
			Boolean where = false;
			if (!"".equals(search_id)) {
				where = true;
				sql += " WHERE license_id =?";
				Val.add(search_id);
			}
			if (!"".equals(search_name)) {
				if (where == false) {
					where = true;
					sql += " WHERE license_name LIKE ?";
					Val.add("%" + search_name + "%");
				} else {
					sql += " AND license_name LIKE ?";
					Val.add("%" + search_name + "%");
				}
			}
			if ("on".equals(search_seisekinashi) && !"on".equals(search_seisekiari)) {
				if (where == false) {
					where = true;
					sql += " WHERE record_flg = ?";
					Val.add("1");
				} else {
					sql += " AND record_flg = ?";
					Val.add("1");
				}
			}
			if (!"on".equals(search_seisekinashi) && "on".equals(search_seisekiari)) {
				if (where == false) {
					where = true;
					sql += " WHERE record_flg = ?";
					Val.add("0");
				} else {
					sql += " AND record_flg = ?";
					Val.add("0");
				}
			}
			if (!"on".equals(search_sakujosumi)) {
				if (where == false) {
					where = true;
					sql += " WHERE del_flg = ?";
					Val.add("0");
				} else {
					sql += " AND del_flg = ?";
					Val.add("0");
				}
			}
			sql += " ORDER BY license_id ASC";

			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				for (int i = 0; i < Val.size(); i++) {
					preparedstatement.setString(1 + i, Val.get(i));
				}
				rs = preparedstatement.executeQuery();
				int count = 1;
				while (rs.next()) {
					SkillListValue sValue = new SkillListValue();
					sValue.setNum(String.valueOf(count));
					sValue.setShikakuid(rs.getString("license_id"));
					sValue.setShikakumei(rs.getString("license_name"));
					String seiseki = rs.getString("record_flg");
					if ("1".equals(seiseki)) {
						sValue.setSeiseki("無し");
					} else {
						sValue.setSeiseki("あり");
					}
					String sakujo = rs.getString("del_flg");
					if ("1".equals(sakujo)) {
						sValue.setSakujosumi("○");
					} else {
						sValue.setSakujosumi("");
					}
					list.add(sValue);
					count = count + 1;
				}

			} catch (Exception e) {
				request.setAttribute("errorMessage", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
			request.setAttribute("hidden_shikakuId", search_id);
			request.setAttribute("hidden_shikakumei", search_name);
			request.setAttribute("hidden_seisekinashi", search_seisekinashi);
			request.setAttribute("hidden_seisekiari", search_seisekiari);
			request.setAttribute("hidden_sakujosumi", search_sakujosumi);
			if (list.size() == 0) {
				request.setAttribute("errorMessage", "検索条件に一致する資格が見つかりません。");
			}
			request.setAttribute("memberList", list);
			RequestDispatcher rd = request.getRequestDispatcher("SkillList.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 編集ボタン押下処理 ↓
		 */
		if ("編集".equals(actionName) && !"".equals(actionValue)) {
			request.setAttribute("hidden_shikakuId", search_id);
			request.setAttribute("hidden_shikakumei", search_name);
			request.setAttribute("hidden_seisekinashi", search_seisekinashi);
			request.setAttribute("hidden_seisekiari", search_seisekiari);
			request.setAttribute("hidden_sakujosumi", search_sakujosumi);
			request.setAttribute("skillListFrom_shikakuId", actionValue);
			RequestDispatcher rd = request.getRequestDispatcher("SkillListUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 新規追加ボタン押下 ↓
		 */
		if ("新規追加".equals(actionName)) {
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
		 * 削除ボタン押下処理 ↓
		 */
		if ("削除".equals(actionName) && !"".equals(actionValue)) {
			// System.out.println("Run");
			String shiyouKakunin = "SELECT COUNT(license_id) AS count FROM emp_skill_lic WHERE license_id = ?";
			String kakunin = "SELECT license_id,  del_flg FROM skill_lic_mas WHERE license_id = ? AND del_flg = ?";
			String sql = "UPDATE skill_lic_mas SET del_flg = ?, upd_date = current_timestamp WHERE license_id = ? AND del_flg = ?";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(shiyouKakunin);
				preparedstatement.setString(1, actionValue);

				rs = preparedstatement.executeQuery();
				int count = 0;
				if (rs.next()) {
					count = rs.getInt("count");
				}

				if (count != 0) {
					request.setAttribute("errorMessage", "資格IDが使用されています。削除できません。");
				} else {
					preparedstatement = connection.prepareStatement(kakunin);
					preparedstatement.setString(1, actionValue);
					preparedstatement.setString(2, "0");
					rs = preparedstatement.executeQuery();
					if (rs.next()) {
						preparedstatement = connection.prepareStatement(sql);
						preparedstatement.setString(1, "1");
						preparedstatement.setString(2, actionValue);
						preparedstatement.setString(3, "0");
						preparedstatement.executeUpdate();
						connection.commit();
					} else {
						request.setAttribute("errorMessage", "資格ID [" + actionValue + "] が見つかりません。");
					}
				}
			} catch (Exception e) {
				try {
					request.setAttribute("errorMessage", "サーバー処理で例外が発生しました。");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.setAttribute("errorMessage", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
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
	}

}
