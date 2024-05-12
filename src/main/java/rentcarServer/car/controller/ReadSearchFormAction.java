package rentcarServer.car.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.car.model.CarDao;
import rentcarServer.car.model.CarResponseDto;
import rentcarServer.reservate.model.ReservationDao;
import rentcarServer.reservate.model.ReservationRequestDto;
import rentcarServer.reservate.model.ReservationResponseDto;

/**
 * Servlet implementation class ReadSearchFormAction
 */
public class ReadSearchFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadSearchFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		String location = request.getParameter("location");
		String renDate = request.getParameter("ren-date");
		String returnDate = request.getParameter("return-date");
		String renTime = request.getParameter("ren-time");
		String returnTime = request.getParameter("return-time");
		
		session.setAttribute("location", location);
		session.setAttribute("renDate", renDate);
		session.setAttribute("returnDate", returnDate);
		session.setAttribute("renTime", renTime);
		session.setAttribute("returnTime", returnTime);
		
		String resevtemp = renDate + " " + renTime;
		String returntemp = returnDate + " " + returnTime;

		Timestamp resevDateTime = Timestamp.valueOf(resevtemp);
		Timestamp returnDateTime = Timestamp.valueOf(returntemp);
		
		ReservationDao reservationDao = ReservationDao.getInstance();
		
		ReservationRequestDto reservationDto = new ReservationRequestDto();
		reservationDto.setRenDate(resevDateTime);
		reservationDto.setReturnDate(returnDateTime);
		List<ReservationResponseDto> reservationList = reservationDao.createReservationList(reservationDto);
		System.out.println(location);
		System.out.println("reservationList.size: " + reservationList.size());
		
		CarDao carDao = CarDao.getInstance();
		List<CarResponseDto> carList = carDao.readSearchCar(reservationList, location);

		request.setAttribute("carList", carList);
		System.out.println("carList.size: " + carList.size());

		request.getRequestDispatcher("/car").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
