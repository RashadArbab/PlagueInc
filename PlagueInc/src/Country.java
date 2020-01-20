
public class Country {
	private int populationInitial ;
	private int infectedPopulation; 
	private int dead; 
	private int populationCurrent; 
	private int dnaPoints ; 
	private double infectivity = 1.00; 
	private double lethality = 1.00; 
	private double cure ; 
	private double cureMultiplier; 
	public Country (int population) {
		
		this.populationInitial = population; 
		this.populationCurrent = population; 
		this.infectedPopulation = 1; 
		this.cureMultiplier = 1.00; 
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
	
	public double getCure() {
		return this.cure; 
	}
	
	public void slowCure() {
		cureMultiplier = cureMultiplier - 0.05; 
	}
	
	public double getCureMultiplier() {
		return this.cureMultiplier; 
	}
		
	
	
	public void cure() {
		
		
		if (infectedPopulation >= ( populationCurrent/2) || (dead >= (0.10 * populationInitial))) {
			double odds =  Math.random() ;
			odds = odds* cureMultiplier ; 
			if (odds >= 0.50) {
				cure = cure +0.01; 
			}
			System.out.println("The cure is at " + (int) cure*100 + " percent"); 
		}
	}
	
	public void increaseInfection () {
		if (infectedPopulation < populationCurrent) {
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
		else {
			
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
