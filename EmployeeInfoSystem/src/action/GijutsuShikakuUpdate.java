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

		String actionName = request.getParameter("actionName");
		String actionValue = request.getParameter("actionValue");
		System.out.println(actionName);
		System.out.println(actionValue);

		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<SkillValue> list = new ArrayList<SkillValue>();
		if ("�����\��".equals(actionName)) {
			String sql = "SELECT emp_mas.emp_id, emp_mas.name, emp_skill_lic.license_id, emp_skill_lic.get_date, emp_skill_lic.record, emp_skill_lic.disp_order, skill_lic_mas.license_name FROM emp_mas RIGHT JOIN emp_skill_lic ON emp_mas.emp_id = emp_skill_lic.emp_id LEFT JOIN skill_lic_mas ON emp_skill_lic.license_id = skill_lic_mas.license_id WHERE emp_mas.emp_id =? AND emp_mas.del_flg = ? AND emp_skill_lic.del_flg = ? ORDER BY emp_skill_lic.disp_order, emp_skill_lic.teg_date ASC";
			String displayOrder = "SSELECT MAX(disp_order) AS count FROM emp_skill_lic WHERE emp_id = ?";
			try{
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				preparedstatement.setString(1, actionValue);
				preparedstatement.setString(2, "0");
				preparedstatement.setString(3, "0");
				rs = preparedstatement.executeQuery();
				while(rs.next()){
					SkillValue sVal = new SkillValue();
					request.setAttribute("shainId", rs.getString("emp_id"));
					request.setAttribute("namae", rs.getString("name"));
					sVal.setNum(rs.getString("disp_order"));
					sVal.setShikakuid(rs.getString("license_id"));
					sVal.setNamae(rs.getString("license_name"));
					sVal.setShutokuday(rs.getString("get_date"));
					sVal.setSeiseki(rs.getString("record"));
					list.add(sVal);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			request.setAttribute("memberList", list);
			RequestDispatcher rd = request.getRequestDispatcher("SkillUpdate.jsp");
			rd.forward(request, response);
		}
		

	}

}
