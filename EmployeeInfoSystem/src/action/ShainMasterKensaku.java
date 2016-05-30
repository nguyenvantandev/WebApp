package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		/*
		 * 検索処理を行う
		 * 終了
		 * */
	}

}
