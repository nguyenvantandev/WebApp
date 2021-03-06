package action;

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
import Value.SearchValue;
import connectionDB.DBconnection;

/**
 * Servlet implementation class KeirekishoKensaku
 */
@WebServlet("/KeirekishoKensaku")
public class KeirekishoKensaku extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KeirekishoKensaku() {
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

		String shainId = request.getParameter("shainId");
		String namae = request.getParameter("namae");
		String sakujoCheck = request.getParameter("sakujocheck");
		String gyumuMei = request.getParameter("gyumumei");
		String gyouShu = request.getParameter("gyoushu");
		String shokumunaiyou = request.getParameter("shokumunaiyou");
		String shiyougengo = request.getParameter("shiyougengo");
		String db = request.getParameter("db");
		String sonohoka = request.getParameter("sonohoka");

		String actionName = request.getParameter("actionName");
		String actionValue = request.getParameter("actionValue");

		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<String> val = new ArrayList<String>();
		ArrayList<SearchValue> lresult = new ArrayList<SearchValue>();
		/*
		 * 検索ボタン押下処理
		 */
		if ("検索".equals(actionName)) {
			StringBuffer sql = new StringBuffer();
			sql.append(
					"SELECT DISTINCT mas.emp_id, mas.name, mas.sex, extract(year from age(current_timestamp,mas.birth_date))AS age,");
			sql.append(
					" extract(year from age(current_timestamp,mas.work_start_date))AS workage, mas.near_station, mas.del_flg");
			sql.append(" FROM emp_mas AS mas");
			sql.append(" LEFT JOIN emp_resume AS resume");
			sql.append(" ON mas.emp_id = resume.emp_id");
			Boolean where = false;
			if (!"".equals(shainId)) {
				where = true;
				sql.append(" WHERE mas.emp_id = ?");
				val.add(shainId);
			}
			if (!"".equals(namae)) {
				if (where == false) {
					where = true;
					sql.append(" WHERE mas.name = ?");
					val.add(namae);
				} else {
					sql.append(" AND mas.name = ?");
					val.add(namae);
				}
			}
			if (!"".equals(gyumuMei)) {
				if (where == false) {
					where = true;
					sql.append(" WHERE resume.system_name LIKE ?");
					val.add("%" + gyumuMei + "%");
				} else {
					sql.append(" AND resume.system_name LIKE ?");
					val.add("%" + gyumuMei + "%");
				}
			}
			if (!"".equals(gyouShu)) {
				if (where == false) {
					where = true;
					sql.append(" WHERE resume.industry_name LIKE ?");
					val.add("%" + gyouShu + "%");
				} else {
					sql.append(" AND resume.industry_name LIKE ?");
					val.add("%" + gyouShu + "%");
				}
			}
			if (!"".equals(shokumunaiyou)) {
				if (where == false) {
					where = true;
					sql.append(" WHERE resume.progress_name LIKE ?");
					val.add("%" + shokumunaiyou + "%");
				} else {
					sql.append(" AND resume.progress_name LIKE ?");
					val.add("%" + shokumunaiyou + "%");
				}
			}
			if (!"".equals(shiyougengo)) {
				if (where == false) {
					where = true;
					sql.append(" WHERE resume.language LIKE ?");
					val.add("%" + shiyougengo + "%");
				} else {
					sql.append(" AND resume.language LIKE ?");
					val.add("%" + shiyougengo + "%");
				}
			}
			if (!"".equals(db)) {
				if (where == false) {
					where = true;
					sql.append(" WHERE resume.db_name LIKE ?");
					val.add("%" + db + "%");
				} else {
					sql.append(" AND resume.db_name LIKE ?");
					val.add("%" + db + "%");
				}
			}
			if (!"".equals(sonohoka)) {
				if (where == false) {
					where = true;
					sql.append(" WHERE resume.other LIKE ?");
					val.add("%" + sonohoka + "%");
				} else {
					sql.append(" AND resume.other LIKE ?");
					val.add("%" + sonohoka + "%");
				}
			}
			if (sakujoCheck == null) {
				if (where == false) {
					where = true;
					sql.append(" WHERE mas.del_flg = ?");
					val.add("0");
				} else {
					sql.append(" AND mas.del_flg = ?");
					val.add("0");
				}
			}
			sql.append(" ORDER BY mas.emp_id ASC");
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql.toString());
				for (int i = 0; i < val.size(); i++) {
					preparedstatement.setString(1 + i, val.get(i));

				}
				rs = preparedstatement.executeQuery();
				int count = 1;
				while (rs.next()) {
					SearchValue sValue = new SearchValue();
					sValue.setNum(String.valueOf(count));
					sValue.setShainid(rs.getString("emp_id"));
					sValue.setNamae(rs.getString("name"));
					sValue.setSebetsu(rs.getString("sex"));
					sValue.setNenrei(rs.getString("age"));
					sValue.setKeikennensuu(rs.getString("workage"));
					sValue.setSaiyorieki(rs.getString("near_station"));
					String delete = rs.getString("del_flg");
					if ("0".equals(delete)) {
						sValue.setSakujosumi("");
					} else if ("1".equals(delete)) {
						sValue.setSakujosumi("○");
					}
					lresult.add(sValue);
					count = count + 1;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("shainId", shainId);
			request.setAttribute("namae", namae);
			request.setAttribute("hidden_sakujocheck", sakujoCheck);
			request.setAttribute("gyumumei", gyumuMei);
			request.setAttribute("gyoushu", gyouShu);
			request.setAttribute("shokumunaiyou", shokumunaiyou);
			request.setAttribute("shiyougengo", shiyougengo);
			request.setAttribute("db", db);
			request.setAttribute("sonohoka", sonohoka);

			request.setAttribute("memberList", lresult);
			int ValNum = lresult.size();
			request.setAttribute("count", ValNum);
			RequestDispatcher rd = request.getRequestDispatcher("ResumeSearch.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 詳細ボタン押下処理
		 */
		if ("詳細".equals(actionName)) {
			request.setAttribute("actionId", actionValue);
			request.setAttribute("keireki_shainId", shainId);
			request.setAttribute("keireki_namae", namae);
			request.setAttribute("keireki_sakujocheck", sakujoCheck);
			request.setAttribute("keireki_gyumumei", gyumuMei);
			request.setAttribute("keireki_gyoushu", gyouShu);
			request.setAttribute("keireki_shokumunaiyou", shokumunaiyou);
			request.setAttribute("keireki_shiyougengo", shiyougengo);
			request.setAttribute("keireki_db", db);
			request.setAttribute("keireki_sonohoka", sonohoka);
			request.setAttribute("whatpage", "経歴書検索");
			RequestDispatcher rd = request.getRequestDispatcher("Resume.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
