package rentcarServer.board.model;

public class BoardRequestDto {
	private String code;
	private String title;
	private String content;
	private String userId;
	private String category;
	
	public BoardRequestDto() {
		super();
	}

	public BoardRequestDto(String code, String title, String content, String userId, String category) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.category = category;
	}
	
	
}
