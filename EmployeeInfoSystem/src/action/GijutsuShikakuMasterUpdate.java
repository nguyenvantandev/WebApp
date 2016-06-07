package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GijutsuShikakuMasterUpdate
 */
@WebServlet("/GijutsuShikakuMasterUpdate")
public class GijutsuShikakuMasterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GijutsuShikakuMasterUpdate() {
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

		String shikakuId = request.getParameter("shikakuId");
		System.out.println(shikakuId);
		request.setAttribute("shikakuId", shikakuId);
		RequestDispatcher rd = request.getRequestDispatcher("SkillListUpdate.jsp");
		rd.forward(request, response);
	}

}
