import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
class Main {

	public static List<City> cityList = new ArrayList<City>();
	public static void main(String[] args) {
		
		City city1 = new City(0,5,12);
        City city2 = new City(2,3,4);
        City city3 = new City(1,6,38);
        City city4 = new City(3,15,20);
        City city5 = new City(4,72,24);
        City city6 = new City(10,512,1522);
        City city7 = new City(12,35,241);
        City city8 = new City(2411,62,5248);
        City city9 = new City(213,115,220);
        City city10 = new City(21874,57,224);
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);
        cityList.add(city5);
        cityList.add(city6);
        cityList.add(city7);
        cityList.add(city8);
        cityList.add(city9);
        cityList.add(city10);
        

     /*for(int i = 0;i<10000;i++) {
    	  Collections.shuffle(cityList);
    	  TravellerSalesman ts = new TravellerSalesman(cityList);
    	  if(ts.getDistanceMine() < 10800)
    		  System.out.println("FÝNALLLYYYyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

     }*/
       
       
       
       // cityList.add(city5);
        
        double temp = Math.sqrt(Math.pow((city1.getX() - city2.getX()), 2) + Math.pow((city1.getY() - city2.getY()), 2));
        //System.out.print(temp);
        
        TravellerSalesman ts = new TravellerSalesman(cityList);
      
        
        
        
	}

}
