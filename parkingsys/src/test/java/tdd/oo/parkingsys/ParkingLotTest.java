package tdd.oo.parkingsys;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import tdd.oo.parkingsys.Exception.noMoreFreeParkingException;
import tdd.oo.parkingsys.Exception.wrongPickUpCarNumberException;

public class ParkingLotTest {

	@Test
	public void given_1_paking_space_when_1_paking_car_then_0_free_parking() throws noMoreFreeParkingException {
		ParkingLot parkingLot = new ParkingLot(1);
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car();
		cars.add(car);
		parkingLot.parking(cars);
		Assert.assertEquals(0, parkingLot.getFreeSpace());
	}
	
	@Test(expected = noMoreFreeParkingException.class)  
	public void given_1_paking_space_when_2_paking_car_then_throw_noMoreFreeParkingException() throws noMoreFreeParkingException {
		ParkingLot parkingLot = new ParkingLot(1);
		List<Car> cars = new ArrayList<Car>();
		Car car1 = new Car();
		Car car2 = new Car();
		cars.add(car1);
		cars.add(car2);
		parkingLot.parking(cars);
	}
	
	@Test
	public void given_1_paking_space_and_1_paking_car_with_number_5555_when_pick_up_1_car_with_number_5555_then_1_free_parking() throws noMoreFreeParkingException, wrongPickUpCarNumberException {
		ParkingLot parkingLot = new ParkingLot(1);
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car();
		car.setNumber("5555");
		cars.add(car);
		parkingLot.parking(cars);
		parkingLot.parkup(cars);
		Assert.assertEquals(1, parkingLot.getFreeSpace());
	}
	
	@Test(expected = wrongPickUpCarNumberException.class)
	public void given_1_paking_space_and_1_paking_car_with_number_5555_when_pick_up_1_car_with_number_6666_then_throw_wrongPickUpCarNumberException() throws noMoreFreeParkingException, wrongPickUpCarNumberException  {
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
}
