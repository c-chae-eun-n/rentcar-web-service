package rentcarServer.board.model;

import java.sql.Timestamp;

public class Board {
	private String code;
	private String title;
	private String content;
	private String userId;
	private String category;
	private Timestamp writeDate;
	private Timestamp modDate;
	
	public Board(String code, String title, String content, String userId, String category, Timestamp writeDate,
			Timestamp modDate) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.category = category;
		this.writeDate = writeDate;
		this.modDate = modDate;
	}
	
}
