import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.PerspectiveCamera;

class Main {
	
	public static void runInput1(String inputName, float percentage) {
		Management management = new Management(inputName, percentage);
		ArrayList<Object> dataPackage = management.readFile();
		ArrayList<Integer> xCoordinates = (ArrayList<Integer>)dataPackage.get(0);
		ArrayList<Integer> yCoordinates = (ArrayList<Integer>)dataPackage.get(1);
		ArrayList<int[]> parsedLines = (ArrayList<int[]>)dataPackage.get(2);
		int numberOfCities = (int)dataPackage.get(3);
		int upperX = Collections.max(xCoordinates) + 500;
		int lowerX = Collections.min(xCoordinates) - 500;
		int upperY = Collections.max(yCoordinates) + 500;
		int lowerY = Collections.min(yCoordinates) - 500;
		management.setDistanceX(((upperX - lowerX) * management.getRowColumnPercentageForRegion()) / 100);
		management.setDistanceY(((upperY - lowerY) * management.getRowColumnPercentageForRegion()) / 100);
		management.createRegions();
		management.placeCitiesToRegions(parsedLines); // problem
		ArrayList<Region> orderedTourForRegions = management.selectRegionsOfHalfCities(numberOfCities);
		
		int order = 1;
		int total = 0;
		for(Region region: orderedTourForRegions) {
			System.out.println(order + ": Region[" + region.getRow() + "][" + region.getColumn() + "]" + region.getCities().size());
			order++;
			total = total + region.getCities().size();
		}
		System.out.println("\nTotal cities: " + total);
	}
	
	public static void runInput2(String inputName, float percentage) {
		Management management = new Management(inputName, percentage);
		ArrayList<Object> dataPackage = management.readFile();
		ArrayList<Integer> xCoordinates = (ArrayList<Integer>)dataPackage.get(0);
		ArrayList<Integer> yCoordinates = (ArrayList<Integer>)dataPackage.get(1);
		ArrayList<int[]> parsedLines = (ArrayList<int[]>)dataPackage.get(2);
		int numberOfCities = (int)dataPackage.get(3);
		int upperX = Collections.max(xCoordinates) + 500;
		int lowerX = Collections.min(xCoordinates) - 500;
		int upperY = Collections.max(yCoordinates) + 500;
		int lowerY = Collections.min(yCoordinates) - 500;
		management.setDistanceX(((upperX - lowerX) * management.getRowColumnPercentageForRegion()) / 100);
		management.setDistanceY(((upperY - lowerY) * management.getRowColumnPercentageForRegion()) / 100);
		management.createRegions();
		management.placeCitiesToRegions(parsedLines); // problem
		ArrayList<Region> orderedTourForRegions = management.selectRegionsOfHalfCities(numberOfCities);
		
		int order = 1;
		int total = 0;
		for(Region region: orderedTourForRegions) {
			System.out.println(order + ": Region[" + region.getRow() + "][" + region.getColumn() + "]" + region.getCities().size());
			order++;
			total = total + region.getCities().size();
		}
		System.out.println("\nTotal cities: " + total);
	}
	
	public static void runInput3(String inputName, float percentage) {
		Management management = new Management(inputName, percentage);
		ArrayList<Object> dataPackage = management.readFile();
		ArrayList<Integer> xCoordinates = (ArrayList<Integer>)dataPackage.get(0);
		ArrayList<Integer> yCoordinates = (ArrayList<Integer>)dataPackage.get(1);
		ArrayList<int[]> parsedLines = (ArrayList<int[]>)dataPackage.get(2);
		int numberOfCities = (int)dataPackage.get(3);
		int upperX = Collections.max(xCoordinates) + 500;
		int lowerX = Collections.min(xCoordinates) - 500;
		int upperY = Collections.max(yCoordinates) + 500;
		int lowerY = Collections.min(yCoordinates) - 500;
		management.setDistanceX(((upperX - lowerX) * management.getRowColumnPercentageForRegion()) / 100);
		management.setDistanceY(((upperY - lowerY) * management.getRowColumnPercentageForRegion()) / 100);
		management.createRegions();
		management.placeCitiesToRegions(parsedLines); // problem
		ArrayList<Region> orderedTourForRegions = management.selectRegionsOfHalfCities(numberOfCities);
		
		int order = 1;
		int total = 0;
		for(Region region: orderedTourForRegions) {
			System.out.println(order + ": Region[" + region.getRow() + "][" + region.getColumn() + "]" + region.getCities().size());
			order++;
			total = total + region.getCities().size();
		}
		System.out.println("\nTotal cities: " + total);
	}

	public static void main(String[] args) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput1 - Regions to visit in order");
		runInput1("example-input-1", (float)20); // 5
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput2 - Regions to visit in order");
		runInput2("example-input-2", (float)2); // 2
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput3 - Regions to visit in order");
		runInput3("example-input-3", (float)20); // 5
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
	}	
		
		
		//System.out.print(input.getCities().get(12486).getCityId() + " " + input.getCities().get(12486).getX() + " " + input.getCities().get(12486).getY());

	
	
}