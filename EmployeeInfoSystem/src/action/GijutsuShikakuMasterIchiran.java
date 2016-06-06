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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
//		System.out.println(search_id);
//		System.out.println(search_name);
//		System.out.println(search_seisekinashi);
//		System.out.println(search_seisekiari);
//		System.out.println(search_sakujosumi);
//		request.setAttribute("hidden_shikakuId", search_id);
//		request.setAttribute("hidden_shikakumei", search_name);
//		request.setAttribute("hidden_seisekinashi", search_seisekinashi);
//		request.setAttribute("hidden_seisekiari", search_seisekiari);
//		request.setAttribute("hidden_sakujosumi",search_sakujosumi);
		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<String> Val = new ArrayList<String>();
		
		ArrayList<SkillListValue> list = new ArrayList<SkillListValue>();
		
		if("����".equals(actionName)){
			String sql = "SELECT license_id, license_name, record_flg, del_flg FROM skill_lic_mas";
			Boolean where = false;
			if(!"".equals(search_id)){
				where = true;
				sql += " WHERE license_id =?";
				Val.add(search_id);
			}
			if(!"".equals(search_name)){
				if(where == false){
					where = true;
					sql += " WHERE license_name LIKE ?";
					Val.add("%"+search_name+"%");
				}else{
					sql += " AND license_name LIKE ?";
					Val.add("%"+search_name+"%");
				}
			}
			if("on".equals(search_seisekinashi) && !"on".equals(search_seisekiari)){
				if(where == false){
					where = true;
					sql += " WHERE record_flg = ?";
					Val.add("1");
				}else{
					sql += " AND record_flg = ?";
					Val.add("1");
				}
			}
			if(!"on".equals(search_seisekinashi) && "on".equals(search_seisekiari)){
				if(where == false){
					where = true;
					sql += " WHERE record_flg = ?";
					Val.add("0");
				}else{
					sql += " AND record_flg = ?";
					Val.add("0");
				}
			}
			if(!"on".equals(search_sakujosumi)){
				if(where == false){
					where = true;
					sql += " WHERE del_flg = ?";
					Val.add("0");
				}else{
					sql += " AND del_flg = ?";
					Val.add("0");
				}
			}
			sql += " ORDER BY license_id ASC";
			
			try{
				connection = con.connect();
				preparedstatement = connection.prepareStatement(sql);
				for(int i = 0; i < Val.size(); i++){
					preparedstatement.setString(1+i, Val.get(i));
				}
				rs = preparedstatement.executeQuery();
				int count = 1;
				while(rs.next()){
					SkillListValue sValue = new SkillListValue();
					sValue.setNum(String.valueOf(count));
					sValue.setShikakuid(rs.getString("license_id"));
					sValue.setShikakumei(rs.getString("license_name"));
					String seiseki = rs.getString("record_flg");
					if("1".equals(seiseki)){
						sValue.setSeiseki("����");
					}else {
						sValue.setSeiseki("����");
					}
					String sakujo = rs.getString("del_flg");
					if("1".equals(sakujo)){
						sValue.setSakujosumi("��");
					}else {
						sValue.setSakujosumi("");
					}
					list.add(sValue);
					count = count+1;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			request.setAttribute("hidden_shikakuId", search_id);
			request.setAttribute("hidden_shikakumei", search_name);
			request.setAttribute("hidden_seisekinashi", search_seisekinashi);
			request.setAttribute("hidden_seisekiari", search_seisekiari);
			request.setAttribute("hidden_sakujosumi",search_sakujosumi);
			request.setAttribute("memberList", list);
			RequestDispatcher rd = request.getRequestDispatcher("SkillList.jsp");
			rd.forward(request, response);
			return;
		}
		if("�ҏW".equals(actionName) && !"".equals(actionValue)){
			request.setAttribute("id", actionValue);
			RequestDispatcher rd = request.getRequestDispatcher("SkillListUpdate.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		
	}

}
