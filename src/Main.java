import java.util.List;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		boolean isTrue = true;
		while(isTrue) {
	    System.gc();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter input file name for calculate Half Traveller Salesman Problem"
				+ " without file extnsion! (input file must be in txt format)");
		String input = scanner.next();
		
		System.out.println("Now we We will already ask you to enter a percentage. This will use for region dividing. For example: \n"
				+ "if you enter 20 your, the area will divide into 5 rows and 5 columns (100/20=5) or \n"
				+ "if you enter 10 your, the area will divide into 10 rows and 10 columns (100/10=10)");
		

		int ratio = scanner.nextInt();
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n" + input + " - Regions to visit in order");
		Management management1 = new Management(input, ratio); // 5
		management1.run();
		List<City> tempCities = management1.getCities();
		ReadAndWrite html = new ReadAndWrite(input);
		
		TravellerSalesman ts = new TravellerSalesman(tempCities, html.getCities().size()/2);
		
		System.out.println("Total distance with " + html.getCities().size()/2 + " cities is: " + ts.getDistance());
		
		String output = ts.getDistance() + "\n" + ts.getCitiesStr().toString(); 
		html.writeHTML(output,input);
		
		System.out.println("Do you want to continue calculating? Yes or No");
		String yesOrNo = scanner.next();
		
		if (yesOrNo.equals("Yes")) {
			isTrue = true;
		}
		else if (yesOrNo.equals("No")) {
			isTrue = false;
			System.out.println("Have a nice day!");
		}
		else {
			while(!yesOrNo.equals("Yes") && !yesOrNo.equals("No")) {
		System.out.println("Please enter Yes or No");
		System.out.println("Do you want to continue calculating? Yes or No");
		yesOrNo = scanner.nextLine();
		if (yesOrNo.equals("Yes")) {
			isTrue = true;
		}
		else if (yesOrNo.equals("No")) {
			isTrue = false;
			System.out.println("Have a nice day!");
		}
		}
		}
		
		}
		
		
	}	
	
}