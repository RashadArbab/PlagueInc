
public class Country {
	private int populationInitial ;
	private int infectedPopulation; 
	private int dead; 
	private int populationCurrent; 
	private int dnaPoints ; 
	private double infectivity = 1.00; 
	private double lethality = 1.00; 
	

	public Country (int population) {
		
		this.populationInitial = population; 
		this.populationCurrent = population; 
		this.infectedPopulation = 1; 
		
	}
	
	
	
	public int getPopulationInitial() { 
		return this.populationInitial; 
	}
	
	public int getPopulationCurrent() {
		return populationCurrent;
	}
	
	public int getInfectedPopulation() {
		return this.infectedPopulation; 
	}
	
	public int getDead() {
		return this.dead; 
	}
	
	public double getInfectivity() {
		return this.infectivity; 
	}
	
	public double getLethality() {
		return this.lethality; 
	}
	
	public void increaseInfectivity() {
		infectivity = infectivity + 0.05;
	}
	
	public void increaseLethality() {
		lethality = lethality + 0.05;
	}
	
	
	public void increaseInfection () {
		
		for (int i = 0 ; i <= infectedPopulation; i ++) {
		double odds =   Math.random() ;
		odds = odds * infectivity; 
		
			if (infectedPopulation < populationCurrent) { 
				if (odds >= 0.90) {
					this.infectedPopulation ++; 
				
				}
		
			}
		}
		
	}
	
	public void death() {
		for (int i = 0; i < infectedPopulation; i ++) {
			double num = Math.random() ;
			num = num* lethality; 
			if (num >= 0.95) { 
				populationCurrent --; 
				infectedPopulation --; 
				
				dead ++; 
				
			}
		}
	
	
	
	}
}
