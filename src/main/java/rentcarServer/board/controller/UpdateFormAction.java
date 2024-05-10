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
import rentcarServer.user.model.UserRequestDto;

/**
 * Servlet implementation class UpdateFormAction
 */
public class UpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		BoardDao boardDao = BoardDao.getInstance();
		
		BoardResponseDto board = (BoardResponseDto) session.getAttribute("board");
		
		String code = board.getCode();
		
		if(boardDao.findBoardByCode(code) != null) {
			BoardRequestDto boardDto = new BoardRequestDto();
			
			boardDto.setTitle(board.getTitle());
			boardDto.setContent(board.getContent());
			boardDto.setCode(code);
			
			String newTitle = request.getParameter("title-new");
			String newContent = request.getParameter("content-new");
			System.out.println("newtitle: " + newTitle);
			System.out.println("newContent: " + newContent);
			
			if(newTitle != null || newTitle.equals(board.getTitle()) || newContent != null || newContent.equals("")) {
				boardDao.updatePostTitleAndContent(boardDto, newTitle, newContent);
			}
			
			session.setAttribute("board", board);
			response.sendRedirect("/read/board?code="+board.getCode());
		}
	}

}
