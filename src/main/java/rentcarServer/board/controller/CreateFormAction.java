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
import rentcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class CreateFormAction
 */
@WebServlet("/CreateFormAction")
public class CreateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFormAction() {
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
		BoardDao boardDao = BoardDao.getInstance();
		
		System.out.println("code 생성");
		String code = boardDao.createPostCode();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		boolean isValid = true;
		
		if(title == null || title.equals(""))
			isValid = false;
		else if(content == null || content.equals(""))
			isValid = false;
		
		if(isValid) {
			HttpSession session = request.getSession();
			UserResponseDto user = (UserResponseDto) session.getAttribute("user");
			System.out.println("id:"+user.getId());
			String id = user.getId();
			
			String category = "";
			if(id.equals("Admin"))
				category = "Admin";
			else
				category = "Free";
			
			BoardRequestDto boardDto = new BoardRequestDto(code, title, content, id, category);
			
			BoardResponseDto board = boardDao.createBoard(boardDto);
			
			if(board == null) {
				response.sendRedirect("/post");
			} else {
				response.sendRedirect("/board");
			}
		}
	}

}
