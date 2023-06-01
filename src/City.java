public class City {
	
	private int cityId;
	private int x;
	private int y;
	private int[] point;
	
	public City(int cityId, int x, int y) {
		this.cityId = cityId;
		this.x = x;
		this.y = y;
		int[] pointTemp = new int[2];
		pointTemp[0] = x;
		pointTemp[1] = y;
		this.point = pointTemp;
	}
	
	public int getId() {
		return this.cityId;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
	public int[] getPoint() {
		return this.point;
	}

}