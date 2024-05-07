package rentcarServer.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import rentcarServer.user.model.UserDao;

/**
 * Servlet implementation class FindUserAction
 */
@WebServlet("/FindUserAction")
public class FindUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserAction() {
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
		
		String id = request.getParameter("id");
		
		UserDao userDao = UserDao.getInstance();
		boolean isValid = !userDao.userExists(id);
		
		JSONObject object = new JSONObject();
		
		object.put("id", id);
		object.put("isValid", isValid);
		
		// response type 설정 (MIME-Type)
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.append(object.toString());
	}

}
