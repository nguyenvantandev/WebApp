package jp.co.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.co.model.ListInfo;

@Component
public class MasterDAOAction implements MasterDAO {

	
	private JdbcTemplate jdbcTemplate;
	public MasterDAOAction(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ListInfo> list(){
		String sql = "SELECT book.book_id, book.book_title, book.author_name, book.publisher, book.publication_day, stock.stock, book.delete_flg FROM mt_book book left JOIN tbl_book_stock stock ON book.book_id = stock.book_id";
		List<ListInfo> listInfos = jdbcTemplate.query(sql, new RowMapper<ListInfo>(){
			@Override
			public ListInfo mapRow(ResultSet rs, int rownum) throws SQLException{
				ListInfo listInfo = new ListInfo();
				listInfo.setBookid(rs.getString("book_id"));
				listInfo.setBooktitle(rs.getString("book_title"));
				listInfo.setAuthorname(rs.getString("author_name"));
				listInfo.setPublisher(rs.getString("publisher"));
				listInfo.setPublicationday(rs.getString("publication_day"));
				listInfo.setStock(rs.getString("stock"));
				listInfo.setDeleleflg(rs.getString("delete_flg"));
				return listInfo;
			}
		});
		return listInfos;
	}
}
