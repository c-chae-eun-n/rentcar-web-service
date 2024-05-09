package rentcarServer.board.model;

public class BoardResponseDto {
	private String code;
	private String title;
	private String content;
	private String userId;
	private String category;
	
	public BoardResponseDto(String code, String title, String content, String userId, String category) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.category = category;
	}

	public BoardResponseDto(Board board) {
		this.code = board.getCode();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.userId = board.getUserId();
		this.category = board.getCategory();
	}
	
	
}
