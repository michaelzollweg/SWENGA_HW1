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
 * Servlet implementation class ChangeCity
 */
@WebServlet("/changeCity")
public class ChangeCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeCity() {
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
 
		// get all form data out of the request
		String nameString = request.getParameter("name");
		String countryString = request.getParameter("country");
		String stateString = request.getParameter("state");
		String populationString = request.getParameter("population");
 
		// provide a String to collect all error messages
		String errorMessage = "";
		boolean errorOccurred = false;
 
		// ---- Convert population ----
		// if population is not a number -> add an error text to the error message
		int population = 0;
		try {
			population = Integer.parseInt(populationString);
		} catch (Exception e) {
			errorMessage += "Population invalid<br>";
			errorOccurred = true;
		}
 
 
		// Data Conversion ok? -> Change Employee
		if (!errorOccurred) { // same as: if (errorOccurred==false)
			CitiesModel city = citiesService.getCityByName(nameString);
 
			if (city == null) {
				errorMessage += "City doesn't exist!<br>";
				errorOccurred = true;
			} else { 
				// overwrite data in the existing employee object
				city.setCountry(countryString);
				city.setState(stateString);
				city.setPopulation(population);
				
			}
		}
 
		// --- Create a message for the JSP
 
		if (!errorOccurred) { // same as: if (errorOccurred==false)
			// No error? Then put a message on the page that an employee has changed
			request.setAttribute("message", "City " + nameString + " changed.");
		} else {
			// Errors happened? -> put all collected error messages in the request for the JSP
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
