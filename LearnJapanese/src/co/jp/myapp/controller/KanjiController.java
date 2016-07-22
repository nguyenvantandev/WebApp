package co.jp.myapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.myapp.dao.ConnectionDao;
import co.jp.myapp.model.KanjiVal;

/**
 * Servlet implementation class KanjiController
 */
@WebServlet("/KanjiController")
public class KanjiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KanjiController() {
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
	
		String actionName = request.getParameter("actionName");
		String searchVal = request.getParameter("searchVal");
		
		ConnectionDao con = new ConnectionDao();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<KanjiVal> list = new ArrayList<KanjiVal>();
		ArrayList<String> getlist = new ArrayList<String>();
		if("�����\��".equals(actionName)){
			String sql = "SELECT kanji FROM kanji_list";
			try{
				connection = con.connect();
				preparedStatement= connection.prepareStatement(sql);
				rs = preparedStatement.executeQuery();
				while(rs.next()){
					getlist.add(rs.getString("kanji"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			int i = 0;
			while(i<getlist.size()){
				KanjiVal val = new KanjiVal();
				val.setLocal1(getlist.get(i));
				val.setLocal2((1+i<getlist.size())?getlist.get(1+i):"");
				val.setLocal3((2+i<getlist.size())?getlist.get(2+i):"");
				val.setLocal4((3+i<getlist.size())?getlist.get(3+i):"");
				val.setLocal5((4+i<getlist.size())?getlist.get(4+i):"");
				val.setLocal6((5+i<getlist.size())?getlist.get(5+i):"");
				val.setLocal7((6+i<getlist.size())?getlist.get(6+i):"");
				val.setLocal8((7+i<getlist.size())?getlist.get(7+i):"");
				val.setLocal9((8+i<getlist.size())?getlist.get(8+i):"");
				val.setLocal10((9+i<getlist.size())?getlist.get(9+i):"");
				list.add(val);
				i+=10;
			}
			System.out.println(getlist.size());
			System.out.println(list.size());
			request.setAttribute("Valshow", list);
			request.setAttribute("actionVal", "1");
			RequestDispatcher rd = request.getRequestDispatcher("Kanji.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
