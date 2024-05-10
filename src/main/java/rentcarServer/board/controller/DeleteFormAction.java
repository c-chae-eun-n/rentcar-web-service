package rentcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardRequestDto;
import rentcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class DeleteFormAction
 */
public class DeleteFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		BoardDao boardDao = BoardDao.getInstance();
		
		BoardResponseDto board = (BoardResponseDto) session.getAttribute("board");
		
		String code = board.getCode();
		
		BoardRequestDto boardDto = new BoardRequestDto();
		boardDto.setCode(code);
		
		boolean result = boardDao.deletePost(boardDto);
		
		if(result) {
			System.out.println("삭제성공");
			session.removeAttribute("board");
			response.sendRedirect("/readAllFormAction");
		} else {
			System.out.println("삭제실패");
			response.sendRedirect("/read/board?code="+board.getCode());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

}
