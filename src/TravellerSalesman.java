import java.util.ArrayList;
import java.util.List;

public class TravellerSalesman {
	
	private ArrayList<Integer> cityList;
	private long distance;
	private int [][]cityTable;
	private ArrayList<Integer> orderedCities;
	private String citiesStr;
	private ArrayList<Region> orderedTourForRegions;
	private int halfOfCity;

	public TravellerSalesman(ArrayList<Region> orderedTourForRegions, int halfOfCity) {
		//this.cityList = orderCities(cities);
		//this.distance = calculateDistance(cities);
		this.halfOfCity = halfOfCity;
		this.orderedTourForRegions = orderedTourForRegions;
		this.cityTable = new int[0][0];
		this.orderedCities = new ArrayList<Integer>();
		this.visitEachRegion();
		
	}
	
	public void visitEachRegion() {
		long sumDistance = 0;
		int index = 1;
		for(Region region: this.orderedTourForRegions) {
			this.cityTable = generateMatrix(region.getCities());
			this.orderedCities = orderCities(region, index);
			sumDistance = sumDistance + distance;
			index++;
			
		}
		System.out.println(sumDistance);
	}

	public ArrayList<Integer> orderCities(Region region, int index) {
		ArrayList<City> cities = region.getCities();
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<Integer> orderedList = new ArrayList();
		ArrayList<City> tempCityList = new ArrayList<City>();
		
		int[][] tempMatrixArr = this.cityTable;
		distance = 0;
		int min = Integer.MAX_VALUE;
		int tempX = 0;
		int tempY = 0;
		int total = cities.size();
		for(Region regionTemp: this.orderedTourForRegions) {
			if(this.orderedTourForRegions.indexOf(regionTemp) == this.orderedTourForRegions.size() - 1) {
				break;
			}
			total = total + regionTemp.getCities().size();
		}

		if (this.orderedTourForRegions.indexOf(region) == this.orderedTourForRegions.size() - 1) {
			total = halfOfCity - total;
		}
		
		
		for (int i = 0; i < total; i++) {
			tempCityList.add(cities.get(i));
			orderedList.add(cities.get(i).getId());
			stringBuilder.append(cities.get(i).getId()+"");
			stringBuilder.append(" ");
			
			if(orderedList.size() == cities.size()) {
				try {
					distance += this.twoCityDistance(tempCityList.get(tempCityList.size() - 1), this.orderedTourForRegions.get(index).getCities().get(0));
				}
				catch (java.lang.IndexOutOfBoundsException e) {
					break;
				}

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
		System.out.println("\n"+orderedList + "-> According to the id numbers");
		System.out.println(orderedList.size() - 1 +" + 1 = "+orderedList.size() +" cities travelled");
		System.out.println("Total Length = " + distance);
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
		
//		for(int i = 0; i < matrixArr.length; i++) {
//			for(int j = 0; j < matrixArr.length; j++) {
//			System.out.print(matrixArr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
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