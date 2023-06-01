import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import javafx.scene.PerspectiveCamera;

class Main {

	public static void main(String[] args) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput1 - Regions to visit in order");
		Management management1 = new Management("example-input-2", 20); // 5
		management1.run();
		List<City> tempCities = management1.getCities();
		ReadAndWrite html = new ReadAndWrite("example-input-2");
		for (City c : tempCities) {
			//System.out.println(c.getId()+" "+c.getX()+" "+c.getY());
			
		}
		
		TravellerSalesman ts = new TravellerSalesman(tempCities, html.getCities().size()/2);
		TravellerSalesman ts1 = new TravellerSalesman(html.getCities(), html.getCities().size()/2);
		//System.out.println(ts.getCitiesStr().toString());
		System.out.println(ts.getDistance());
		System.out.println(ts1.getDistance());
		String output = ts.getDistance() + "\n" + ts.getCitiesStr().toString(); 
		html.writeHTML(output);
		
	}	
	
}