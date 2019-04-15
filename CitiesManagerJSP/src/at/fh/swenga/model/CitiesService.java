package at.fh.swenga.model;
 
import java.util.ArrayList;
import java.util.List;
 
public class CitiesService {
 
	private List<CitiesModel> cities = new ArrayList<CitiesModel>();
 
	/**
	 * Add city to List
	 * 
	 * @param city
	 */
	public void addCity(CitiesModel city) {
		cities.add(city);
	}
 
	/**
	 * Verify if list contains employee with same SSN
	 * 
	 * @param employee
	 * @return
	 */
	public boolean contains(CitiesModel city) {
		return cities.contains(city);
	}
 
	/**
	 * convenient method: true if list is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return cities.isEmpty();
	}
 
	/**
	 * try to find CitiesModel with given name return model, otherwise null
	 * 
	 * @param name
	 * @return
	 */
	public CitiesModel getCityByName(String name) {
		for (CitiesModel citiesModel : cities) {
			if (citiesModel.getName() == name) {
				return citiesModel;
			}
		}
		return null;
	}
 
	/**
	 * return size of list
	 * 
	 * @return
	 */
	public int getSize() {
		return cities.size();
	}
 
	/**
	 * return list with all cities
	 * 
	 * @return
	 */
	public List<CitiesModel> getAllCities() {
		return cities;
	}
 
	/**
	 * return a new list with all employees where firstname or lastname contains
	 * search string
	 * 
	 * @param searchString
	 * @return
	 */
	public List<CitiesModel> getFilteredCities(String searchString) {
 
		if (searchString == null || searchString.equals("")) {
			return cities;
		}
 
		// List for results
		List<CitiesModel> filteredList = new ArrayList<CitiesModel>();
 
		// check every city
		for (CitiesModel citiesModel : cities) {
 
			if ((citiesModel.getName() != null && citiesModel.getName().contains(searchString))
					|| (citiesModel.getCountry() != null && citiesModel.getCountry().contains(searchString))) {
				filteredList.add(citiesModel);
			}
		}
		return filteredList;
	}
 
	/**
	 * TRICKY: remove employees with same ssn
	 * 
	 * @param ssn
	 * @return
	 */
	public boolean remove(String name) {
		return cities.remove(new CitiesModel(name, null, null, 0));
	}
}