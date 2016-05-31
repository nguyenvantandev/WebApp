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
		 * EmployeeSearch.jspからパラメータ取得する。
		 * 開始
		 * */
		String click_action = request.getParameter("click_action");
		String shainID = request.getParameter("shain_id");
		String namae = request.getParameter("namae");
		String seibetsu = request.getParameter("sebetsu");
		String sakujosumi = request.getParameter("sakujosumi");
		System.out.println(click_action);
		System.out.println(shainID);
		System.out.println(namae);
		System.out.println(seibetsu);
		System.out.println(sakujosumi);
		/*
		 * EmployeeSearch.jspからパラメータ取得する。
		 * 終了
		 * */
		/*
		 * 新規追加ボタンを押下する場合
		 * 社員マスタ更新画面に遷移する。
		 * 開始
		 * */
		
		if("新規追加".equals(click_action)){
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.forward(request, response);
		}
		/*
		 * 社員マスタ更新画面に遷移する。
		 * 終了
		 * */
		
		/*
		 * 検索ボタンを押下する場合
		 * 検索処理を行う
		 * 開始
		 * */
		DBconnection con = new DBconnection();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet rs = null;
		ArrayList<String> Val = new ArrayList<String>();
		
		ArrayList<SearchValue> lresult = new ArrayList<SearchValue>();
		
		if("検索".equals(click_action)){
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
						sValue.setSakujosumi("○");
					}
					lresult.add(sValue);
					count= count+1;
				}
				
			}catch(Exception e){
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
		}
		/*
		 * 検索処理を行う
		 * 終了
		 * */
	}

}
