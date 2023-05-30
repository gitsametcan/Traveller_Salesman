import java.util.ArrayList;
import java.util.List;

public class TravellerSalesman {
	
	private List<Integer> cityList;
	private long distance;
	
	public TravellerSalesman(List<City> cities) {
		this.cityList = orderCities(cities);
		this.distance = calculateDistance(cities);
	}
	
	private List<Integer> orderCities(List<City> cities) {
		List<Integer> orderedList = new ArrayList();
		
		// matris olusturma
		// matris islemleri
		return null;
	}
	
	private int[][] generateMatrix(List<City> cities) {
		//matris burada olusacak
		
		int[][] matrixArr = new int[cities.size()][];
		
		for (int i = 0; i < cities.size(); i++) {
			for(int j = 0; j < cities.size(); j++) {
				matrixArr[i][j] = (int) twoCityDistance(cities.get(i),cities.get(j));
			}
		}
		
		
		return matrixArr;
	}
	
	private long calculateDistance(List<City> cities) {
		long result = 0;
		for (int i = 0; i<cities.size(); i++) {
			result = result + twoCityDistance(cities.get(i), cities.get(i+1));
		}
		return 0;
	}
	
	private long twoCityDistance(City city1, City city2) {
		return Math.round(Math.sqrt((city1.getX()-city2.getX())^2 + (city1.getY()-city2.getY())^2));
	}

	public List<Integer> getCityList() {
		return cityList;
	}

	public long getDistance() {
		return distance;
	}

}
