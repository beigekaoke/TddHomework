package tdd.oo.parkingsys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import tdd.oo.parkingsys.Exception.NoMoreFreeParkingException;

public class SmartParkingManTest {

	@Test
	public void should_parked_in_ramdom_parkinglot_when_2_parkinglot_having_the_same_number_of_parking_spaces() throws NoMoreFreeParkingException {
		//given
		ParkingLot parkingLotA = new ParkingLot(1);
		ParkingLot parkingLotB = new ParkingLot(1);
		List<ParkingLot> parkingLots= new ArrayList<ParkingLot>();
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);
		
		
		//when
		SmartParkingMan smartParkingMan = new SmartParkingMan(parkingLots);
		Car car = new Car();
		smartParkingMan.park(car);
		
		//then
		Assert.assertTrue(parkingLotA.getFreeSpace() == 0 || parkingLotB.getFreeSpace() == 0);
		
	}
	
	@Test
	public void should_parked_in_Blot_parkinglot_when_Blot_has_more_free_space_than_lotA() throws NoMoreFreeParkingException {
		// given
		ParkingLot parkingLotA = new ParkingLot(2);
		Car car = new Car();
		parkingLotA.parking(car);
		ParkingLot parkingLotB = new ParkingLot(2);
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);
		
		//when
		SmartParkingMan smartParkingMan = new SmartParkingMan(parkingLots);
		Car car2 = new Car();
		smartParkingMan.park(car2);
		
		//then
		Assert.assertEquals(1, parkingLotA.getFreeSpace());
		Assert.assertEquals(1, parkingLotB.getFreeSpace());
	}
	
	@Test(expected = NoMoreFreeParkingException.class) 
	public void should_hasexception_when_both_Blot_and_lotA_have_no_free_space() throws NoMoreFreeParkingException {
		// given
		ParkingLot parkingLotA = new ParkingLot(1);
		Car car = new Car();
		parkingLotA.parking(car);
		ParkingLot parkingLotB = new ParkingLot(1);
		parkingLotB.parking(car);
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);

		// when
		SmartParkingMan smartParkingMan = new SmartParkingMan(parkingLots);
		Car car2 = new Car();
		smartParkingMan.park(car2);
	}

}
