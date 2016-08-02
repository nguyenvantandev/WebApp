package co.jp.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import co.jp.myapp.dao.ConnectionDao;

/**
 * Servlet implementation class ChoukaiController
 */
@WebServlet("/ChoukaiController")
public class ChoukaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoukaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ConnectionDao con = new ConnectionDao();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
/*		File file = new File("kanji.jpg");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream outfis = new FileOutputStream("Choukai.jsp");
		//OutputStream out = null;
		String name = file.getName();
		System.out.println(name);
		String img = null;
	
		String sql = "INSERT INTO choukai_list VALUES (?,?)";
		String searchsql = "SELECT audio FROM choukai_list";
		try{
			connection = con.connect();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 100001);
			preparedStatement.setBinaryStream(2, fis, (int)file.length());
			preparedStatement.executeUpdate();
			connection.commit();
			
			preparedStatement = connection.prepareStatement(searchsql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				img = resultSet.getString("audio");
				byte[] imgBytes = new byte[img.length()];
				InputStream imgStream = resultSet.getBinaryStream("audio");
				//int index = imgStream.read(imgBytes, 0, img.length());
				//preparedStatement.close();
				//response.reset();
				response.setContentType("image/jpg");
				response.getOutputStream().write(imgBytes,0,imgBytes.length);
				//response.getOutputStream().flush();
				//imgStream.close();
				request.setAttribute("audio", imgStream);
				//System.out.println(index);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		RequestDispatcher rd = request.getRequestDispatcher("Choukai.jsp");
		rd.forward(request, response);
		
		
		
	}

}
