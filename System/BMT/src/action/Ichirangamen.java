package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connection.DbConnection;
import value.BookInfo;

/**
 * Servlet implementation class Ichirangamen
 */
@WebServlet("/Ichirangamen")
public class Ichirangamen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ichirangamen() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// 検索条件取得
		String bookId = request.getParameter("id");
		String bookTitle = request.getParameter("book_title");
		String bookAuthor = request.getParameter("book_author");
		String bookPulisher = request.getParameter("book_pulisher");
		String inDay = request.getParameter("checkinday");
		String outDay = request.getParameter("checkinout");
		String checkdelete = request.getParameter("check");
		String action = request.getParameter("action");

		request.setAttribute("id", bookId);
		request.setAttribute("book_title", bookTitle);
		request.setAttribute("book_author", bookAuthor);
		request.setAttribute("book_pulisher", bookPulisher);
		request.setAttribute("checkinday", inDay);
		request.setAttribute("checkinout", outDay);
		request.setAttribute("checkbox", checkdelete);
		if("検索".equals(action)){
			ArrayList<String> pramSQL = new ArrayList<String>();
			DbConnection con = new DbConnection();
				PreparedStatement preparedStatement = null;
				ResultSet rs = null;
				String sort = " ORDER BY book_id ASC";
				String mysql = "SELECT book.book_id, book.book_title, book.author_name, book.publisher, book.publication_day, stock.stock, book.delete_flg FROM mt_book book left JOIN tbl_book_stock stock ON book.book_id = stock.book_id";
				ArrayList<BookInfo> lstResult = new ArrayList<BookInfo>();
				try {
					Connection connection = con.connect();
					Boolean where = false;
					if(!"".equals(bookId)){
						if(where == false){
							where = true;
								String str= " WHERE book.book_id = to_number(?, '999999')";
								mysql += str;
								pramSQL.add(bookId);
							
						}
						if("false".equals(checkdelete)){
							if(where == false){
								where = true;
								String str = " WHERE book.delete_flg = '0'";
								mysql += str;
							}
							else {
								String str = " AND book.delete_flg = '0'";
								mysql += str;
							}
						}
					}
					if("".equals(bookId)){
						if(!"".equals(bookTitle)){
							if(where == false){
								where = true;
								String str = " WHERE book.book_title LIKE ?";
								mysql += str;
								pramSQL.add("%"+bookTitle+"%");
							}
							else {
								String str = " AND book.book_title LIKE ?";
								mysql += str;
								pramSQL.add("%"+bookTitle+"%");
							}
						}
						if(!"".equals(bookAuthor)){
							if(where == false){
								where = true;
								String str = " WHERE book.author_name LIKE ?";
								mysql += str;
								pramSQL.add("%"+bookAuthor+"%");
							}
							else{
								String str = " AND book.author_name LIKE ?";
								mysql += str;
								pramSQL.add("%"+bookAuthor+"%");
							}
						}
						if(!"".equals(bookPulisher)){
							if(where == false){
								where = true;
								String str = " WHERE book.publisher LIKE ?";
								mysql += str;
								pramSQL.add("%"+bookPulisher+"%");
							}
							else {
								String str = " AND book.publisher LIKE ?";
								mysql += str;
								pramSQL.add("%"+bookPulisher+"%");
							}
						}
						if(!"".equals(inDay) && !"".equals(outDay)){
							if(where == false){
								where = true;
								String str = " WHERE book.publication_day >= to_timestamp(?, 'yyyyMMdd') AND book.publication_day <= to_timestamp(?, 'yyyyMMdd')";
								mysql += str;
								pramSQL.add(inDay);
								pramSQL.add(outDay);
							}
							else{
								String str = " AND book.publication_day >= to_timestamp(?, 'yyyyMMdd') AND book.publication_day <= to_timestamp(?, 'yyyyMMdd')";
								mysql += str;
								pramSQL.add(inDay);
								pramSQL.add(outDay);
							}
						}
						if(!"".equals(inDay) && "".equals(outDay)){
							if(where == false){
								where = true;
								String str = " WHERE book.publication_day >= to_timestamp(?, 'yyyyMMdd')";
								mysql += str;
								pramSQL.add(inDay);
							}
							else{
								String str = " AND book.publication_day >= to_timestamp(?, 'yyyyMMdd')";
								mysql += str;
								pramSQL.add(inDay);
							}
						}
						if(!"".equals(outDay) && "".equals(inDay) ){
							if(where == false){
								where = true;
								String str = " WHERE book.publication_day <= to_timestamp(?, 'yyyyMMdd')";
								mysql += str;
								pramSQL.add(outDay);
							}
							else{
								String str = " AND book.publication_day <= to_timestamp(?, 'yyyyMMdd')";
								mysql += str;
								pramSQL.add(outDay);
							}
						}
						if("false".equals(checkdelete)){
							if(where == false){
								where = true;
								String str = " WHERE book.delete_flg = '0'";
								mysql += str;
							}
							else {
								String str = " AND book.delete_flg = '0'";
								mysql += str;
							}
						}
					}
					mysql += sort;
					preparedStatement  = connection.prepareStatement(mysql);
					for(int i = 0; i < pramSQL.size(); i++){
						preparedStatement.setString(1+i, pramSQL.get(i));
					}
					rs = preparedStatement.executeQuery();
					while (rs.next()) {
						BookInfo info = new BookInfo();
						info.setBookid(rs.getString("book_id"));
						info.setBooktitle(rs.getString("book_title"));
						info.setAuthorname(rs.getString("author_name"));
						info.setPublisher(rs.getString("publisher"));
						String getpublication = rs.getString("publication_day");
						String[] splitpublication = getpublication.split("-");
						String year = splitpublication[0];
						String month = splitpublication[1];
						String day = splitpublication[2];
						String publication = year +"/"+month+"/"+day;
						info.setPublicationday(publication);
						if(rs.getString("stock") == null || rs.getString("stock").equals("0")){
							info.setStock("在庫なし");
						}else{
							info.setStock(rs.getString("stock"));
						}
						if(rs.getString("delete_flg").equals("1")){
							info.setDeleleflg("〇");
						}
						else{
							info.setDeleleflg("");
						}
					    lstResult.add(info);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					request.setAttribute("servererrormessage", "サーバー処理で例外が発生しました。");
					e.printStackTrace();
				}
				request.setAttribute("memberList", lstResult);
				int count = lstResult.size();
				request.setAttribute("count", count);
			//データベース接続できない場合
			RequestDispatcher rd = request.getRequestDispatcher("ichirangamen.jsp");
			rd.forward(request, response);
		}
		else if("新規追加".equals(action)){
					Timestamp nowdate = new Timestamp(System.currentTimeMillis());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					String pday = dateFormat.format(nowdate);
					request.setAttribute("bookid", "");
					request.setAttribute("booktitle", "");
					request.setAttribute("authorname", "");
					request.setAttribute("publisher", "");
					String[] dbpulicationday = pday.split("/");
					request.setAttribute("year", dbpulicationday[0]);
					request.setAttribute("month", dbpulicationday[1]);
					request.setAttribute("day", dbpulicationday[2]);
					request.setAttribute("stock", "");
					// For back button//
					request.setAttribute("searchid", bookId);
					request.setAttribute("searchtitle", bookTitle);
					request.setAttribute("searchauthor", bookAuthor);
					request.setAttribute("searchpulisher", bookPulisher);
					request.setAttribute("searchpulication_dayin", inDay);
					request.setAttribute("searchpulication_dayout", outDay);
					request.setAttribute("searchcheckbox", checkdelete);
					request.getRequestDispatcher("koushingamen.jsp").forward(request, response);
		}
		else if("更新".equals(action)){
			String id = request.getParameter("updateid");
			DbConnection con = new DbConnection();
			 
					String stringsql = "SELECT book.book_id, book.book_title, book.author_name, book.publisher, book.publication_day, stock.stock, book.delete_flg, book.update_cnt AS bookupdatecount, stock.update_cnt AS stockupdatecount FROM mt_book book left JOIN tbl_book_stock stock ON book.book_id = stock.book_id WHERE book.book_id= ? AND book.delete_flg = '0'";
					try {
						Connection connection =  con.connect();
						PreparedStatement preparedStatement  = connection.prepareStatement(stringsql);
						preparedStatement.setInt(1, Integer.parseInt(id));
						ResultSet rs = preparedStatement.executeQuery();
						if (rs.next()) {
							request.setAttribute("bookid", rs.getString("book_id"));
							request.setAttribute("booktitle", rs.getString("book_title"));
							request.setAttribute("authorname", rs.getString("author_name"));
							request.setAttribute("publisher", rs.getString("publisher"));
							String[] dbpulicationday = rs.getString("publication_day").split("-");
							request.setAttribute("year", dbpulicationday[0]);
							request.setAttribute("month", dbpulicationday[1]);
							request.setAttribute("day", dbpulicationday[2]);
							if(rs.getString("stock") == null){
								request.setAttribute("stock", "");
							}else{
								request.setAttribute("stock", rs.getString("stock"));
							}
							request.setAttribute("bookupdatecount", rs.getInt("bookupdatecount"));
							request.setAttribute("stockupdatecount", rs.getInt("stockupdatecount"));
						} else {
							request.setAttribute("bookid", "");
							request.setAttribute("booktitle", "");
							request.setAttribute("authorname", "");
							request.setAttribute("publisher", "");
							request.setAttribute("year", "");
							request.setAttribute("month", "");
							request.setAttribute("day", "");
							request.setAttribute("stock", "");
							request.setAttribute("servererrormessage", "本情報が更新された可能性があります。再度、本マスタ一覧画面に戻り、やり直してください。");
						}
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						request.setAttribute("servererrormessage", "サーバー処理で例外が発生しました。");
						e.printStackTrace();
					}
			// For back button//
			request.setAttribute("searchid", bookId);
			request.setAttribute("searchtitle", bookTitle);
			request.setAttribute("searchauthor", bookAuthor);
			request.setAttribute("searchpulisher", bookPulisher);
			request.setAttribute("searchpulication_dayin", inDay);
			request.setAttribute("searchpulication_dayout", outDay);
			request.setAttribute("searchcheckbox", checkdelete);
			request.getRequestDispatcher("koushingamen.jsp").forward(request, response);
		}
	}

}
