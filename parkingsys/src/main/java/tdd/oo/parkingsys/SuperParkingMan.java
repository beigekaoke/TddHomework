package tdd.oo.parkingsys;

import java.util.ArrayList;
import java.util.List;

import tdd.oo.parkingsys.Exception.NoMoreFreeParkingException;

public class SuperParkingMan {

	private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

	public SuperParkingMan(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public void park(Car car) throws NoMoreFreeParkingException {
		double tmpVacancyRate = 0.00;
		ParkingLot tmpParkingLot = null;
		for (ParkingLot parkingLot : parkingLots) {

			if ((double) parkingLot.getFreeSpace() / parkingLot.getSpaceCount() > tmpVacancyRate) {
				tmpVacancyRate = (double) parkingLot.getFreeSpace() / parkingLot.getSpaceCount();
				tmpParkingLot = parkingLot;
			}
		}
		if (tmpParkingLot != null) {
			tmpParkingLot.parking(car);
		} else {
			parkingLots.get(1).parking(car);
		}
	}

}
