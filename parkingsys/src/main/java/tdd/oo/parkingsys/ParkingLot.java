package tdd.oo.parkingsys;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tdd.oo.parkingsys.Exception.noMoreFreeParkingException;
import tdd.oo.parkingsys.Exception.wrongPickUpCarNumberException;

public class ParkingLot {
	
	private int spaceCount;
	
	private Set<Car> pakedCars = new HashSet<Car>();

	public ParkingLot(int spaceCount) {
		this.spaceCount = spaceCount;
	}

	public int getFreeSpace() {
		return spaceCount;
	}
	
	public void parking(List<Car> cars) throws noMoreFreeParkingException{
		for(Car car:cars){
			pakedCars.add(car);
			spaceCount--;
		}
		if(spaceCount < 0){
			throw new noMoreFreeParkingException();
		}
	}

	public void parkup(List<Car> cars) throws wrongPickUpCarNumberException {
		for(Car car:cars){
			if(!pakedCars.contains(car)){
				throw new wrongPickUpCarNumberException();
			}
			pakedCars.remove(car);
			spaceCount++;
		}
		
	}

}
