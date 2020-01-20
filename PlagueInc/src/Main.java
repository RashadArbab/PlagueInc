import java.util.*; 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int turn = 0 ; 
		boolean gameOver = false; 
			
		Country country = new Country(10000000);
		Scanner scan = new Scanner(System.in); 
		
		
		System.out.println(country.getPopulationCurrent() + " current at start") ;
		System.out.println(country.getPopulationInitial() + " initial at start");
		System.out.println(country.getInfectedPopulation() + " infected at start"); 
		
		
		int month = 1; 
		int dnaPoints = 0; 
		
		
		while (gameOver == false ) { 
			turn = turn + 1 ;
			
			if (turn % 30  == 0) {
				System.out.println("Month: " + month); 
				month ++ ; 
				
				System.out.println("You Have " + dnaPoints + " dnaPoints"); 
				
				System.out.println("0. exit store");
				System.out.println("1. Would you like to buy increased infectivity?  (5DNA Points)");
				System.out.println("2. Would you like to buy increased lethality?  (3DNA Points)");
				System.out.println("3. Would you like to slow down the cure?  (4DNA Points)"); 
				
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
							System.out.println("You do not have enough dna points to increase the infection rate"); 
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
							System.out.println("You do not have enough dna points to increase the lethality"); 
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("");
						}
					}
					
					if (response == 3) {
							if (dnaPoints >= 4) {
							country.slowCure()  ; 
							dnaPoints = dnaPoints -4; 
						}
						else { 
							System.out.println("");
							System.out.println("");
							System.out.println("");
							System.out.println("You do not have enough dna points to slow down the cure "); 
							System.out.println("");
							System.out.println("");
							System.out.println("");
						}
					}
					
					System.out.println("0. exit store"); 
					response = scan.nextInt(); 
				
				}
				
				
				
				
			}
			
			 
			System.out.println("********************************************************************");
			
			country.death(); 
			country.increaseInfection() ;
			country.cure();
			
			System.out.println(country.getInfectedPopulation() + " population infected"); 
			System.out.println(country.getPopulationCurrent() + " population current") ;
			System.out.println(country.getDead() + " dead"); 
			System.out.println("The cure is at " +  Math.round(country.getCure() *  100.0)  + " percent"); 
			System.out.println(""); 
			
			if (country.getPopulationCurrent() == 0) {
				gameOver = true; 
				System.out.println("!!!!!!!The whole world is dead!!!!!!!!"); 
			}
			
			
			else if (country.getInfectedPopulation() == 0) {
				gameOver = true; 
				System.out.println("!!!!!!!There are no more infected people left!!!!!!!");
			}
			
			else if (country.getCure() >= 1) {
				gameOver = true; 
				System.out.println("You Lose!!!!! A cure was found!!!"); 
			}
			
			double dnaLottery = Math.random(); 
			if (dnaLottery >= 0.90) {
				dnaPoints++; 
			}
			
			
			
		}
		
		if (country.getCure() == 0.00) {
			System.out.println("Work on the cure has yet to begin") ; 
		}
		else {
		System.out.println("The cure is at " + Math.round(country.getCure()* 100) + " percent");
		} 
		System.out.println("Cure Multiplier: " + country.getCureMultiplier());
		System.out.println("Lethality: " + country.getLethality()) ; 
		System.out.println("Infectivity: " + country.getInfectivity()) ; 
		System.out.println("Month " + month);
		if (country.getPopulationCurrent() == 0) {
		System.out.println("It took " +turn+ " turns to kill the world"); 
		}
		else if (country.getCure() >= 1) {
			System.out.println("It took " + turn + " to find the cure");
		}
		else {
			System.out.println("Everyone with the virus is dead. It took " + turn + " turns"); 
		}
		System.out.println("Population Alive: " + country.getPopulationCurrent()  ); 
		System.out.println("Population dead: " + country.getDead() );
		System.out.println("Infected Population " + country.getInfectedPopulation());
	}
}