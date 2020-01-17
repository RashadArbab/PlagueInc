import java.util.*; 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int turn = 0 ; 
		boolean gameOver = false; 
			
		Country country = new Country(70000000);
		Scanner scan = new Scanner(System.in); 
		
		
		System.out.println(country.getPopulationCurrent() + " current at start") ;
		System.out.println(country.getPopulationInitial() + " initial at start");
		System.out.println(country.getInfectedPopulation() + " infected at start"); 
		
		
		int month = 1; 
		int dnaPoints = 0; 
		double lethality = 1.00 ; 
		double infectivity = 1.00 ; 
		
		
		while (gameOver == false ) { 
			turn = turn + 1 ;
			
			if (turn % 30  == 0) {
				System.out.println("Month: " + month); 
				month ++ ; 
				
				System.out.println("You Have " + dnaPoints + " dnaPoints"); 
				
				System.out.println("0. exit store");
				System.out.println("1. Would you like to buy increased infectivity (5DNA Points) ?");
				System.out.println("2. Would you like to buy increased lethality (3DNA Points) ? ");
				
				int response = scan.nextInt(); 
				
				while (response != 0) {
					
					if (response == 1) {
						if (dnaPoints >= 5 ) {
							country.increaseInfectivity(); 
							dnaPoints = dnaPoints - 5; 
						}
						else {
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("You do not have enough dna points to evolve"); 
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
						}
					}
					else if (response == 2) {
						if (dnaPoints >= 3) {
							country.increaseLethality() ; 
							dnaPoints = dnaPoints -3; 
						}
						else { 
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("You do not have enough dna points to evolve"); 
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
						}
					}
					System.out.println("0. exit store"); 
					response = scan.nextInt(); 
				
				}
				
				
				
				
			}
			country.death(); 
			country.increaseInfection() ;
			System.out.println("********************************************************************");
			System.out.println(country.getInfectedPopulation() + " population infected"); 
			System.out.println(country.getPopulationCurrent() + " population current") ;
			System.out.println(country.getDead() + " dead"); 
			System.out.println(""); 
			
			if (country.getPopulationCurrent() == 0) {
				gameOver = true; 
				System.out.println("!!!!!!!The whole world is dead!!!!!!!!"); 
			}
			
			
			else if (country.getInfectedPopulation() == 0) {
				gameOver = true; 
				System.out.println("!!!!!!!There are no more infected people left!!!!!!!");
			}
			
			double dnaLottery = Math.random(); 
			if (dnaLottery >= 0.90) {
				dnaPoints++; 
			}
			
			
			
		}
		
		System.out.println("Lethality: " + country.getLethality()) ; 
		System.out.println("Infectivity: " + country.getInfectivity()) ; 
		System.out.println("Month " + month);
		System.out.println("It took " +turn+ " turns to kill the world"); 
		System.out.println("Population Alive: " + country.getPopulationCurrent()  ); 
		System.out.println("Population dead: " + country.getDead() );
		System.out.println("Infected Population " + country.getInfectedPopulation());
	}
}