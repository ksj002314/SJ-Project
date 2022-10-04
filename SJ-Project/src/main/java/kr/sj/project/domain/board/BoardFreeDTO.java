package kr.sj.project.domain.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardFreeDTO {

	private Long IDX; // 번호
	private String CUM_TITLE; // 제목
	private String CUM_CONTENTS; // 내용
	private String CUM_WRITER; // 작성자
	private Date CUM_REGISTER_TIME; // 시간

}
