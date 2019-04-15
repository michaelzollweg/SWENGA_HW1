package at.fh.swenga.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.fh.swenga.model.CitiesModel;
import at.fh.swenga.model.CitiesService;

/**
 * Servlet implementation class EditCity
 */
@WebServlet("/editCity")
public class EditCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String nameString = request.getParameter("name");
		 
		
 
		// get the http session object for the user
		HttpSession session = request.getSession(true);
 
		// get the employeeService out of the session
		CitiesService citiesService = (CitiesService) session.getAttribute("citiesService");
 
		if (citiesService != null) {
			CitiesModel citiesModel = citiesService.getCityByName(nameString);
			if (citiesModel != null) {
				request.setAttribute("city", citiesModel);
				RequestDispatcher rd = request.getRequestDispatcher("./editCity.jsp");
				rd.forward(request, response);
				return;
			}
		}
 
		request.setAttribute("errorMessage", "No city with name " + nameString);
		RequestDispatcher rd = request.getRequestDispatcher("./listCities");
		rd.forward(request, response);
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
