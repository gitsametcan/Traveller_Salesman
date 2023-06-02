import java.util.ArrayList;
import java.util.List;
public class TravellerSalesman {
	
	private List<Integer> cityList;
	private long distance;
	private int [][]cityTable;
	private List<Integer> orderedCities;
	private String citiesStr;	
	public TravellerSalesman(List<City> cities, int half) {
		//this.cityList = orderCities(cities);
		//this.distance = calculateDistance(cities);
		cities = remove(cities,half);
		this.cityTable = generateMatrix(cities);
		this.orderedCities = orderCities(cities);
		
	}
	private List<Integer> orderCities(List<City> cities) {
		
		StringBuilder stringBuilder = new StringBuilder();
		List<Integer> orderedList = new ArrayList();
		List<City> tempCityList = new ArrayList<City>();
		
		int[][] tempMatrixArr = this.cityTable;
		distance = 0;
		int min = Integer.MAX_VALUE;
		int tempX = 0;
		int tempY = 0;
		
		for (int i = 0; i < cities.size(); i++) {
			tempCityList.add(cities.get(i));
			orderedList.add(cities.get(i).getId());
			stringBuilder.append(cities.get(i).getId()+"");
			stringBuilder.append("\n");
			
			if(orderedList.size() == cities.size()) {
				distance += tempMatrixArr[i][0];
				//orderedList.add(cities.get(0).getId());
				//stringBuilder.append(cities.get(0).getId()+"");
				//tempCityList.add(cities.get(0));
				break;
			}
			
			min = Integer.MAX_VALUE;
			for(int j = 1; j < cities.size(); j++) {
				
				if(tempMatrixArr[i][j] > 0 && tempMatrixArr[i][j] < min) {
					min = tempMatrixArr[i][j];
					tempX = i;
					tempY = j;
				}
				
			}
			distance += min;
			for (int k = 0; k < cities.size(); k++)
				tempMatrixArr[k][tempY] = 0;
			for (int k = 0; k < cities.size(); k++)
				tempMatrixArr[tempX][k] = 0;
			i = tempY - 1;
		}
		citiesStr = stringBuilder.toString();
		//System.out.println(orderedList + "-> According to the id numbers");
		/*System.out.println(orderedList.size() - 1 +" + 1 = "+orderedList.size() +" cities travelled");
		System.out.println("Total Length = " + distance);*/
		return orderedList;
	}
	
	private int[][] generateMatrix(List<City> cities) {
		//matris burada olusacak
		
		int[][] matrixArr = new int[cities.size()][cities.size()];
		
		for (int i = 0; i < cities.size(); i++) {
			for(int j = 0; j < cities.size(); j++) {
				matrixArr[i][j] = (int) twoCityDistance(cities.get(i),cities.get(j));
				
			}
		}
		
		/*for(int i = 0; i < matrixArr.length; i++) {
			for(int j = 0; j < matrixArr.length; j++) {
			System.out.print(matrixArr[i][j] + " ");
			}
			System.out.println();
		}*/
		
		
		return matrixArr;
	}
	
	private long calculateDistance(List<City> cities) {
		long result = 0;
		for (int i = 0; i<cities.size() - 1; i++) {
			result = result + twoCityDistance(cities.get(i), cities.get(i+1));
		}
		return 0;
	}
	
	private long twoCityDistance(City city1, City city2) {
		long temp = Math.round(Math.sqrt(Math.pow((city1.getX() - city2.getX()), 2) + Math.pow((city1.getY() - city2.getY()), 2)));
		return temp;
		
	}
	
	private List<City> remove(List<City> cities,int a){
		List<City> tempCityList = new ArrayList<City>();
		
		for (int i = 0; i<a; i++) {
			tempCityList.add(cities.get(i));
		}
		
		return tempCityList;
	}
	public List<Integer> getCityList() {
		return cityList;
	}
	public long getDistance() {
		return distance;
	}
	
	public String getCitiesStr() {
		return citiesStr;
	}
}