import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.PerspectiveCamera;

class Main {

	public static void main(String[] args) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput1 - Regions to visit in order");
		Management management1 = new Management("example-input-1", 20); // 5
		management1.run();
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput2 - Regions to visit in order");
		Management management2 = new Management("example-input-2", 2); // 2
		management2.run();
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput3 - Regions to visit in order");
		Management management3 = new Management("example-input-3", 20); // 5
		management3.run();
		System.out.println("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
	}	
	
}