package rentcarServer.reservate.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import rentcarServer.reservate.model.ReservationDao;

/**
 * Servlet implementation class SearchReservationFormAction
 */
public class SearchReservationFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchReservationFormAction() {
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
		
		String carCode = request.getParameter("carCode");
		String renDate = request.getParameter("renDate");
		String returnDate = request.getParameter("returnDate");
		String renTime = request.getParameter("renTime");
		String returnTime = request.getParameter("returnTime");
		
		String rentemp = renDate + " " + renTime;
		String returntemp = returnDate + " " + returnTime;

		Timestamp renDateTime = Timestamp.valueOf(rentemp);
		Timestamp returnDateTime = Timestamp.valueOf(returntemp);
		
		ReservationDao reservationDao = ReservationDao.getInstance();
		boolean isValid = reservationDao.reserveExists(carCode, renDateTime, returnDateTime);
		
		JSONObject object = new JSONObject();
		
		object.put("carCode", carCode);
		object.put("isValid", isValid);
		
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.append(object.toString());
	}

}
