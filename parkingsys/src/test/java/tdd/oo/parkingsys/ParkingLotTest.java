package tdd.oo.parkingsys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import tdd.oo.parkingsys.Exception.NoMoreFreeParkingException;
import tdd.oo.parkingsys.Exception.WrongPickUpCarNumberException;

public class ParkingLotTest {

	@Test
	public void given_1_paking_space_when_1_paking_car_then_0_free_parking() throws NoMoreFreeParkingException {
		ParkingLot parkingLot = new ParkingLot(1);
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car();
		cars.add(car);
		parkingLot.parking(cars);
		Assert.assertEquals(0, parkingLot.getFreeSpace());
	}
	
	@Test(expected = NoMoreFreeParkingException.class)  
	public void given_1_paking_space_when_2_paking_car_then_throw_noMoreFreeParkingException() throws NoMoreFreeParkingException {
		ParkingLot parkingLot = new ParkingLot(1);
		List<Car> cars = new ArrayList<Car>();
		Car car1 = new Car();
		Car car2 = new Car();
		cars.add(car1);
		cars.add(car2);
		parkingLot.parking(cars);
	}
	
	@Test
	public void given_1_paking_space_and_1_paking_car_with_number_5555_when_pick_up_1_car_with_number_5555_then_1_free_parking() throws NoMoreFreeParkingException, WrongPickUpCarNumberException {
		ParkingLot parkingLot = new ParkingLot(1);
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car();
		car.setNumber("5555");
		cars.add(car);
		parkingLot.parking(cars);
		parkingLot.parkup(cars);
		Assert.assertEquals(1, parkingLot.getFreeSpace());
	}
	
	@Test(expected = WrongPickUpCarNumberException.class)
	public void given_1_paking_space_and_1_paking_car_with_number_5555_when_pick_up_1_car_with_number_6666_then_throw_wrongPickUpCarNumberException() throws NoMoreFreeParkingException, WrongPickUpCarNumberException  {
		ParkingLot parkingLot = new ParkingLot(1);
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car();
		car.setNumber("5555");
		cars.add(car);
		parkingLot.parking(cars);
		List<Car> pickupcars = new ArrayList<Car>();
		Car pickupcar = new Car();
		pickupcar.setNumber("6666");
		pickupcars.add(pickupcar);
		parkingLot.parkup(pickupcars);
	}
	
	@Test
	public void given_parking_lot_A_has_1_parking_space_parking_lot_B_has_1_parking_space_when_1_parking_car_then_parking_lot_A_has_0_free_parking_space(){
		//given
		ParkingLot parkingLotA = new ParkingLot(1);
		ParkingLot parkingLotB = new ParkingLot(1);
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);
		
		//when
		ParkingMan parkingMan = new ParkingMan(parkingLots);
		Car car = new Car();
		parkingMan.park(car);
		
		//then
		Assert.assertEquals(0, parkingLotA.getFreeSpace());
	}
	
	@Test
	public void given_parking_lot_A_has_1_parking_space_parking_lot_B_has_1_parking_space_when_2_parking_car_then_both_parking_lot_has_0_free_parking_space(){
		
	}
	
	@Test
    public void given_parking_lot_A_has_1_parking_space_parking_lot_B_has_1_parking_space_when_3_parking_car_then_throw_noMoreFreeParkingException(){
		
	}
	
	@Test
    public void given_parking_lot_A_has_2_parking_space_parking_lot_B_has_2_parking_space_when_lotA_paked_1_car_lotB_has_noparked_car_then_lotA_has_0_free_parking_lot_B_has_2_free_parking_space(){
		
	}
}
