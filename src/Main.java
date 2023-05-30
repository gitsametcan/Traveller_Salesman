import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
class Main {

	public static List<City> cityList = new ArrayList<City>();
	public static void main(String[] args) {
		
        
        
        City city1 = new City(5,12);
        City city2 = new City(3,4);
        City city3 = new City(6,8);
        City city4 = new City(15,20);
        City city5 = new City(7,24);
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
        cityList.add(city5);
        
        double temp = Math.sqrt(Math.pow((city1.getX() - city2.getX()), 2) + Math.pow((city1.getY() - city2.getY()), 2));
        //System.out.print(temp);
        
        TravellerSalesman ts = new TravellerSalesman(cityList);
        
        
        
	}

}
