package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Value.LisenceNameList;
import Value.SkillValue;
import connectionDB.DBconnection;

/**
 * Servlet implementation class GijutsuShikakuUpdate
 */
@WebServlet("/GijutsuShikakuUpdate")
public class GijutsuShikakuUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GijutsuShikakuUpdate() {
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

		String shainId_search = request.getParameter("shainId_search");
		String namae_search = request.getParameter("namae_search");
		String sebetsu_search = request.getParameter("sebetsu_search");
		String sakujo_search = request.getParameter("sakujo_search");

		String actionName = request.getParameter("actionName");
		String actionValue = request.getParameter("actionValue");
		String licenseId = request.getParameter("licenseID");

		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<SkillValue> list = new ArrayList<SkillValue>();
		ArrayList<LisenceNameList> licenseLst = new ArrayList<LisenceNameList>();

		if ("�����\��".equals(actionName)) {
			/*
			 * ��������
			 */
			StringBuffer sql = new StringBuffer();
			sql.append(
					"SELECT emp_mas.emp_id, emp_mas.name, emp_skill_lic.license_id, emp_skill_lic.get_date, emp_skill_lic.record, emp_skill_lic.disp_order, skill_lic_mas.license_name");
			sql.append(" FROM emp_mas");
			sql.append(" RIGHT JOIN emp_skill_lic ON emp_mas.emp_id = emp_skill_lic.emp_id");
			sql.append(" LEFT JOIN skill_lic_mas ON emp_skill_lic.license_id = skill_lic_mas.license_id");
			sql.append(" WHERE emp_mas.emp_id = ? AND emp_mas.del_flg = ?");
			sql.append(" ORDER BY emp_skill_lic.disp_order, emp_skill_lic.teg_date ASC");
			/*
			 * �\����
			 */
			String displayOrder = "SELECT MAX(disp_order) AS count FROM emp_skill_lic WHERE emp_id = ?";
			/*
			 * ���i�����X�g�擾
			 */
			StringBuffer licenseVal = new StringBuffer();
			licenseVal.append("SELECT skill_lic_mas.license_name, skill_lic_mas.record_flg, skill_lic_mas.license_id FROM skill_lic_mas");
			licenseVal.append(" LEFT JOIN emp_skill_lic");
			licenseVal.append(" ON skill_lic_mas.license_id = emp_skill_lic.license_id AND emp_skill_lic.emp_id = ?");
			licenseVal.append(" WHERE emp_skill_lic.license_id IS NULL");
			licenseVal.append(" AND skill_lic_mas.del_flg = ?");

			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql.toString());
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, "0");

				rs = preparedstatement.executeQuery();
				Boolean have = false;

				while (rs.next()) {
					have = true;
					SkillValue sVal = new SkillValue();
					request.setAttribute("shainId", rs.getString("emp_id"));
					request.setAttribute("namae", rs.getString("name"));
					sVal.setNum(rs.getString("disp_order"));
					sVal.setShikakuid(rs.getString("license_id"));
					sVal.setNamae(rs.getString("license_name"));
					sVal.setShutokuday(rs.getString("get_date"));
					String seiseki = rs.getString("record");
					if (seiseki == null || "".equals(seiseki)) {
						sVal.setSeiseki("��");
					} else {
						sVal.setSeiseki(rs.getString("record"));
					}
					list.add(sVal);

				}

				if (have == true) {
					preparedstatement = connection.prepareStatement(displayOrder);
					preparedstatement.setString(1, actionValue);
					rs = preparedstatement.executeQuery();
					if (rs.next()) {
						request.setAttribute("hyoujijun_count", Integer.parseInt(rs.getString("count")) + 1);
					}
				}

				if (have == false) {
					String sqlempmas = "SELECT emp_id, name FROM emp_mas WHERE emp_id = ? AND del_flg = ?";
					preparedstatement = connection.prepareStatement(sqlempmas);
					preparedstatement.setString(1, actionValue);
					preparedstatement.setString(2, "0");
					rs = preparedstatement.executeQuery();
					if (rs.next()) {
						request.setAttribute("shainId", rs.getString("emp_id"));
						request.setAttribute("namae", rs.getString("name"));
					}
				}
				/*
				 * ���i�����X�g
				 */
				preparedstatement = connection.prepareStatement(licenseVal.toString());
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				while (rs.next()) {
					LisenceNameList sVal = new LisenceNameList();
					sVal.setInfo(rs.getString("license_name"));
					sVal.setRecord(rs.getString("record_flg"));
					sVal.setLicenseid(rs.getString("license_id"));
					licenseLst.add(sVal);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("ColectionList", licenseLst);
			request.setAttribute("memberList", list);
			request.setAttribute("shainId_search", shainId_search);
			request.setAttribute("namae_search", namae_search);
			request.setAttribute("sebetsu_search", sebetsu_search);
			request.setAttribute("sakujo_search", sakujo_search);
			RequestDispatcher rd = request.getRequestDispatcher("SkillUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �߂�{�^������
		 * 
		 */
		if ("�߂�".equals(actionName) || "�G���[".equals(actionName)) {
			request.setAttribute("id", shainId_search);
			request.setAttribute("name", namae_search);
			request.setAttribute("sex", sebetsu_search);
			if ("on".equals(sakujo_search)) {
				request.setAttribute("del", "1");
			} else {
				request.setAttribute("del", sakujo_search);
			}
			request.setAttribute("sakujoButton", "����");
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeSearch.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �X�V�{�^������
		 *
		 */
		if ("�X�V".equals(actionName)) {
			String year = request.getParameter("upd_year");
			String month = request.getParameter("upd_month");
			String day = request.getParameter("upd_day");
			String seiseki = request.getParameter("upd_seiseki");
			String hyojijun = request.getParameter("upd_houjijun");
			String shutokudate = year + "-" + month + "-" + day;
			String sql = "UPDATE emp_skill_lic SET get_date = ?, record = ?, disp_order = ?, upd_date = current_timestamp WHERE emp_id = ? AND license_id = ?";
			String dispSearch = "SELECT license_id, disp_order FROM emp_skill_lic WHERE  emp_id = ? AND license_id != ? order by disp_order ASC";
			String dispUpd = "UPDATE emp_skill_lic SET disp_order = ?, upd_date = current_timestamp WHERE emp_id = ? AND license_id = ?";
			try {
				Timestamp formatday = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(shutokudate).getTime());
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setTimestamp(1, formatday);
				if (seiseki == null) {
					preparedstatement.setString(2, "");
				} else {
					preparedstatement.setString(2, seiseki);
				}

				preparedstatement.setInt(3, Integer.parseInt(hyojijun));
				preparedstatement.setString(4, actionValue);
				preparedstatement.setString(5, licenseId);
				preparedstatement.executeUpdate();

				/*
				 * �\�����X�V ��
				 */
				String junbanUpd = request.getParameter("junbanUpd");
				preparedstatement = connection.prepareStatement(dispSearch);
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, licenseId);
				rs = preparedstatement.executeQuery();
				ArrayList<String> licenseid = new ArrayList<String>();
				ArrayList<Integer> dispOrder = new ArrayList<Integer>();
				while (rs.next()) {
					licenseid.add(rs.getString("license_id"));
					dispOrder.add(rs.getInt("disp_order"));
				}
				int num = Integer.parseInt(hyojijun) + 1;
				int num2 = Integer.parseInt(junbanUpd);
				for (int i = 0; i < dispOrder.size(); i++) {
					if (Integer.parseInt(hyojijun) < Integer.parseInt(junbanUpd)) {
						if (dispOrder.get(i) >= Integer.parseInt(hyojijun)
								&& dispOrder.get(i) <= Integer.parseInt(junbanUpd)) {

							for (int j = i; j <= i; j++) {
								dispOrder.set(j, num);
							}
							num += 1;
						}
					}
					if (Integer.parseInt(hyojijun) > Integer.parseInt(junbanUpd)) {
						if (dispOrder.get(i) <= Integer.parseInt(hyojijun)
								&& dispOrder.get(i) >= Integer.parseInt(junbanUpd)) {
							for (int j = i; j <= i; j++) {
								dispOrder.set(j, num2);
							}
							num2 += 1;
						}
					}

				}
				preparedstatement = connection.prepareStatement(dispUpd);
				for (int z = 0; z < licenseid.size(); z++) {
					preparedstatement.setInt(1, dispOrder.get(z));
					preparedstatement.setString(2, actionValue);
					preparedstatement.setString(3, licenseid.get(z));
					preparedstatement.executeUpdate();
				}
				/*
				 * �� �\�����X�V
				 */
				connection.commit();

			} catch (Exception e) {
				try {
					request.setAttribute("serverErrorMes", "�T�[�o�[�����ŗ�O���������܂����B");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.setAttribute("serverErrorMes", "�T�[�o�[�����ŗ�O���������܂����B");
				e.printStackTrace();
			}
			request.setAttribute("compeleteMes", "���i���̏����X�V���܂����B");
			request.setAttribute("shainId_search", shainId_search);
			request.setAttribute("namae_search", namae_search);
			request.setAttribute("sebetsu_search", sebetsu_search);
			request.setAttribute("sakujo_search", sakujo_search);
			request.setAttribute("zengamen_shainId", actionValue);
			RequestDispatcher rd = request.getRequestDispatcher("SkillUpdate.jsp");
			rd.forward(request, response);
			return;

		}
		/*
		 * �ǉ��{�^������
		 */
		if ("�ǉ�".equals(actionName)) {
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String seiseki = request.getParameter("seiseki");
			String hyojijun = request.getParameter("houjijun");
			String shutokudate = year + "-" + month + "-" + day;
			String sql = "INSERT INTO emp_skill_lic (emp_id, license_id, get_date, record, disp_order, teg_date) VALUES (?, ?, ?, ?, ?, current_timestamp)";
			String dispSearch = "SELECT license_id, disp_order FROM emp_skill_lic WHERE  emp_id = ? AND license_id != ? order by disp_order ASC";
			String dispUpd = "UPDATE emp_skill_lic SET disp_order = ?, upd_date = current_timestamp WHERE emp_id = ? AND license_id = ?";
			try {
				Timestamp formatday = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(shutokudate).getTime());
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, licenseId);
				preparedstatement.setTimestamp(3, formatday);
				if (seiseki == null) {
					preparedstatement.setString(4, "");
				} else {
					preparedstatement.setString(4, seiseki);
				}
				preparedstatement.setInt(5, Integer.parseInt(hyojijun));
				preparedstatement.executeUpdate();
				/*
				 * �\�����X�V ��
				 */
				preparedstatement = connection.prepareStatement(dispSearch);
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, licenseId);
				rs = preparedstatement.executeQuery();
				ArrayList<String> licenseid = new ArrayList<String>();
				ArrayList<Integer> dispOrder = new ArrayList<Integer>();
				while (rs.next()) {
					licenseid.add(rs.getString("license_id"));
					dispOrder.add(rs.getInt("disp_order"));
				}
				for (int i = 0; i < dispOrder.size(); i++) {
					if (dispOrder.get(i) == Integer.parseInt(hyojijun)) {
						int num = Integer.parseInt(hyojijun) + 1;
						for (int j = i; j < dispOrder.size(); j++) {
							dispOrder.set(j, num);
							num += 1;
						}
					}
				}

				preparedstatement = connection.prepareStatement(dispUpd);
				for (int z = 0; z < licenseid.size(); z++) {
					preparedstatement.setInt(1, dispOrder.get(z));
					preparedstatement.setString(2, actionValue);
					preparedstatement.setString(3, licenseid.get(z));
					preparedstatement.executeUpdate();
				}

				/*
				 * �\�����X�V ��
				 */

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
			request.setAttribute("compeleteMes", "���iID �u" + licenseId + "�v ��ǉ����܂����B");
			request.setAttribute("shainId_search", shainId_search);
			request.setAttribute("namae_search", namae_search);
			request.setAttribute("sebetsu_search", sebetsu_search);
			request.setAttribute("sakujo_search", sakujo_search);
			request.setAttribute("zengamen_shainId", actionValue);
			RequestDispatcher rd = request.getRequestDispatcher("SkillUpdate.jsp");
			rd.forward(request, response);
			return;

		}
		/*
		 * �폜�{�^������
		 */
		if ("�폜".equals(actionName)) {
			String searchVal = "SELECT emp_id, license_id FROM emp_skill_lic  WHERE emp_id = ? AND license_id = ?";
			String sql = "DELETE FROM emp_skill_lic WHERE emp_id = ? AND license_id = ?";
			String dispSearch = "SELECT license_id, disp_order FROM emp_skill_lic WHERE  emp_id = ? AND license_id != ? order by disp_order ASC";
			String dispUpd = "UPDATE emp_skill_lic SET disp_order = ?, upd_date = current_timestamp WHERE emp_id = ? AND license_id = ?";
			try {
				connection = con.connect();
				preparedstatement = connection.prepareStatement(searchVal);
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, licenseId);
				rs = preparedstatement.executeQuery();
				if (rs.next()) {
					preparedstatement = connection.prepareStatement(sql);
					preparedstatement.setString(1, actionValue);
					preparedstatement.setString(2, licenseId);
					preparedstatement.executeUpdate();
					/*
					 * �\�����X�V ��
					 */
					String junbanUpd = request.getParameter("junbanUpd");
					preparedstatement = connection.prepareStatement(dispSearch);
					preparedstatement.setString(1, actionValue);
					preparedstatement.setString(2, licenseId);
					rs = preparedstatement.executeQuery();
					ArrayList<String> licenseid = new ArrayList<String>();
					ArrayList<Integer> dispOrder = new ArrayList<Integer>();
					while (rs.next()) {
						licenseid.add(rs.getString("license_id"));
						dispOrder.add(rs.getInt("disp_order"));
					}
					int num = Integer.parseInt(junbanUpd);
					for (int i = 0; i < dispOrder.size(); i++) {

						if (dispOrder.get(i) > Integer.parseInt(junbanUpd)) {

							dispOrder.set(i, num);
							num += 1;
						}

					}

					preparedstatement = connection.prepareStatement(dispUpd);
					for (int z = 0; z < licenseid.size(); z++) {
						preparedstatement.setInt(1, dispOrder.get(z));
						preparedstatement.setString(2, actionValue);
						preparedstatement.setString(3, licenseid.get(z));
						preparedstatement.executeUpdate();
					}
					/*
					 * �\�����X�V ��
					 */
					connection.commit();
					request.setAttribute("compeleteMes",
							"���iID " + licenseId + " �̎Ј�ID " + actionValue + " �̏����폜���܂����B");
				} else {
					request.setAttribute("errorMes", "���iID " + licenseId + " �̎Ј�ID " + actionValue + " �̏�񂪌�����܂���B");
				}

			} catch (Exception e) {
				try {
					request.setAttribute("serverErrorMes", "�T�[�o�[�����ŗ�O���������܂����B");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				request.setAttribute("serverErrorMes", "�T�[�o�[�����ŗ�O���������܂����B");
				e.printStackTrace();
			}
			request.setAttribute("shainId_search", shainId_search);
			request.setAttribute("namae_search", namae_search);
			request.setAttribute("sebetsu_search", sebetsu_search);
			request.setAttribute("sakujo_search", sakujo_search);
			request.setAttribute("zengamen_shainId", actionValue);
			RequestDispatcher rd = request.getRequestDispatcher("SkillUpdate.jsp");
			rd.forward(request, response);
			return;

		}
	}

}