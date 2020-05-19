import java.util.List;

public class Mall {
	private List<Floor> floors;

	public Mall() {

	}

	public Mall(List<Floor> floors) {
		this.floors = floors;
	}


	public Mall addFloor(Floor newFloor) {
		this.floors.add(newFloor);
		return this;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public Mall setFloors(List<Floor> floors) {
		this.floors = floors;
		return this;
	}
}
