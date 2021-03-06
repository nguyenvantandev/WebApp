package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionDB.DBconnection;

/**
 * Servlet implementation class ShainMasterUpdate
 */
@WebServlet("/ShainMasterUpdate")
public class ShainMasterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShainMasterUpdate() {
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

		String shainNum = request.getParameter("shainNum");
		String shainId_search = request.getParameter("shainId_search");
		String namae_search = request.getParameter("namae_search");
		String sebetsu_search = request.getParameter("sebetsu_search");
		String sakujo_search = request.getParameter("sakujo_search");
		String conditionVal = request.getParameter("conditionVal");

		String namae = request.getParameter("namae");
		String furigane = request.getParameter("furigana");
		String inisharu = request.getParameter("inisharu");
		String sebetsu = request.getParameter("sebetsu");
		String birth_year = request.getParameter("year");
		String birth_month = request.getParameter("month");
		String birth_day = request.getParameter("day");
		String saiyorieki = request.getParameter("saiyorieki");
		String jusho = request.getParameter("jusho");
		String jikopr = request.getParameter("jikopr");

		/*
		 * 初期表示 社員ID取得できた場合 開始
		 */
		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		if ("初期表示".equals(conditionVal)) {
			String sql = "SELECT emp_id, name, name_kana, name_ini, sex, birth_date, near_station, address, self_pr FROM emp_mas WHERE emp_id = ? AND del_flg = ?";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setString(1, shainNum);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					request.setAttribute("shainId", rs.getString("emp_id"));
					request.setAttribute("namae", rs.getString("name"));
					request.setAttribute("furigana", rs.getString("name_kana"));
					request.setAttribute("inisharu", rs.getString("name_ini"));
					request.setAttribute("selcect_sex", rs.getString("sex"));
					String[] birthday = rs.getString("birth_date").split("-");
					request.setAttribute("birth_year", birthday[0]);
					request.setAttribute("birth_month", birthday[1]);
					request.setAttribute("birth_day", birthday[2]);
					request.setAttribute("saiyorieki", rs.getString("near_station"));
					request.setAttribute("jusho", rs.getString("address"));
					request.setAttribute("jikopr", rs.getString("self_pr"));
				} else {
					request.setAttribute("notFindMes", "該当の社員情報が更新された可能性があります。再度、社員マスタ検索画面で確認してください。");
				}
			} catch (Exception e) {
				request.setAttribute("serverErrorMs", "サーバー処理で例外が発生しました。");
				e.printStackTrace();
			}
			request.setAttribute("shainId_search", shainId_search);
			request.setAttribute("namae_search", namae_search);
			request.setAttribute("sebetsu_search", sebetsu_search);
			request.setAttribute("sakujo_search", sakujo_search);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 初期表示 社員ID取得できた場合 終了
		 */

		/*
		 * 初期表示 社員ID取得できない場合 「戻る」ボタンを押下する場合 社員マスタ検索画面に戻る 開始
		 */
		if ("検索画面".equals(conditionVal) || "戻る".equals(conditionVal)) {
			request.setAttribute("id", shainId_search);
			request.setAttribute("name", namae_search);
			request.setAttribute("sex", sebetsu_search);
			if ("on".equals(sakujo_search)) {
				request.setAttribute("del", "1");
			} else {
				request.setAttribute("del", sakujo_search);
			}
			request.setAttribute("sakujoButton", "検索");
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeSearch.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 初期表示 社員ID取得できない場合 「戻る」ボタンを押下する場合 社員マスタ検索画面に戻る 終了
		 */

		/*
		 * 「登録/更新」ボタンを押下する処理 開始
		 */
		if ("登録/更新".equals(conditionVal)) {
			String birthday = birth_year + "-" + birth_month + "-" + birth_day;

			String checkId = "SELECT COUNT(emp_id) AS count FROM emp_mas WHERE emp_id = ?";
			String insertInfo = "INSERT INTO emp_mas (emp_id, name, name_kana, name_ini, sex, birth_date, near_station, address, self_pr, del_flg, reg_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, current_timestamp)";
			String updateInfo = "UPDATE emp_mas SET name = ?, name_kana = ?, name_ini = ?, sex = ?, birth_date = ?, near_station = ?, address = ?, self_pr = ?, upd_date = current_timestamp WHERE emp_id = ? AND del_flg = ?";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(checkId);
				preparedstatement.setString(1, shainNum);
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					String count = rs.getString("count");
					Timestamp formatday = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(birthday).getTime());
					if ("0".equals(count)) {
						preparedstatement = connection.prepareStatement(insertInfo);
						preparedstatement.setString(1, shainNum);
						preparedstatement.setString(2, namae);
						preparedstatement.setString(3, furigane);
						preparedstatement.setString(4, inisharu);
						preparedstatement.setString(5, sebetsu);
						preparedstatement.setTimestamp(6, formatday);
						preparedstatement.setString(7, saiyorieki);
						preparedstatement.setString(8, jusho);
						preparedstatement.setString(9, jikopr);
						preparedstatement.setString(10, "0");
						preparedstatement.executeUpdate();
						connection.commit();
					}
					if ("1".equals(count)) {
						preparedstatement = connection.prepareStatement(updateInfo);
						preparedstatement.setString(1, namae);
						preparedstatement.setString(2, furigane);
						preparedstatement.setString(3, inisharu);
						preparedstatement.setString(4, sebetsu);
						preparedstatement.setTimestamp(5, formatday);
						preparedstatement.setString(6, saiyorieki);
						preparedstatement.setString(7, jusho);
						preparedstatement.setString(8, jikopr);
						preparedstatement.setString(9, shainNum);
						preparedstatement.setString(10, "0");
						preparedstatement.executeUpdate();
						connection.commit();
					}
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
			request.setAttribute("shaiNum", shainNum);
			request.setAttribute("shainId_search", shainId_search);
			request.setAttribute("namae_search", namae_search);
			request.setAttribute("sebetsu_search", sebetsu_search);
			request.setAttribute("sakujo_search", sakujo_search);
			request.setAttribute("completeMs", "社員情報の登録/更新処理が完了しました。");
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * 「登録/更新」ボタンを押下する処理 終了
		 */
	}

}
