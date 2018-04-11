package tdd.oo.parkingsys;

import java.util.ArrayList;
import java.util.List;

import tdd.oo.parkingsys.Exception.NoMoreFreeParkingException;

public class SmartParkingMan {
	
	private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

	public SmartParkingMan(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public void park(Car car) throws NoMoreFreeParkingException {
		int tmpFreeSpace = 0;
		ParkingLot tmpParkingLot = null;
		for(ParkingLot parkingLot:parkingLots){
			if(parkingLot.getFreeSpace() > tmpFreeSpace){
				tmpParkingLot = parkingLot;
			}
		}
		if(tmpParkingLot != null){
			tmpParkingLot.parking(car);
		}else{
			parkingLots.get(0).parking(car);
		}
		
	}

}
