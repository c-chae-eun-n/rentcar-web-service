package rentcarServer.car.controller;

import java.io.IOException;
import java.sql.Timestamp;
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
 * Servlet implementation class SearchModelAction
 */
public class SearchModelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchModelAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		String carModel = request.getParameter("car-model");
		
		session.setAttribute("carModel", carModel);
		
		CarDao carDao = CarDao.getInstance();
		List<CarResponseDto> carList = carDao.searchCarByModel(carModel);

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
