package at.fh.swenga.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.fh.swenga.model.CitiesService;

/**
 * Servlet implementation class ListCities
 */
@WebServlet("/listCities")
public class ListCities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCities() {
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
		

		// EmployeeService in the session? if not, create a new EmployeeService and put it into the session
		CitiesService citiesService =(CitiesService)session.getAttribute("citiesService");	
		
		if (citiesService==null) {
			citiesService=new CitiesService();
			session.setAttribute("citiesService", citiesService);
		}
		
		request.setAttribute("cities", citiesService.getAllCities());
		
		RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
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
