import java.util.ArrayList;
import java.util.List;

public class TravellerSalesman {
	
	private List<Integer> cityList;
	private int distance;
	
	public TravellerSalesman(List<City> cities) {
		this.cityList = orderCities(cities);
		this.distance = calculateDistance(cities);
	}
	
	private List<Integer> orderCities(List<City> cities) {
		List<Integer> orderedList = new ArrayList();
		//Burada dugru siralamamizi olusturacaz
		return orderedList;
	}
	
	private int calculateDistance(List<City> cities) {
		//Burada siralanmis listeyi cagirip, dosyadaki formul ugulanacak iki sehir icin mesafe hesaplama methodunu yazdim
		return 0;
	}
	
	private long twoCityDistance(City city1, City city2) {
		return Math.round(Math.sqrt((city1.getX()-city2.getX())^2 + (city1.getY()-city2.getY())^2));
	}

	public List<Integer> getCityList() {
		return cityList;
	}

	public int getDistance() {
		return distance;
	}

}
