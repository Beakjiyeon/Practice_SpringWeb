package org.zerock.domain;

import java.util.Date;

import lombok.Data;

// Setter, Getter을 기본적으로 만들어주는 @data
@Data
public class BoardVO {
	// sqldeveloper에서 만든 테이블 속성 그대로 작성한다.
	private Long  bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
}
