package kr.sj.project.service.board;

import java.util.List;

import kr.sj.project.domain.board.BoardFreeDTO;
import kr.sj.project.domain.board.Criteria;


public interface FreeBoardService {
		
public Long register(BoardFreeDTO freeboard);
	
	public BoardFreeDTO get(Long IDX);
	
	public int modify(BoardFreeDTO freeboard);
	
	public int remove(Long IDX);
	
	public List<BoardFreeDTO> FreegetList();
	
	public List<BoardFreeDTO> FreegetList(Criteria cri);
	
	public int gettotalcount(Criteria cri);
	
}
