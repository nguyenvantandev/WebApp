package action;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.sql.ResultSet;
import javax.servlet.http.HttpSession;

import connection.DbConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
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
		HttpSession session = request.getSession();
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		DbConnection con = new DbConnection();
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		ResultSet rs = null;
		String sql = "SELECT count(user_id) AS userinfo FROM tbl_user_mst WHERE user_id = ? AND pass_word = ?";
		
		
		if("".equals(userid)){
			request.setAttribute("ErrMsg", "*ユーザーIDが入力されていません。");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			return;
		} else if("".equals(password)) {
			request.setAttribute("userid", userid);
			request.setAttribute("ErrMsg", "*ユーザーパスワードが入力されていません。");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			return;
		}
		
		//
		try{
			connection = con.connect();
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, Integer.parseInt(userid) );
			preparedstatement.setString(2, password);
			rs = preparedstatement.executeQuery();
			
			if(rs.next()){
				// セッションにユーザIDを保存
				int info = rs.getInt("userinfo");
				if(info == 1){

					session.setAttribute("UserInfo", Integer.parseInt(userid));
					RequestDispatcher rd = request.getRequestDispatcher("Calendar.jsp");
					rd.forward(request, response);
				}else{
					request.setAttribute("ErrMsg", "*ユーザーID、又はパスワードが不正です。");
					request.setAttribute("userid", userid);
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
