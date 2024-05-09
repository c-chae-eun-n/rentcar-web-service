package rentcarServer.board.model;

import java.sql.Timestamp;

public class BoardResponseDto {
	private String code;
	private String title;
	private String content;
	private String userId;
	private String category;
	private Timestamp write_date;
	private Timestamp mod_date;
	
	public BoardResponseDto(String code, String title, String content, String userId, String category) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.category = category;
	}
	
	public BoardResponseDto(String code, String title, String content, String userId,
			Timestamp write_date, Timestamp mod_date) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.write_date = write_date;
		this.mod_date = mod_date;
	}
	
	public BoardResponseDto(String code, String title, String content, String userId, String category,
			Timestamp write_date, Timestamp mod_date) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.category = category;
		this.write_date = write_date;
		this.mod_date = mod_date;
	}

	public BoardResponseDto(Board board) {
		this.code = board.getCode();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.userId = board.getUserId();
		this.category = board.getCategory();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

	public Timestamp getMod_date() {
		return mod_date;
	}

	public void setMod_date(Timestamp mod_date) {
		this.mod_date = mod_date;
	}
	
	@Override
	public String toString() {
		return String.format("%s/%s  %s", this.title, this.content, this.userId);
	}
	
}
