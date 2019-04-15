package at.fh.swenga.model;

public class CitiesModel {

	private String name;
	private String country;
	private String state;
	private int population;
	
	public CitiesModel() {
		
	}
	
	
	public CitiesModel(String name, String country, String state, int population) {
		super();
		this.name = name;
		this.country = country;
		this.state = state;
		this.population = population;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CitiesModel other = (CitiesModel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CitiesModel [name=" + name + ", country=" + country + ", state=" + state + ", population=" + population
				+ "]";
	}
	
	
	
	
	
}
