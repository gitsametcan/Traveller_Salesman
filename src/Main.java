import java.util.List;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		System.gc();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose input file to calculate Half Traveller Salesman Problem! (without .txt)");
		String input = scanner.nextLine();

		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n" + input + " - Regions to visit in order");
		Management management1 = new Management(input, 25); // 5
		management1.run();
		List<City> tempCities = management1.getCities();
		ReadAndWrite html = new ReadAndWrite(input);
		
		TravellerSalesman ts = new TravellerSalesman(tempCities, html.getCities().size()/2);
		//TravellerSalesman ts1 = new TravellerSalesman(html.getCities(), html.getCities().size()/2);
		System.out.println("Total distance with " + html.getCities().size()/2 + " cities is: " + ts.getDistance());
		//System.out.println(ts1.getDistance());
		String output = ts.getDistance() + "\n" + ts.getCitiesStr().toString(); 
		html.writeHTML(output,input);
		
	}	
	
}