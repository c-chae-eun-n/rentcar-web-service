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

		Object renDate = request.getParameter("renDate");
		Object returnDate = request.getParameter("returnDate");
		Object renTime = request.getParameter("renTime");
		Object returnTime = request.getParameter("returnTime");
		
		System.out.println("renDate: "+renDate);
		System.out.println("returnDate: "+returnDate);
		System.out.println("renTime: "+renTime);
		System.out.println("returnTime: "+returnTime);
		
		String rentemp = renDate + " " + renTime;
		String returntemp = returnDate + " " + returnTime;
		System.out.println("resevtemp: "+rentemp);
		System.out.println("returntemp: "+returntemp);
		
		String userId = request.getParameter("id");
		String carCode = request.getParameter("carCode");
		System.out.println("userId: "+userId);
		System.out.println("carCode: "+carCode);
		Timestamp resevDateTime = Timestamp.valueOf(rentemp);	//
		Timestamp returnDateTime = Timestamp.valueOf(returntemp);
		String insurance = request.getParameter("insurance");
		boolean paymentStatus = request.getParameter("payment").equals("신용카드") ? true : false;
		String payment = request.getParameter("payment");
		String location = request.getParameter("location");
		String carModel = request.getParameter("carModel");
		String priceTemp = request.getParameter("price");
		int price = Integer.parseInt(priceTemp);
		

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
		else if(location == null || location.equals(""))
			isValid = false;
		else if(carModel == null || carModel.equals(""))
			isValid = false;
		
		if(isValid) {
			ReservationDao reservationDao = ReservationDao.getInstance();
			
			String number = reservationDao.createNumber();
			ReservationRequestDto reservationDto = new ReservationRequestDto(number, userId, carCode, resevDateTime, returnDateTime, insurance, paymentStatus, payment, location, carModel, price);

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
