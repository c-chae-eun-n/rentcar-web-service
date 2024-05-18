package rentcarServer.reservate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.reservate.model.ReservationDao;
import rentcarServer.user.model.UserDao;
import rentcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class DeleteReservationAction
 */
public class DeleteReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReservationAction() {
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

		UserResponseDto tempUser = (UserResponseDto) session.getAttribute("user");
		String id = (String) tempUser.getId();
		
		String password = request.getParameter("password");
		String reservationNumber = request.getParameter("number");
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		System.out.println("reservationNumber : " + reservationNumber);
		
		UserDao userDao = UserDao.getInstance();
		ReservationDao reservationDao = ReservationDao.getInstance();
		
		UserResponseDto user = userDao.findUserByIdAndPassword(id, password);
		System.out.println("user :" + user);
		
		if(user != null) {
			boolean result = reservationDao.deleteReservationByNumber(reservationNumber);
			System.out.println("result :" + result);

			if(result) {
				request.setAttribute("isDeleted", true);
			} else {
				request.setAttribute("isDeleted", false);
			}
		}else {
			request.setAttribute("isDeleted", false);
		}
		
		request.getRequestDispatcher("/reservationDeleteCheck").forward(request,response);
	}

}
