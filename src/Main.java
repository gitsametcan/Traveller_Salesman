import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

	public static void main(String[] args) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		Management management1 = new Management("example-input-1", 19); // input-3 %5 verified, input-1 %19, input-2 %8
		management1.run();
		List<City> tempCities = management1.getCities();
		ReadAndWrite html = new ReadAndWrite("example-input-1");
		TravellerSalesman ts = new TravellerSalesman(tempCities, html.getCities().size()/2);
		TravellerSalesman ts1 = new TravellerSalesman(html.getCities(), html.getCities().size()/2);
		String output = ts.getDistance() + "\n" + ts.getCitiesStr().toString(); 
		html.writeHTML(output);
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		Management management2 = new Management("example-input-2", 8); // input-3 %5 verified, input-1 %19, input-2 %8
		management2.run();
		tempCities = management2.getCities();
		html = new ReadAndWrite("example-input-2");
		ts = new TravellerSalesman(tempCities, html.getCities().size()/2);
		ts1 = new TravellerSalesman(html.getCities(), html.getCities().size()/2);
		output = ts.getDistance() + "\n" + ts.getCitiesStr().toString(); 
		html.writeHTML(output);
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");
		Management management3 = new Management("example-input-3", 5); // input-3 %5 verified, input-1 %19, input-2 %8
		management3.run();
		tempCities = management3.getCities();
		html = new ReadAndWrite("example-input-3");
		ts = new TravellerSalesman(tempCities, html.getCities().size()/2);
		ts1 = new TravellerSalesman(html.getCities(), html.getCities().size()/2);
		output = ts.getDistance() + "\n" + ts.getCitiesStr().toString(); 
		html.writeHTML(output);
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
	}	
	
}