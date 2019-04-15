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
 * Servlet implementation class SaveNewCity
 */
@WebServlet("/saveNewCity")
public class SaveNewCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveNewCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nameString = request.getParameter("name");
		String countryString = request.getParameter("country");
		String stateString = request.getParameter("state");
		String populationString = request.getParameter("population");
		
		String errorMessage = "";
		boolean errorOccurred = false;
		
		
		//---- Convert Population ----
		int population = 0;
		
		try {
			population = Integer.parseInt(populationString);
		} catch (Exception e) {
			errorMessage += "Population invalid<br>";
			errorOccurred = true;
		}
		
		if (!errorOccurred) { // same as: if (errorOccurred==false)
			 
			// get the http session object for the user
			HttpSession session = request.getSession(true);
 
			// EmployeeService in the session? if not, create a new EmployeeService and put it into the session
			CitiesService citiesService = (CitiesService) session.getAttribute("citiesService");
			if (citiesService==null) {
				citiesService=new CitiesService();
				session.setAttribute("citiesService", citiesService);
			}
 
			CitiesModel city = citiesService.getCityByName(nameString);
 
			if (city != null) {
				errorMessage += "City already exists!<br>";
				errorOccurred = true;
			} else {
				CitiesModel cm = new CitiesModel(nameString, countryString, stateString, population);
				citiesService.addCity(cm);
			}
		}
		
		if (!errorOccurred) { // same as: if (errorOccurred==false)
			request.setAttribute("message", "New city " + nameString + " added.");
		}
		else {
			request.setAttribute("errorMessage", errorMessage);
 
		}
		
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
