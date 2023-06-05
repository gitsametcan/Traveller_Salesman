import java.util.List;

class Main {

	public static void main(String[] args) {
		
		System.gc();
		String input = "example-input-4";
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput1 - Regions to visit in order");
		Management management1 = new Management(input, 25); // 5
		management1.run();
		List<City> tempCities = management1.getCities();
		ReadAndWrite html = new ReadAndWrite(input);
		
		TravellerSalesman ts = new TravellerSalesman(tempCities, html.getCities().size()/2);
		//TravellerSalesman ts1 = new TravellerSalesman(html.getCities(), html.getCities().size()/2);
		System.out.println(ts.getDistance());
		//System.out.println(ts1.getDistance());
		String output = ts.getDistance() + "\n" + ts.getCitiesStr().toString(); 
		html.writeHTML(output,input);
		
	}	
	
}