package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dto.MYDto;
import com.boot.jdbc.model.mapper.MyBoardMapper;

@Service
public class MYBizImpl implements MYBiz {
	
	@Autowired
	private MyBoardMapper mapper;

	@Override
	public List<MYDto> selectList() {
		return mapper.selectList();
	}

	@Override
	public MYDto selectOne(int myno) {
		return mapper.selectOne(myno);
	}

	@Override
	public int insert(MYDto dto) {
		return mapper.insert(dto);
	}

	@Override
	public int update(MYDto dto) {
		return mapper.update(dto);
	}

	@Override
	public int delete(int myno) {
		return mapper.delete(myno);
	}

}
