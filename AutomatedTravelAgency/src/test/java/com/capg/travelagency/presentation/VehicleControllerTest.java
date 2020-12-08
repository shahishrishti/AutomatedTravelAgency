package com.capg.travelagency.presentation;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capg.travelagency.exceptions.InvalidDriverDataException;
import com.capg.travelagency.exceptions.InvalidVehicleDataException;


public class VehicleControllerTest {

	private static Logger logger;
	private static VehicleController vehicleController;
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(VehicleControllerTest.class.getName());
		vehicleController = new VehicleController();
	}
	
//	@Test(expected = InvalidVehicleDataException.class)
//	public void testDeleteVehicleInvalidVehicleNo() throws InvalidVehicleDataException {
//		logger.info("[start] testDeleteVehicleInvalidVehicleNo()");
//		vehicleController.deleteVehicle(-1);
//		logger.info("[end] testDeleteVehicleInvalidVehicleNo()");
//	}
//	
//	@Test
//	public void testDeleteVehicleValidVehicleNo() throws InvalidVehicleDataException {
//		logger.info("[start] testDeleteVehicleValidVehicleNo()");
//		assertNotNull("Vehicle Found to be deleted", vehicleController.deleteVehicle(1));
//		logger.info("[end] testDeleteVehicleValidVehicleNo()");
//	}
//	
	@Test(expected = InvalidVehicleDataException.class)
	public void testModifyVehicleInvalidVehicleNo() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleInvalidVehicleNo()");
		vehicleController.modifyVehicle(-1, "Tata Kia", "Car", 20.5, 4, 1);
		logger.error("VehicleNo cannot be negative or zero");
		logger.info("[end] testModifyVehicleInvalidVehicleNo()");
	}
	
	@Test
	public void testModifyVehicleValidVehicleNo() throws InvalidVehicleDataException, InvalidDriverDataException {
		logger.info("[start] testModifyVehicleValidVehicleNo()");
		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(1, "Tata Kia", "Car", 20.5, 4, 1));
		logger.info("[end] testModifyVehicleValidVehicleNo()");
	}
//	
//	@Test(expected = InvalidVehicleDataException.class)
//	public void testModifyVehicleInvalidVehicleName() throws InvalidVehicleDataException {
//		logger.info("[start] testModifyVehicleInvalidVehicleName()");
//		vehicleController.modifyVehicle(1, null, "Car", 20.5, 4, 1);
//		//logger.error("VehicleName cannot be null");
//		logger.info("[end] testModifyVehicleInvalidVehicleName()");
//	}
//	
//	@Test
//	public void testModifyVehicleValidVehicleName() throws InvalidVehicleDataException {
//		logger.info("[start] testModifyVehicleValidVehicleNo()");
//		assertNotNull("Vehicle Found to be Updated", vehicleController.modifyVehicle(1, "Tata Kia", "Bus", 20.5, 20, 1));
//		logger.info("[end] testModifyVehicleValidVehicleNo()");
//	}
//	
//	@Test
//	public void testSeatingCapacityValue() throws InvalidVehicleDataException {
//		logger.info("[start] testSeatingCapacityValue()");
//
////			if(vehicleType.equals("Car")) {
////				if(seatingCapacity >= 1 and <=4) then 
////					logger.info("Success");
////				else {
////					throw new InvalidVehicleDataException("Seating Capacity of car can only be in the range of 1 to 4");
////				}
////			} else if(vehicleType.equals("Bus")) {
////				if(seatingCapacity >= 1 and <=20) then 
////					logger.info("Success");
////				else {
////					throw new InvalidVehicleDataException("Seating Capacity of bus can only be in the range of 1 to 20");
////				}
////			}
////		} catch(InvalidVehicleDataException invalidVehicleDataException) {
////			logger.error("Seating Capacity range is incorrect");
////		}
//		logger.info("[end] testSeatingCapacityValue()");
//	}
//	
//	@Test
//	public void testModifyVehicleInvalidVehicleType() throws InvalidVehicleDataException {
//		logger.info("[start] testModifyVehicleInvalidVehicleType()");
////		try {
////			modifyVehicle(1, "Tata Kia", null,...)
////			throw new InvalidVehicleDataException("Vehicle Type cannot be null.");
////		} catch(InvalidVehicleDataException invalidVehicleDataException) {
////			logger.error("Vehicle Type cannot be null.");
////		}
//		logger.info("[end] testModifyVehicleInvalidVehicleType()");
//	}
//	
//	@Test
//	public void testModifyVehicleValidVehicleType() throws InvalidVehicleDataException {
//		logger.info("[start] testModifyVehicleValidVehicleNo()");
////		assertNotNull("Item Found", vehicleController.modifyVehicle(1, "Tata Kia", "car",...));
//		logger.info("[end] testModifyVehicleValidVehicleNo()");
//	}
//	
//	@Test(expected = InvalidVehicleDataException.class)
//	public void testModifyVehicleInvalidFare() throws InvalidVehicleDataException {
//		logger.info("[start] testModifyVehicleInvalidVehicleNo()");
////		try {
////			modifyVehicle(1, "Tata Kia", "Car", -20,...);
////			throw new InvalidVehicleDataException("Fare cannot be negative or zero.");
////		} catch(InvalidVehicleDataException invalidVehicleDataException) {
////			logger.error("Fare cannot be negative or zero.");
////		}
//		logger.info("[end] testModifyVehicleInvalidVehicleNo()");
//	}
//	
//	@Test
//	public void testModifyVehicleValidFare() throws InvalidVehicleDataException {
//		logger.info("[start] testModifyVehicleValidVehicleNo()");
////		assertNotNull("Item Found", vehicleController.modifyVehicle(1, "Tata Kia", "Car", 20.50,...));
//		logger.info("[end] testModifyVehicleValidVehicleNo()");
//	}
}
