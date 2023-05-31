class Main {
	public static void main(String[] args) {
		ReadAndWrite input = new ReadAndWrite("example-input-3");
		
		System.out.print(input.getCities().get(12486).getId() + " " + input.getCities().get(12486).getX() + " " + input.getCities().get(12486).getY());

	}
	
}
