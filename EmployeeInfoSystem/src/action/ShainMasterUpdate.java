package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String shainId = request.getParameter("shainNum");
		
		request.setAttribute("shainId", shainId);
		request.setAttribute("shaiNum", shainId);
		RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
		rd.forward(request, response);
		
	}

}
