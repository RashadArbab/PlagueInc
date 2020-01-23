import java.util.*; 
public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int turn = 0 ; 
		boolean gameOver = false; 
			
		Country countryA = new Country(100000000);
		Country countryB = new Country(100000000);
		
		
		
		countryB.increaseInfection(1);
		 
		List<Country> countries = new ArrayList<Country>() ;  
		
		countries.add(countryA);
		countries.add(countryB); 
		
		
		World world = new World(countries); 
		 
		//world.spread(); 
		
		Scanner scan = new Scanner(System.in); 
		
		System.out.println(countryA.getPopulationCurrent() + " current at start") ;
		System.out.println(countryA.getPopulationInitial() + " initial at start");
		System.out.println(countryA.getInfectedPopulation() + " infected at start"); 
		
		
		int month = 1; 
		int dnaPoints = 0; 
		
		
		while (gameOver == false ) { 
			turn = turn + 1 ;
			
			
			System.out.println(world.getInfectedPopulation() + " infected world pop");
			System.out.println(world.getPopulation() + " current world population");
			
			
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
							world.increaseInfectivity(); 
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
							world.increaseLethality() ; 
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
							world.slowCure()  ; 
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
			
			System.out.println("");
			System.out.println("");
			System.out.println(""); 
			
			System.out.println("********************************************************************");
			world.increaseInfection() ;
			world.spread();
			world.death(); 
			world.cure();
			
			System.out.println("Population infected");
			System.out.println("Country A: " + countryA.getInfectedPopulation()  + " Country B: " + countryB.getInfectedPopulation());
			System.out.println("");
			System.out.println("Population Current");
			System.out.println("Country A: " + countryA.getPopulationCurrent()  + " Country B: " + countryB.getPopulationCurrent());
			System.out.println("");
			System.out.println("Population Dead ");
			System.out.println("Country A: " + countryA.getDead()  + " Country B: " + countryB.getDead());
			System.out.println("");
			System.out.println("The cure is at " +  Math.round(world.getCure() *  100.0)  + " percent"); 
			System.out.println(""); 
			System.out.flush();
			if (world.getPopulation() == 0) {
				gameOver = true; 
				System.out.println("!!!!!!!The whole world is dead!!!!!!!!"); 
			}
			
			
			else if (world.getInfectedPopulation() == 0) {
				gameOver = true; 
				System.out.println("!!!!!!!There are no more infected people left!!!!!!!");
			}
			
			else if (world.getCure() >= 1) {
				gameOver = true; 
				System.out.println("You Lose!!!!! A cure was found!!!"); 
			}
			
			double dnaLottery = Math.random(); 
			if (dnaLottery >= 0.90) {
				dnaPoints++; 
			}
			
			
			
		}
		
		 
		System.out.println("Cure Multiplier: " + countryA.getCureMultiplier());
		System.out.println("Lethality: " + countryA.getLethality()) ; 
		System.out.println("Infectivity: " + countryA.getInfectivity()) ; 
		System.out.println("Month " + month);
		if (world.getPopulation() == 0) {
		System.out.println("It took " +turn+ " turns to kill the world"); 
		}
		else if (world.getCure() >= 1) {
			System.out.println("It took " + turn + " to find the cure");
		}
		else {
			System.out.println("Everyone with the virus is dead. It took " + turn + " turns"); 
		}
		System.out.println("Population Alive: " + world.getPopulation()  ); 
		System.out.println("Population dead: " + world.getDead() );
		System.out.println("Infected Population " + world.getInfectedPopulation());
	}
	
	
}