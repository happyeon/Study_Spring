package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JdbcDto;

@Repository
public class JdbcDaoImpl implements JdbcDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<JdbcDto> selectList() {
		
		List<JdbcDto> list = new ArrayList<JdbcDto>();
		
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD ORDER BY SEQ DESC ";
		
		list = jdbcTemplate.query(
				sql,
				// lambda : java 1.8 이상
				// (rs, rowNum)->{		
				//	 JdbcDto dto = new JdbcDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				//	 return dto;
				// }
				new MyMapper()
				);
		
		
		return list;
	}

	@Override
	public JdbcDto selectOne(int seq) {
		
		JdbcDto dto = null;
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM JDBCBOARD WHERE SEQ = ? ";
		
		try {
			dto = jdbcTemplate.queryForObject(sql, new MyMapper(), new Object[] {seq});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(JdbcDto dto) {
		int res = 0;
		String sql = " INSERT INTO JDBCBOARD VALUES(JDBCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		res = jdbcTemplate.update(sql,
				new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()},
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
		
		return res;
	}

	@Override
	public int update(JdbcDto dto) {
		int res = 0;
		String sql = " UPDATE JDBCBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
		res = jdbcTemplate.update(sql,
				new Object[] {dto.getTitle(), dto.getContent(), dto.getSeq()},
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
		
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = 0;
		String sql = " DELETE FROM JDBCBOARD WHERE SEQ = ? ";
		res = jdbcTemplate.update(sql, new Object[] {seq}, new int[] {Types.INTEGER});
		
		return res;
	}
	
	// inner class impl RowMapper
	private static final class MyMapper implements RowMapper<JdbcDto> {

		@Override
		public JdbcDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JdbcDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
		
	}

}
