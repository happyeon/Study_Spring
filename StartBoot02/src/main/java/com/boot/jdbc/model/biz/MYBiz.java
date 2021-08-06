package com.boot.jdbc.model.biz;

import java.util.List;

import com.boot.jdbc.model.dto.MYDto;

public interface MYBiz {
	
	public List<MYDto> selectList();
	public MYDto selectOne(int myno);
	public int insert(MYDto dto);
	public int update(MYDto dto);
	public int delete(int myno);

}
