package rentcarServer.reservate.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.car.model.CarDao;
import rentcarServer.reservate.model.ReservationDao;
import rentcarServer.reservate.model.ReservationRequestDto;
import rentcarServer.reservate.model.ReservationResponseDto;


/**
 * Servlet implementation class CreateReservationFormAction
 */
public class CreateReservationFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateReservationFormAction() {
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

		Object renDate = session.getAttribute("renDate");
		Object returnDate = session.getAttribute("returnDate");
		Object renTime = session.getAttribute("renTime");
		Object returnTime = session.getAttribute("returnTime");
		
		String resevtemp = renDate + " " + renTime;
		String returntemp = returnDate + " " + returnTime;

		
		String userId = request.getParameter("id");
		String carCode = request.getParameter("carCode");
		Timestamp resevDateTime = Timestamp.valueOf(resevtemp);
		Timestamp returnDateTime = Timestamp.valueOf(returntemp);
		String insurance = request.getParameter("insurance");
		boolean paymentStatus = request.getParameter("payment").equals("신용카드") ? true : false;
		String payment = request.getParameter("payment");

		boolean isValid = true;
		
		if(userId == null || userId.equals(""))
			isValid = false;
		else if(carCode == null || carCode.equals(""))
			isValid = false;
		else if(resevDateTime == null || resevDateTime.equals(""))
			isValid = false;
		else if(returnDateTime == null || returnDateTime.equals(""))
			isValid = false;
		else if(insurance == null || insurance.equals(""))
			isValid = false;
		else if(payment == null || payment.equals(""))
			isValid = false;
		
		if(isValid) {
			ReservationDao reservationDao = ReservationDao.getInstance();
			
			String number = reservationDao.createNumber();
			ReservationRequestDto reservationDto = new ReservationRequestDto(number, userId, carCode, resevDateTime, returnDateTime, insurance, paymentStatus, payment);

			ReservationResponseDto reservation = reservationDao.createReservation(reservationDto);
			CarDao carDao = CarDao.getInstance();
			carDao.changeCarReservation(carCode);

			if (reservation == null) {
				request.setAttribute("isReservated", false);
			} else {
				request.setAttribute("isReservated", true);
			}
			
			request.getRequestDispatcher("/reservationCheck").forward(request,response);
		}
	}

}
