package rentcarServer.car.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentcarServer.car.model.CarDao;
import rentcarServer.car.model.CarResponseDto;

/**
 * Servlet implementation class SearchFuelAction
 */
public class SearchFuelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFuelAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		String fuel = request.getParameter("fuel");
		
		session.setAttribute("fuel", fuel);
		
		CarDao carDao = CarDao.getInstance();
		List<CarResponseDto> carList = carDao.searchCarByFuel(fuel);

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
