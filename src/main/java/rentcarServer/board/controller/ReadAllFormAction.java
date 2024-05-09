package rentcarServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentcarServer.board.model.BoardDao;
import rentcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class ReadAllFormAction
 */
public class ReadAllFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAllFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> boardList = boardDao.readAllBoard();
		System.out.println(boardList);

		request.setAttribute("boardList", boardList);

		// JSP 내장 객체를 활용한 페이지 이동처리
		// 1) response.sendRedirect(패스)     : 순수 페이지 이동 
		// 2) request.getRequestDispatcher(패스).forward(req, res) : 객체 전달과 함께 url의 변화가 없음 

		request.getRequestDispatcher("/board").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

}
