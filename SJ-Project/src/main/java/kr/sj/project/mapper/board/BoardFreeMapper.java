package kr.sj.project.mapper.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.sj.project.domain.board.BoardFreeDTO;
import kr.sj.project.domain.board.Criteria;

@Mapper
public interface BoardFreeMapper {
		// 由ъ뒪�듃 蹂닿린
		public List<BoardFreeDTO> freegetList();
		
		// 湲� 留뚮뱾湲�
		public void Freeinsert(BoardFreeDTO boardfree);
		
		// 湲� 留뚮뱾湲� �꽑�깮 踰덊샇
		public void insertSelectKey(BoardFreeDTO boardfree);
		
		// 湲� 議고쉶
		public BoardFreeDTO freeread(Long IDX);
		
		// �궘�젣
		public int freedelete(Long IDX); 
		
		// 湲� �닔�젙
		public int freeupdate(BoardFreeDTO boardfree);
		
		
		// �럹�씠吏�
		public List<BoardFreeDTO> getListWithPaging(Criteria cri);
		
		
		public int gettotalcount(Criteria cri);
		
		//寃��깋
		public List<BoardFreeDTO> searchT(Map<String, Map<String,String>> map);
		
}
