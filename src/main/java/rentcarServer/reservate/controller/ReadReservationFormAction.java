package rentcarServer.reservate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.reservate.model.ReservationDao;
import rentcarServer.reservate.model.ReservationResponseDto;
import rentcarServer.user.model.User;
import rentcarServer.user.model.UserRequestDto;
import rentcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class ReadReservationFormAction
 */
public class ReadReservationFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadReservationFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		ReservationDao reservationDao = ReservationDao.getInstance();

		if(session.getAttribute("user") == null)
			response.sendRedirect("/login");
		else {
			UserResponseDto user = (UserResponseDto) session.getAttribute("user");
			
			String userId = (String) user.getId();
			
			List<ReservationResponseDto> reserveList = reservationDao.readReservationList(userId);
			System.out.println("reserveList : "+reserveList);
			
			request.setAttribute("reserveList", reserveList);
			
			request.getRequestDispatcher("/mypage").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
