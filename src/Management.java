import java.util.ArrayList;
import java.util.HashMap;

public class Management {
	private String inputFileName;
	private HashMap<Integer, ArrayList<Region>> regions;
	private float rowColumnPercentageForRegion;
	private float distanceX;
	private float distanceY;
	
	public Management(String inputFileName, float percentage) {
		this.inputFileName = inputFileName;
		this.regions = new HashMap<Integer, ArrayList<Region>>();
		this.rowColumnPercentageForRegion = percentage;
		this.distanceX = 0;
		this.distanceY = 0;
	}
	
	public ArrayList<Object> readFile() {
		ReadAndWrite input = new ReadAndWrite("example-input-1");
		int numberOfCities = input.getCities().size();
		ArrayList<Integer> xCoordinates = new ArrayList<Integer>();
		ArrayList<Integer> yCoordinates = new ArrayList<Integer>();
		ArrayList<int[]> parsedLines = new ArrayList<int[]>();
		int[] temp;
		for(City city: input.getCities()) {
			xCoordinates.add(city.getX());
			yCoordinates.add(city.getY());
			temp = new int[3];
			temp[0] = city.getCityId();
			temp[1] = city.getX();
			temp[2] = city.getY();
			parsedLines.add(temp);
		}
		ArrayList<Object> dataPackage = new ArrayList<Object>();
		dataPackage.add(xCoordinates);
		dataPackage.add(yCoordinates);
		dataPackage.add(parsedLines);
		dataPackage.add(numberOfCities);
		
		return dataPackage;
	}
	
	public void createRegions() {
		int n = (int)(100 / this.rowColumnPercentageForRegion);
		for(int i = 0; i < n; i++) {
			ArrayList<Region> row = new ArrayList<Region>();
			for(int j = 0; j < n; j++) {
				float[] leftTopPoint = new float[2];
				leftTopPoint[0] = j * this.distanceX;
				leftTopPoint[1] = (i + 1) * this.distanceY;
				
				float[] leftDownPoint = new float[2];
				leftDownPoint[0] = j * this.distanceX;
				leftDownPoint[1] = i * this.distanceY;
				
				float[] rightTopPoint = new float[2];
				rightTopPoint[0] = (j + 1) * this.distanceX;
				rightTopPoint[1] = (i + 1) * this.distanceY;
				
				float[] rightDownPoint = new float[2];
				rightDownPoint[0] = (j + 1) * this.distanceX;
				rightDownPoint[1] = i * this.distanceY;
				
				row.add(new Region(leftTopPoint, leftDownPoint, rightTopPoint, rightDownPoint, i, j));
			}
			this.regions.put(i, row);
		}
	}
	
	public ArrayList<City> createCities(ArrayList<int[]> parsedLines){
		ArrayList<City> cities = new ArrayList<City>();
		for(int[] parsedLine: parsedLines) {
			cities.add(new City(parsedLine[0], parsedLine[1], parsedLine[2]));
		}
		return cities;
	}
	
	public void placeCitiesToRegions(ArrayList<int[]> parsedLines) {
		ArrayList<City> cities = this.createCities(parsedLines);
		ArrayList<City> addedCities = new ArrayList<City>();
		for(ArrayList<Region> row: this.regions.values()) {
			for(Region region: row) {
				for(City city: cities) {
					boolean isAdded = region.addSuitableCity(city);
					if (isAdded) {
						addedCities.add(city);
					}
				}
				for(City city: addedCities) {
					cities.remove(city);
				}
				addedCities.clear();
			}
		}
	}
	
	public ArrayList<Region> findRegionsForMaxCity() { // can be improved loops!!!
	    int n = (int) (100 / this.rowColumnPercentageForRegion);
	    int max = 0;
	    ArrayList<Region> regions = new ArrayList<Region>();
	    for (int i: this.regions.keySet()) {
	        for (int j = 0; j < n; j++) {
	            int numberOfCities = this.regions.get(i).get(j).getNumberOfCities();
	            if ((numberOfCities > max) && (!this.regions.get(i).get(j).isVisitedTemp())) {
	                max = numberOfCities;
	            }
	        }
	    }

	    for (int i : this.regions.keySet()) {
	        for (int j = 0; j < n; j++) {
	            Region region = this.regions.get(i).get(j);
	            if ((region.getNumberOfCities() == max) && (!region.isVisitedTemp())) {
	                regions.add(region);
	            }
	        }
	    }
	    return regions;
	}

	
	public ArrayList<Region> selectRegionsOfHalfCities(int numberOfCities) { // can be improved for same transition region by using row column
	    ArrayList<Region> orderTourForRegions = new ArrayList<>();
	    int halfCity = numberOfCities / 2;
	    int numberOfVisitedCity = 0;
	    while (true) {
//	        HashMap<Integer, Region> tuples = new HashMap<>();
	        ArrayList<Region> regions = findRegionsForMaxCity();
//	        Region firstRegion = regions.get(0);
//	        if (regions.size() > 2) {
//	            for (int i = 1; i < regions.size(); i++) {
//	                Region region = regions.get(i);
//	                tuples.put(Math.abs(firstRegion.getRow() - region.getRow()), Math.abs(firstRegion.getColumn() - region.getColumn()), region);
//	            }
//	        }
//	        for (int i = 1; i < regions.size(); i++) {
//	            try {
//	                regions.set(i, tuples.get(Collections.min(tuples.keySet())));
//	                tuples.remove(Collections.min(tuples.keySet()));
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        }
	        for (Region region : regions) {
	            numberOfVisitedCity += region.getNumberOfCities();
	            region.setIsVisitedTemp(true);
	            orderTourForRegions.add(region);
	            if (numberOfVisitedCity >= halfCity) {
	                regions.clear();
	                return orderTourForRegions;
	            }
	        }
	    }
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public HashMap<Integer, ArrayList<Region>> getRegions() {
		return regions;
	}

	public float getRowColumnPercentageForRegion() {
		return rowColumnPercentageForRegion;
	}

	public float getDistanceX() {
		return distanceX;
	}

	public float getDistanceY() {
		return distanceY;
	}
	
	public void setDistanceX(float distanceX) {
		this.distanceX = distanceX;
	}
	
	public void setDistanceY(float distanceY) {
		this.distanceY = distanceY;
	}
	
}
