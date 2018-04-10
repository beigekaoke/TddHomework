package tdd.oo.parkingsys;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tdd.oo.parkingsys.Exception.NoMoreFreeParkingException;
import tdd.oo.parkingsys.Exception.WrongPickUpCarNumberException;

public class ParkingLot {
	
	private int spaceCount;
	
	private Set<Car> pakedCars = new HashSet<Car>();

	public ParkingLot(int spaceCount) {
		this.spaceCount = spaceCount;
	}

	public int getFreeSpace() {
		return spaceCount;
	}
	
	public void parking(List<Car> cars) throws NoMoreFreeParkingException{
		for(Car car:cars){
			pakedCars.add(car);
			spaceCount--;
		}
		if(spaceCount < 0){
			throw new NoMoreFreeParkingException();
		}
	}

	public void parkup(List<Car> cars) throws WrongPickUpCarNumberException {
		for(Car car:cars){
			if(!pakedCars.contains(car)){
				throw new WrongPickUpCarNumberException();
			}
			pakedCars.remove(car);
			spaceCount++;
		}
		
	}

}
