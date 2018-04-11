package tdd.oo.parkingsys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import tdd.oo.parkingsys.Exception.NoMoreFreeParkingException;

public class SuperSparkingManTest {

	@Test
	public void should_parked_in_ramdom_parkinglot_when_2_parkinglot_having_the_same_vacancy_rate() throws NoMoreFreeParkingException {
		// given
		ParkingLot parkingLotA = new ParkingLot(1);
		ParkingLot parkingLotB = new ParkingLot(3);
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);

		// when
		SuperParkingMan superParkingMan = new SuperParkingMan(parkingLots);
		Car car = new Car();
		superParkingMan.park(car);

		// then
		Assert.assertTrue(parkingLotA.getFreeSpace() == 0 || parkingLotB.getFreeSpace() == 2);
	}
	
	@Test
	public void should_parked_in_Blot_parkinglot_when_Blot_has_more_vacancy_rate_than_lotA()
			throws NoMoreFreeParkingException {
		// given
		ParkingLot parkingLotA = new ParkingLot(1);
		ParkingLot parkingLotB = new ParkingLot(3);
		Car car = new Car();
		parkingLotB.parking(car);
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);

		// when
		SuperParkingMan superParkingMan = new SuperParkingMan(parkingLots);
		Car car2 = new Car();
		superParkingMan.park(car2);

		// then
		Assert.assertEquals(0, parkingLotA.getFreeSpace());
		Assert.assertEquals(2, parkingLotB.getFreeSpace());
	}

}
