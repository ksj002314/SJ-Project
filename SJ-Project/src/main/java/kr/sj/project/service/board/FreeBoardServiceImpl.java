package kr.sj.project.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.sj.project.domain.board.BoardFreeDTO;
import kr.sj.project.domain.board.Criteria;
import kr.sj.project.mapper.board.BoardFreeMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class FreeBoardServiceImpl implements FreeBoardService {
	@Autowired
	private BoardFreeMapper mapper;
	
	@Override
	public Long register(BoardFreeDTO freeboard) {	
		mapper.insertSelectKey(freeboard);
		
		return freeboard.getIDX();
	}
	
	@Override
	public BoardFreeDTO get(Long IDX) {
		return mapper.freeread(IDX);
	}

	@Override
	public int modify(BoardFreeDTO freeboard) {
		return mapper.freeupdate(freeboard);
	 }

	@Override
	public int remove(Long IDX) {
		return mapper.freedelete(IDX);
	}

	@Override
	public List<BoardFreeDTO> FreegetList() {
		return mapper.freegetList();
	}

	@Override
	public List<BoardFreeDTO> FreegetList(Criteria cri) {	
		return mapper.getListWithPaging(cri);
	}	
	
	@Override
	public int gettotalcount(Criteria cri) {
		return mapper.gettotalcount(cri);
	}
}
