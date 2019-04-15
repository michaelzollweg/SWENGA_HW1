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
 * Servlet implementation class FillCitiesList
 */
@WebServlet("/fillCitiesList")
public class FillCitiesList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FillCitiesList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get the http session object for the user
		HttpSession session = request.getSession(true);
		
		// get the employeeService out of the session
		CitiesService citiesService = (CitiesService) session.getAttribute("citiesService");
		if (citiesService == null) {
			citiesService = new CitiesService();
			session.setAttribute("citiesService", citiesService);
		}
		
		int people = 42;
		
		citiesService.addCity(new CitiesModel("Wien","Austria","Wien", people));
		citiesService.addCity(new CitiesModel("Graz","Austria","Steiermark", people));
		citiesService.addCity(new CitiesModel("St. Johann im Pongau","Austria","Salzburg", people));
		
		RequestDispatcher rd = request.getRequestDispatcher("./listCities");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
