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

import Value.SearchValue;
import connectionDB.DBconnection;

/**
 * Servlet implementation class ShainMasterKensaku
 */
@WebServlet("/ShainMasterKensaku")
public class ShainMasterKensaku extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ShainMasterKensaku() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		/*
		 * EmployeeSearch.jsp����p�����[�^�擾����B
		 * �J�n
		 * */
		String click_action = request.getParameter("click_action");
		String shainID = request.getParameter("shain_id");
		String namae = request.getParameter("namae");
		String seibetsu = request.getParameter("sebetsu");
		String sakujosumi = request.getParameter("sakujosumi");
		String shainMasterButton = request.getParameter("shainmasterButton");
		String sakujoButton = request.getParameter("sakujoButton");
		String gijutsushikakuMasterButton = request.getParameter("GijutsushikakuMasterButton");
		String gijitsushaKerekishoButton = request.getParameter("GijitsushaKerekishoButton");
		/*
		 * EmployeeSearch.jsp����p�����[�^�擾����B
		 * �I��
		 * */
		/*
		 * �V�K�ǉ��{�^������������ꍇ
		 * �Ј��}�X�^�X�V��ʂɑJ�ڂ���B
		 * �J�n
		 * */
		
		if("�V�K�ǉ�".equals(click_action)){
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �Ј��}�X�^�X�V��ʂɑJ�ڂ���B
		 * �I��
		 * */
		
		/*
		 * �����{�^������������ꍇ
		 * �����������s��
		 * �J�n
		 * */
		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<String> Val = new ArrayList<String>();
		
		ArrayList<SearchValue> lresult = new ArrayList<SearchValue>();
		
		if("����".equals(click_action)){
			String sql = "SELECT emp_id, name, sex, extract(year from age(current_timestamp,birth_date))AS age, extract(year from age(current_timestamp,work_start_date))AS keikennensuu, near_station, del_flg FROM emp_mas";
			boolean where = false;
			if(!"".equals(shainID)){
				request.setAttribute("id", shainID);
				where = true;
				sql += " WHERE emp_id = ?";
				Val.add(shainID);
			}
			if(!"".equals(namae)){
				request.setAttribute("name", namae);
				if(where == false){
					where = true;
					sql += " WHERE name LIKE ?";
					Val.add("%"+namae+"%");
				}else{
					sql += " AND name LIKE ?";
					Val.add("%"+namae+"%");
				}
			}
			if(!"".equals(seibetsu)){
				request.setAttribute("sex", seibetsu);
				if(where == false){
					where = true;
					sql += " WHERE sex = ?";
					Val.add(seibetsu);
				}else{
					sql += " AND sex = ?";
					Val.add(seibetsu);
				}
			}
			if(!"on".equals(sakujosumi)){
				
				if(where == false){
					where = true;
					sql += " WHERE del_flg = ?";
					Val.add("0");
				}else{
					sql += " AND del_flg = ?";
					Val.add("0");
				}
			}

			sql += " ORDER BY emp_id ASC";
			
			try{
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				for(int i = 0; i < Val.size(); i++){
					preparedstatement.setString(1+i, Val.get(i));
				}
				
				rs = preparedstatement.executeQuery();
				int count = 1;
				while(rs.next()){
					SearchValue sValue = new SearchValue();
					sValue.setNum(String.valueOf(count));
					sValue.setShainid(rs.getString("emp_id"));
					sValue.setNamae(rs.getString("name"));
					sValue.setSebetsu(rs.getString("sex"));
					sValue.setNenrei(rs.getString("age"));
					sValue.setKeikennensuu(rs.getString("keikennensuu"));
					sValue.setSaiyorieki(rs.getString("near_station"));
					String delete = rs.getString("del_flg");
					if("0".equals(delete)){
						sValue.setSakujosumi("");
					}else if("1".equals(delete)){
						sValue.setSakujosumi("��");
					}
					lresult.add(sValue);
					count= count+1;
				}
				
			}catch(Exception e){
				request.setAttribute("serverErrorMs", "�T�[�o�[�����ŗ�O���������܂����B");
				e.printStackTrace();
			}
			if("on".equals(sakujosumi)){
				request.setAttribute("del", "1");
			}
			request.setAttribute("memberList", lresult);
			int ValNum = lresult.size();
			request.setAttribute("count", ValNum);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeSearch.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �����������s��
		 * �I��
		 * */
		
		/*
		 * �Q��/�ҏW�{�^�������̏���
		 * (�Ј��}�X�^)
		 *�J�n
		 * */
		if(!"".equals(shainMasterButton) && !"null".equals(shainMasterButton)){
			request.setAttribute("shaiNum", shainMasterButton);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �Q��/�ҏW�{�^�������̏���
		 * (�Ј��}�X�^)
		 *�I��
		 * */
		
		/*
		 * �폜�{�^�������̏���
		 * �J�n
		 * */
		if(!"".equals(sakujoButton) && !"null".equals(sakujoButton)){
			String sqlsearch = "SELECT emp_id, del_flg, upd_date FROM emp_mas WHERE emp_id = ? AND del_flg = ?";
			String sql = "UPDATE emp_mas SET del_flg = ?, upd_date = current_timestamp WHERE emp_id = ? AND del_flg = ?";
			try{
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sqlsearch);
				preparedstatement.setString(1, sakujoButton);
				preparedstatement.setString(2, "0");
				rs = preparedstatement.executeQuery();
				if(rs.next()){
					preparedstatement = connection.prepareStatement(sql);
					preparedstatement.setString(1, "1");
					preparedstatement.setString(2, sakujoButton);
					preparedstatement.setString(3, "0");
					preparedstatement.executeUpdate();
					connection.commit();
					request.setAttribute("sakujoMes", "�Ј�ID"+sakujoButton+"�̎Ј������폜���܂����B");
				}else{
					request.setAttribute("sakujoMes", "�Ј�ID"+sakujoButton+"��������܂���B");
				}
				
			}catch(Exception e){
				request.setAttribute("serverErrorMs", "�T�[�o�[�����ŗ�O���������܂����B");
				try {
				request.setAttribute("serverErrorMs", "�T�[�o�[�����ŗ�O���������܂����B");
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			request.setAttribute("id", shainID);
			request.setAttribute("name", namae);
			request.setAttribute("sex", seibetsu);
			if("on".equals(sakujosumi)){
				request.setAttribute("del", "1");
			}
			request.setAttribute("sakujoButton", "����");
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeSearch.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �폜�{�^�������̏���
		 * �I��
		 * */
		
		/*
		 * �Q��/�ҏW�{�^�������̏���
		 * (�Z�p���i�}�X�^)
		 *�J�n
		 * */
		if(!"".equals(gijutsushikakuMasterButton) && !"null".equals(gijutsushikakuMasterButton)){
			request.setAttribute("id", gijutsushikakuMasterButton);
			RequestDispatcher rd = request.getRequestDispatcher("SkillUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �Q��/�ҏW�{�^�������̏���
		 * (�Z�p���i�}�X�^)
		 *�I��
		 * */
		
		/*
		 * �Q�ƃ{�^�������̏���
		 * ((�Z�p�Ҍo����)
		 *�J�n
		 * */
		if(!"".equals(gijitsushaKerekishoButton) && !"null".equals(gijitsushaKerekishoButton)){
			request.setAttribute("id", gijitsushaKerekishoButton);
			RequestDispatcher rd = request.getRequestDispatcher("Resume.jsp");
			rd.forward(request, response);
			return;
		}
		/*
		 * �Q�ƃ{�^�������̏���
		 * ((�Z�p�Ҍo����)
		 *�I��
		 * */
		
	}

}