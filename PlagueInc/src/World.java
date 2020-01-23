import java.util.ArrayList;
import java.util.List;

public class World {
	List<Country> countries; 
	private int populationInitial ;
	private int populationCurrent; 
	private int populationInfected; 
	private int populationDead; 
	private double cure;
	
	
	
	
	
	
	public World(List<Country> countries) {
		this.countries = countries; 
		this.populationInitial = 0 ; 
		this.populationCurrent = 0; 
		this.populationDead = 0; 
		this.populationInfected = 0 ; 
		this.cure = 0; 
		for(int i = 0 ; i < countries.size(); i++) {
			this.populationInitial += countries.get(i).getPopulationInitial(); 
			this.populationCurrent += countries.get(i).getPopulationCurrent();
			this.populationDead += countries.get(i).getDead();
			this.populationInfected += countries.get(i).getInfectedPopulation(); 
		}
		
	}
	
	
	
	public List<Country> getCountries () {
		return this.countries; 
	}
	
	public void addCountry(Country country) { 
		countries.add(country); 
	
	}
	
	public int getInfectedPopulation() {
		int infected = 0; 
		for (int i = 0; i < countries.size(); i ++) {
			infected += countries.get(i).getInfectedPopulation();
		}
		
		return infected; 
	}
	
	public int getPopulation() {
		int pop = 0 ; 
		for (int i = 0 ; i < countries.size(); i++) {
			pop += countries.get(i).getPopulationCurrent(); 
		}
		return pop; 
	}
	
	public int getPopulationInitial() {
		int pop = 0 ;  
		for (int i = 0 ; i < countries.size(); i++) {
			pop += countries.get(i).getPopulationInitial(); 
		}
		return pop; 
	}
	
	public int getDead() {
		int dead = 0 ; 
		for (int i = 0 ; i < countries.size(); i++) {
			dead += countries.get(i).getDead(); 
		}
		return dead;
	}
	
	public double getCure() {
		double cure = 0 ; 
		for (int i = 0; i < countries.size(); i++) {
			cure += countries.get(i).getCure(); 
		}
		
		return cure; 
	}
	
	public void spread(int i) {
		double odds = Math.random() ; 
		if (odds >= 0.98) {
			if(countries.get(i).getInfectedPopulation() == 0) {
				countries.get(i).increaseInfection(i); 
				countries.get(i).increasePopulation();
			}
				if (i > 0) {
					countries.get(i-1).decreasePopulation();
				} 
				else if (i <1) {
					countries.get(i+1).decreasePopulation();
				}
			}
		}

				
		
	
	public void spread() {
		double odds = Math.random();
		if (odds >= 0.98){
			for (int i = 0; i < countries.size(); i ++) {
				if(countries.get(i).getInfectedPopulation() == 0) {
					countries.get(i).increaseInfection(i+1); 
					countries.get(i).increasePopulation();
				}
					if (i > 0) {
						countries.get(i-1).decreasePopulation();
					} 
					else if (i <1) {
						countries.get(i+1).decreasePopulation();
					}
				}
		}
	}

	
	public void death () {
		for (int i = 0; i < countries.size(); i ++) {
			countries.get(i).death();
		} 
	}
	
	public void increaseInfection () {
		for (int i = 0; i < countries.size(); i ++) {
			countries.get(i).increaseInfection();
		} 
	}
	
	public void cure () {
		for (int i = 0; i < countries.size(); i ++) {
			countries.get(i).cure();
		} 
	}
	
	public void increaseInfectivity() {
		for (int i = 0; i < countries.size(); i ++) {
			countries.get(i).increaseInfectivity();
		} 
	}
	
	public void increaseLethality() {
		for (int i = 0; i < countries.size(); i ++) {
			countries.get(i).increaseLethality();
		} 
	}
	
	public void slowCure() {
		for (int i = 0; i < countries.size(); i ++) {
			countries.get(i).slowCure();
		} 
	}
	
	
}
