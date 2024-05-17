package rentcarServer.reservate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.reservate.model.ReservationDao;
import rentcarServer.reservate.model.ReservationResponseDto;

/**
 * Servlet implementation class SearchUpdateFormAction
 */
public class SearchUpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUpdateFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String number = request.getParameter("number");
		System.out.println(number);
		
		String button = request.getParameter("button");
		System.out.println(button);
		
		ReservationDao reservationDao = ReservationDao.getInstance();
		
		System.out.println(number);
		
		ReservationResponseDto reserve = reservationDao.searchReservationByNumber(number);
		
		String[] tempRenDate = reservationDao.convertTimeStampToString(reserve.getRenDate(), "yyyy-MM-dd HH:mm:ss").split(" ");
		String[] tempReturnDate = reservationDao.convertTimeStampToString(reserve.getReturnDate(), "yyyy-MM-dd HH:mm:ss").split(" ");
		
		String renDate = tempRenDate[0];
		String renTime = tempRenDate[1];
		String returnDate = tempReturnDate[0];
		String returnTime = tempReturnDate[1];
		
		session.setAttribute("renDate", renDate);
		session.setAttribute("renTime", renTime);
		session.setAttribute("returnDate", returnDate);
		session.setAttribute("returnTime", returnTime);

		request.setAttribute("reserve", reserve);

		if(button.equals("수정"))
			request.getRequestDispatcher("/updateReservaion").forward(request, response);
		else if(button.equals("삭제"))
			request.getRequestDispatcher("/reservationDelete").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
