import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
	
	private List<City> cities;
	
	public ReadAndWrite(String filename){
		Scanner scanner;
		try {
			scanner = new Scanner(new File(filename + ".txt"));
			while (scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				
				addCity(line);
								
				 	   	   
			}
		} catch (FileNotFoundException e) {
			System.out.print("txt file problem");
		}
		
		
		
	}
	
	private void addCity(String line) {
		City city = new City(findX(line),findX(line));
		cities.add(city);
	}
	
	private int findX(String line) {
		//Burada stringin icindeki 2.sayi int olarak cevrilecek
		return 0;
	}
	
	private int findY(String line) {
		//Burada stringin icindeki 2.sayi int olarak cevrilecek
		return 0;
	}

	public List<City> getCities() {
		return cities;
	}
	
	

}
